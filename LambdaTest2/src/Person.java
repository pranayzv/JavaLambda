
public class Person {

	private String firstName;
	private String middleName;
	private int mobileNumber;
	
	public Person() {}
	
	public Person(String firstName, String middleName, int mobileNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
