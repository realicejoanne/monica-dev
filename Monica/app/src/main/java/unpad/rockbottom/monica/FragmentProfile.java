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


        return view;
    }
}