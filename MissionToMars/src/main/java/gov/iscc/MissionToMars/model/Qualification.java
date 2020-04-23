package gov.iscc.MissionToMars.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Qualifications")
public class Qualification {

    String qualificationName;
}
