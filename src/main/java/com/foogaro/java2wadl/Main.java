package com.foogaro.java2wadl;

import com.foogaro.java2wadl.model.Application;

import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

/**
 * @author foogaro
 */
public class Main {

    private final static String CLASSPATH_SEPARATOR = ":";

    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            System.out.println("classLoader: " + classLoader);

            String classPath = "java.class.path";
            String jars = System.getProperty(classPath);
            System.out.println("jars: " + jars);
            StringTokenizer stringTokenizer = new StringTokenizer(jars, CLASSPATH_SEPARATOR);
            System.out.println("stringTokenizer: " + stringTokenizer);

            List<URL> urlList = new ArrayList<URL>();

            if (stringTokenizer != null) {
                while (stringTokenizer.hasMoreTokens()) {
                    String jar = stringTokenizer.nextToken();
                    System.out.println("jar: " + jar);
                    urlList.add(new File(jar).toURI().toURL());

                }
            }
            System.out.println("urlList: " + urlList);
            if (urlList != null) {
                URL[] urls = new URL[urlList.size()];
                for (int i=0; i<urlList.size(); i++) {
                    urls[i] = urlList.get(i);
                }
                //ClassLoader jarClassLoader = new URLClassLoader(urls);
                for (URL url : urls) {
                    System.out.println("url: " + url);
                    InputStream inputStream = url.openStream();
                    //System.out.println("inputStream: " + inputStream);
                    JarInputStream jarInputStream = new JarInputStream(inputStream);
                    //System.out.println("jarInputStream: " + jarInputStream);
                    JarEntry jarEntry = null;
                    while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
                        jarEntry = jarInputStream.getNextJarEntry();
                        //System.out.println("jarEntry: " + jarEntry);
                        if (jarEntry != null) {
                            //System.out.println("jarEntry.getName(): " + jarEntry.getName());
                            if (jarEntry.isDirectory() == true) {
                                //System.out.println("jarEntry.isDirectory(): " + jarEntry.isDirectory());
                                continue;
                            } else {
                                //System.out.println("jarEntry is NOT a directory... it's a Class!");

                                //ClassLoader cload = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());

                                Class clazz = null;
                                try {
                                    String className = jarEntry.getName();
                                    className = className.replace('/', '.');
                                    className = className.substring(0,className.lastIndexOf('.'));
                                    clazz = classLoader.loadClass(className);
                                    //clazz = Class.forName(className, true, cload);
                                } catch (ClassNotFoundException e) {
                                    //System.out.println("error: " + e.getMessage());
                                    continue;
                                }

                                if (isParentResource(clazz)) {
                                    System.out.println(clazz + " is a REST resource!");
                                    Application application =  new Application();
                                    Method[] methods = clazz.getDeclaredMethods();
                                    if (methods != null) {
                                        for (Method method : methods) {
                                            if (method != null && Modifier.isPublic(method.getModifiers())) {
                                                System.out.println("Method " + method.getName());
                                                Class returnTypeClass = method.getReturnType();
                                                System.out.println("returns " + returnTypeClass.getName());
                                                Annotation[] annotations = method.getDeclaredAnnotations();
                                                System.out.println("has these REST's directives: ");
                                                for (Annotation annotation : annotations) {
                                                    System.out.println(annotation.toString());
                                                }
                                                Class[] parameterTypesClass = method.getParameterTypes();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
//
//            URL url = classLoader.getResource(jar);
//            System.out.println("url: " + url);
//            url = ClassLoader.getSystemResource(jar);
//            System.out.println("url: " + url);
//
//            InputStream inputStream = classLoader.getResourceAsStream(jar);
//            System.out.println("inputStream: " + inputStream);
//            JarInputStream jarInputStream = new JarInputStream(inputStream);
//            System.out.println("jarInputStream: " + jarInputStream);
//            JarEntry jarEntry = jarInputStream.getNextJarEntry();
//            System.out.println("jarEntry: " + jarEntry);
//            Attributes  attributes = jarEntry.getAttributes();
//            System.out.println("attributes: " + attributes);
//
//            Enumeration<URL> urls =  null;
//            urls = classLoader.getResources("");
//            System.out.println("urls: " + urls);
//            if (urls != null) {
//                while (urls.hasMoreElements()) {
//                    URL url = urls.nextElement();
//                    System.out.println("url: " + url);
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isParentResource(Class clazz) {
        return clazz.getAnnotation(javax.ws.rs.ext.Provider.class) != null || clazz.getAnnotation(javax.ws.rs.Path.class) != null;
    }

    /*


Method
 Type
  Field
   Parameter
    Constructor
01000       @javax.ws.rs.ext.Provider
11000       @javax.ws.rs.Path

11000       @javax.ws.rs.Consumes
11000       @javax.ws.rs.Produces
11111       @javax.ws.rs.Encoded

10000       @javax.ws.rs.DELETE
10000       @javax.ws.rs.GET
10000       @javax.ws.rs.HEAD
10000       @javax.ws.rs.POST
10000       @javax.ws.rs.PUT

10110       @javax.ws.rs.PathParam
10110       @javax.ws.rs.QueryParam
10110       @javax.ws.rs.FormParam

10110       @javax.ws.rs.CookieParam
10110       @javax.ws.rs.HeaderParam
10110       @javax.ws.rs.MatrixParam
10110       @javax.ws.rs.DefaultValue
10110       @javax.ws.rs.core.Context

     */

}
