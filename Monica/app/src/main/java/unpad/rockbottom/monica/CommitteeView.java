package unpad.rockbottom.monica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CommitteeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committee);
    }

    // Connect with others
    public void onClickChatRoom(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Chat.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickLiveCall(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Call.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickChannels(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Channel.class);
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
            Intent i = new Intent(CommitteeView.this, ToDoList.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickItemList(View view){
        try {
            Intent i = new Intent(CommitteeView.this, ItemList.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickFiles(View view){
        try {
            Intent i = new Intent(CommitteeView.this, FileCloud.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
