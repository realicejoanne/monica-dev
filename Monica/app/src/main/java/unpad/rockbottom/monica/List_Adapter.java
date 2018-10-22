package unpad.rockbottom.monica;

import android.app.Activity;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class List_Adapter extends ArrayAdapter<List_Class> {
    private Activity context;
    private List<List_Class> taskList;
    List_Class pesan;
    DatabaseReference databaseToDoList = FirebaseDatabase.getInstance().getReference("toDoList");

    public List_Adapter (Activity context, List<List_Class> taskList){
        super(context, R.layout.list_layout, taskList);
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

        pesan = taskList.get(position);
        listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView divisi = (TextView) listViewItem.findViewById(R.id.divisi);
        CheckBox isiPesan = (CheckBox) listViewItem.findViewById(R.id.pesan);
        ImageButton delete = (ImageButton) listViewItem.findViewById(R.id.delete);
        final String id = taskList.get(position).getId();

        delete.setVisibility(View.VISIBLE);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseToDoList.getRef().child(id).removeValue();
            }
        });

        /*if (daftarDivisi.size() == 0){
            daftarDivisi.add(pesan.getDivisi());
            isNewDivision = true;
        }
        for (int i = 0; i < daftarDivisi.size(); i++){
            if (daftarDivisi.get(i) != pesan.getDivisi()){
                daftarDivisi.add(pesan.getDivisi());
                isNewDivision = true;
            }
        }*/

        if (isNewDivision == true){
            ViewGroup.LayoutParams params = divisi.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            divisi.setLayoutParams(params);
            divisi.setText(pesan.getDivisi());
        }
        else{
            divisi.setHeight(0);
            divisi.setWidth(0);
        }

        isiPesan.setChecked(pesan.getIsChecked());
        if (pesan.getIsChecked() == false)
            isiPesan.setText(pesan.getIsiPesan());
        else
            isiPesan.setPaintFlags(isiPesan.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        return listViewItem;
    }
}
