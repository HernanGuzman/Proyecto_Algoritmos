package Viajes;
import java.util.ArrayList;
import java.util.List;




public class Grafo {
	private List<NodoGrafo> vertices;
    

    public Grafo(){
        vertices = new ArrayList<>();
        
    }

    public void agregarVertice (Puerto dato) {
        vertices.add(new NodoGrafo(dato));
    }

    private NodoGrafo buscar(int codigo){
        NodoGrafo retornar = null;
        int iterar=0;
        while (iterar<vertices.size() && retornar == null){
            if (vertices.get(iterar).getDato().getCodigo() == codigo){
                retornar = vertices.get(iterar);
            }else{
                iterar = iterar + 1;
            }
        }
        return retornar;
    }

    public void agregarArista(int codigo, Viaje arista) {
        NodoGrafo nodoAgregar = buscar(codigo);
        if (nodoAgregar!=null) nodoAgregar.agregarArista(arista);
    }

   

    private  int BuscarPosicionNodoGrafo(int codigo){
        NodoGrafo retornar = null;
        int iterar=0;
        while (iterar<vertices.size() && retornar == null){
            if (vertices.get(iterar).getDato().getCodigo() == codigo){
                retornar = vertices.get(iterar);
            }else{
                iterar = iterar + 1;
            }
        }
        return iterar;
    }
    
    public void recorrerAdyacentes(int PosNodo, Distancias Di) {
    	NodoGrafo Nod = vertices.get(PosNodo);
    	for(int i = 0; i< Nod.getAdyacentes().size(); i++) {
    		Viaje Vi = Nod.getAdyacentes().get(i);
    		int  PosViaje = BuscarPosicionNodoGrafo(Vi.getCodigoDest());
    		Di.setDistancia(PosViaje, ( Di.getValor(PosNodo)+ Vi.getCosto()));
    	}
    }
    
    public void dijkstra (int codigo) {
    	Distancias Di = new Distancias(vertices.size());
    	Di.Inicializar();
    	int  PosNodo = BuscarPosicionNodoGrafo(codigo);
    	Di.setDistancia(PosNodo, 0);
    	
    	//listar los adyacentes
    	for(int j =0; j< vertices.size(); j++) {
    		//VALIDAR SI FUE VISITADO
    		if(!Di.getVisitado(j)) {
    			recorrerAdyacentes(j, Di);
    			Di.setVisitado(j);
    		}
    		
    	}
    	
    	ImprimrCaminosMasCortos(Di, codigo);
    	
    }
    
    
    private void ImprimrCaminosMasCortos(Distancias di, int codigo) {
		NodoGrafo G = buscar(codigo);
		System.out.println(" La distancia mas corta desde el puero " + G.getDato().getNombre() + " a:");
		for(int j =0; j< vertices.size(); j++) {
    		if(di.getValor(j) != 0) {
    			if(di.getValor(j) !=  999999999) {
    				System.out.println(vertices.get(j).getDato().getNombre() + " es: " + di.getValor(j));
        			
    			}
    			else {
    				System.out.println(vertices.get(j).getDato().getNombre() + " no es posible.");
    			}
    			
    		}
    	}
		
	}

	public void eliminarPuerto(int codigo) {
    	//Primero eliminamos las aristas que tienen destino el puerto
    	EliminarAristasDestino(codigo);
    	EliminarNodoGrafo(codigo);
    	
    }

   

    private void EliminarNodoGrafo(int codigo) {
    	boolean encontrado = false;
    	for(int j =0; j< vertices.size() && encontrado == false; j++) {
    		if(vertices.get(j).getDato().getCodigo() == codigo) {
    			vertices.remove(j);
    			encontrado = true;
    			
    		}
    	}
		
	}

	private void EliminarAristasDestino(int codigo) {
		//RECORRER TODOS LOS VERTICES Y BUSCAR LAS ARISTAS QUE TIENEN COMO DESTINO EL PUERTO
    	//A ELIMINAR
    	for(int j =0; j< vertices.size(); j++) {
    		
    		for(int i = 0; i<  vertices.get(j).getAdyacentes().size(); i++) {
        		Viaje Vi = vertices.get(j).getAdyacentes().get(i);
        		if(codigo == Vi.getCodigoDest()) {
        			vertices.get(j).getAdyacentes().remove(i);
        		}
        	}
    	}
		
	}

	public void imprimir(){
        int iterar=0;
        while (iterar<vertices.size()){
            NodoGrafo nodo = vertices.get(iterar);
            System.out.println(nodo.getDato());
            nodo.imprimirAristas();
            iterar =  iterar + 1;
        }
    }


}
