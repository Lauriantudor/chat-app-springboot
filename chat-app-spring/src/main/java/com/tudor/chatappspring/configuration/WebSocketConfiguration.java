package com.tudor.chatappspring.configuration;

import com.tudor.chatappspring.handler.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    private final static String Chat_endpoint = "/chat";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler(), Chat_endpoint)
                .setAllowedOriginPatterns("*");
    }
    @Bean
    public WebSocketHandler webSocketHandler(){
        return new WebSocketHandler();
    }
}
