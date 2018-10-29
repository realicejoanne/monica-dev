package unpad.rockbottom.monica;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.ThreeBounce;

public class CommitteeView extends AppCompatActivity {

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committee);
    }

    // Connect with others
    public void onClickChatRoom(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Chat.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickLiveCall(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Call.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickChannels(View view){
        try {
            Intent i = new Intent(CommitteeView.this, Channel.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Features
    public void onClickToDOList(View view){
        try {
            Intent i = new Intent(CommitteeView.this, ToDoList.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickItemList(View view){
        try {
            Intent i = new Intent(CommitteeView.this, ItemList.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickFiles(View view){
        try {
            Intent i = new Intent(CommitteeView.this, FileCloud.class);
            startActivity(i);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickFinish(View view){
        try {
            DialogForm();
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void DialogForm(){
        final Activity activity;
        activity = this;
        // setup the alert builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this,
                R.style.AlertDialogCustom)).setTitle("Mengakhiri Kepanitian Ini?").setMessage("");

        // add the buttons
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(CommitteeView.this, "YA", Toast.LENGTH_SHORT).show();
                //ProgressDialog progressDialog = ProgressDialog.show(CommitteeView.this, "",
                    //"Loading. Please wait...", true);
                loadingDialog();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onStop();
                        finish();
                    }
                }, 3000L); //3000 L = 3 detik
            }

        });
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(CommitteeView.this, "TIDAK", Toast.LENGTH_SHORT).show();
            }
        });
        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources()
                        .getColor(R.color.colorPrimaryDark));
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources()
                        .getColor(R.color.colorPrimaryDark));
            }
        });
        dialog.show();
    }

    private void loadingDialog(){
        dialog = new AlertDialog.Builder(CommitteeView.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.finish_layout, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);

        dialog.show();

    }
}
