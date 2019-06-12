package sms;

import bean.TencentCloudSmsConfig;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import constant.SmsTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.CollectionUtil;

/**
 * @author 孙继峰
 * @date 2019/05/15
 */
@Component
@Slf4j
public class TencentCloudtSmsSender extends SmsSender {

    private final TencentCloudSmsConfig config;

    @Autowired
    public TencentCloudtSmsSender(TencentCloudSmsConfig config) {
        this.config = config;
    }

    /**
     * 发送短信
     *
     * @param type 发送的短信类型
     */
    @Override
    public void sendSms(SmsTypeEnum type) {
        int[] templateIds = config.getTemplates().get(type);
        int templateId = CollectionUtil.getRandomElement(templateIds);

        boolean sendFailed = !sendSmsByTemplateId(templateId);
        if (sendFailed && nextSmsSender != null) {
            nextSmsSender.sendSms(type);
        }
    }

    /**
     * 发送成功时对应的 result 值
     */
    private static final int SUCCESS = 0;
    /**
     * 中国国家编号
     */
    private static final String CN = "86";

    /**
     * 使用短信模板发送短信
     * TODO: AOP 日志
     *
     * @param templateId 从接口提供商获取的短信模板
     * @return 短信发送成功返回 true, 发送失败返回 false
     */
    private boolean sendSmsByTemplateId(int templateId) {
        SmsSingleSender ssender = new SmsSingleSender(config.getAppId(), config.getAppKey());
        SmsSingleSenderResult result = new SmsSingleSenderResult();

        try {
            result = ssender.sendWithParam(CN, config.getReceiver(),
                    templateId, new String[]{}, null, null, null);
            log.info("发送至 {}, 发送结果:{}, 原因:{}", config.getReceiver(),
                    result.result == SUCCESS ? "SUCCESS" : "FAIL", result.errMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.result == SUCCESS;
    }
}