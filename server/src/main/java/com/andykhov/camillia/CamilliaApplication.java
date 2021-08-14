package com.andykhov.camillia;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class CamilliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamilliaApplication.class, args);
	}

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(final Message message) throws Exception {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getAuthor(), message.getBody(), time);
	}
}
