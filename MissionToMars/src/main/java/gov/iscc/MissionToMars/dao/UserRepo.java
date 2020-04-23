package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@org.springframework.stereotype.Repository
public interface UserRepo extends MongoRepository<User,Integer> {

    public User findByUserLoginIdAndPassword(String userLoginId, String password);

}
