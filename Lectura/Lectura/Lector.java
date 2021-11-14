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
/*
    public ABB cargarArbol(){
        ABB arbolBB = new ABB();
        try{
            lector=new BufferedReader(new FileReader("puertos2.csv"));
            while((linea = lector.readLine())!=null){
                partes = linea.split(",");
                arbolBB.insertar(new Puerto(partes));
            }
            lector.close();
            linea=null;
            partes=null;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arbolBB;
    }
*/
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

    public Grafo cargarGrafo(){
        Grafo grafo = new Grafo();
        cargarVertices(grafo);
        cargarAristas(grafo);
        return grafo;
    }

    public void imprimirLinea(){
        for (int i=0; i< partes.length; i++){
            System.out.print(partes[i]+"   |   ");
        }
        System.out.println();
    }
}