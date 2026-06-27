package entites;

public class ListaChamada {
    private String professor;
    private String disciplina;
    private Aluno[] alunos;

    public ListaChamada (String professor, String disciplina, Aluno[] alunos){
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
    }

    //get - tipo - sem parametro - return
    public String getProfessor() {
        return professor;
    }

    public String getDisciplina(){
        return disciplina;
    }

    public Aluno[] getAlunos(){
        return alunos;
    }

    //set - void - com parametro - this.
    public void setProfessor (String professor){
        this.professor = professor;
    }

    public void setDisciplina (String disciplina) {
        this.disciplina = disciplina;
    }

    public void setAlunos (Aluno[] alunos) {
        this.alunos = alunos;
    }
}
