package service;

import entites.AcompanhamentoIA;
import entites.Aluno;
import entites.BolsistaIC;
import entites.Pessoa;

import java.util.Scanner;

public class Funcionalidades {


    //Inicializando Scanner para receber valores do Usuario
    Scanner input = new Scanner (System.in);

    //Iniciar um array para armazenar os alunos:
    Aluno[] alunos = new Aluno[10];
    //Contador para verificar quantos alunos tem:
    int contadorAluno = 0;

    //Iniciar um array para armazenar os Bolsistas de IC:
    BolsistaIC[] bolsista = new BolsistaIC[10];
    //Contador para verificar quantos Bolsistas de IC tem:
    int contadorBolsista = 0;

    AcompanhamentoIA[] registros = new AcompanhamentoIA[10];
    int contadorAcompanhamento = 0;

    AcompanhamentoIA[] riscoAlto = new AcompanhamentoIA[10];
    int contadorRiscoAlto = 0;

    //Para adicionar alunos
    public void adicionarAluno(){
        //Informações para criar a Pessoa:
        System.out.println("Digite seu nome:");
        String nome = input.nextLine();
        System.out.println("Digite seu local de Nascimento:");
        String localNascimento = input.nextLine();
        System.out.println("Digite sua idade:");
        int idade = input.nextInt();

        //Limpando o Buffer
        input.nextLine();

        //Criando o objeto Pessoa:
        Pessoa pessoa = new Pessoa(nome, localNascimento, idade);

        //Informações para criar o Aluno:
        System.out.println("Digite seu curso:");
        String curso = input.nextLine();
        System.out.println("Digite sua matrícula:");
        String matricula = input.nextLine();
        System.out.println("Digite seu semestre:");
        int semestre = input.nextInt();
        System.out.println("Digite seu ano:");
        int ano = input.nextInt();
        System.out.println("É bolsista? (S/N)");
        char escolha = input.next().charAt(0);

        boolean ehBolsista = verificaBolsista(escolha);


        Aluno aluno = new Aluno(pessoa, curso, matricula, semestre, ano, ehBolsista);

        //Para salvar o aluno usamos um array para verificar se é possível:
        if (contadorAluno < alunos.length){
            alunos[contadorAluno] = aluno;
            contadorAluno++;

            System.out.println("Aluno cadastrado com sucesso");
        } else {
            System.out.println("Limite de alunos atingido!");
        }
        //Limpando o Buffer
        input.nextLine();
    }

    //Para adicionar Bolsista de IC:
    public void adicionarBolsistaIC(){
        //Mostrar alunos Disponiveis:
        listarAlunos();

        System.out.println("Digite o indíce do aluno que deseja cadastrar:");
        int indice = input.nextInt();
        Aluno alunoIC = alunos[indice];

        //Limpando o Buffer:
        input.nextLine();

        System.out.println("Digite o seu projeto:");
        String projeto = input.nextLine();

        System.out.println("Quem é seu orientador?");
        String orientador = input.nextLine();

        BolsistaIC bolsistaIC = new BolsistaIC(alunoIC, projeto, orientador);

        if (contadorBolsista < bolsista.length) {
            bolsista[contadorBolsista] = bolsistaIC;
            contadorBolsista++;

            System.out.println("Bolsista de IC cadastrado com Sucesso!");
        } else {
            System.out.println("Limite de cadastro de bolsistas atingido");
        }

        //Limpando o Buffer
        input.nextLine();
    }

    //Método para listar alunos:
    public void listarAlunos(){
        System.out.println("Alunos Cadastrados:");
        for(int i = 0; i < contadorAluno; i++){
            System.out.println("Índice: " + i + " Nome: " + alunos[i].getPessoa().getNome());
            espaco();
        }
    }

    //Registrar dados de acompanhamento do uso de IA
    public void registroAcompanhamento(){
        listarAlunos();

        System.out.println("Digite o indice do aluno que deseja registrar o acompanhamento:");
        int indice = input.nextInt();
        percentualAlunosPorCurso();
        Aluno alunoRegistroIa = alunos[indice];

        System.out.println("Digite a quantidade de atividades entregues:");
        int atividadesEntregues = input.nextInt();

        System.out.println("Digite a quantidade de atividades em que foi usado IA");
        int atividadesComIA = input.nextInt();

        System.out.println("Digite quantas atividades o aluno explicou corretamente");
        int explicadasCorretamente = input.nextInt();

        System.out.println("Digite quantas atividades o aluno modificou sem ajuda:");
        int alteracaoSemAjuda = input.nextInt();

        System.out.println("Digite a quantidade de conteudos avançados nos materiais entregues:");
        int conteudosAvancados = input.nextInt();

        String riscoPedagogico = "";
        AcompanhamentoIA acompanhamento = new AcompanhamentoIA(alunoRegistroIa, atividadesEntregues,
                atividadesComIA, explicadasCorretamente, alteracaoSemAjuda, conteudosAvancados,riscoPedagogico);

        riscoPedagogico = acompanhamento.riscoPedagogico();

        if (registros.length > contadorAcompanhamento){
            if ("Risco Alto".equals(riscoPedagogico)){
                riscoAlto[contadorRiscoAlto] = acompanhamento;
                contadorRiscoAlto++;
            }
            registros[contadorAcompanhamento] = acompanhamento;
            contadorAcompanhamento++;

            System.out.println("Registro de Acompanhamento do uso de IA realizado com sucesso");
        } else {
            System.out.println("Limite de registros atingidos");
        }

        exibirRegistros();
    }

