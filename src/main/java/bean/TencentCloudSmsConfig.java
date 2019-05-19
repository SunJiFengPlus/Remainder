package bean;

import constant.SmsTypeEnum;
import lombok.Data;

import java.util.Map;

/**
 * @author 孙继峰
 * @date 2019/05/18
 */
@Data
public class TencentCloudSmsConfig {
    /**
     * 接收人手机号
     */
    String receiver;
    /**
     * Key: 短信类型, Value: 短信类型对应的模板 id 集合
     */
    Map<SmsTypeEnum, int[]> templates;

    int appId;
    String appKey;
}
