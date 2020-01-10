package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models;

import java.util.Date;

public class ModelsGrupoAmizade {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private Date dataAniversario;
    private String senha;
    private String confirmaSenha;
    private int foto;
    private String sexo;


    public ModelsGrupoAmizade(String nome, String telefone, int foto) {
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
