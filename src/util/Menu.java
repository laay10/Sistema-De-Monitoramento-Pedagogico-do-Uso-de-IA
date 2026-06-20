package util;

import service.Funcionalidades;

import java.util.Scanner;

public class Menu {
    Funcionalidades funcao = new Funcionalidades();

    Scanner input = new Scanner(System.in);

    public void iniciar(){
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
                System.out.println("Tamo pensando");
            } else if (escolha == 15) {
                funcao.exibirRegistros();
            } else {
                System.out.println("Opção inválida");
            }
        } while (continuar);

    }

    /* Menu se desse para usar Switch Case:
     *
     * Funcionalidades funcao = new Funcionalidades();
     *
     * Scanner input = new Scanner(System.in);
     *
     * boolean continuar = true;
     *
     * while (continuar) {
     *     exibirMenu();
     *     System.out.println("Digite a opção desejada:");
     *     int escolha = input.nextInt();
     *
     *     switch(escolha) {
     *         case 0 -> {
     *             System.out.println("Fechando o sistema");
     *             continuar = false;
     *             }
     *         case 1 -> funcao.adicionarAluno();
     *         case 2 -> funcao.adicionarBolsistaIC();
     *         case 3 -> funcao.registroAcompanhamento();
     *         case 4 -> funcao.listarAlunos();
     *         case 5 -> funcao.listarBolsistas();
     *         case 6 -> funcao.nomeMaisLongoTurma();
     *         case 7 -> funcao.contarVogais();
     *         case 8 -> funcao.percentualAlunosPorCurso();
     *         case 9 -> funcao.mediaIdadeAlunos();
     *         case 10 -> funcao.listaDeChamada();
     *         case 11 -> funcao.exibirListaDeChamada();
     *         case 12 -> funcao.calculoDeRiscoPedagogico();
     *         case 13 -> funcao.alunosRiscoAlto();
     *         case 14 ->
     *
     *         default -> Sytem.out.println("Opção inválida");
     *
     *         }
     *      }
     }
     }
       */


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
        14 - Inovação
        15 - Exibir registros
        0 - Sair
        """;
        System.out.println(menu);
    }
}
