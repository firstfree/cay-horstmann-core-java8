package ch04.sec02;

import java.util.ArrayList;

public final class Message implements Cloneable {
	private String sender;
	private ArrayList<String> recipients;
	private String text;
	
	public Message(String sender, String text) {
		this.sender = sender;
		this.text = text;
		recipients = new ArrayList<>();
	}
	
	public String getSender() {
		return this.sender;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void addRecipient(String recipient) {
		recipients.add(recipient);
	}
	
	@Override
	public Message clone() {
		try {
			Message cloned = (Message) super.clone();
			@SuppressWarnings("unchecked") ArrayList<String> clonedRecipients 
				= (ArrayList<String>) recipients.clone();
			cloned.recipients = clonedRecipients;
			return cloned;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
