package unpad.rockbottom.monica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList_Activity extends AppCompatActivity {

    private EditText addTask;
    private ImageButton addTaskButton;
    private ListView toDoListView;

    DatabaseReference databaseToDoList;
    private List<List_Class> taskList;
    private List<String> daftarDivisi = new ArrayList<>();
    private boolean isNewDivision = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_);

        databaseToDoList = FirebaseDatabase.getInstance().getReference("toDoList");
        toDoListView = (ListView) findViewById(R.id.toDoList);
        taskList = new ArrayList<>();

        addTask = findViewById(R.id.addTask);
        addTaskButton = findViewById(R.id.addTaskButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Ambil data dari Firebase Database

        databaseToDoList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Kalo update, clear dulu biar ga numpuk
                taskList.clear();
                int i = 0;
                boolean isNewDivision = false;

                // Kirim data perchild ke kelas responden
                for(DataSnapshot respondenSnapshot : dataSnapshot.getChildren()){
                    List_Class list_class = respondenSnapshot.getValue(List_Class.class);
                    if (daftarDivisi.isEmpty())
                        daftarDivisi.add(list_class.getDivisi());
                    else {
                        for (int j=0; j<daftarDivisi.size(); j++){
                            if (!daftarDivisi.get(j).equals(list_class.getDivisi()) ) {
                                isNewDivision = true;
                            }
                            else {
                                isNewDivision = false;
                                break;
                            }
                        }
                        if (isNewDivision == true)
                            daftarDivisi.add(list_class.getDivisi());
                    }
                    taskList.add(list_class);
                    i++;
                }

                // Sorting tiap list dari divisinya ALPHABETICALLY
                for (int k=0; k<daftarDivisi.size(); k++){
                    Toast.makeText(getApplicationContext(), daftarDivisi.get(k), Toast.LENGTH_SHORT).show();
                }
                Collections.sort(, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });


                //Masukin ke listViewnya
                List_Adapter adapter = new List_Adapter(ToDoList_Activity.this, taskList);
                toDoListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void addNewTask(View v){
        String id = databaseToDoList.push().getKey();
        String divisi = "Acara";
        String taskEntered = addTask.getText().toString();
        boolean isChecked = false;

        // Submit the data to Firebase database
        try{
            List_Class taskList = new List_Class(id, divisi, taskEntered, isChecked);
            databaseToDoList.child(id).setValue(taskList);
            Toast.makeText(this, "Data terkirim (test)", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        addTask.setText("");
    }

}
