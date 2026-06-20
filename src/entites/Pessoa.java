package entites;

public class Pessoa {
        private String nome;
        private String localNascimento;
        private int idade;

        // Construtor
    public Pessoa (String nome, String localNascimento, int idade) {
        this.nome = nome;
        this.localNascimento = localNascimento;
        this.idade = idade;
    }

    //Getters:

    public String getNome() {
        return nome;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    public int getIdade(){
        return idade;
    }

    // Setters:


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalNascimento (String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public void setIdade (int idade) {
        this.idade = idade;
    }
}
