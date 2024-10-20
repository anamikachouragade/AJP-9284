package Utility;

public class AdminQuery {
	 public String insertAdmin(){
	        return "INSERT INTO Admin(username, password) VALUES(?, ?)";
	    }

	    public String selectAdmin(){
	        return "SELECT * FROM Admin WHERE username = ? AND password = ?";
	    }

	    public String updatePassword(){
	        return "UPDATE Admin SET password = ? WHERE username = ?";
	    }
}

