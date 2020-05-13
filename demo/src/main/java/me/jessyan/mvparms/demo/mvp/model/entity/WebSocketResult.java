package me.jessyan.mvparms.demo.mvp.model.entity;

import java.io.Serializable;

/**
 * @Author :hexingbo
 * @Date :2020/5/13
 * @FileName： WebSocketResult
 * @Describe :
 */
public class WebSocketResult implements Serializable {

    /**
     * chatSession_id : 15214
     * msgType : 1
     * msg : 健健康康健健康康
     * toUserid : 10738
     * fromUserid : 33676
     * msgId : fee748f786174cd6ac381e694823fb86243
     * msgFrom_head : http://image.huacaigou.com/media%2Fhead%2F33676%2F1589333824877.png
     * msgFrom_nickname : ༺ཌ波波ད༻
     * createTime : 2020-05-13 03:11:35
     * id : 70569
     */

    private String chatSession_id;
    private int msgType;
    private String msg;
    private String toUserid;
    private String fromUserid;
    private String msgId;
    private String msgFrom_head;
    private String msgFrom_nickname;
    private String createTime;
    private String id;

    public String getChatSession_id() {
        return chatSession_id;
    }

    public void setChatSession_id(String chatSession_id) {
        this.chatSession_id = chatSession_id;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToUserid() {
        return toUserid;
    }

    public void setToUserid(String toUserid) {
        this.toUserid = toUserid;
    }

    public String getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(String fromUserid) {
        this.fromUserid = fromUserid;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgFrom_head() {
        return msgFrom_head;
    }

    public void setMsgFrom_head(String msgFrom_head) {
        this.msgFrom_head = msgFrom_head;
    }

    public String getMsgFrom_nickname() {
        return msgFrom_nickname;
    }

    public void setMsgFrom_nickname(String msgFrom_nickname) {
        this.msgFrom_nickname = msgFrom_nickname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
