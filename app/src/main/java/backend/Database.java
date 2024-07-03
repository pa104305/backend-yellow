package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String route = "jdbc:mysql://127.0.0.1:8291/";
    private String user = "";
    private String password = "";
    private Connection db;
    private Statement search;
    private ResultSet data;


    public Database(){}

    public void initConnection(){
        try{
            db = DriverManager.getConnection(route, user, password);
        }catch(SQLException e){
            System.out.println("Codigo de error: " + e.getMessage());
        }
    }

    public void closeConnection(){
        try{
            db.close();
        }catch(SQLException e){
            System.out.println("Codigo de error: " + e.getMessage());
        }
    }

    public String[] searchUserInfo(String email){
        String[] userData = null;
        try {
            String query = "SELECT * FROM ye8291.users WHERE email = '" + email + "';";
            search = db.createStatement();
            data = search.executeQuery(query);
            if(data.next()){
                userData = new String[6];
                for(int i = 0; i < 6; i++){
                    userData[i] = data.getString(i + 1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Codigo de error: " + e.getMessage());
        }
        return userData;
    }
}
