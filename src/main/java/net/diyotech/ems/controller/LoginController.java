package net.diyotech.ems.controller;

import jakarta.validation.Valid;
import net.diyotech.ems.model.UserLogin;
import net.diyotech.ems.service.LoginService;
import net.diyotech.ems.service.StudentService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    //1. Field based Injection
    /*@Autowired
    private LoginService loginService;

    @Autowired
    private StudentService studentService;*/

    private final LoginService loginService;
    private final StudentService studentService;
    //2. Constructor Injection (Recommended way)
    public LoginController(LoginService loginService, StudentService studentService) {
        this.loginService = loginService;
        this.studentService = studentService;
    }

    //3. Setter Injection
    /*@Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }*/

    // URL: http://localhost:8082/login/userlogin
    //@PostMapping("/userlogin")
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public ResponseEntity<UserLogin> login(@Valid @RequestBody UserLogin userLogin) {
        //return new ResponseEntity<>(userLogin, HttpStatus.INTERNAL_SERVER_ERROR);
        //return ResponseEntity.ok(userLogin);
        loginService.login(userLogin);
        return ResponseEntity.ok().body(userLogin);
    }
}
