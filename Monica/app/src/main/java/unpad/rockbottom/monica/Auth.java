package unpad.rockbottom.monica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.id.message;

public class Auth extends AppCompatActivity {

    private static final String TAG = "Auth";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText mEmail, mPass;
    private Button btnSignup, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mEmail = (EditText) findViewById(R.id.email);
        mPass = (EditText) findViewById(R.id.pass);
        btnSignup = (Button) findViewById(R.id.signup);
        btnLogin = (Button) findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                }
            }
        };
        /* signup belom dapet
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String pass = mPass.getText().toString();
                if (!email.equals("") && !pass.equals("")) {
                    mAuth.signInWithEmailAndPassword(email, pass);
                    Intent intent = new Intent(Auth.this, MainActivity.class);
                    Auth.this.startActivity(intent);
                    finish();
                }
                else {
                    toastMessage("Please fill all fields.");
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}