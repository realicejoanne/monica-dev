package unpad.rockbottom.monica;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FragmentHome extends Fragment {
    private LinearLayout linear_cbs_btn,
                linear_cm_create;
    private ImageButton cbs_btn,
                cm_create,
                ifest_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Navigate to CBS Committee
        linear_cbs_btn = (LinearLayout) view.findViewById(R.id.cm_cbs);
        linear_cbs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getActivity(), CommitteeView.class);
                    startActivity(i);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbs_btn = (ImageButton) view.findViewById(R.id.cbs_btn);
        linear_cbs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getActivity(), CommitteeView.class);
                    startActivity(i);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Navigate to create Committee
        linear_cm_create = (LinearLayout) view.findViewById(R.id.cm_create);
        linear_cm_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getActivity(), CreateCommittee.class);
                    startActivity(i);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        cm_create = (ImageButton) view.findViewById(R.id.cm_create_btn);
        cm_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getActivity(), CreateCommittee.class);
                    startActivity(i);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Navigate to Test Screen
        ifest_btn = (ImageButton) view.findViewById(R.id.ifest_btn);
        ifest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getActivity(), DeleteLater.class);
                    startActivity(i);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }
}
