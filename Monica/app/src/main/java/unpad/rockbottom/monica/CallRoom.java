package unpad.rockbottom.monica;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class CallRoom extends AppCompatActivity {

    private ImageButton speak_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_room);

        speak_btn = (ImageButton) findViewById(R.id.speak_btn);
    }
}
