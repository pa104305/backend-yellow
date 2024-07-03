package backend;

import spark.Response;

public class Auth {
    Database db;
    public Auth(){
        db = new Database();
    }
    
    public boolean tryAuth(String email, String password, Response res){
        db.initConnection();
        String[] dataAuth = db.searchUserInfo(email);
        db.closeConnection();
        
        if(email.equals(dataAuth[2]) && password.equals(dataAuth[3])){
            res.cookie("/", "email", dataAuth[2], -1, true, true);
            res.cookie("/", "isAuth", "1", -1, true, true);
            return true;
        }
        return false;
    }
}
