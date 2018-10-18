package unpad.rockbottom.monica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ToDoList_Activity extends AppCompatActivity {

    private EditText addTask;
    private ImageButton addTaskButton;
    private ListView toDoList;

    private List<List_Class> taskList;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_);

        addTask = findViewById(R.id.addTask);
        addTaskButton = findViewById(R.id.addTaskButton);
        toDoList = findViewById(R.id.toDoList);

        toDoList = (ListView) findViewById(R.id.toDoList);
        taskList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void addNewTask(View v){
        String taskEntered = addTask.getText().toString();
        adapter.add(taskEntered);
        addTask.setText("");

        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
    }

}
