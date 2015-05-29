package com.sura.it.management.platforms.model.util;

public class ValidationMessage {

	private MessageType messageType;
	private String message;
	
	public ValidationMessage(MessageType messageType, String message) {
		this.setMessageType(messageType);
		this.setMessage(message);
	}
	
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
