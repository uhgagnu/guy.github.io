package org.liufeng.weixin.test;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.liufeng.course.message.resp.Menu;
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
//		AccessToken accessToken = WeixinUtil.getAccessToken("wxf0c766b553e5610c", "abb31e73ed0e5c83e67188c3fc10d39e");
//		System.out.println("票据:"+accessToken.getToken());
	//	System.out.println("有效时间:"+accessToken.getExpiresIn());
		//token l6sIQ6kcIClf4ySqfbXoKr-SrCPJ4bjVMdUzBSC0YV2hZsJYnETSBpfrBbf4a0Xpax9-6HAl6YxAg5XNrPXBPjUBI-KQcLUBhH4WR1EO9oEooAib_ngF-vnVDJFcuwrqUAEaAFAIOS
		//测试上传
	
		
		//String path = "E:\\upload\\luchuan.mp3";
		//String media_id = WeixinUtil.upload(path, "TXLU_KX5tc13pF8iUWEIMyHW6cUJpXCDVISpsmPnqEaNNjcEQDSzaeEEMHRqRt7DIBrKExvA70faQJx-0dhqMJoFS5KyRQ1kpGwD7yXfUBUAREeAFAOFS", "voice");
		//System.out.println("media_id:"+media_id);
		
//		Menu menu = WeixinUtil.initMenu();
//		//转换为字符串(组装菜单的字符串)
//		String strMenu = JSONObject.fromObject(menu).toString();
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$");
//		System.out.println(strMenu);
		
		//调用接口组装菜单
//		int resultCode = 0;
//		resultCode = WeixinUtil.createMenu("w7GeIR-ECmw17xgP6BLZuHJuepgOnwkdsQd65UrlSdtMXCZ2MQSUhy98M-RnNihuAgOMo2GUiQlKnRYeFFFJHK8V1UPxyy1KvLGdLOUSJ3i1N55mcsd1b4NWrWLGc2ghWRLcADARMG", strMenu);
//		if (resultCode==0) {
//			System.out.println("菜单创建成功...");
//			return;
//		}
//		System.out.println("返回的状态吗是:"+resultCode);
		
		
		//查询菜单
		JSONObject jsonObject = WeixinUtil.queryMenu("w7GeIR-ECmw17xgP6BLZuHJuepgOnwkdsQd65UrlSdtMXCZ2MQSUhy98M-RnNihuAgOMo2GUiQlKnRYeFFFJHK8V1UPxyy1KvLGdLOUSJ3i1N55mcsd1b4NWrWLGc2ghWRLcADARMG");
		System.out.println("查询的菜单json数据包为:"+jsonObject);
		
		//删除菜单
//		int result = WeixinUtil.deleteMenu("w7GeIR-ECmw17xgP6BLZuHJuepgOnwkdsQd65UrlSdtMXCZ2MQSUhy98M-RnNihuAgOMo2GUiQlKnRYeFFFJHK8V1UPxyy1KvLGdLOUSJ3i1N55mcsd1b4NWrWLGc2ghWRLcADARMG");
//		if (result == 0) {
//			System.out.println("菜单删除成功...");
//			return ;
//		}
//		System.out.println("删除失败...");
	}  
}  
