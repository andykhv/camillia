package com.andykhov.camillia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class OutputMessage {
	@Getter @Setter private String author;
	@Getter @Setter private String body;
	@Getter @Setter private String timestamp;
}
