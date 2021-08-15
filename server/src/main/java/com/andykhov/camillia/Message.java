package com.andykhov.camillia;

import lombok.Getter;
import lombok.Setter;

public class Message {
	@Getter @Setter private String author;
	@Getter @Setter private String body;	

	@Override
	public String toString() {
		return this.author + ":" + this.body;
	}
}
