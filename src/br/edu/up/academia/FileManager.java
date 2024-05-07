package br.edu.up.academia;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    /* Esse método recebe uma lista de strings, itera sobre cada uma delas,
    e as escreve no arquivo filename
      Se usa a funçao try para garantir que o "fileWriter" seja fechado
     corretamente após o uso, e captura exceções caso ocorram problemas 
     durante a escrita do arquivo */
    public void salvarDados(List<String> dados){
        try (FileWriter writer = new FileWriter(fileName)){
            for(String linha: dados){
                writer.write(linha);
            }
        } catch (IOException e){ // Captura exceções do tipo IOException, que é uma classe que representa exceções de entrada/saída.
            /* printStackTrace é um método para imprimir informações sobre
            a exceção que ocorreu, auxilia para identificar onde ocorreu 
            os problemas */
            e.printStackTrace();
        }
    }
    // Lista de equipamentos 
    public static List<Equipamento> listaEquipaqmentos() {
        var equipamentos = new ArrayList<Equipamento>();
        equipamentos.add(new Equipamento("Supino inclinado"));//peito1
        equipamentos.add(new Equipamento("Cadeira adutora"));//perna1
        equipamentos.add(new Equipamento("Triceps corda"));//triceps1
        equipamentos.add(new Equipamento("Biceps Halter"));//bic1
        equipamentos.add(new Equipamento("Cadeira flexora"));//perna2
        equipamentos.add(new Equipamento("Crossover"));//peito2
        equipamentos.add(new Equipamento("Crucifixo"));//peito3
        equipamentos.add(new Equipamento("Esteira"));//cardio
        equipamentos.add(new Equipamento("Bike"));//cardio
        equipamentos.add(new Equipamento("Desenvolvimento de ombro"));//ombro
        equipamentos.add(new Equipamento("ElevaÃ§ao lateral"));//ombro
        equipamentos.add(new Equipamento("Triceps na polia"));//tric


        return equipamentos;
    }


    }
