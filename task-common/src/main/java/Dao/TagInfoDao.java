package com.at;
import Bean.TagInfo;
import Util.MysqlUtil;

public class TagInfoDao {

    // TODO: 2023/2/14 1 参数id

    public static TagInfo getTagInfoByTaskId(String taskId){
        String sql ="select id,tag_code,tag_name ,tag_level,parent,parent_tag_id,\n" +
                "tag_type,tag_value_type,tag_value_limit,tag_value_step,tag_task_id,\n" +
                "tag_comment,update_time,create_time\n" +
                "from tag_info\n" +
                "where tag_task_id =" + taskId;
        TagInfo tagInfo= MysqlUtil.selectOne(sql,TagInfo.class,true);
        return tagInfo;



    }



    /*
    * 查询计算的标签表
    * */








    }

