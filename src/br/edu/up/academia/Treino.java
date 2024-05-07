package br.edu.up.academia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Treino {
    private String nomeTreino;
    private Instrutor instrutor;
    private Aluno aluno;


    private static List<Equipamento> equipamentos;


    public Treino(String nomeTreino, Instrutor instrutor, Aluno aluno) {
        this.nomeTreino = nomeTreino;
        this.instrutor = instrutor;
        this.aluno = aluno;
        this.equipamentos = new ArrayList<>();
    }
    // Printa para o usuario o "Nome do treino, do Instrutor e do Aluno"
    public static void listarTreinos(Treino treino) {
        System.out.println("Nome do treino: " + treino.getNome());
        System.out.println("Instrutor: " + treino.getInstrutor().getNome());
        System.out.println("Nome do aluno: " + treino.getAluno().getNome());
    }
    public static void listarEquipamentosOrdenados(Treino treino) {
        // Cria uma nova lista de equipamentos chamada "equipamentos", inicializando-a com os equipamentos do treino
        List<Equipamento> equipamentos = new ArrayList<>(treino.getEquipamento());
        // Esta linha ordena os equipamentos na lista equipamentos com base na ordem alfabética
        //  Usa o método "sort", que passa um comparador para comparar os nomes dos equipamentos
        equipamentos.sort(Comparator.comparing(Equipamento::getNomeEquipamento));
        //  Percorre sobre cada elemento
        for (Equipamento equipamento : equipamentos) {
            // Printa em ordem cada equipamento
            System.out.println("- " + " (" + equipamento.getNomeEquipamento() + ")");
        }
    }
    public void adicionarEquipamento(Equipamento equipamento){
        equipamentos.add(equipamento);
    }
    public void removerEquipamento(Equipamento equipamento){
        equipamentos.remove(equipamento);
    }

    public String getNome() {

        return nomeTreino;
    }

    public void setNome(String nome) {

        this.nomeTreino = nome;
    }

    public Instrutor getInstrutor() {

        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {

        this.instrutor = instrutor;
    }
    public Aluno getAluno(){
        return aluno;
    }



    public List<Equipamento> getEquipamento() {
        return equipamentos;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamentos = equipamento;
    }

}
