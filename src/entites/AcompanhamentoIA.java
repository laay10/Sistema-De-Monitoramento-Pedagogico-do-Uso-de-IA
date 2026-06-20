package entites;

public class AcompanhamentoIA {
    private Aluno aluno;
    private int atividadesEntregues; //aE
    private int atividadesComIA; //aIA
    private int explicacaoCorreta; //eC
    private int alteracaoSemAjuda; //aSA
    private int conteudosAvancados; //cA
    private String riscoPedagogico;

    //Construtor:
    public AcompanhamentoIA (Aluno aluno, int aE, int aIA, int eC, int aSA, int cA, String riscoPedagogico) {
        this.aluno = aluno;
        this.atividadesEntregues = aE;
        this.atividadesComIA = aIA;
        this.explicacaoCorreta = eC;
        this.alteracaoSemAjuda = aSA;
        this.conteudosAvancados = cA;
        this.riscoPedagogico = riscoPedagogico();
    }

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

    public void setConteudosAvancados (int conteudosAvancados) {
        this.conteudosAvancados = conteudosAvancados;
    }

    public String riscoPedagogico() {
        // Se o aluno não usou IA, o risco de uso inadequado é baixo
        if (atividadesComIA == 0) {
            return "Risco Baixo";
        }

        // Não consegue explicar a maior parte E usou conteúdos avançados
        if (explicacaoCorreta < (double) atividadesComIA / 2 && conteudosAvancados > 0) {
            return "Risco Alto";
        }

        // Apresenta dificuldade parcial (errou algumas explicações) OU usou conteudos avançados
        if (explicacaoCorreta < atividadesComIA || conteudosAvancados > 0) {
            return "Risco Moderado";
        }

        // Se não caiu nos anteriores, significa que declara o uso, explica bem e domina o que fez
        return "Risco Baixo";
    }

}
