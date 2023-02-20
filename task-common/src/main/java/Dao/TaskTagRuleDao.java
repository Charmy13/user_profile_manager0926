package Dao;

import Bean.TaskTagInfo;
import Util.MysqlUtil;

import java.util.List;

public class TaskTagRuleDao {
    //
    public static List<TaskTagInfo> getTaskTagRuleDao(String taskId){
        String sql =
                " select tr.id , tr.tag_id, tr.task_id ,tr.query_value ,tr.sub_tag_id , ti.tag_name as sub_tag_value " +
                        " from task_tag_rule tr join tag_info ti " +
                        " on tr.sub_tag_id = ti.id " +
                        " where task_id = " + taskId ;
        List<TaskTagInfo> taskTagRules = MysqlUtil.queryList(sql, TaskTagInfo.class, true);
        return taskTagRules ;
    }

}

