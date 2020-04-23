package gov.iscc.MissionToMars.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString

@Document(collection = "Users")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String userLevel;
    private String password;
    private String userLoginId;
    List<Integer>missionIds;

public void addMissionId()
{}

}
