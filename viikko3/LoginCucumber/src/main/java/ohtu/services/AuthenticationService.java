package ohtu.services;

import static java.lang.Character.digit;
import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        
        if (invalid(username, password)){
            return false;
        }
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        
        
        String alph = ".*[a-zA-Z].*";
        String nro = ".*[0-9].*";
        String specials = ".*[!#%&/()=?].*";

        if (username.length()< 3) {
            return true;
        }
        if (password.length()< 8) {
            return true;
        }
        if (!(password.matches(alph)&& (password.matches(nro)||password.matches(specials)))){
            return true;
        }
        return false;
    }
}
