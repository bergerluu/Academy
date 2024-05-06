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

    public static void listarTreinos(Treino treino) {
        System.out.println("Nome do treino: " + treino.getNome());
        System.out.println("Instrutor: " + treino.getInstrutor().getNome());
    }
    public static void listarEquipamentosOrdenados(Treino treino) {
        List<Equipamento> equipamentos = new ArrayList<>(treino.getEquipamento());
        equipamentos.sort(Comparator.comparing(Equipamento::getNomeEquipamento));

        for (Equipamento equipamento : equipamentos) {
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


    public List<Equipamento> getEquipamento() {
        return equipamentos;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamentos = equipamento;
    }

}