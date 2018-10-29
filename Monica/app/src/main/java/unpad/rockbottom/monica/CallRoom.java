package unpad.rockbottom.monica;

import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class CallRoom extends AppCompatActivity {

    private ImageButton speak_btn;
    private ImageButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_room);

        speak_btn = (ImageButton) findViewById(R.id.speak_btn);
        back_btn = (ImageButton) findViewById(R.id.back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onStop();
                        finish();
                    }
                });
            }
        });
    }
}
