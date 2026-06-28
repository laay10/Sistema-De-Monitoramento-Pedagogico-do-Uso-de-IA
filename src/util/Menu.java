package util;

import service.Funcionalidades;

import java.util.Scanner;

public class Menu {
    Funcionalidades funcao = new Funcionalidades();

    Scanner input = new Scanner(System.in);

    public void iniciar(){
        funcao.cadastrarDadosIniciais();
        boolean continuar = true;

        do {
            exibirMenu();
            System.out.println("Digite a opção desejada: ");
            int escolha = input.nextInt();

            if (escolha == 0) {
                System.out.println("Fechando o sistema");
                continuar = false;
            } else if (escolha == 1) {
                funcao.adicionarAluno();
            } else if (escolha == 2) {
                funcao.adicionarBolsistaIC();
            } else if (escolha == 3) {
                funcao.registroAcompanhamento();
            } else if (escolha == 4) {
                funcao.listarAlunos();
            } else if (escolha == 5) {
                funcao.listarBolsistas();
            } else if (escolha == 6) {
                funcao.nomeMaisLongoTurma();
            } else if (escolha == 7) {
                funcao.contarVogais();
            } else if (escolha == 8) {
                funcao.percentualAlunosPorCurso();
            } else if (escolha == 9) {
                funcao.mediaIdadeAlunos();
            } else if (escolha == 10) {
                funcao.listaDeChamada();
            } else if (escolha == 11) {
                funcao.exibirListaDeChamada();
            } else if (escolha == 12) {
                funcao.calculoDeRiscoPedagogico();
            } else if (escolha == 13) {
                funcao.alunosRiscoAlto();
            } else if (escolha == 14) {
                funcao.planoDeDesenvolvimento();
            } else {
                System.out.println("Opção inválida");
            }
        } while (continuar);

    }

    public void exibirMenu(){
        String menu = """ 
        OPÇÕES DISPONÍVEIS:
        ---------------------------------------------
        1 - Cadastrar aluno
        2 - Cadastrar aluno Bolsista de IC
        3 - Registrar acompanhamento de IA 
        4 - Listar todos os alunos 
        5 - Listar todos os alunos bolsistas de IC
        6 - Mostrar nome mais longo 
        7 - Contar vogais nos nomes cadastrados
        8 - Percentual de alunos por curso
        9 - Média de idade dos alunos
        10 - Criar ou atualizar a lista de chamada
        11 - Exibir lista de chamada 
        12 - Calcular o risco pedagógico
        13 - Exibir alunos de alto risco
        14 - Plano de Desenvolvimento de Alunos
        0 - Sair
        """;
        System.out.println(menu);
    }
}
