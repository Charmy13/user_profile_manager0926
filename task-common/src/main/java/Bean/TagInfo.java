package Bean;

import java.util.Date;

public class TagInfo {
    private  Long id;

    private  String tagCode;

    private  String tagName;

    private  Long tagLevel;

    private  Long parentTagId;

    private  String tagType;

    private  String tagValueType;

    private  Long tagTaskId;

    private  String tagComment;

    private Date createTime;

    private  Date updateTime;

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
