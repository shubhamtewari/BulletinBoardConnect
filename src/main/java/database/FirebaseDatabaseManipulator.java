package database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import core.BoardStructure;

public class FirebaseDatabaseManipulator implements DatabaseManipulatable{

    @Override
    public void testUpload(DatabaseConnectable databaseConnectable, BoardStructure object) throws Exception {
        //databaseConnectable.setupConnection();
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        mRef.child("displayBoard").setValueAsync(object);
    }
}
