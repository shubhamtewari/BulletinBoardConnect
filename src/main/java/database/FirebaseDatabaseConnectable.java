package database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import exceptions.DuplicateConnectionToDatabaseException;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;

public class FirebaseDatabaseConnectable implements DatabaseConnectable{
    @Override
    public boolean setupConnection(boolean isBoardOnline, String path) throws Exception {
        FirebaseApp firebaseApp = null;
        if(isBoardOnline) {
            throw new DuplicateConnectionToDatabaseException();
        }
        else {
            try {
                FileInputStream serviceAccount =
                        new FileInputStream(path);
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://notice-board-60616.firebaseio.com")
                        .setStorageBucket("notice-board-60616.appspot.com")
                        .build();

                firebaseApp = FirebaseApp.initializeApp(options);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if(firebaseApp!=null) {
                    FirebaseApp.getInstance().delete();
                }
                //setupConnection(isBoardOnline, path);
            }
        }
        return true;
    }

    @Override
    public boolean disconnectDatabase() {
        try {
            FirebaseApp.getInstance().delete();
        } catch (IllegalStateException e) {
            return false;
        }
        return true;
    }
}
