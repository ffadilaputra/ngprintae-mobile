package ffadilaputra.org.bottom_toolbar.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ffadilaputra.org.bottom_toolbar.MainActivity;
import ffadilaputra.org.bottom_toolbar.R;

public class Login extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        btnSignIn = (Button)findViewById(R.id.btn_login);
        btnSignUp = (Button)findViewById(R.id.register);
        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                    final String password = inputPassword.getText().toString();
                    if (TextUtils.isEmpty(email)){
                        Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
                        return;
                    }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Pass",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()){
                            if (password.length() < 6){
                                inputPassword.setError(getString(R.string.minim_password));
                            }else{
                                Toast.makeText(Login.this,getString(R.string.auth_faied),Toast.LENGTH_LONG).show();
                            }
                        } else {
                               Intent i = new Intent(Login.this,MainActivity.class);
                               startActivity(i);
                               finish();
                        }
                    }
                });
            }
        });

    }
}
