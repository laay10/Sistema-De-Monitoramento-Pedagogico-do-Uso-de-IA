package entites;

public class BolsistaIC {
    private Aluno aluno;
    private String projeto;
    private String orientador;

    // Construtor:

    public BolsistaIC (Aluno aluno, String projeto, String orientador) {
        this.aluno = aluno;
        this.projeto = projeto;
        this.orientador = orientador;
    }

    //Getters:

    public Aluno getAluno() {
        return aluno;
    }

    public String getProjeto() {
        return projeto;
    }

    public String getOrientador() {
        return orientador;
    }

    // Setters:

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProjeto (String projeto) {
        this.projeto = projeto;
    }

    public void setOrientador (String orientador) {
        this.orientador = orientador;
    }
}