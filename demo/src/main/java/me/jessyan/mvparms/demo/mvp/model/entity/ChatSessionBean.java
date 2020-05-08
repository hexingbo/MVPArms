package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * @Author :hexingbo
 * @Date :2020/5/8
 * @FileName： ChatSessionBean
 * @Describe :
 */
public class ChatSessionBean {

    /**
     * createTime : 2019-02-15T14:58:37.042Z
     * desc : 圈号:20190215145837
     * groupinfo : {"head":"http://image.huacaigou.com/media%2Ffile%2FNone%2F20200325100927wqen3t90.png","id":64,"member_num":143}
     * has_shop : true
     * head : http://image.huacaigou.com/media%2Ffile%2FNone%2F20200325100927wqen3t90.png
     * id : 151
     * ischanneler : false
     * lastMessage : {"msg":"","msgFrom":{"CNname":"演示厂家","id":383},"msgType":16,"sendTime":"2020-04-13T06:42:39.979Z"}
     * lastMsgTime : 2020-04-13T06:42:39.979Z
     * master : {"id":1319,"nickname":"娃子"}
     * sessionType : 1
     * title : 全国华南城华耀城建筑材料采购中心
     */

    private String createTime;
    private String desc;
    private GroupinfoBean groupinfo;
    private boolean has_shop;
    private String head;
    private String id;
    private boolean ischanneler;
    private LastMessageBean lastMessage;
    private String lastMsgTime;
    private MasterBean master;
    private int sessionType;
    private String title;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public GroupinfoBean getGroupinfo() {
        return groupinfo;
    }

    public void setGroupinfo(GroupinfoBean groupinfo) {
        this.groupinfo = groupinfo;
    }

    public boolean isHas_shop() {
        return has_shop;
    }

    public void setHas_shop(boolean has_shop) {
        this.has_shop = has_shop;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIschanneler() {
        return ischanneler;
    }

    public void setIschanneler(boolean ischanneler) {
        this.ischanneler = ischanneler;
    }

    public LastMessageBean getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessageBean lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(String lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public MasterBean getMaster() {
        return master;
    }

    public void setMaster(MasterBean master) {
        this.master = master;
    }

    public int getSessionType() {
        return sessionType;
    }

    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class GroupinfoBean {
        /**
         * head : http://image.huacaigou.com/media%2Ffile%2FNone%2F20200325100927wqen3t90.png
         * id : 64
         * member_num : 143
         */

        private String head;
        private String id;
        private String member_num;

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMember_num() {
            return member_num;
        }

        public void setMember_num(String member_num) {
            this.member_num = member_num;
        }

        @Override
        public String toString() {
            return "GroupinfoBean{" +
                    "head='" + head + '\'' +
                    ", id='" + id + '\'' +
                    ", member_num='" + member_num + '\'' +
                    '}';
        }
    }

    public static class LastMessageBean {
        /**
         * msg : 
         * msgFrom : {"CNname":"演示厂家","id":383}
         * msgType : 16
         * sendTime : 2020-04-13T06:42:39.979Z
         */

        private String msg;
        private MsgFromBean msgFrom;
        private int msgType;
        private String sendTime;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public MsgFromBean getMsgFrom() {
            return msgFrom;
        }

        public void setMsgFrom(MsgFromBean msgFrom) {
            this.msgFrom = msgFrom;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public static class MsgFromBean {
            /**
             * CNname : 演示厂家
             * id : 383
             */

            private String CNname;
            private String id;

            public String getCNname() {
                return CNname;
            }

            public void setCNname(String CNname) {
                this.CNname = CNname;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "MsgFromBean{" +
                        "CNname='" + CNname + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }
        }
    }

    public static class MasterBean {
        /**
         * id : 1319
         * nickname : 娃子
         */

        private String id;
        private String nickname;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "MasterBean{" +
                    "id='" + id + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ChatSessionBean{" +
                "createTime='" + createTime + '\'' +
                ", desc='" + desc + '\'' +
                ", groupinfo=" + groupinfo +
                ", has_shop=" + has_shop +
                ", head='" + head + '\'' +
                ", id='" + id + '\'' +
                ", ischanneler=" + ischanneler +
                ", lastMessage=" + lastMessage +
                ", lastMsgTime='" + lastMsgTime + '\'' +
                ", master=" + master +
                ", sessionType=" + sessionType +
                ", title='" + title + '\'' +
                '}';
    }
}
