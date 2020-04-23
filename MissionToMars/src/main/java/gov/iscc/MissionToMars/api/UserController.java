package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.dao.UserRepo;
import gov.iscc.MissionToMars.model.User;
import gov.iscc.MissionToMars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findAll")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @PostMapping("/authenticate")
    public User login(@RequestBody User u)
    {
        System.out.println("In authentication contr.");
        System.out.println(u.getUserLoginId());
        System.out.println(u.getPassword());

    return userService.userAuthentication(u.getUserLoginId(),u.getPassword());
    }


}
