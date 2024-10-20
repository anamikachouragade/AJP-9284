package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.AdminException;
import Model.Admin;
import Utility.AdminQuery;
import Utility.ConnectionFactory;


public class AdminDaoImpl implements AdminDao {
    AdminQuery query = new AdminQuery();

    public String addAdmin(Admin admin) throws AdminException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertAdmin())) {
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Admin Registered Successfully! Now you can login to your account.";
            }
        } catch (SQLException e) {
            throw new AdminException("Unable to add admin: " + e.getMessage());
        }
        return null;
    }

    public boolean authenticate(String username, String password) throws AdminException {
    	 try(Connection con = ConnectionFactory.getInstance().getConnection();
    	      PreparedStatement ps = con.prepareStatement(query.selectAdmin())) {
    	      ps.setString(1, username.trim());
    	      ps.setString(2, password.trim());
    	      ResultSet rs = ps.executeQuery();
    	      return rs.next();
    	  } catch (SQLException e) {
    	            e.printStackTrace();
    	  }
    	  return false;
    }

    public String updatePassword(String username, String newPassword) throws AdminException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.updatePassword())) {
            ps.setString(1, newPassword);
            ps.setString(2, username);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Password Updated Successfully!";
            }
        } catch (SQLException e) {
            throw new AdminException("Unable to update password: " + e.getMessage());
        }
        return null;
    }
}

