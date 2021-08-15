package com.andykhov.camillia;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/*
Multi-User Chat App is created with a Pub/Sub model with STOMP and WebSocket
The configuration sets up a message broker at /topic, in which /topic/<name> could be a topic
STOMP handshake is at /chat with SockJS fallback

A SockJS client will:
	1. connect at /chat to register to the websocket endpoint
	2. subscribe to a topic at /topic/<name>
	3. send messages to the application through /app/<name>
	4. the application controller will receive the message and send that message to the message broker
*/

@SpringBootApplication
@Controller
public class CamilliaApplication {

	private static final Logger LOG = LogManager.getLogger(CamilliaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CamilliaApplication.class, args);
	}

	@MessageMapping("/{room}")
	public OutputMessage send(final Message message, @DestinationVariable final String room) throws Exception {
		LOG.debug("Room: " + room + " Message: " + message);
		final String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getAuthor(), message.getBody(), time);
	}
}
