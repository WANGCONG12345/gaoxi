package com.gaoxi.gaoxicommonservicefacade.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author acong
 * @date 2018年6月13日13:11:11
 * @description Class对象处理工具包
 */
public class ClassUtil {
    /**
     * 通过包名获取包内所有类
     * @param pkg
     * @return
     */
    public static List<Class<?>> getAllClassByPackageName(Package pkg){
        String pkgName = pkg.getName();
        List<Class<?>> returnCLassList = getClasses(pkgName);
        return returnCLassList;
    }
    /**
     * 通过接口名获取某个接口下所有实现这个接口的类
     */
    public static List<Class<?>> getAllClassByInterface(Class<?> clazz){
        List<Class<?>> returnClassList = null;
        if (clazz.isInterface()){
            String packageName = clazz.getPackage().getName();
            List<Class<?>> allClass = getClasses(packageName);
            if (allClass != null ){
                returnClassList = new ArrayList<Class<?>>();
                for (Class<?> cls:allClass) {
                    if (clazz.isAssignableFrom(cls)){
                        //本身不加进去
                        if (!clazz.equals(cls)){
                            returnClassList.add(cls);
                        }
                    }
                }
            }
        }
        return returnClassList;

    }



    /**
     * 从包pkgName中获取所有的Class
     * @param pkgName
     * @return
     */

    private static List<Class<?>> getClasses(String pkgName) {
        //第一个Class类的集合
        List<Class<?>> classes = new ArrayList<Class<?>>();
        //是否迭代循环
       boolean recursive = true;
       //获取包的名字并进行替换
        String packageDirName = pkgName.replace('.', '/');
        //定义一个枚举的集合
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(pkgName);
            //循环迭代下去
           while (dirs.hasMoreElements()){
               //获取下一个元素
               URL url = dirs.nextElement();
               String protocol = url.getProtocol();
               if ("file".equals(protocol)){
                   String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                   findAndAddClassesInPackageByFile(pkgName,filePath,recursive,classes);
               }else if ("jar".equals(protocol)){
                //如果是jar包文件
                   //定义一个JarFile
                   JarFile jar;
                   jar = ((JarURLConnection)url.openConnection()).getJarFile();
                   //从此jar包得到一个枚举类
                   Enumeration<JarEntry> entries = jar.entries();
                   //同样的进行循环迭代
                   while (entries.hasMoreElements()){
                       JarEntry jarEntry = entries.nextElement();
                       String name = jarEntry.getName();
                       if (name.charAt(0) == '/'){
                           name = name.substring(1);
                       }
                       if (name.startsWith(packageDirName)){
                           int idx = name.lastIndexOf('/');
                           if (idx != -1){
                               pkgName = name.substring(0,idx).replace('/','.');
                           }
                           if ((idx != -1) && recursive){
                               if (name.endsWith(".class") && !jarEntry.isDirectory()){
                                   //去掉后面的.class，获取真正的类名
                                   String className = name.substring(pkgName.length() + 1, pkgName.length() - 6);
                                   try {
                                       classes.add(Class.forName(pkgName+'.'+className));
                                   } catch (ClassNotFoundException e) {
                                       e.printStackTrace();
                                   }
                               }
                           }
                       }
                   }

               }

           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;

    }

    /**
     * 以文件的形式来获取包下所有的Class
     * @param pkgName
     * @param filePath
     * @param recursive
     * @param classes
     */

    private static void findAndAddClassesInPackageByFile(String pkgName, String filePath, boolean recursive, List<Class<?>> classes) {
        //获取此包的目录，建立一个File
        File dir = new File(filePath);
        //如果不存在或也不是目录，就直接返回
        if(!dir.exists() || !dir.isDirectory()){
            return;
        }
        //如果存在获取包下所有文件及目录
        File[] dirFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (recursive && pathname.isDirectory()) || (pathname.getName().endsWith(".class"));
            }
        });
        //循环所有文件
        for (File file:dirFiles) {
            //如果是目录则继续扫面
            if(file.isDirectory()){
                findAndAddClassesInPackageByFile(pkgName+","+file.getName(),file.getAbsolutePath(),recursive,classes);
            }else{
                //如果是java文件，去掉后面的.class只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(pkgName+'.'+className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
