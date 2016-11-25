package org.liufeng.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.liufeng.course.message.resp.Article;
import org.liufeng.course.message.resp.Image;
import org.liufeng.course.message.resp.ImageMessage;
import org.liufeng.course.message.resp.NewsMessage;
import org.liufeng.course.message.resp.TextMessage;
import org.liufeng.course.util.MessageUtil;

import org.liufeng.weixin.pojo.AccessToken;
import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 核心服务类
 * cn.suunyboy.wechat.resp
 * author:HUGUANG
 * version:v1.0
 * time:2016-11-24 下午4:44:16
 * email:940728678@qq.com
 */
public class CoreService {
	
	//private static Logger log = LoggerFactory.getLogger(CoreService.class);
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析为map集合
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			System.out.println("");
			System.out.println("msgType:"+msgType);
			System.out.println("fromUserName:"+fromUserName);
			System.out.println("toUserName:"+toUserName);

			// 默认回复此文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义			
			StringBuffer contentMsg = new StringBuffer();  
			contentMsg.append("欢迎访问本微信公众测试平台").append("\n");  
			contentMsg.append("您好，我是sunnyboy，请回复数字选择服务：").append("\n\n");  
			contentMsg.append("1 Individual Resume").append("\n");  
			contentMsg.append("2 github-repository ").append("\n");  
			contentMsg.append("3 CSDN-technology-blog").append("\n");  
			contentMsg.append("4 Linux&git").append("\n");  
			contentMsg.append("5 OpenSource").append("\n");  
			contentMsg.append("6 BeautyImage").append("\n\n");
			contentMsg.append("点击查看 <a href=\"https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453&token=&lang=zh_CN\">开发者文档</a>");  

			textMessage.setContent(contentMsg.toString());
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 接收用户发送的文本消息内容
				String content = requestMap.get("Content");
				System.out.println("content:"+content);

				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				// 单图文消息
				if ("1".equals(content)) {
					Article article = new Article();
					article.setTitle("个人简介");
					// 图文消息中可以使用QQ表情、符号表情
					article.setDescription("胡光，92年，" + emoji(0x1F6B9)
							+ "，微信公众帐号开发经验3个月。刚接触微信公众号开发，现在有很多地方还不够熟悉，希望借此机会认识更多同行，一起学习，一起提高");
					// 将图片置为空
					article.setPicUrl("");
					article.setUrl("https://github.com/uhgagnu");
					articleList.add(article);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
				}
				// 单图文消息
				else if ("2".equals(content)) {
					Article article = new Article();
					article.setTitle("github官网个人仓库,仅供参考,大神勿喷!");
					article.setDescription("一起学习，一起努力，磨炼技术，铸就辉煌!!!");
					article.setPicUrl("http://1612w56h01.51mypc.cn/wechat/github.jpg");
					article.setUrl("https://github.com/uhgagnu");
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
				}
				// 多图文消息
				else if ("3".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("个人csdn技术博客\n引言");
					article1.setDescription("");
					article1.setPicUrl("http://1612w56h01.51mypc.cn/wechat/CSDN.jpg");
					//article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");
					article1.setUrl("http://blog.csdn.net/uhgagnu");

					Article article2 = new Article();
					article2.setTitle("第2篇\nCSDN技术精华篇");
					article2.setDescription("");
					article2.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article2.setUrl("http://geek.csdn.net/news/detail/125752");

					Article article3 = new Article();
					article3.setTitle("第3篇\nNode.js + Expressjs + React.js + mongoosejs 开发实战");
					article3.setDescription("");
					article3.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article3.setUrl("http://edu.csdn.net/combo/detail/170");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
				}
				// 多图文消息---首条消息不含图片
				else if ("4".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("Linux&Git");
					article1.setDescription("Linux相关和Git的基本使用");
					// 将图片置为空
					article1.setPicUrl("");
					article1.setUrl("http://lib.csdn.net/article/linux/53363");

					Article article2 = new Article();
					article2.setTitle("第4篇\n版本管理 RCS CVS SVN Git之比对");
					article2.setDescription("");
					article2.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article2.setUrl("http://lib.csdn.net/article/git/53802");

					Article article3 = new Article();
					article3.setTitle("第5篇\neclipse git 插件集成与本地使用（傻瓜教程 一）");
					article3.setDescription("");
					article3.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article3.setUrl("http://lib.csdn.net/article/git/9355");

					Article article4 = new Article();
					article4.setTitle("第6篇\n利用TortoiseGit（小乌龟）将项目上传至GitHub网站");
					article4.setDescription("");
					article4.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article4.setUrl("http://lib.csdn.net/article/git/53788");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
				}
				// 多图文消息---最后一条消息不含图片
				else if ("5".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("第7篇\nAngular.js v1.6.0-rc.2 和 v1.5.9 发布");
					article1.setDescription("");
					article1.setPicUrl("http://1612w56h01.51mypc.cn/wechat/oschina.jpg");
					article1.setUrl("http://www.oschina.net/news/79367/angularjs-1-6-0-rc2-and-1-5-9");

					Article article2 = new Article();
					article2.setTitle("第8篇\nGit for Windows v2.11.0-rc3.windows.1 发布");
					article2.setDescription("");
					article2.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article2.setUrl("http://www.oschina.net/news/79355/git-for-windows-v2-11-0-rc3-windows-1");

					Article article4 = new Article();
					article4.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号sunnyguy来支持我,更多开源技术可从github获得！");
					article4.setDescription("");
					// 将图片置为空
					article4.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article4.setUrl("https://github.com/");
					
					//提供21个国外网站
					Article article3 = new Article();
					article3.setTitle("第9篇\n友情赠送21个国外热门IT网站...");
					article3.setDescription("");
					article3.setPicUrl("http://1612w56h01.51mypc.cn/wechat/mine.JPG");
					article3.setUrl("http://www.open-open.com/news/view/1c0bf25/");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
				}else if("6".equals(content)){
					Image image = new Image();
					image.setMediaId("zfQNJmOYxXggg0_dySctHV2z2czjqASebUTZJw6AQQKLmpCu6il6ix35TSTKARlt");
					ImageMessage imageMessage = new ImageMessage();
					imageMessage.setFromUserName(toUserName);
					imageMessage.setToUserName(fromUserName);
					imageMessage.setCreateTime(System.currentTimeMillis());
					imageMessage.setMsgType("image");
					imageMessage.setImage(image);
					respMessage = MessageUtil.imageMessage2Xml(imageMessage);
					
					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
					
				}else if("视频".equals(content)){

					System.out.println("&&&&&&&&&&&respMessage&&&&&&&&&&");
					System.out.println(respMessage);
					
				}
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
				// 接收用户发送的事件请求内容
				String Event = requestMap.get("Event");
				String EventKey = requestMap.get("EventKey");
				System.out.println("EventKey:"+Event);
				System.out.println("EventKey:"+EventKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}