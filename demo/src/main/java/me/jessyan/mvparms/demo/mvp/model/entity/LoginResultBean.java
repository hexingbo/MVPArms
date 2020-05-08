package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * @Author :hexingbo
 * @Date :2020/5/8
 * @FileName： LoginResultBean
 * @Describe :
 */
public class LoginResultBean {

    /**
     * memberid : 10738
     * access_token : c20ca940-bb93-4c75-97fd-31ca655f3cee
     * head : http://image.huacaigou.com/media%2Fhead%2F10738%2F1588842217925.jpeg
     * name : 啵啵
     * phone : 13590467446
     * account_type : 4
     * is_cooperation : 0
     * hzh_member_type : 0
     */

    private String memberid;
    private String access_token;
    private String head;
    private String name;
    private String phone;
    private int account_type;
    private int is_cooperation;
    private int hzh_member_type;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    public int getIs_cooperation() {
        return is_cooperation;
    }

    @Override
    public String toString() {
        return "LoginResultBean{" +
                "memberid='" + memberid + '\'' +
                ", access_token='" + access_token + '\'' +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", account_type=" + account_type +
                ", is_cooperation=" + is_cooperation +
                ", hzh_member_type=" + hzh_member_type +
                '}';
    }

    public void setIs_cooperation(int is_cooperation) {
        this.is_cooperation = is_cooperation;
    }

    public int getHzh_member_type() {
        return hzh_member_type;
    }

    public void setHzh_member_type(int hzh_member_type) {
        this.hzh_member_type = hzh_member_type;
    }
    
    
}
