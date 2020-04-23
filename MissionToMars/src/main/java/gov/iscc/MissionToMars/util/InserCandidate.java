package gov.iscc.MissionToMars.util;

import java.io.File;
import java.util.*;

public class InserCandidate {


    public void insertData() {

        MongoUtil mongo = new MongoUtil( "MissionToMars","Candidate", 27017);
        int count=1;
        try {
            List<Map<String, Object>> data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            Scanner scanner = new Scanner(new File("src/main/resources/sampleData/countries.csv"));
            while (scanner.hasNextLine()) {

                System.out.println("here");
                map.put("countryName",scanner.nextLine());
                map.put("_id",count);
                count++;
                data.add(map);
                map = new HashMap<>();

            }
            mongo.addMultipleDocuments(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
