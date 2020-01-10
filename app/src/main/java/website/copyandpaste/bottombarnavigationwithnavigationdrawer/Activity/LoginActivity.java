package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.EsquecerSenhaSettings;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailView;
    private EditText passwordView;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthAuthStateListener ;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailView = (EditText) findViewById(R.id.email_edit_text);
        passwordView = (EditText) findViewById(R.id.passord_edit_text);
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuthAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user !=null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

    }

    public void Login(View view) {
        validateLogin();

//        String email = emailView.getText().toString();
//        String password = passwordView.getText().toString();
//
//        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
//
//            firebaseAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.getResult().getUser() != null){
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }else{
//                                Toast.makeText(getApplicationContext(), "Email e/ou senha incorretos",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//        }else{
//            Toast.makeText(getApplicationContext(), "Por favor preenchar os campos e-mail e senha.",
//                    Toast.LENGTH_SHORT).show();
//        }

    }

    private void validateLogin() {

        final String email = emailView.getText().toString();
        final String password = passwordView.getText().toString();

        if(TextUtils.isEmpty(email)){
            emailView.setError("E-mail field is required");
            emailView.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailView.setError("Please, enter a valid email");
            emailView.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password)){
            passwordView.setError("Password field is required");
            passwordView.requestFocus();
            return;
        }


        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AbrirRegister(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void EsquecerSenha(View view) {
        Intent intent = new Intent(LoginActivity.this, EsquecerSenhaSettings.class);
        startActivity(intent);
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (firebaseAuth.getCurrentUser() == null){
//            finish();
//            startActivity(new Intent(this, MainActivity.class));
//        }
//    }

}
