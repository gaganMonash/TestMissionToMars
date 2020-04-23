package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "Mission")
public class Mission {
@Id
    int missionId;
    String missionName;
    String missionDescription;
    Country countryOrigin;
    List<Country> allowedCountries;
    Coordinator coordinator;
    List<Job>jobs;
    List<Requirement>requirements;
    Date launchDate;
    String status;
    String duration;
    List<Administrator>administrators;
    List<Shuttle>shuttles;






}
