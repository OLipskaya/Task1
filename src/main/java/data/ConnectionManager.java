package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager {
    private ResourceBundle resource;
    private Connection connect = null;

    public ConnectionManager() {
        resource = ResourceBundle.getBundle("data");
    }

    public Connection getConnection() throws SQLException {
        String uri = resource.getString("uri");
        String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("pass");
        try {
            Class.forName(driver).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(uri, user, pass);
    }

    public void closeConnection(){
        try {
            connect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
