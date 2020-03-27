/*
package com.example.studenthub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
*/

package com.example.studenthub;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn<mModr> extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private EditText mEmail;
    private EditText mPassword;

    private Button mSignUp;
    private Button mLogIn;

    private ProgressBar mProgressBar;

    private FirebaseAuth mAuth;
    private Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Spinner spinner = findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        mAuth = FirebaseAuth.getInstance();

        mEmail = (EditText) findViewById(R.id.emailTextView);
        mPassword = (EditText) findViewById(R.id.passwordTextView);

        mSignUp = (Button) findViewById(R.id.SignInButton);
        mLogIn = (Button) findViewById(R.id.LoggingButton);

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, Login.class);
                startActivity(intent);
            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty()) return;
                inProgress(true);
                mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(SignIn.this, "User Registered Successfully!", Toast.LENGTH_LONG).show();
                                inProgress(false);

                                Intent intent = new Intent(SignIn.this, Login.class);
                                startActivity(intent);
                                finish();
                                return;
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(SignIn.this, "Sign Up failed!" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        b1 = (Button) findViewById(R.id.Modr);
        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ModuleReg= new Intent(SignIn.this, ModuleSelect.class);
                startActivity(ModuleReg);
            }

        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT) .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void inProgress(boolean x){
        if(x){
            mProgressBar.setVisibility(View.VISIBLE);
            mSignUp.setEnabled(false);
        }else{
            mProgressBar.setVisibility(View.GONE);
            mSignUp.setEnabled(true);
        }
    }

    private boolean isEmpty(){
        if(TextUtils.isEmpty(mEmail.getText().toString())){
            mEmail.setError("Required!");
        }
        if(TextUtils.isEmpty(mPassword.getText().toString())) {
            mPassword.setError("Required!");
        }
        return false;
    }

}































