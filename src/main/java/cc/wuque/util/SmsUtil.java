package cc.wuque.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 腾讯云手机验证码工具类
 *
 * @Author 无缺
 * @Date 2021/3/21 20:17
 */
@Component
@PropertySource(value = "classpath:config.properties",encoding = "UTF-8")
public class SmsUtil implements Serializable {

    @Value("${tencent.secretId}")
    private String secretId;
    @Value("${tencent.secretKey}")
    private String secretKey;
    @Value("${tencent.appid}")
    private String appid;
    @Value("${tencent.sign}")
    private String sign;
    @Value("${tencent.templateID}")
    private String templateID;


    public SendSmsResponse sendSms(String phoneNumber,String codeNum){
        try{

            Credential cred = new Credential(secretId, secretKey);

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {"+86" + phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID(templateID);
            req.setSign(sign);

            String[] templateParamSet1 = {codeNum};
            req.setTemplateParamSet(templateParamSet1);

            req.setSmsSdkAppid(appid);

            SendSmsResponse resp = client.SendSms(req);

            return resp;

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
