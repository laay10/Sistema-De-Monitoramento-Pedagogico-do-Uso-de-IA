package service;

import entites.AcompanhamentoIA;
import entites.Aluno;
import entites.BolsistaIC;
import entites.ListaChamada;
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

    ListaChamada[] listas = new ListaChamada[10];
    int contadorListas = 0;

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
        exibirCursos();
        System.out.println("Digite o indíce do curso escolhido:");
        int decisao = input.nextInt();
        String curso = cursoEscolhido(decisao);

        input.nextLine();

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

    public void cadastrarDadosIniciais(){
        Pessoa p1 = new Pessoa("Laís", "Porto Alegre", 18);
        Aluno a1 = new Aluno(p1, "Engenharia de Software", "1001", 3, 2026, false);
        alunos[contadorAluno] = a1;
        contadorAluno++;

        Pessoa p2 = new Pessoa("Hugo", "Cabo Verde", 19);
        Aluno a2 = new Aluno(p2, "Engenharia de Software", "2341", 3, 2026, false);
        alunos[contadorAluno] = a2;
        contadorAluno++;

        Pessoa p3 = new Pessoa("Otávio", "Porto Alegre", 20);
        Aluno a3 =  new Aluno(p3, "Ciências da Computação", "3561", 7, 2026, false);
        alunos[contadorAluno] = a3;
        contadorAluno++;

        Pessoa p4 = new Pessoa("Luara", "Santa Maria", 24);
        Aluno a4 = new Aluno(p4, "Sistemas de Informação", "2578", 8, 2026, true);
        alunos[contadorAluno] = a4;
        contadorAluno++;

        Pessoa p5 = new Pessoa("Luara", "Santa Maria", 24);
        Aluno a5 = new Aluno(p5, "Ciências de Dados e Inteligência Artificial", "9248", 5, 2026, true);
        alunos[contadorAluno] = a5;
        contadorAluno++;

        // Os dois bolsistas obrigatórios:
        bolsista[contadorBolsista] = new BolsistaIC(a4, "Uso de IA no Desenvolvimento de Projetos", "Daniela do Amaral");
        contadorBolsista++;

        bolsista[contadorBolsista] = new BolsistaIC(a5, "Simulação de Humanos Virtuais", "Gabriel Fonseca");
        contadorBolsista++;

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
    public void percentualAlunosPorCurso(){
        int ec = 0;
        int es = 0;
        int ads = 0;
        int cc = 0;
        int cdia = 0;
        int si = 0;

        for (int i = 0; i < alunos.length; i++){
            if (alunos[i] != null){
                if(alunos[i].getCurso().equals("Engenharia da Computação")){
                    ec++;
                } else if (alunos[i].getCurso().equals("Engenharia de Software")) {
                    es++;
                } else if(alunos[i].getCurso().equals("Análise e Desenvolvimento de Sistemas")) {
                    ads++;
                } else if (alunos[i].getCurso().equals("Ciências da Computação")) {
                    cc++;
                } else if (alunos[i].getCurso().equals("Ciências de Dados e Inteligência Artificial")){
                    cdia++;
                } else if (alunos[i].getCurso().equals("Sistemas de Informações")) {
                    si++;
                } 
            }
        }

        int total = ec + es + ads + cc + cdia + si;

        System.out.println("Engenharia da Computação: " + (ec * 100.0/ total) + "%");
        System.out.println("Engenharia de Software: " + (es * 100.0/ total) + "%");
        System.out.println("Análise e Desenvolvimento de Sistemas: " + (ads * 100.0/ total) + "%");
        System.out.println("Ciências da Computação: " + (cc * 100.0/ total) + "% \t");
        System.out.println("Ciências de Dados e Inteligência Artificial: " + (cdia * 100.0/ total) + "%");
        System.out.println("Sistemas de Informações: " + (si * 100.0/ total) + "%");
    }

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
    public void listaDeChamada(){
        System.out.println("Digite o nome do Professor:");
        String professor = input.nextLine();

        System.out.println("Digite o nome da disciplina:");
        String disciplina = input.nextLine();

        System.out.println("Quantidade de alunos da turma:");
        int quantidade = input.nextInt();

        //Se a quantidade for maior que os alunos cadastrados ou menor/igual a zero:
        while (quantidade > contadorAluno || quantidade <= 0) {
            System.out.println("Quantidade inválida. Digite novamente:");
            quantidade = input.nextInt();
        }

        Aluno[] turma = new Aluno[quantidade];

        listarAlunos();

        for (int i = 0; i < quantidade; i++){
            System.out.println("Escolha o índice do aluno:");
            int opcao = input.nextInt();

            while (opcao < 0 ||opcao > contadorAluno) {
                System.out.println("Aluno inválido. Escolha novamente:");
                opcao = input.nextInt();
            }

            turma[i] = alunos[opcao];
        }

        ListaChamada lista = new ListaChamada(professor, disciplina, turma);

        if (listas.length > contadorListas) {
                listas[contadorListas] = lista;
            contadorListas++;
        } else {
            System.out.println("Limite de turmas atingido!");
        }
    }

    //Exibir a lista de chamada em ordem alfabetica crescente, contendo nome, matricula e curso
    public void exibirListaDeChamada() {

        if(contadorListas == 0) {
            System.out.println("Nenhuma lista encontrada!");
            return;
        }

        System.out.println("Listas disponiveis:");

        for (int i = 0; i < contadorListas; i++){
            System.out.println( i + " - " + listas[i].getProfessor() + " | " + listas[i].getDisciplina());
        }

        System.out.println("Escolha a lista:");
        int opcao = input.nextInt();

        while (opcao < 0 || opcao > contadorListas) {
            System.out.println("Lista inválida. Escolha novamente:");
            opcao = input.nextInt();
        }

        System.out.println("Professor: " + listas[opcao].getProfessor());
        System.out.println("disciplina: " + listas[opcao].getDisciplina());

        Aluno[] turma = listas[opcao].getAlunos();

        ordenarListaChamada(turma);
        
        for (int i = 0; i < turma.length; i++){
            System.out.println(i + " - " + turma[i].getMatricula() + " - " + turma[i].getPessoa().getNome() + " - " + 
            turma[i].getCurso());
        }
    }

    //Método para organizar a lista de chamada usando Bubble Sort:
    public void ordenarListaChamada(Aluno[] turma){
        for (int i = 0; i < turma.length - 1; i++) {
        for (int j = 0; j < turma.length - 1 - i; j++) {

            if (turma[j].getPessoa().getNome().compareToIgnoreCase(turma[j + 1].getPessoa().getNome()) > 0) {

                Aluno aux = turma[j];
                turma[j] = turma[j + 1];
                turma[j + 1] = aux;
            }
        }
    }
    }
    
    // Calcular o percentual de risco pedagogico 
    public void calculoDeRiscoPedagogico(){
        if (contadorAcompanhamento == 0) {
            System.out.println("Nenhuma acompanhamento cadastrado");
            return;
        }

        int baixo = 0;
        int medio = 0;
        int alto = 0;

        for(int i = 0; i < contadorAcompanhamento; i++) {
            String risco = registros[i].riscoPedagogico();

            if (risco.equals("Risco Baixo")) {
                baixo++;
            } else if (risco.equals("Risco Médio")){
                medio++;
            } else if (risco.equals("Risco Alto")) {
                alto++;
            }
        }

        System.out.println("Relatório de Risco pedagogico");

        System.out.println("Risco Baixo: " + baixo + " (" + (baixo * 100.0 / contadorAcompanhamento) + "%)");
        System.out.println("Risco Médio: " + medio + " (" + (medio * 100.0 / contadorAcompanhamento) + "%)");
        System.out.println("Risco Alto: " + alto + " (" + (alto * 100.0 / contadorAcompanhamento) + "%)");
    }

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
// Linha não encontrada
        } else {
            ehBolsista = false;
        }
        return ehBolsista;
    }

    //Exibir cursos disponiveis:
    public void exibirCursos(){
        String cursos = """
        Cursos Disponiveis:
        1 - Engenharia da Computação
        2 - Engenharia de Software
        3 - Análise e Desenvolvimento de Sistemas
        4 - Ciências da Computação
        5 - Ciências de Dados e Inteligência Artificial
        6 - Sistemas de Informações
        """;
        System.out.println(cursos);
    }

    //Método para desingar o curso de cada aluno:
    public String cursoEscolhido(int escolha){
        String curso = "";
        if (escolha == 1) {
            curso = "Engenharia da Computação";
        } else if (escolha == 2){
            curso = "Engenharia de Software";
        } else if (escolha == 3) {
            curso = "Analise e Desenvolvimento de Sistemas";
        } else if ( escolha == 4 ) {
            curso = "Ciências da Computação";
        } else if (escolha == 5 ) {
            curso = "Ciências de Dados e Inteligência Artificial";
        } else if (escolha == 6) {
            curso = "Sistemas de Informações";
        } else {
            curso = "Indisponível";
        }
        return curso;
    }
    //Método para exibir os tracinhos:
    public void espaco(){
        System.out.println("---------------------------------------------");
    }

