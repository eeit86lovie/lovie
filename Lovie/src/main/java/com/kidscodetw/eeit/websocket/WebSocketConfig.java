package com.kidscodetw.eeit.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/queue","/topic");
		registry.setApplicationDestinationPrefixes("/app");
		registry.setUserDestinationPrefix("/user");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/broadcast").withSockJS();
		
	}

}

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//@Configuration
//@EnableWebSocket
//@Controller
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(socketHandler(),"/socket").setAllowedOrigins("*")
//        .addInterceptors(new HttpSessionHandshakeInterceptor());
//    }
//
//    @Bean
//    public WebSocketHandler socketHandler() {
//        return new SocketHandler();
//    }
//
//
//}