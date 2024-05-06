package br.edu.up.academia;

import java.util.ArrayList;
import java.util.List;

public class Equipamento {

    private String nomeEquipamentos;

    public Equipamento(String nomeEquipamento) {
        this.nomeEquipamentos = nomeEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamentos;
    }
    public static Equipamento pesquisarEquipamento(Treino treino, String nomeEquipamento) {
        for (Equipamento equipamento: treino.getEquipamento()){
            if (equipamento.getNomeEquipamento().equals(nomeEquipamento)){
                return equipamento;
            }
        }
        return null;

    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamentos = nomeEquipamento;
    }

}
