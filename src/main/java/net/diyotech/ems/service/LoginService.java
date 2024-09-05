package net.diyotech.ems.service;

import net.diyotech.ems.model.UserLogin;
import net.diyotech.ems.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    /*private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }*/

    public void login(UserLogin userLogin) {
        System.err.println("Iniside login service login  method");
        System.err.println(userLogin.getUsername()+" : "+userLogin.getPassword());
    }
}
