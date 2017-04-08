package Classes;

public class User {
	
	protected String firstName;
	protected String lastName;
	protected String password;
	
	public User(){		
		firstName = "";
		lastName = "";
		password = "";
	}
	
	public User(String fn, String ln, String pword){
		
		firstName = fn;
		lastName = ln;
		password = pword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void displayuser(){
		System.out.println(firstName +""+ lastName);
	}
}