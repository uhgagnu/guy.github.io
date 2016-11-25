package org.liufeng.course.message.resp;

/**
 * 文本信息
 * cn.suunyboy.wechat.resp
 * author:HUGUANG
 * version:v1.0
 * time:2016-11-24 下午4:44:16
 * email:940728678@qq.com
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;
    
	public String getContent() {
		return Content;
	}    
 
	public void setContent(String content) {
		Content = content;
	}
}