    public void exibirRegistros() {
        System.out.println("Registros Cadastrados:");

        for(int i = 0; i < contadorAcompanhamento; i++){
            System.out.println("Nome do Aluno: " + registros[i].getAluno().getPessoa().getNome());
            System.out.println("Risco pedagogico: " + registros[i].riscoPedagogico());
        }
    }

    //Listar apenas alunos de Bolsista de IC: Método para listar Bolsistas:
    public void listarBolsistas(){
        System.out.println("Bolsistas cadastrados:");

        for(int i = 0; i < contadorBolsista; i++) {
            System.out.println("Indice: " + i + " Nome: " + bolsista[i].getAluno().getPessoa().getNome());
            System.out.println("Projeto: " + bolsista[i].getProjeto());
            System.out.println("Orientador: " + bolsista[i].getOrientador());
            espaco();
        }
    }

    //Mostrar o nome mais longo da turma
    public void nomeMaisLongoTurma() {

        //Tentei não tratar a excecção mas estava dando muito erro

        // Garantir que a turma não está vazia para evitar erro de NullPointerException
        if (alunos == null || alunos.length == 0) {
            System.out.println("A turma não possui alunos.");
            return;
        }

        String maiorNome = "";

        //Percorremos o vetor:
        for (int i = 0; i < alunos.length; i++) {
            //Ignora a posição caso o aluno seja nulo
            if (alunos[i] != null) {

                // Se for o primeiro nome válido encontrado ou se for maior que o atual
                if (maiorNome.equals("") || alunos[i].getPessoa().getNome().length() > maiorNome.length()) {
                    maiorNome = alunos[i].getPessoa().getNome();
                }
            }
        }

        System.out.println("O maior nome da é: " + maiorNome);
    }

    //Contar quantidade de vogais de todos os nomes cadastrados
    public void contarVogais() {
        int contadorVogal = 0;

        for (int i = 0; i < contadorAluno; i++) {
            Aluno aluno = alunos[i];
            String nome = aluno.getPessoa().getNome();

            for(char letra : nome.toCharArray()){
                if(letra == 'a'||letra == 'e'|| letra == 'o'|| letra == 'i' || letra == 'u'){
                    contadorVogal++;
                }
            }
        }
        System.out.println("Quantidade de vogais: " + contadorVogal);
    }

    //Calcular o percentual de alunos por curso
    public void percentualAlunosPorCurso(){}

    //Calcular a média de idade de alunos cadastrados:
    public void mediaIdadeAlunos(){
        int somaIdade = 0;

        for(int i = 0; i < contadorAluno; i++) {
            Aluno aluno = alunos[i];
            int idade = aluno.getPessoa().getIdade();

            somaIdade += idade;
        }
        int idadeMedia = somaIdade/contadorAluno;
        System.out.println("A idade média da turma é: " + idadeMedia);
    }

    //Criar-Atualizar a lista de chamada da dispciplina
    public void listaDeChamada(){}

    //Exibir a lista de chamada em ordem alfabetica crescente, contendo nome, matricula e curso
    public void exibirListaDeChamada() {}

    //Calcular o nível de risco pedagogico relacionado ao uso de IA - Feito na classe AcompanhamentoIA
    public void calculoDeRiscoPedagogico(){}

    //Exibir apenas alunos classificados como alto risco
    public void alunosRiscoAlto(){
        System.out.println("Classificação de RISCO ALTA:");

        for(int i = 0; i < contadorRiscoAlto; i++){
            System.out.println("Nome do Aluno: " + riscoAlto[i].getAluno().getPessoa().getNome());
            System.out.println("Risco pedagogico: " + riscoAlto[i].riscoPedagogico());
        }
    }

    //Inovation

    // Converter char pra boolean
    public boolean verificaBolsista(char escolha){
        boolean ehBolsista;
        if (escolha == 's' || escolha == 'S') {
            ehBolsista = true;
        } else {
            ehBolsista = false;
        }
        return ehBolsista;
    }
    //Método para exibir os tracinhos:
    public void espaco(){
        System.out.println("---------------------------------------------");
    }

}
