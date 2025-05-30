package com.vecter.mini.program.business.config;

import com.vecter.mini.program.business.service.AiWebfluxService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpToolsConfig {

    @Resource
    private ChatModel chatModel;

    @Resource
    private AiWebfluxService aiWebfluxService;
    @Bean
    public ChatClient chatModelClient() {
        return ChatClient
                .builder(chatModel)
                .defaultTools(MethodToolCallbackProvider.builder().toolObjects(aiWebfluxService).build())
                .build();
    }

}
