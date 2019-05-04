package database;


import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import core.BoardStructure;
import core.NoticeStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FirebaseDatabaseManipulator implements DatabaseManipulatable{

    @Override
    public void uploadBoard(BoardStructure object, String workspaceName) throws Exception {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        mRef.child("hj");
        mRef.child(workspaceName).child("displayBoard").setValueAsync(object);
    }

    @Override
    public void uploadHPP(File fileImage, boolean update, NoticeStructure noticeStructure, String workspaceName) throws IOException {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        if(!update) {
            mRef.child(workspaceName).child("adminNotices").setValueAsync(null);
        }
        Bucket bucket = StorageClient.getInstance().bucket();
        bucket.create("AdminNotices/"+workspaceName+"/" + noticeStructure.getNoticeTimeStamp(), Files.readAllBytes(fileImage.toPath()), Bucket.BlobTargetOption.doesNotExist());
        mRef.child(workspaceName).child("adminNotices").push().setValueAsync(noticeStructure);
        mRef.child("AdminNoticesStorage").child(workspaceName).push().setValueAsync(noticeStructure);

    }

    public void getWorkspaces() {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    }
}
