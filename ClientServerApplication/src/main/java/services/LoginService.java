package services;

import services.db.LoginDBService;

public class LoginService {

    public Boolean auth(String login, String pass){
        HashService hashService = new HashService();
        String passHash = hashService.createHash(pass);
        pass = hashService.createHash(pass);
        LoginDBService loginDBService = new LoginDBService();
        String getPass = loginDBService.getPassByLogin(login);
        if(getPass != null && passHash.equals(getPass)){
            return true;
        }
        return false;
    }

}
