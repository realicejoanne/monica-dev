package unpad.rockbottom.monica;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class AddDivisionAdapter extends ArrayAdapter<AddDivision> {
    public AddDivisionAdapter(Activity context, ArrayList<AddDivision> adapter){
//        Contructor for costum WordAdapter
//        The second argument is used when the ArrayAdapter is population  a single TextView
//        Because this is a custom adapter for two TextView then the second argument is not going
// to be used, so it can be any value, Here we used 0.
        super(context,0,adapter);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
//        check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.add_division_list, parent,
                    false);
        }
//        Get the {@link Word} object located at this position in the list
        AddDivision currentDivisionAdapter = getItem(position);

        EditText editText = (EditText) listItemView.findViewById(R.id.division_name);
        editText.setText(currentDivisionAdapter.getTextViewInEditText());
        Button button = (Button) listItemView.findViewById(R.id.invite_member);
        return listItemView;
    }
}
