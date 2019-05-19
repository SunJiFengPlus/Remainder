package sms;

import constant.SmsTypeEnum;

/**
 * @author 孙继峰
 * @date 2019/05/17
 */
public class JiGuangSmsSender extends SmsSender {


    /**
     * 使用短信模板发送短信
     *
     * @param phone      收信人手机号
     * @param templateId 从接口提供商获取的短信模板
     * @return 短信发送成功返回 true, 发送失败返回 false
     */
    protected boolean sendSmsByTemplateId(String phone, int templateId) {
        return false;
    }

    /**
     * 发送短信
     *
     * @param type 发送的短信类型
     */
    @Override
    public void sendSms(SmsTypeEnum type) {

    }
}
