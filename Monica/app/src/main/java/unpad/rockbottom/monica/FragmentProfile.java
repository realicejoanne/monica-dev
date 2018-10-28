package unpad.rockbottom.monica;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class FragmentProfile extends Fragment {

    Toolbar mActionBarToolbar;
    private ImageButton cbs_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        cbs_btn = (ImageButton) view.findViewById(R.id.cbs_btn);
        cbs_btn.setOnClickListener(new View.OnClickListener() {
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

        return view;
    }
}