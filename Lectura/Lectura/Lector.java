package Lectura;


import Viajes.Puerto;
import Viajes.Grafo;
import Viajes.Viaje;

import javax.swing.*;
import java.io.*;

public class Lector {
    private BufferedReader lector;
    private String linea;
    private String partes[]=null;

    public Grafo cargarGrafo(){
    	Grafo grafo = new Grafo();
    	cargarVertices(grafo);
    	cargarAristas(grafo);
    	return grafo;
    }
    
    //Método para cargar el grafo desde un csv
    private void cargarVertices(Grafo grafo){
        try{
            lector=new BufferedReader(new FileReader("Puertos2.csv"));
            while((linea = lector.readLine())!=null){
                partes = linea.split(",");
                grafo.agregarVertice(new Puerto(partes));
            }
            lector.close();
            linea=null;
            partes=null;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

  //Método para cargar las aristas desde un csv
    private void cargarAristas(Grafo grafo){
        try{
            lector=new BufferedReader(new FileReader("viajes2.csv"));
            while((linea = lector.readLine())!=null){
                partes = linea.split(",");
                grafo.agregarArista(Integer.parseInt(partes[0]),new Viaje(partes));
            }
            lector.close();
            linea=null;
            partes=null;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //Método de prueba de la lectura del csv
    public void imprimirLinea(){
        for (int i=0; i< partes.length; i++){
            System.out.print(partes[i]+"   |   ");
        }
        System.out.println();
    }
}