package com.project.AutoDeelsoftwareproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    public static final String EXTRA_TEXT = "softwareproject.EXTRA_TEXT";
    private static final String TAG = "Login";
    private ImageButton signup_btn;
    private ImageButton login_btn;
    private EditText emailLogin;
    private EditText passwordLogin;

    //firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //firebase
        mAuth = FirebaseAuth.getInstance();

        login_btn = findViewById(R.id.login);
        signup_btn = findViewById(R.id.signup);
        emailLogin = findViewById(R.id.email);
        passwordLogin = findViewById(R.id.Password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //openUserProfile();
            //firebase user authen implement
            //sign in existing user
            String Email = emailLogin.getText().toString();
            String Password = passwordLogin.getText().toString();
            if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
             Toast.makeText(getApplicationContext(), "Please enter Email and Password", Toast.LENGTH_LONG).show();
             return;
            }
            mAuth.signInWithEmailAndPassword(Email, Password)
                 .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             // Sign in success, update UI with the signed-in user's information
                             Log.d(TAG, "signInWithEmail:success");
                             FirebaseUser user = mAuth.getCurrentUser();
                             updateUI(user);
                         } else {
                              //If sign in fails, display a message to the user.
                             Log.w(TAG, "signInWithEmail:failure", task.getException());
                             Toast.makeText(Login.this,"Login failed.", Toast.LENGTH_SHORT).show();
                         }
                     }
                 });
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
            }
        });

        //sharePrefs
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS",MODE_PRIVATE);
        String emailPref = sharedPreferences.getString("email_pref","");
        emailLogin.setText(emailPref);
        String passwordPref = sharedPreferences.getString("password_pref","");
        passwordLogin.setText(passwordPref);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            updateUI(currentUser);
//        }
//    }



    public void updateUI(FirebaseUser currentUser){
        TextView tv = findViewById(R.id.user_name);
        EditText username = findViewById(R.id.email);
        String profileName = username.getText().toString();


        Intent userProfile = new Intent(this,user_profile.class);
        userProfile.putExtra(EXTRA_TEXT,profileName);
        startActivity(userProfile);
    }
}