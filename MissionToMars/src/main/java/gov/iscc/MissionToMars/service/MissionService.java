package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.MissionRepo;
import gov.iscc.MissionToMars.model.Mission;
import gov.iscc.MissionToMars.model.Shuttle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissionService {
    @Autowired
MissionRepo missionRepo;

public void addMission(Mission mission)
{
    missionRepo.insert(mission);
}
public List<Mission> getMissions(){return missionRepo.findAll();}
public void addShuttle(Shuttle shuttle,Mission mission)
{
    List<Shuttle> shuttles = mission.getShuttles();
    if(shuttles==null || shuttles.isEmpty())
    {
        shuttles= new ArrayList<>();
        shuttles.add(shuttle);
    }
    else{
        shuttles.add(shuttle);
    }
    mission.setShuttles(shuttles);
    missionRepo.save(mission);
}

}
