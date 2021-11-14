package Viajes;


import java.util.ArrayList;
import java.util.List;

public class NodoGrafo {
    private Puerto dato;
    private List<Viaje> destinos = new ArrayList<Viaje>();
    private int distancia;
    private boolean visitado;

    public NodoGrafo(Puerto nuevo){
        this.dato = nuevo;
    }
    public void agregarArista(Viaje arista){
        this.destinos.add(arista);
    }
    public Puerto getDato(){return this.dato;}

    public int getDistancia() {
        return this.distancia;
    }
    public void setDistancia(int numero){
        this.distancia = numero;
    }
    public boolean getVisitado(){
        return this.visitado;
    }
    public void setVisitado(boolean nuevo){
        this.visitado = nuevo;
    }
    public List<Viaje> getAdyacentes() {return this.destinos;}
    public void imprimirAristas(){
        int iterar = 0;
        while (iterar<destinos.size()){
            System.out.println(destinos.get(iterar));
            iterar =  iterar + 1;
        }
    }
}

