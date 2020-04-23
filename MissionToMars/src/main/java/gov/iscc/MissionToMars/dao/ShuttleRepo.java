package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Shuttle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShuttleRepo extends MongoRepository<Shuttle,Integer> {
}
