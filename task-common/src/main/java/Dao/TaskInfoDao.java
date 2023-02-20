package Dao;

import Bean.TagInfo;
import Bean.TaskInfo;
import Util.MyProUtil;
import Util.MysqlUtil;

public class TaskInfoDao {

    public static TaskInfo getTaskInfoById(String taskId){
        String sql ="select\n" +
                " id,\n" +
                " task_name,\n" +
                " task_status,\n" +
                " task_comment,\n" +
                " task_time,\n" +
                " task_type,\n" +
                " exec_type,\n" +
                "main_class,\n" +
                "file_id,\n" +
                "task_args,\n" +
                "task_sql,\n" +
                "task_exec_level,\n" +
                "create_time\n" +
                "from task_info \n" +
                "where id =" +taskId;
        TaskInfo taskInfo= MysqlUtil.selectOne(sql, TaskInfo.class, true);
        return taskInfo;
    }
}