// INOVAÇÃO DO GRUPO: Relatório de Melhorias + Duplas pra estudo:
public void planoDeDesenvolvimento() {

    if (contadorAcompanhamento == 0) {
        System.out.println("Nenhum acompanhamento cadastrado!");
        return;
    }

    System.out.println("Plano de Desenvolvimento:");
    espaco();

    for (int i = 0; i < contadorAluno; i++) {
        System.out.println((i + 1) + " - " + alunos[i].getPessoa().getNome());
    }

    System.out.print("Escolha um aluno: ");
    int opcao = input.nextInt() - 1;

    if (opcao < 0 || opcao >= contadorAluno) {
        System.out.println("Aluno inválido!");
        return;
    }

    AcompanhamentoIA acompanhamento = null;

    for (int i = 0; i < contadorAcompanhamento; i++) {

        if (registros[i].getAluno().getMatricula() ==
                alunos[opcao].getMatricula()) {

            acompanhamento = registros[i];
            break;
        }
    }

    if (acompanhamento == null) {
        System.out.println("Este aluno não possui acompanhamento cadastrado.");
        return;
    }

    String risco = acompanhamento.riscoPedagogico();

    System.out.println("\nAluno: " + alunos[opcao].getPessoa().getNome());
    System.out.println("Curso: " + alunos[opcao].getCurso());
    System.out.println("Risco: " + risco);

    mostrarPlano(risco);
    espaco();

    if (risco.equalsIgnoreCase("Risco Alto")) {
        sugerirDupla(alunos[opcao]);
    }

}
//Para exibir o plano com Melhorias:
public void mostrarPlano(String risco){

    System.out.println("\nPlano de ação:");

    if(risco.equalsIgnoreCase("Risco Baixo")){

        System.out.println("- Continue mantendo sua rotina de estudos.");
        System.out.println("- Utilize a IA apenas como apoio.");
        System.out.println("- Continue revisando os conteúdos.");

    }else if(risco.equalsIgnoreCase("Risco Médio")){

        System.out.println("- Faça revisões semanais.");
        System.out.println("- Resolva exercícios antes de consultar a IA.");
        System.out.println("- Organize um cronograma de estudos.");

    }else{

        System.out.println("- Estabeleça uma rotina diária de estudos.");
        System.out.println("- Utilize menos a IA para respostas prontas.");
        System.out.println("- Procure ajuda de colegas e professores.");
        System.out.println("- Refaça atividades sem auxílio da IA.");

    }

}

//Para encontrar dupla: 
public void sugerirDupla(Aluno aluno){

    for(int i = 0; i < contadorAcompanhamento; i++){

        if(registros[i].riscoPedagogico().equalsIgnoreCase("Risco Baixo")
                && registros[i].getAluno().getMatricula() != aluno.getMatricula()
                && registros[i].getAluno().getCurso().equals(aluno.getCurso())){

            System.out.println("Dupla Sugerida:");
            System.out.println("Aluno: " + registros[i].getAluno().getPessoa().getNome());
            System.out.println("Curso: " + registros[i].getAluno().getCurso());

            return;
        }
    }

    System.out.println("\nNenhum aluno do mesmo curso com risco baixo foi encontrado.");
}
}
