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

	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		this.Video = video;
	}
}
