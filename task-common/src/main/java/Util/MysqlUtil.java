package Util;

import Util.ConstCode;
import Util.MyProUtil;
import org.apache.commons.beanutils.BeanUtils;

import org.sparkproject.guava.base.CaseFormat;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Class.forName;

//Mysql 工具类
public class MysqlUtil {

    //定义连接数据库
    static String url = MyProUtil.get(ConstCode.MYSQL_URL);
static String username=MyProUtil.get(ConstCode.MYSQL_USERNAME);
static String password=MyProUtil.get(ConstCode.MYSQL_PASSWORD);

    /**
     * 根据给定的SQL, 查询对应的元素
     */

    public static<T> T selectOne(String sql,Class<T> clazz,Boolean underScoreToCamel){
        List<T> selectList =queryList(sql,clazz,underScoreToCamel);
        //1.返回值结果不为空 接受类型否则返回值为null
        if(!selectList.isEmpty()){
            return selectList.get(0);
        }else{
            return null;
        }
    }

    /**
     *  根据给定的sql语句和class类型，查询对应的元素列表  (通用查询方法)
     */
public  static <T> List<T> queryList(String sql ,Class<T> clazz,Boolean underScoreToCamel)  {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    ArrayList<T> arrayList= null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        //返回对象的列的个数//获取结果集中的元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        arrayList = new ArrayList<T>();
        //处理结果
        //目的将查询到的字段 转换成 标签 从而创建标签表
        while(resultSet.next()){
            T instance = clazz.newInstance();
            //获取结果列的个数
            //mysql 索引 是从1开始   方法有说明
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //大小写转换
                String propertyName="";
                if (underScoreToCamel) {

                    propertyName= CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,metaData.getColumnName(i));
                }else{
                    propertyName = metaData.getColumnLabel(i);
                }
                if(resultSet.getObject(i)!=null){
                    BeanUtils.setProperty(instance,propertyName,resultSet.getObject(i));
                }
                arrayList.add(instance);

            }

            }
        resultSet.close();
        statement.close();
        connection.close();
        return  arrayList;
    } catch (Exception e) {
        throw new RuntimeException("查询mysql 失败："+e.getMessage());
    }
}
}






