package Model;



public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    

    // Constructor
    public Customer() {
    	
    }
    
    public Customer(String name, String email) {
        
        this.name = name;
        this.email = email;
        
    }

    public Customer(String name,  String phone, String email, String username, String password) {
		super();
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' + 
                '}';
    }

	

}
