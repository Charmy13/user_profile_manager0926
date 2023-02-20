package Bean;

import java.util.Date;

public class TaskInfo {
    private  Long id;

    private  String taskName;

    private  String taskStatus;

    private  String taskComment;

    private  String taskType;

    private  String execType;

    private  String mainClass;

    private  Long fileId;

    private  String taskArgs;

    private  String taskSql;

    private  Long taskExecLevel;

    private Date createTime;

    public String getTaskSql() {
        return taskSql;
    }
}
