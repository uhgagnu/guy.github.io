package org.liufeng.course.message.resp;

/**
 * 信息基础类，其他信息类继承本类
 * cn.suunyboy.wechat.resp
 * author:HUGUANG
 * version:v1.0
 * time:2016-11-24 下午4:44:16
 * email:940728678@qq.com
 */
public class BaseMessage {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 发送方微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001被标志时，星标刚收到的消息
//	private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
//
//	public int getFuncFlag() {
//		return FuncFlag;
//	}
//
//	public void setFuncFlag(int funcFlag) {
//		FuncFlag = funcFlag;
//	}
}