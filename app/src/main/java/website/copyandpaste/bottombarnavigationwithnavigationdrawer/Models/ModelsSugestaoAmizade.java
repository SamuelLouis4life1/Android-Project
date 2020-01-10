package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models;

public class ModelsSugestaoAmizade {
    private String nome;
    private String sobrenome;
    private int foto;
    private String dataAniversario;
    private String sexo;


    public ModelsSugestaoAmizade(String nome, String sobrenome, int foto, String dataAniversario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.foto = foto;
        this.sobrenome = sobrenome;
        this.dataAniversario = dataAniversario;
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

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) { this.dataAniversario = dataAniversario; }

    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
