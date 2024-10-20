package Service;


import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Exception.AdminException;
import Model.Admin;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao;

    public AdminServiceImpl() {
        this.dao = new AdminDaoImpl();
    }

    @Override
    public String addAdmin(Admin admin) throws AdminException {
    	return dao.addAdmin(admin);
    }


	public boolean authenticate(String username, String password) throws AdminException {
	
		return dao.authenticate(username, password);
	}

	public String updatePassword(String username, String newPassword) throws AdminException {
		
		return dao.updatePassword(username, newPassword);
	}
    
    
}

