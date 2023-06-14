package com.example.dm_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.dm_demo.service.LtpServer;
import com.example.dm_demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class ProfitController {


    @Autowired
    private LtpServer ltpServer;

    /**
     * 获取出账地址
     * @return
     */
    @GetMapping("getAddress")
    public Result getAddress(){
        JSONObject rechargeAddress = ltpServer.getRechargeAddress();
        log.info("返回的参数是：{}", rechargeAddress);
        return Result.success(rechargeAddress);
    }

    /**
     * 推送分成数据
     * @return
     */
    @GetMapping("pushAmount")
    public Result pushAmount(){
        JSONObject b = ltpServer.partitionToUser("OSNU6ngAAQCRpMf3jopJ6bQjr4Uu568sx2FoqkK6SD6MVpSuJPD",
                "com.jtalking10",
                "USDT",
                BigDecimal.ONE,
                "12312312",
                "2023-06-13 10:43:00");
        log.info("返回的参数是：{}", b);
        return Result.success(b);
    }
}
