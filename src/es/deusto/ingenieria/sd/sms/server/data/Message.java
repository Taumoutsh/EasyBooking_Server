package es.deusto.ingenieria.sd.sms.server.data;

public class Message {
	private String phone;
    private String text;
    
    public Message(String phone, String text) {
        this.phone = phone;
    	this.text = text;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}