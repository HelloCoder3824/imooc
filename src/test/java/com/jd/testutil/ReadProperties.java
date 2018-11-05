package com.jd.testutil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @class: ReadProperties
 * @description: 读取配置文件及文件内容
 * @author: Jindong
 * @create: 2018-09-21 16:03
 **/
public class ReadProperties {

      static Properties properties =new Properties();

    /**
     *
     * @param key
     * @return 将脚本元素文件加载加载至内存
     * @throws IOException
     */
    public static String ElementFile(String key ) throws IOException {
        //String filepath= "D:\\idea-workspace01\\demo\\imooc3\\src\\test\\java\\com\\jd\\properties\\imooc.properties";
        String filepath= "D:\\idea-workspace01\\demo\\imooc3\\src\\test\\java\\com\\jd\\properties\\imooc.properties";
       // String filepath= "com/jd/properties/imooc.properties";
        //将文件读入缓冲流中
        InputStream inputStream =new BufferedInputStream(new FileInputStream(filepath));
        //加载流至内存
        ReadProperties.properties.load(inputStream);

        //属性locator 是通过key获取的value

        String locator = ReadProperties.properties.getProperty(key);
        /*
        //属性locatorType 获取的value中通过split分离出的>前面的数据==id、name等

        String locatorType = locator.split(">")[0];

        //属性locatorType 获取的value中通过split分离出的>后面的数据==元素

        String locatorValue = locator.split(">")[1];
        */


        return  locator;

    }

    public static String GetTypeByKey(String key) throws IOException {

        ReadProperties.ElementFile(key);

        //属性locator 是通过key获取的value

        String locator =ReadProperties. properties.getProperty(key);

        //属性locatorType 获取的value中通过split分离出的>前面的数据==id、name等

        String locatorType = locator.split(">")[0];

        return locatorType;

    }

    public static String GetValueByKey(String key) throws IOException {
        ReadProperties.ElementFile(key);

        //属性locator 是通过key获取的value

        String locator =ReadProperties. properties.getProperty(key);

        //属性locatorType 获取的value中通过split分离出的>后面的数据==元素

        String locatorValue = locator.split(">")[1];

        return locatorValue;
    }



}
