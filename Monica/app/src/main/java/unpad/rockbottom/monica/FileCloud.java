package unpad.rockbottom.monica;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FileCloud extends AppCompatActivity {
//    private FileItem[] files;
    private ImageButton back_btn;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_cloud);

        final ArrayList<FileItem> files = new ArrayList<>();
        files.add(new FileItem("Desain",R.drawable.folders));
        files.add(new FileItem("Notulensi",R.drawable.folders));
        files.add(new FileItem("Humas",R.drawable.folders));
        files.add(new FileItem("",R.drawable.folder));
        files.add(new FileItem("",R.drawable.file));

        GridView gridView = (GridView)findViewById(R.id.grid_files);
        final FilesAdapter filesAdapter = new FilesAdapter(this,files);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FileItem fileItemAdapter = files.get(position);
                //Toast.makeText(FileCloud.this, "Posisi: "+position, Toast.LENGTH_SHORT).show();
                if (position == (files.size()-2)) {
                    files.add((files.size()-2),new FileItem("Tambahan " +(files.size()-4), R.drawable.folders));
                }
                if (position == (files.size()-1)){
                    files.add((files.size()-2),new FileItem("Tambahan" +(files.size()-4), R.drawable.files));
                }
                filesAdapter.notifyDataSetChanged();
            }
        });
        gridView.setAdapter(filesAdapter);

        back_btn = (ImageButton) findViewById(R.id.back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onStop();
                        finish();
                    }
                });
            }
        });
        title = (TextView) findViewById(R.id.titleToolbar);
        title.setText("Files");
    }
}
