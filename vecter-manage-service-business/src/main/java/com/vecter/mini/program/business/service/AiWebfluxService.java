package com.vecter.mini.program.business.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AiWebfluxService {

    @Tool(description = "通给出的物料编码获取物料库存信息")
    public String getWeather(@ToolParam(description = "物料编码") String productName) {
        // 创建 Random 对象
        Random random = new Random();
        // 生成一个随机整数
        int randomInt = random.nextInt();
        // 生成一个 0 到 99 之间的随机整数
        int randomIntInRange = random.nextInt(100);

        return "物料编码" +productName +  "库存是" + randomIntInRange+"PCS";
    }
}
