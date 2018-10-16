package unpad.rockbottom.monica;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectedCommitee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_commitee);
    }

    // Connect with others
    public void onClickChatRoom(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, ChatRoom.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickLiveCall(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, LiveCall.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickChannels(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, Channels.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Features
    public void onClickToDOList(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, ToDoList_Activity.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickItemList(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, ItemList_Activity.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickFiles(View view){
        try {
            Intent i = new Intent(SelectedCommitee.this, Files_Activity.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
