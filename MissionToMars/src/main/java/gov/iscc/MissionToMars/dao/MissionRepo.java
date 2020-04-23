package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Mission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MissionRepo extends MongoRepository<Mission,Integer> {


}
