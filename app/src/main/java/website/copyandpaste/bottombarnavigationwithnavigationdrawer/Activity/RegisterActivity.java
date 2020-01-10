package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Contact;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.DataPickerFragmento;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsContact;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

//    private static final Pattern PASSWORD_PATTERN =
//            Pattern.compile("^"+"(?=.*[0-9])"+ "(?=.*[a-z])"+"(?=.*[A-Z])+"+"(?=.*[@#$%^&+=])"+"(?=\\s+$])"+".{6,}"+"$" );
    private EditText nameEdt, sobrenomeEdt, phoneEdt, dataAniversario,  confirmPasswordView, passwordView,  emailView;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthAuthStateListener ;
    private Contact contact;
    private RadioGroup mradioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailView = (EditText) findViewById(R.id.email_edit_text);
        nameEdt = (EditText) findViewById(R.id.lastname);
        sobrenomeEdt = (EditText)findViewById(R.id.firstname);
        phoneEdt = (EditText) findViewById(R.id.phone);
        passwordView = (EditText) findViewById(R.id.passord_edit_text);
        confirmPasswordView = (EditText)findViewById(R.id.comfirm_password_edt);
        dataAniversario = (EditText) findViewById(R.id.day_of_birth);
        mradioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user !=null){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };
    }

    public void Register(View view) {
        validateRegister();


//        int seletedId = mradioGroup.getCheckedRadioButtonId();
//
//        final  RadioButton radioButton = (RadioButton)findViewById(seletedId);
//
//        if (radioButton.getText() == null){
//            return;
//        }

//        final String email = emailView.getText().toString();
////        final String name = nameEdt.getText().toString();
//        final String password = passwordView.getText().toString();
////
//        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
//
//            firebaseAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.getResult().getUser() != null){
//                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                startActivity(intent);
//                                Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso",
//                                        Toast.LENGTH_SHORT).show();
//                                finish();
//                            }
//                        }
//                    });
//
//        }else{
//            Toast.makeText(getApplicationContext(), "Um dois campos está vazio, por favor preenche todos os campos. ",
//                    Toast.LENGTH_SHORT).show();
//
//        }
    }

//      validation in Register
    private void validateRegister() {
        final String email = emailView.getText().toString();
        final Pattern NOME_PATTERN = Pattern.compile("^[a-zA-Z ]+$");
        final Pattern SOBRENOME_PATTERN = Pattern.compile("^[a-zA-Z ]+$");
        final String lastName = nameEdt.getText().toString();
        final String password = passwordView.getText().toString();
        final String confirmPassord = confirmPasswordView.getText().toString();
        final String firstName = sobrenomeEdt.getText().toString();
        final String phone = phoneEdt.getText().toString();
        final String dayOfbirth = dataAniversario.getText().toString();


        // validate lastname
        if(TextUtils.isEmpty(lastName)){
            nameEdt.setError("Last name field cannot be empty");
            nameEdt.requestFocus();
            return;
        }
        if (!NOME_PATTERN.matcher(lastName).matches()){
            nameEdt.setError("Last name field cannot have number or special characters");
            nameEdt.requestFocus();
            return;
        }
        // validate firstname
        if(TextUtils.isEmpty(firstName)){
            sobrenomeEdt.setError("First name field cannot be empty");
            sobrenomeEdt.requestFocus();
            return;
        }
        if (!SOBRENOME_PATTERN.matcher(firstName).matches()){
            sobrenomeEdt.setError("First name field cannot have number or special characters");
            sobrenomeEdt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(email)){
            emailView.setError("Email field is required");
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
        if(TextUtils.isEmpty(confirmPassord)){
            confirmPasswordView.setError("Please confirm Password");
            confirmPasswordView.requestFocus();
            return;
        }
        if (!passwordView.getText().toString().equals(confirmPasswordView.getText().toString())) {
            passwordView.setError("Password and confirm password should be match");
            passwordView.requestFocus();
            return;
        }


        int seletedId = mradioGroup.getCheckedRadioButtonId();

        final  RadioButton radioButton = (RadioButton)findViewById(seletedId);

        if (radioButton.getText() == null){
            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    ModelsContact user = new ModelsContact(
                            lastName,
                            firstName,
                            phone,
                            email,
                            dayOfbirth
                    );
                    FirebaseDatabase.getInstance().getReference("User")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Informations are registered",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                    finish();
                    Toast.makeText(RegisterActivity.this, "User registered Successfull", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "E-mail already registered",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
//                    String userId = firebaseAuth.getCurrentUser().getUid();
//                    DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(radioButton.getText().toString()).child(userId).child("name");
//                    currentUserDb.setValue(name);


                }
            }
        });
    }

    public void DataAni(View view) {
        DialogFragment dataPicker = new DataPickerFragmento();
        dataPicker.show(getSupportFragmentManager(), "data picker");

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set( Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDataString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        EditText editText = (EditText)findViewById(R.id.day_of_birth);
        editText.setText(currentDataString);
    }

    public void limpar (View view) {
        TextView nomeEditText = findViewById(R.id.lastname);
        TextView sobreNomeEditText = findViewById(R.id.firstname);
        EditText telefoneEditText = findViewById(R.id.phone);
        EditText emailEditText = findViewById(R.id.email_edit_text);
        EditText dataAni = findViewById(R.id.day_of_birth);
        EditText senhaEditText = findViewById(R.id.passord_edit_text);
        EditText confirmaSenhaEditText = findViewById(R.id.comfirm_password_edt);
        nomeEditText.setText("");
        sobreNomeEditText.setText("");
        telefoneEditText.setText("");
        emailEditText.setText("");
        dataAni.setText("");
        senhaEditText.setText("");
        confirmaSenhaEditText.setText("");
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        firebaseAuth.removeAuthStateListener(firebaseAuthAuthStateListener);
//    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthAuthStateListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() != null){
//            finish();
//            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}
