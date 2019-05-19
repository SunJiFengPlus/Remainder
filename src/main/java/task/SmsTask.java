package task;

import constant.SmsTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sms.SmsSender;

import java.util.Date;

/**
 * @author 孙继峰
 * @date 2019/05/13
 */
@Component
public class SmsTask {

    private final SmsSender smsSender;

    @Autowired
    public SmsTask(SmsSender tencentSmsSender) {
        this.smsSender = tencentSmsSender;
    }

    /**
     * 每天早上 6 点
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void morning() {
//        smsSender.sendSms(SmsTypeEnum.MORNING);
        System.out.println(new Date() + " " + SmsTypeEnum.MORNING);
    }

    /**
     * 每天 6:00 - 21:00 点, 初定每隔三个小时提醒一次喝水
     * 子表达式小时只能是 6-21, 或 6/3, 并不能组合使用
     */
    @Scheduled(cron = "0 0 9,12,15,18,21 * * ?")
    public void drink() {
//        smsSender.sendSms(SmsTypeEnum.DRINK);
        System.out.println(new Date() + " " + SmsTypeEnum.DRINK);
    }

    /**
     * 农历生日还真是不好弄呢, 一年维护一次?
     * 四月拾肆
     * 2020 5 6
     * 2021 5 25
     * 2022 5 14
     * 2023 6 1
     * 2024 5 21
     */
    @Scheduled(cron = "0 0 0 6 5 ? 2020")
    public void birthday() {
//        smsSender.sendSms(SmsTypeEnum.BIRTHDAY);
    }

    /**
     * 希望我能维护到这一天
     */
//    @Scheduled(cron = "")
    public void weddingDay () {

    }
}
