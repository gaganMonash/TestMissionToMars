package gov.iscc.MissionToMars.api;

import gov.iscc.MissionToMars.dao.UserRepo;
import gov.iscc.MissionToMars.model.Administrator;
import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.service.MissionService;
import gov.iscc.MissionToMars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MissionController {

    @Autowired
    MissionService missionService;
    @Autowired
    UserService userService;
    @PostMapping("/addMission")
    public void addMission(@RequestBody Mission mission)
    {
        try {

            userService.updateMissionList(mission.getCoordinator().getUserId(), mission.getMissionId());
        }catch (Exception e)
        {
            System.out.println("IDHAR AAYA AHAIIIIII");
            e.printStackTrace();
        }

        List<Administrator> administrators = mission.getAdministrators();
        for (Administrator admin :
                administrators) {
            userService.updateMissionList(admin.getUserId(), mission.getMissionId());

        }

        missionService.addMission(mission);

    }
@GetMapping("/getMission")
    public List<Mission>getMissions()
    {
        return missionService.getMissions();
    }
    @PostMapping
    public void selectShuttle(Mission m,String shuttleId)
    {

    }

}
