package co.eltiempo.controllers.aux;

/**
 * 
 * @author Felipe Triana
 * @version 1.0
 */
public class UserSignIn {

	private String email;

	private String password;

	/**
	 * Default Constructor
	 */
	public UserSignIn() {

	}

	/**
	 * 
	 * 
	 * @param email
	 * @param password
	 */
	public UserSignIn(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
