package org.liufeng.weixin.test;

import java.io.IOException;

import org.liufeng.weixin.pojo.AccessToken;
import org.liufeng.weixin.util.WeixinUtil;

/**
 * 获取token
 * org.liufeng.weixin.test
 * author:HUGUANG
 * version:v1.0
 * time:2016-11-24 下午10:51:03
 * email:940728678@qq.com
 */
public class Token {

		AccessToken accessToken = null;
	public static void main(String[] args) throws IOException {
		AccessToken accessToken = WeixinUtil.getAccessToken("wxf0c766b553e5610c", "abb31e73ed0e5c83e67188c3fc10d39e");
		System.out.println("票据:"+accessToken.getToken());
		System.out.println("有效时间:"+accessToken.getExpiresIn());
	
		//测试上传
		String path = "E:\\upload\\mine.JPG";
		String media_id = WeixinUtil.upload(path, accessToken.getToken(), "image");
		System.out.println("media_id:"+media_id);
	}
}
