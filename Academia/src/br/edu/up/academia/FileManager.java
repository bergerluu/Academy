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
    public void salvarDados(List<String> dados){
        try (FileWriter writer = new FileWriter(fileName)){
            for(String linha: dados){
                writer.write(linha + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

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
