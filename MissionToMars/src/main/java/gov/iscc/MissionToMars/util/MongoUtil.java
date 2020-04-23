package gov.iscc.MissionToMars.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoUtil {
    private final String mongoDBName;
    private final String mongoCollectionName;
    private final int mongoPort;
    private final String host_name = "localhost";

    public MongoUtil(String mongoDBName, String mongoCollectionName, int mongoPort) {
        this.mongoDBName = mongoDBName;
        this.mongoCollectionName = mongoCollectionName;
        this.mongoPort = mongoPort;
    }


    public  void addMultipleDocuments(List<Map<String,Object>> data) {


        // Mongodb connection string.
        String client_url = "mongodb://" + host_name + ":" + mongoPort + "/" + mongoDBName;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(mongoDBName);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(mongoCollectionName);

        List<Document> docs = new ArrayList<Document>();
        for (Map<String,Object> doc:data) {
            Document dc= new Document();
            System.out.println(doc);
            System.out.println("-----");
            dc.putAll(doc);

            docs.add(new Document(dc));
        }

        MongoCollection<Document> col = db.getCollection(mongoCollectionName);
        col.insertMany(docs);
    }

    // Fetching all documents from the mongo collection.
    private static void getAllDocuments(MongoCollection<Document> col) {


        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {

        // Mongodb initialization parameters.
        int port_no = 27017;
        String host_name = "localhost", db_name = "MissionToMars", db_coll_name = "Shuttle";

        // Mongodb connection string.
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(db_name);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(db_coll_name);

        // Adding a single document in the mongo collection.
        //addOneDocument(coll);

        // Adding the multiple documents in the mongo collection.
       // addMultipleDocuments(   new ReadCSV().read("src/main/resources/shuttle.csv"),coll);

        // Fetching all the documents from the mongodb.
      //  getAllDocuments(coll);
    }
}
