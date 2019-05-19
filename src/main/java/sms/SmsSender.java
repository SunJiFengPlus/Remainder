package sms;

import constant.SmsTypeEnum;

/**
 * 责任链: 腾讯SMS -> 极光SMS -> ...
 * 腾讯SMS 每月赠送 100 条短信, 优先使用赠送的短信
 * 极光SMS 相对较便宜 1000条/19.9元
 *
 * @author 孙继峰
 * @date 2019/05/17
 */
public abstract class SmsSender {

    protected SmsSender nextSmsSender;

    public void setNextSmsSender(SmsSender nextSmsSender) {
        this.nextSmsSender = nextSmsSender;
    }

    /**
     * 发送短信
     * @param type 发送的短信类型
     */
    public abstract void sendSms(SmsTypeEnum type);
}
