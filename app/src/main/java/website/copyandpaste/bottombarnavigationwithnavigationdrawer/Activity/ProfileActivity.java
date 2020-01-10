package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.DAO.FirebaseConfiguration;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsContact;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;

public class ProfileActivity extends AppCompatActivity {

    private static final int CHOOSE_IMAGE = 101;
    private TextView descricao;
    private TextView txtNome;
    private TextView txtSobreNome;
    private TextView txtTelefone;
    private TextView txtEmail;
    private TextView txtDataNacimento;
    private ImageView imageView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;

    private String txtdecricao = "";
    private String txtnome = "";
    private String txtsobrenome = "";
    private String txttelefone = "";
    private String txtemail = "";
    private String txtdatanacimento = "";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        reference = FirebaseConfiguration.getFirebase();

//        txtNome = (TextView) findViewById(R.id.txtNomeUsuario);
//        txtSobreNome = (TextView) findViewById(R.id.sobreNomeUsuario);
//        txtTelefone = (TextView) findViewById(R.id.txtTelefoneUsuriao);
//        txtEmail = (TextView) findViewById(R.id.txtEmailUsurario);
//        txtDataNacimento = (TextView) findViewById(R.id.txtdataNacimentoUsuario);
//        imageView = (ImageView) findViewById(R.id.profileImageView);

        String emailUserLogin = firebaseAuth.getCurrentUser().getEmail();

        reference.child("user").orderByChild("email").equalTo(emailUserLogin).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    ModelsContact user = postSnapshot.getValue(ModelsContact.class);

//                    imageView.setImageURI(Uri.parse(user.getPhoto()));
//                    txtNome.setText(user.getLastName());
//                    txtSobreNome.setText(user.getFirstName());
//                    txtTelefone.setText(user.getPhone());
//                    txtEmail.setText(user.getEmail());
//                    txtDataNacimento.setText((CharSequence) user.getDayOfbirth());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }












//
//
//
//
//
//
//
//

//
//    private void EditProfileUser() {
//
//
//
//        String emailUserLogin  = firebaseAuth.getCurrentUser().getEmail();
//
//        reference = FirebaseConfiguration.getFirebase();
//
//        reference.child("usuarios").orderByChild("email").equalTo(emailUserLogin).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//
//                    ModelsContact usuario = postSnapshot.getValue(ModelsContact.class);
//
//
//                    final Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
//
//                    final Bundle bundle = new Bundle();
//
//                    bundle.putString("origem", "editarUsuario");
//
//                    bundle.putString("nome", usuario.getLastName());
//                    bundle.putString("cpf", usuario.getFirstName());
//                    bundle.putString("tipoUsuario", usuario.getPhone());
//                    bundle.putString("email", usuario.getEmail());
//                    bundle.putString("logradouro", String.valueOf(usuario.getDayOfbirth()));
//
//                    intent.putExtras(bundle);
//
//                    startActivity(intent);
//
//                    finish();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//
//        });
//    }
//
    public void Voltar(View view) {
        finish();
        return;
    }
//
//    public void Excluir(View view) {
//    }

}
