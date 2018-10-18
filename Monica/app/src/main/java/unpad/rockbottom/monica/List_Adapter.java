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
import android.widget.TextView;

import java.util.List;

public class List_Adapter extends ArrayAdapter<List_Class> {
    private Activity context;
    private List<List_Class> taskList;

    public List_Adapter (Activity context, List<List_Class> taskList){
        super(context, R.layout.list_layout, taskList);
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        CheckBox isiPesan = (CheckBox) listViewItem.findViewById(R.id.pesan);
        ImageButton delete = (ImageButton) listViewItem.findViewById(R.id.delete);

        List_Class pesan = taskList.get(position);

        isiPesan.setChecked(pesan.getIsChecked());

        if (pesan.getIsChecked() == false)
            isiPesan.setText(pesan.getIsiPesan());
        else
            isiPesan.setPaintFlags(isiPesan.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        delete.setVisibility(View.VISIBLE);

        return listViewItem;
    }
}
