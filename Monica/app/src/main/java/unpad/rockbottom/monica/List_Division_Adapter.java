package unpad.rockbottom.monica;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_Division_Adapter extends ArrayAdapter<String> {

    private Activity context;
    private List<String> divisi;

    public List_Division_Adapter (Activity context, List<String> divisi){
        super(context, R.layout.list_layout_division, divisi);
        this.context = context;
        this.divisi = divisi;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem;

        String divisiList = divisi.get(position);

        listViewItem = inflater.inflate(R.layout.list_layout_division, null, true);

        TextView divisi = (TextView) listViewItem.findViewById(R.id.divisi);
        divisi.setText(divisiList);

        return listViewItem;
    }
}
