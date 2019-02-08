package database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * to setup connection to the mongodb database
 */
public class JongoDatabaseConnection implements DatabaseConnectable {
    @Override
    public boolean setupConnection(boolean flag, String path) throws Exception {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://12345:12345@ghurdauriconnect-8rxjo.mongodb.net/test?retryWrites=true");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("TestDatabase");
        /*
        DB db = new MongoClient().getDB("mongodb+srv://12345:12345@ghurdauriconnect-8rxjo.mongodb.net/TestDatabase?retryWrites=true");
        Jongo jongo = new Jongo(db);

        MongoCollection testCollection = jongo.getCollection("TestCollection");

        testCollection.insert("{name:'Shubham Tewari', year:3}");
        */
        return false;
    }
}
