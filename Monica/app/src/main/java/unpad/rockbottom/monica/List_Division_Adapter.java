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

public class List_Division_Adapter extends ArrayAdapter<List_Class> {

    private Activity context;
    private List<List_Class> taskList;

    public List_Division_Adapter (Activity context, List<List_Class> taskList){
        super(context, R.layout.list_layout_division, taskList);
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem;

        List<String> daftarDivisi = new ArrayList<>();
        boolean isNewDivision = false;

        List_Class pesan = taskList.get(position);

        listViewItem = inflater.inflate(R.layout.list_layout_division, null, true);

        TextView divisi = (TextView) listViewItem.findViewById(R.id.divisi);
        divisi.setText(pesan.getDivisi());

        return listViewItem;
    }
}
