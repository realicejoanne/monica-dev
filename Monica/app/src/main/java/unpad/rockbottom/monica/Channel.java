package unpad.rockbottom.monica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Channel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
    }

    public void onClickChannelRoom (View view){
        try {
            Intent i = new Intent(Channel.this, ChannelRoom.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
