public class AcompanhamentoIA {
    private Aluno aluno;
    private int atividadesEntregues;
    private int atividadesComIA;
    private int explicacaoCorreta;
    private int alteracaoSemAjuda;
    private int conteudosAvancados;

    // get - tipo - sem parametros - return
    // set - void - com parametros - this

    // Getters:
    public Aluno getAluno () {
        return aluno;
    }

    public int getAtividadesEntregues() {
        return atividadesEntregues;
    }

    public int getAtividadesComIA() {
        return atividadesComIA;
    }

    public int getExplicacaoCorreta() {
        return explicacaoCorreta;
    }

    public int getAlteracaoSemAjuda() {
        return alteracaoSemAjuda;
    }

    public int getConteudosAvancados() {
        return conteudosAvancados;
    }

    // Setters:

    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
    }

    public void setAtividadesEntregues(int atividadesEntregues) {
        this.atividadesEntregues = atividadesEntregues;
    }

    public void setExplicacaoCorreto(int explicacaoCorreta) {
        this.explicacaoCorreta = explicacaoCorreta;
    }

    public void setAlteracaoSemAjuda(int alteracaoSemAjuda) {
        this.alteracaoSemAjuda = alteracaoSemAjuda;
    }

    public void setConteudosAvancados ()
}