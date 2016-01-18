package data;

import java.sql.*;

public class DataBaseManager {

    private Connection cn;
    private ConnectionManager manager;

    private String className = "";
    private static String TABLE1 = "classes";
    private static String TABLE2 = "keywords";
    private static String index1 = "binded_class";
    private static String index2 = "classname";

    public String getClassName() {
        return className;
    }

    public DataBaseManager() {
        manager = new ConnectionManager();
        try {
            cn = manager.getConnection();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void start(String key){
        try {
            int binded_class = query1(key);
            if(binded_class > 0){
                query2(binded_class);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private int query1(String key) throws SQLException {
        String selectSt1 = "SELECT * FROM "+TABLE2+" WHERE keyword="+"'"+key+"'";
        Statement st = null;
        ResultSet rs = null;
        int index = -1;
        try {
            st = cn.createStatement();
            if(!st.equals(null)){
                rs = st.executeQuery(selectSt1);
                if(!rs.equals(null)){
                    while(rs.next()) {
                        index = rs.getInt(index1);
                    }
                } else { throw new Exception("Keyword not found!"); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null){ rs.close(); }
            if(!st.equals(null)){ st.close(); }
        }
        return index;
    }

    private void query2(int bindClass) throws SQLException {
        String id = Integer.toString(bindClass);
        String selectSt2 = "SELECT * FROM "+TABLE1+" WHERE id="+id;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            if(!st.equals(null)){
                rs = st.executeQuery(selectSt2);
                if(!rs.equals(null)){
                    while(rs.next()) {
                        className = rs.getString(index2);
                    }
                } else { throw new Exception("ClassName not found!"); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null){ rs.close(); }
            if(!st.equals(null)){ st.close(); }
        }
    }

    /* Adding a new device */
    public void insertDevice(String name, String keyWord, int id) throws SQLException {
        String inStatement = "INSERT INTO " + TABLE1 +" VALUES (?,?)";
        String insStatement = "INSERT INTO " + TABLE2 +" VALUES (?,?,?)";
        PreparedStatement ps = null, prs = null;
        try {
            ps = cn.prepareStatement(inStatement);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.executeUpdate();
            prs = cn.prepareStatement(insStatement);
            prs.setInt(1,id);
            prs.setString(2,keyWord);
            prs.setInt(3,id);
            prs.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){ ps.close(); }
        }
    }

}
