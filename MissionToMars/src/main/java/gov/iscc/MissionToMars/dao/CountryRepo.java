package gov.iscc.MissionToMars.dao;

import gov.iscc.MissionToMars.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepo extends MongoRepository<Country, Integer> {
}
