package org.liufeng.course.message.resp;

/**
 * BaseMessage
 * cn.suunyboy.wechat.resp
 * author:HUGUANG
 * version:v1.0     
 * time:2016-11-24 下午4:44:16
 * email:940728678@qq.com
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}