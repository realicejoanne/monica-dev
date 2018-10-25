package unpad.rockbottom.monica;

import android.app.Activity;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    AppCompatCheckBox isiPesan;
    List_Class pesan;

    TextView divisi;
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
        final int temp = position;

        pesan = taskList.get(temp);
        String id = taskList.get(position).getId();
        listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        divisi = (TextView) listViewItem.findViewById(R.id.divisi);
        ImageButton delete = (ImageButton) listViewItem.findViewById(R.id.delete);
        LinearLayout linearLayout = (LinearLayout) listViewItem.findViewById(R.id.linearLayoutID);
        isiPesan = (AppCompatCheckBox) listViewItem.findViewById(R.id.pesan);
        isiPesan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked ){
                    //isiPesan.setChecked(! isiPesan.isChecked());
                    if(! taskList.get(temp).getIsChecked())
                        taskList.get(temp).setIsChecked(true);
                    else
                        taskList.get(temp).setIsChecked(false);
                }
            }
        });

        // if it is a header
        if (pesan.getId().equals("0XX0")){
            ViewGroup.LayoutParams params = divisi.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            divisi.setLayoutParams(params);
            divisi.setText(pesan.getDivisi());
            linearLayout.removeAllViews();
            linearLayout.setBackground(null);
        }
        // if it is a normal taskList
        else{
            divisi.setHeight(0);
            divisi.setWidth(0);
            isiPesan.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isiPesan.setChecked(pesan.getIsChecked());
                }
            }, 1);
            if (! pesan.getIsChecked())
                isiPesan.setText(pesan.getIsiPesan());
            else {
                isiPesan.setText(pesan.getIsiPesan());
                isiPesan.setPaintFlags(isiPesan.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }

        }
        return listViewItem;
    }
}
