package Pack01;

public class AccountDTO {
	String name;
	String rrn;
	
	public AccountDTO(String name, String rrn) {
		super();
		this.name = name;
		this.rrn = rrn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	
	
}
