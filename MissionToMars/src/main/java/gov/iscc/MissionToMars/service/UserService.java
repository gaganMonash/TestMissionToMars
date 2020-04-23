package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.UserRepo;
import gov.iscc.MissionToMars.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired
    UserRepo userRepo;

public List<User> getAllUsers()
{
    return userRepo.findAll();
}

public User userAuthentication(String userLoginId,String passsword)
{
    System.out.println("In authentication");
    System.out.println(userLoginId);
    System.out.println(passsword);

    return userRepo.findByUserLoginIdAndPassword(userLoginId,passsword);
}

public void updateMissionList(int userId,int missionId )
{
    System.out.println("updateMissionList");

    Optional<User> u = userRepo.findById(userId);
    User oldUser=u.orElse(new User());
    System.out.println(oldUser.getUserName());
    List<Integer> ids = oldUser.getMissionIds();
    if(ids==null)
    {
        ids= new ArrayList<>();
        ids.add(missionId);

    }
    else{
        ids.add(missionId);
    }
    oldUser.setMissionIds(ids);
    System.out.println("inserting");
    userRepo.save(oldUser);
    //userRepo.insert(oldUser);
}
}
