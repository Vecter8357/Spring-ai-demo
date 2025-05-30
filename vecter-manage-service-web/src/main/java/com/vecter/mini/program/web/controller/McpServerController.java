package com.vecter.mini.program.web.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/mcp")
public class McpServerController {

    @Resource
    private OllamaChatModel chatModel;

    @Resource
    private ChatClient chatModelClient;

    /**
     * 本地调用ollama
     * @param message
     * @return
     */
    @PostMapping("/ollam")
    public String ollam(@RequestParam String message){
        message = "请使用中文简体回答：" + message;
        Prompt prompt = new Prompt(new UserMessage(message));
        ChatResponse call = chatModel.call(prompt);
        String callstr = call.toString();
//        String call = ollamaChatModel.call(message);
        log.info(callstr);
        return message;
    }

    /**
     * 挂载tools调用Ollama
     * @param message
     * @return
     */
    @GetMapping("/mcpServer")
    public String mcpServer(@RequestParam String message){
        ChatClient.CallResponseSpec call = chatModelClient.prompt(message).call();
        log.info(call.content());
        return call.content();
    }


}
