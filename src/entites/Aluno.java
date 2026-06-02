public class Aluno {
    private Pessoa pessoa;
    private String curso;
    private String matricula;
    private int semestre;
    private int ano;
    private boolean ehBolsista;


public Aluno (Pessoa pessoa, String curso, String matricula, int semestre,int ano, boolean ehBolsista){
    this.pessoa = pessoa;
    this.curso = curso;
    this.matricula = matricula;
    this.semestre = semestre;
    this.ano = ano;
    this.ehBolsista = ehBolsista;
}

    // get - tipo  - return - sem parametro
    // set - void - this - com parametro 

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getAno() {
        return ano;
    }

    public boolean getEhBolsista() {
        return ehBolsista;
    }

    // Setters:

    public void setPessoa (Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }

    public void setSemestre (int semestre) {
        this.semestre = semestre;
    }

    public void setAno (int ano) {
        this.ano = ano;
    }

    public void setEhBolsista (boolean ehBolsista) {
        this.ehBolsista = ehBolsista;
    }
}