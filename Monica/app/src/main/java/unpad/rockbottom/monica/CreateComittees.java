package unpad.rockbottom.monica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class CreateComittees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comittees);
        Toolbar toolbar = (Toolbar) findViewById(R.id.create_comittees_appbar);
        setSupportActionBar(toolbar);
    }
}
