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
        int indicios = 0;

        if (atividadesComIA == 0) {
            indicios +=2;
        }

        if (explicacaoCorreta < atividadesComIA/2){
            indicios += 3;
        }

        if (conteudosAvancados > 0){
            indicios +=2;
        }
            
        if (indicios <= 2){
            return "Baixo";
        } else if (indicios <= 5) {
            return "Moderado";
        } else {
            return "Alto";
        }
            
    }
}