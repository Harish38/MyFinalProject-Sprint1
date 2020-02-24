package healthcaresystemproject.dto;

public class User {
   String userId;
   String userPassword;
   String userName;
   long contactNo;
   String userRole;
   String email;
public User()
{
	
}
public User(String userId, String userPassword, String userName, long contactNo, String userRole, String email) {
	super();
	this.userId = userId;
	this.userPassword = userPassword;
	this.userName = userName;
	this.contactNo = contactNo;
	this.userRole = userRole;
	this.email = email;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public long getContactNo() {
	return contactNo;
}
public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
			+ contactNo + ", userRole=" + userRole + ", email=" + email + "]";
}


}
