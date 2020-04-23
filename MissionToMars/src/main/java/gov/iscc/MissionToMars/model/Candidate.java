package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document
public class Candidate extends User {


    String dateOfBirth;
    String street;
    String city;
    String postal;
    Country country;
    String phone;
    String identificationType;
    String Gender;
    List<String> allergies;
    String foodPreferences;
    List<String> qualifications;
    int yearOfExperience;
    List<String> ocupations;
    String computerSkill;
    List<String> languagesKnown;




}
