package unpad.rockbottom.monica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.style.Circle;

public class Splash extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Circle circle = new Circle();
        progressBar.setIndeterminateDrawable(circle);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), Auth.class));
            finish();
        }
    }, 3000L); //3000 L = 3 detik
}
}