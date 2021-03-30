package cn.service.impl;

import cn.service.SmsphoneService;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

/**
 * @Auther: lixiaofeng
 * @Date:2021/3/26 10:37
 * @Description:
 * @version：1.0
 **/
@Service
public class SmsphoneSerivceimpl implements SmsphoneService {

    @Override
    public int Smsmsg(String target) {
        String serverIp = "app.cloopen.com";
//请求端口
        String serverPort = "8883";
//主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8aaf0708780055cd01786c5f651129c0";
        String accountToken = "f577e2718077481e9273bca6b3d04184";
//请使用管理控制台中已创建应用的APPID
        String appId = "8aaf0708780055cd01786c5f661d29c7";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        int code = (int)(Math.random()*(9999-1000)+1000);
        String[] datas = {String.valueOf(code),"3"};
        String subAppend="1234"; //可选 扩展码，四位数字 0~9999
        String reqId="abc"; //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        HashMap<String, Object> result = sdk.sendTemplateSMS(target,"1",datas);
// HashMap<String, Object> result =sdk.sendTemplateSMS(target,templateId,datas,subAppend,reqId);
        if("000000".equals(result.get("statusCode"))){
            System.out.println("===========短信发送成功============");
//正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>)
                    result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
//异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息 = "+result.get("statusMsg"));
        }
        return  code;
    }

}