import br.edu.up.academia.*;

import java.io.File;
import java.util.*;

import static br.edu.up.academia.Treino.listarEquipamentosOrdenados;
import static br.edu.up.academia.Treino.listarTreinos;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    // Add o nome que o usuario digitou na lista "instrutores"
                    instrutores.add(new Instrutor(nomeInstrutor));
                    break;
                case 2:
                    System.out.println("EQUIPAMENTOS NA LISTA: \n");
                    // Adiciona uma variavel "e" do tipo Equipamento
                    for (Equipamento e : FileManager.listaEquipaqmentos()) {
                        // Printa todos os equipamentos na lista utilizando o "getNomeEquipamento"
                        System.out.println(e.getNomeEquipamento());
                    }
                    break;
                case 3:
                    // Caso o usuario nao tenha adicionado nenhum instrutor, nao vai ser possivel adicionar um treino
                    if (instrutores.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um instrutor cadastrado para adicionar um treino.");
                        break;
                    }
                    if (alunos.isEmpty()){
                        System.out.println("É necessário ter pelo menos um aluno cadastrado para adicionar um treino");
                        break;
                    }
                    //Incializando a lista de equipamentos e variavel nomeTreino
                    String nomeTreino = "";

                    System.out.print("Digite o nome do treino: ");
                    // Validar a escolha do usuario
                     nomeTreino = scanner.nextLine();
                    
                    System.out.println("Escolha um Aluno para o treino:");
                    // Exibe uma lista para o usuario escolher qual aluno irá ser associado ao treino
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    // Lê qual opção o usuário escolheu
                    int indiceAluno = scanner.nextInt() - 1;
                    /*Seleciona o aluno da posiçao "indiceAluno" e armazena na variavel abaixo
                    Após essa linha ser executada, você pode acessar os dados associado a esse aluno específico */
                    Aluno alunoSelecionado = alunos.get(indiceAluno);
                    
                    System.out.println("Escolha um instrutor para o treino:");
                      // Exibe uma lista para o usuario escolher qual instrutor irá ser associado ao treino
                    for (int i = 0; i < instrutores.size(); i++) {
                        System.out.println((i + 1) + ". " + instrutores.get(i).getNome());
                    }
                     // Lê qual opção o usuário escolheu
                    int indiceInstrutor = scanner.nextInt() - 1;
                     /*Seleciona o instrutor da posiçao "indiceInstrutor" e armazena na variavel abaixo
                    Após essa linha ser executada, você pode acessar os dados associado a esse instrutor específico */
                    Instrutor instrutorSelecionado = instrutores.get(indiceInstrutor);
                    // Cria um novo objeto Treino com os parametros fornecidos pelo usuário
                    Treino novoTreino = new Treino(nomeTreino, instrutorSelecionado, alunoSelecionado);

                    System.out.println("adicione um equipamento ao seu treino");
                    List<Equipamento> listaEquipamentos = FileManager.listaEquipaqmentos();                 
                    // Cria uma lista enumerada dos equipamentos   
                     for (int i = 0; i < listaEquipamentos.size(); i++) {
                        Equipamento e = listaEquipamentos.get(i);
                        System.out.println((i + 1) + ". " + e.getNomeEquipamento());
                    }

                    System.out.println("De 1 a " + listaEquipamentos.size() + " selecione qual equipamento deseja adicionar no seu treino: ");
                    // Armazena o numero correspondende ao equipamento que o usuário escolheu
                    int indiceLista = scanner.nextInt();
                    /*O "indiceLista - 1" é por caso das listas começarem no 0 e terminam no 11, mas para o usuário aparece do 1 ao 12
                    A partir desse indice, obtemos qual equipamento foi selecionado pelo usuario e adicionamos a variavel "equipamentoSelecionado"*/
                    Equipamento equipamentoSelecionado = listaEquipamentos.get(indiceLista - 1);
                    System.out.println("O equipamento " + equipamentoSelecionado.getNomeEquipamento() + " foi adicionado ao treino " + nomeTreino + " .");
                    //Adiciona numa lista os parametros 
                    treinos.add(new Treino(nomeTreino, instrutorSelecionado, alunoSelecionado));
                    System.out.println("Treino adicionado com sucesso!");

                    String nomeAlunoTreino = alunoSelecionado.getNome();
                    String nomeInstrutorTreino = instrutorSelecionado.getNome();
                    FileManager fileManager = new FileManager("dados.txt");
                    List<String> dados = new ArrayList<>();
                    dados.add("Treino: " + novoTreino.getNome() + ", Aluno: " + nomeAlunoTreino + ", Instrutor: " + nomeInstrutorTreino + ", Equipamento: " + equipamentoSelecionado.getNomeEquipamento());
                    fileManager.salvarDados(dados);
                    System.out.println(dados);
                    break;
                case 4:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    alunos.add(new Aluno(nomeAluno));
                    System.out.println("Aluno cadastrado");
                    break;

                case 5:
                List<Equipamento> equipamentos = FileManager.listaEquipaqmentos();

                // Mostra a lista de equipamentos original
                System.out.println("\nLista de equipamentos original:\n");
                for (int i = 0; i < equipamentos.size(); i++) {
                    Equipamento e = equipamentos.get(i);
                    System.out.println((i + 1) + ". " + e.getNomeEquipamento());
                }
                
                System.out.print("\nDigite o número do equipamento que deseja remover: ");
                int equipamentoRemoverNum = scanner.nextInt();
                // Objeto que permite percorrer uma lista e fazer remoção
                Iterator<Equipamento> iterator = equipamentos.iterator();
                // Continua enquanto houver elementos nao percorridos na lista
                while (iterator.hasNext()) {
                    // Avança para o proximo elemento e armazena na variavel "equipamento"
                    Equipamento equipamento = iterator.next();
                    // Verifica se correspondente na lista é igual ao numero digitado pelo usuário
                    if (equipamentos.indexOf(equipamento) + 1 == equipamentoRemoverNum) {
                        // Remove o equipamento da lista
                        iterator.remove();
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
                case 6:
                    List<Equipamento> equips = FileManager.listaEquipaqmentos();
                    // Solicita ao usuário o equipamento a ser procurado
                    System.out.print("\nDigite o nome do equipamento que deseja procurar: ");
                    String equipamentoProcurarNome = scanner.nextLine();

                    boolean encontrado = false; // inicializa uma string boolean armazenado com "false"
                    for (Equipamento equipamento : equips) {// Procura o equipamento na lista
                        /*Caso o nome do equipamento seja igual ao nome digitado pelo usuário (ignorando letra maiscula e minuscula)
                        a variável "encontrado" muda para "true"*/
                        if (equipamento.getNomeEquipamento().equalsIgnoreCase(equipamentoProcurarNome)) {
                            encontrado = true;
                            break;
                        }
                    }
                    // Mostra o resultado da busca
                    if (encontrado) { // Caso encontrado = true
                        System.out.println("\nEquipamento encontrado na lista.");
                    } else { // Caso encontrado = false
                        System.out.println("\nEquipamento não encontrado na lista.");
                    }
                    // Imprime a lista de equipamentos
                    System.out.println("\nLista de equipamentos original:");
                    for (Equipamento equipamento : equips) {
                        System.out.println(equipamento.getNomeEquipamento());
                    }
                    break;
                case 7:
                    // Listar todos os Treinos
                    System.out.println("Lista de todos os treinos:");
                    // Puxa todos os itens armazenados da lista "treinos"
                    for (Treino treino : treinos) {
                        // Printa com nome do treino, instrutor e aluno
                        listarTreinos(treino); // Obs: mexer para aparecer equipamento junto
                    }
                    break;
                case 8:
                    // Inicializa o array
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
                    // Ordena em ordem alfabética
                    Collections.sort(Equips);
                    System.out.println("\nLista ordenada:\n " + Equips);
                    break;
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
