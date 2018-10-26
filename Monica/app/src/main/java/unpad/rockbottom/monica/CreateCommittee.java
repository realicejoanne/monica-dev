package unpad.rockbottom.monica;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateCommittee extends AppCompatActivity {
    //    LinearLayout veronica;
//    int heightImage = 50;
//    int widthImage = 50;
    String divisionName;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_committee);
        Button addDivision = (Button) findViewById(R.id.add_division_icon);
        final EditText addDivisionName = (EditText) findViewById(R.id.add_division_name);
        final ArrayList<AddDivision> AddDivisions = new ArrayList<AddDivision>();
        final AddDivisionAdapter adapter = new
                AddDivisionAdapter(this,AddDivisions);
        ListView listView = (ListView) findViewById(R.id.add_division_list);
        listView.setAdapter(adapter);
        addDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divisionName = addDivisionName.getText().toString();
                AddDivisions.add(new AddDivision(divisionName));
                adapter.notifyDataSetChanged();
            }
        });

    }
}
