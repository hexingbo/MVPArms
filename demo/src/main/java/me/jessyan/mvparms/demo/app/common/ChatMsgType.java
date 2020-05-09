package me.jessyan.mvparms.demo.app.common;


public class ChatMsgType {

//    confirm = -2  # 消息送达确认
//    heart = - 1 # 心跳
//    cmd = 0  # 命令消息
//    text = 1 # 文本
//    image = 2 # 图片
//    forsale = 3  # 商品 和收藏
//    system = 4  # 系统消息
//    notice = 5  # 提示消息
//    groupchatInvite = 6  # 入群邀请
//    agent = 7  # 代理权
//    location = 8  # 位置
//    businesscard = 9  # 名片
//    announcement = 10  # 公告
//    address = 11  # 地址
//    shop = 12  # 店铺
//    ticket = 13  # 发票

    /**
     * 消息送达确认
     */
    public static final int confirm = -2;
    /**
     * 心跳
     */
    public static final int heart = -1;
    /**
     * 命令消息
     */
    public static final int cmd = 0;
    /**
     * 文本
     */
    public static final int text = 1;
    /**
     * 图片
     */
    public static final int image = 2;
    /**
     * 商品 和收藏
     */
    public static final int forsale = 3;
    /**
     * 系统消息
     */
    public static final int system = 4;
    /**
     * 提示消息
     */
    public static final int notice = 5;
    /**
     * 入群邀请
     */
    public static final int groupchatInvite = 6;
    /**
     * 代理权
     */
    public static final int agent = 7;
    /**
     * 位置
     */
    public static final int location = 8;
    /**
     * 名片
     */
    public static final int businesscard = 9;
    /**
     * 公告
     */
    public static final int announcement = 10;
    /**
     * 地址
     */
    public static final int address = 11;
    /**
     * 店铺
     */
    public static final int shop = 12;
    /**
     * 申请圈层价
     */
    public static final int applyCircle = 13;
    /**
     * 回复申请圈层价(添加成功后)
     */
    public static final int reApplyCircle = 14;
    /**
     * 圈子
     */
    public static final int circle = 15;
    /**
     * 语音
     */
    public static final int voice = 16;

    /**
     * 发票
     */
    public static final int ticket = 17;

    /**
     * 对象
     */
    public static final int msgobject = 0x1111;

    public static String getMsgContent(int msgType, String msg) {
        String content = "";
        switch (msgType) {
            case ChatMsgType.cmd:
                content = "[命令消息]";
                break;
            case ChatMsgType.text:
                content = msg;
                break;
            case ChatMsgType.image:
                content = "[图片]";
                break;
            case ChatMsgType.forsale:
                content = "[商品信息]";
                break;
            case ChatMsgType.system:
                content = "[系统消息]";
                break;
            case ChatMsgType.notice:
                content = "[提示消息]";
                break;
            case ChatMsgType.groupchatInvite:
                content = "[入群邀请]";
                break;
            case ChatMsgType.agent:
                content = "[代理权]";
                break;
            case ChatMsgType.location:
                content = "[位置信息]";
                break;
            case ChatMsgType.businesscard:
                content = "[名片]";
                break;
            case ChatMsgType.announcement:
                content = "[群公告]";
                break;
            case ChatMsgType.address:
                content = "[地址]";
                break;
            case ChatMsgType.shop:
                content = "[店铺]";
                break;
            case ChatMsgType.ticket:
                content = "[发票]";
                break;
            case ChatMsgType.applyCircle:
                content = "[申请圈层价]";
                break;
            case ChatMsgType.reApplyCircle:
                content = "[圈层价申请成功]";
                break;
            case ChatMsgType.circle:
                content = "[圈店铺]";
                break;
            case ChatMsgType.voice:
                content = "[语音]";
                break;
            default:
                content = "[未知消息]";
                break;
        }
        return content;
    }

}