package gov.iscc.MissionToMars.service;

import gov.iscc.MissionToMars.dao.ShuttleRepo;
import gov.iscc.MissionToMars.model.Shuttle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShuttleService {
    @Autowired
    ShuttleRepo shuttleRepo;

    public List<Shuttle> findAllShuttles()
    {
        return shuttleRepo.findAll();
    }

}
