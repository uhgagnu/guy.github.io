package org.liufeng.course.message.resp;
/**
 * VideoMessage
 * org.liufeng.course.message.resp
 * author:HUGUANG
 * version:v1.0
 * time:2016-11-25 下午6:10:25
 * email:940728678@qq.com
 */
public class VideoMessage extends BaseMessage{

	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
