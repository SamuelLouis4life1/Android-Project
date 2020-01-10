package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models;

import java.util.Date;

public class ModelsConversas {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private Date dataAniversario;
    private String senha;
    private String confirmaSenha;
    private int foto;
    private String sexo;


    public ModelsConversas(String nome, String telefone, int foto) {
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataAniversario = dataAniversario;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.sexo = sexo;
    }

//    public void salvar(){
//        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
//        referenciaFirebase.child("contato").child(String.valueOf(getLastName())).setValue(this);
//    }
//
//    @Exclude
//    public Map<String, Object> toMap(){
//        HashMap<String, Object> hashMapContato = new HashMap<>();
//
//        hashMapContato.put("nome", getLastName());
//        hashMapContato.put("telefone", getLastName());
//        hashMapContato.put("celular", getLastName());
//        hashMapContato.put("email", getLastName());
//        hashMapContato.put("cpf", getLastName());
//        hashMapContato.put("dataAniversario", getLastName());
//        hashMapContato.put("cidade", getLastName());
//        hashMapContato.put("senha", getLastName());
//        hashMapContato.put("confirmaSenha", getLastName());
//        hashMapContato.put("sexo", getLastName());
//
//        return hashMapContato;
//    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() { return sobrenome; }

    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
