import br.edu.up.academia.*;

import java.io.File;
import java.util.*;

import static br.edu.up.academia.Treino.listarEquipamentosOrdenados;
import static br.edu.up.academia.Treino.listarTreinos;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resposta = 0;
        // Criando listas para armazenar os objetos criados
        List<Instrutor> instrutores = new ArrayList<>();
        List<Treino> treinos = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1- Adicionar Instrutor");
            System.out.println("2- Listar Equipamentos");
            System.out.println("3- Adicionar Treino");
            System.out.println("4- Adicionar Aluno");
            System.out.println("5- Remover Equipamento de Treino");
            System.out.println("6- Pesquisar Equipamento em Treino");
            System.out.println("7- Listar todos os Treinos");
            System.out.println("8- Listar equipamentos ordenadamente");
            System.out.println("9- Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do instrutor: ");
                    String nomeInstrutor = scanner.nextLine();
                    instrutores.add(new Instrutor(nomeInstrutor));
                    break;
                case 2:
                    System.out.println("##########################");
                    for (Equipamento e : FileManager.listaEquipaqmentos()) {
                        System.out.println(e.getNomeEquipamento());
                    }
                    break;
                case 3:
                    if (instrutores.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um instrutor cadastrado para adicionar um treino.");
                        break;
                    }
                    List<Equipamento> eq = FileManager.listaEquipaqmentos();
                    String nomeTreino = "";
                    do {
                        System.out.print("Escolha um treino: ");
                        // Valdiar a escolha do usuario
                        nomeTreino = scanner.nextLine();
                        break;
                    } while (!eq.contains(nomeTreino));

                    System.out.println("Escolha um instrutor para o treino:");
                    for (int i = 0; i < instrutores.size(); i++) {
                        System.out.println((i + 1) + ". " + instrutores.get(i).getNome());
                    }
                    int indiceInstrutor = scanner.nextInt() - 1;
                    Instrutor instrutorSelecionado = instrutores.get(indiceInstrutor);

                    Treino novoTreino = new Treino(nomeTreino, instrutorSelecionado);

                    System.out.println("adicione um equipamento ao seu treino");
                    System.out.println("##########################");

                    List<Equipamento> listaEquipamentos = FileManager.listaEquipaqmentos();

                    for (int i = 0; i < listaEquipamentos.size(); i++) {
                        Equipamento e = listaEquipamentos.get(i);
                        System.out.println((i + 1) + ". " + e.getNomeEquipamento());
                    }

                    System.out.println("De 1 a " + listaEquipamentos.size() + " selecione qual equipamento deseja adicionar no seu treino: ");

                    int indiceLista = scanner.nextInt();

                    Equipamento equipamentoSelecionado = listaEquipamentos.get(indiceLista - 1);

                    System.out.println("O equipamento " + equipamentoSelecionado.getNomeEquipamento() + " foi adicionado ao treino " + nomeTreino + " .");

                    treinos.add(new Treino(nomeTreino, instrutorSelecionado));
                    System.out.println("Treino adicionado com sucesso!");

                    String nomeInstrutorTreino = instrutorSelecionado.getNome();

                    FileManager fileManager = new FileManager("dados.txt");
                    List<String> dados = new ArrayList<>();
                    dados.add("Treino: " + novoTreino.getNome() + ", Instrutor: " + nomeInstrutorTreino + ", Equipamento: " + equipamentoSelecionado.getNomeEquipamento());
                    fileManager.salvarDados(dados);
                    System.out.println(dados);
                    break;
                case 4:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    alunos.add(new Aluno(nomeAluno));
                    System.out.println("Aluno cadastrado");
                    break;
                //erro 2
                case 5:
                    List<Equipamento> equipamentos = FileManager.listaEquipaqmentos();

                    // Mostra a lista de equipamentos original
                    System.out.println("Lista de equipamentos original:");
                    for (Equipamento equipamento : equipamentos) {
                        System.out.println(equipamento.getNomeEquipamento());
                    }
                    System.out.print("\nDigite o nome do equipamento que deseja remover: ");
                    String equipamentoRemoverNome = scanner.nextLine();


                    for (Equipamento equipamento : equipamentos) {
                        if (equipamento.getNomeEquipamento().equalsIgnoreCase(equipamentoRemoverNome)) {
                            equipamentos.remove(equipamento);
                            System.out.println("Equipamento removido com sucesso.");
                            break;
                        }
                    }

                    // Mostra a lista de equipamentos após a remoção
                    System.out.println("\nLista de equipamentos após a remoção:");
                    for (Equipamento equipamento : equipamentos) {
                        System.out.println(equipamento.getNomeEquipamento());
                    }


                    break;
                //erro 3
                case 6:
                    List<Equipamento> equips = FileManager.listaEquipaqmentos();

                    // Mostra a lista de equipamentos original


                    // Solicita ao usuário o equipamento a ser procurado
                    System.out.print("\nDigite o nome do equipamento que deseja procurar: ");
                    String equipamentoProcurarNome = scanner.nextLine();

                    // Procura o equipamento na lista
                    boolean encontrado = false;
                    for (Equipamento equipamento : equips) {
                        if (equipamento.getNomeEquipamento().equalsIgnoreCase(equipamentoProcurarNome)) {
                            encontrado = true;
                            break;
                        }
                    }

                    // Mostra o resultado da busca
                    if (encontrado) {
                        System.out.println("\nEquipamento encontrado na lista.");
                    } else {
                        System.out.println("\nEquipamento não encontrado na lista.");
                    }

                    System.out.println("\nLista de equipamentos original:");
                    for (Equipamento equipamento : equips) {
                        System.out.println(equipamento.getNomeEquipamento());
                    }
                    break;
                case 7:
                    // Listar todos os Treinos
                    System.out.println("Lista de todos os treinos:");
                    for (Treino treino : treinos) {
                        listarTreinos(treino);
                    }
                    break;
                //erro 4
                case 8:
                    ArrayList<String> Equips = new ArrayList<String>();
                    Equips.add("Supino inclinado");
                    Equips.add("Cadeira adutora");
                    Equips.add("Triceps corda");
                    Equips.add("Rosca Scott");
                    Equips.add("Cadeira Flexora");
                    Equips.add("Crossover");
                    Equips.add("Crucifixo");
                    Equips.add("Esteira");
                    Equips.add("Desenvolvimento de ombro");
                    Equips.add("Bike");
                    Equips.add("Elevação lateral");
                    Equips.add("Triceps na polia");

                    Collections.sort(Equips);

                    System.out.println("\nLista ordenada:\n " + Equips);

                case 9:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente!!!!!");
                    break;

            }

        } while (opcao != 9);

    }
}

