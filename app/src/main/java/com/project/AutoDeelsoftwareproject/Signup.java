package com.project.AutoDeelsoftwareproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private static final String TAG = "Signup";
    private ImageButton signup_btn;
    private EditText email;
    private EditText uPassword;
    private EditText conPassword;
    private EditText secQuestion;
    private EditText secAnswer;
    private User user;
    
    //sharepref
//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String EMAIL = "email";
//    public static final String PASSWORD = "password";
//    private String emailSharepref;
//    private String passwordSharepref;


    //firebase
    private FirebaseDatabase database;
    private DatabaseReference dbRef;
    private FirebaseAuth fbAuth;
    private static final String USER = "users";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signup_btn = findViewById(R.id.signup);
        email = findViewById(R.id.email);
        uPassword = findViewById(R.id.regisPassword);
        conPassword = findViewById(R.id.confirm_password);
        secQuestion = findViewById(R.id.security_question);
        secAnswer = findViewById(R.id.answer);

        //firebase
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference(USER);
        fbAuth = FirebaseAuth.getInstance();
        //navigate to user profile screen
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfile();
                String Email = email.getText().toString();
                String password = uPassword.getText().toString();
                if(TextUtils.isEmpty(Email)||TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Please enter Email and Password",Toast.LENGTH_LONG).show();
                    return;
                }
                String conpassword = conPassword.getText().toString();
                String secquest = secQuestion.getText().toString();
                String secans = secAnswer.getText().toString();
                //create new user
                user = new User(Email,password,conpassword,secquest,secans);
                registerUser(Email,password);
                saveData();
            }
        });
    }

    public void openUserProfile(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void registerUser(String email, String password){
        //firebase realtime database implement
        fbAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = fbAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(Signup.this, "Registration success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Registration failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void updateUI(FirebaseUser currentUser){
        String keyID = dbRef.push().getKey();
        dbRef.child(keyID).setValue(user);
        Intent loginIntent = new Intent(this,Login.class);
        startActivity(loginIntent);
    }

    //implement sharepref
    //save data and sent to login screen
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email_pref",email.getText().toString());
        editor.putString("password_pref",uPassword.getText().toString());
        editor.apply();
    }
}