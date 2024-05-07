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
    // Obejto do tipo "Equipamento" que recebe 2 parametros, "treino" e "nomeEquipamento"    
    public static Equipamento pesquisarEquipamento(Treino treino, String nomeEquipamento) {
        for (Equipamento equipamento: treino.getEquipamento()){
             //Verificação para ver se o nome do Equipamento é igual ao nome do Equipamento passado como parâmetro
            if (equipamento.getNomeEquipamento().equals(nomeEquipamento)){
                // Se o equipamento com nome específico for encontrado, ele é retornado
                return equipamento;
            }
        }
        //Se nao houver equipamento com o nome específico, retorna null
        return null;

    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamentos = nomeEquipamento;
    }

}
