package by.laligulbani.vk.presenter.recycleViewNews;


public class Message {
    private String msg;
    private String desc;
    private int resId;
    private int descId;

    public Message(String msg, String desc, int resId, int descId) {
        this.msg = msg;
        this.desc = desc;
        this.resId = resId;
        this.descId = descId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getDescId() {
        return descId;
    }

    public void setDescId(int descId) {
        this.descId = descId;
    }
}
