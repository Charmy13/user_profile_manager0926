package Util;

import java.util.Properties;
import java.util.ResourceBundle;

public class MyProUtil {

    //方法二
    private static ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static String get(String key){
        return  bundle.getString(key);
    }

    public static void main(String[] args) {
        System.out.println(get("mysql.url"));
    //方法一：解析配置文件




    }

}
