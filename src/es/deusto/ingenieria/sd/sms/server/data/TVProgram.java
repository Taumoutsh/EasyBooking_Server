package es.deusto.ingenieria.sd.sms.server.data;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class TVProgram implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String acronym;
	private String description;
	private List<Message> messages;

	public TVProgram(String a, String d) {
		acronym = a;
		description = d;
		messages = new ArrayList<>();
	}

	public void setDescription(String d) {
		description = d;
	}

	public void setAcronym(String a) {
		acronym = a;
	}

	public String getDescription() {
		return description;
	}

	public String getAcronym() {
		return acronym;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void createMessage(String ph, String t) {
		messages.add(new Message(ph, t));
	}

	public void deleteMessage(Message m) {
		messages.remove(m);
	}
}