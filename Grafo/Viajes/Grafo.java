package Viajes;
import java.util.ArrayList;
import java.util.List;


public class Grafo {
	private List<NodoGrafo> puertos;
    

    public Grafo(){
        puertos = new ArrayList<>();
        
    }

    //M�todo para agregar un puerto
    public void agregarVertice (Puerto puerto) {
        puertos.add(new NodoGrafo(puerto));
    }

    // M�todo que dado un c�digo, devuelve el nodoGrafo (puerto) con ese c�digo
    private NodoGrafo buscar(int codigo){
        NodoGrafo retornar = null;
        int iterar=0;
        while (iterar<puertos.size() && retornar == null){
            if (puertos.get(iterar).getDato().getCodigo() == codigo){
                retornar = puertos.get(iterar);
            }else{
                iterar = iterar + 1;
            }
        }
        return retornar;
    }

    //M�todo para agregar una arista, se busca el puerto con el c�digo y luego se le
    //agrega el viaje
    public void agregarArista(int codigo, Viaje arista) {
        NodoGrafo nodoAgregar = buscar(codigo);
        if (nodoAgregar!=null) nodoAgregar.agregarArista(arista);
    }

   //m�todo para obtener la posici�n del array de puertos del c�digo pasado como argumento
    private  int BuscarPosicionNodoGrafo(int codigo){
        NodoGrafo retornar = null;
        int iterar=0;
        while (iterar<puertos.size() && retornar == null){
            if (puertos.get(iterar).getDato().getCodigo() == codigo){
                retornar = puertos.get(iterar);
            }else{
                iterar = iterar + 1;
            }
        }
        return iterar;
    }
    
    //M�todo para recorrer los puerto
    public void recorrerAdyacentes(int PosNodo, Distancias distancias) {
    	//guardamos el nodo de la posici�n
    	NodoGrafo Nodo = puertos.get(PosNodo);
    	//recorremos los adyacentes de el nodo guardado
    	for(int i = 0; i< Nodo.getAdyacentes().size(); i++) {
    		//guardo la arista del nodo
    		Viaje viaje = Nodo.getAdyacentes().get(i);
    		//buscamos la posici�n del viaje
    		int  PosViaje = BuscarPosicionNodoGrafo(viaje.getCodigoDest());
    		//seteamos en la posisi�n, lo que el peso que ya ten�a m�s el valor del costo
    		distancias.setDistancia(PosViaje, ( distancias.getValor(PosNodo)+ viaje.getCosto()));
    	}
    }
    
    public void dijkstra (int codigo) {
    	Distancias distancia = new Distancias(puertos.size());
    	distancia.Inicializar();
    	int  PosNodo = BuscarPosicionNodoGrafo(codigo);
    	distancia.setDistancia(PosNodo, 0);
    	
    	//listar los adyacentes
    	for(int j =0; j< puertos.size(); j++) {
    		//VALIDAR SI FUE VISITADO
    		if(!distancia.getVisitado(j)) {
    			recorrerAdyacentes(j, distancia);
    			distancia.setVisitado(j);
    		}
    	}
    	ImprimrCaminosMasCortos(distancia, codigo);
    }
    
    
    //imprimimos los caminos m�s cortos
    private void ImprimrCaminosMasCortos(Distancias distancia, int codigo) {
		NodoGrafo G = buscar(codigo);
		System.out.println(" La distancia mas corta desde el puero " + G.getDato().getNombre() + " a:");
		for(int j =0; j< puertos.size(); j++) {
    		if(distancia.getValor(j) != 0) {
    			//validamos para saber si llega o no a un puerto
    			if(distancia.getValor(j) !=  999999999) {
    				System.out.println(puertos.get(j).getDato().getNombre() + " es: " + distancia.getValor(j));
    			}
    			else {
    				System.out.println(puertos.get(j).getDato().getNombre() + " no es posible.");
    			}
    			
    		}
    	}
		
	}

	public void eliminarPuerto(int codigo) {
    	//Primero eliminamos las aristas que tienen como destino el puerto
    	EliminarAristasDestino(codigo);
    	EliminarNodoGrafo(codigo);
    	
    }

   
	
    private void EliminarNodoGrafo(int codigo) {
    	//bandera para cortar la b�squeda
    	boolean encontrado = false;
    	for(int j =0; j< puertos.size() && encontrado == false; j++) {
    		//validamos si es el c�digo que buscamos
    		if(puertos.get(j).getDato().getCodigo() == codigo) {
    			//eliminamos el puerto y cortamos la b�squeda con la bandera
    			puertos.remove(j);
    			encontrado = true;
    			
    		}
    	}
		
	}

	private void EliminarAristasDestino(int codigo) {
		//RECORRER TODOS LOS VERTICES Y BUSCAR LAS ARISTAS QUE TIENEN COMO DESTINO EL PUERTO
    	//A ELIMINAR
    	for(int j =0; j< puertos.size(); j++) {
    		//de cada puerto buscamos los adyacentes y eliminamos los encontrados
    		for(int i = 0; i<  puertos.get(j).getAdyacentes().size(); i++) {
        		Viaje Vi = puertos.get(j).getAdyacentes().get(i);
        		if(codigo == Vi.getCodigoDest()) {
        			puertos.get(j).getAdyacentes().remove(i);
        		}
        	}
    	}
		
	}

	//m�todo para imprimir el grafo
	public void imprimir(){
        int iterar=0;
        while (iterar<puertos.size()){
            NodoGrafo nodo = puertos.get(iterar);
            System.out.println(nodo.getDato());
            nodo.imprimirAristas();
            iterar =  iterar + 1;
        }
    }
	
	//m�todo para imprimr todos los puertos
	public void imprimirPuertos() {
		
		for(int i=0; i< puertos.size();i++) {
			System.out.println( puertos.get(i).getDato().toString());
		}
	}
	
	//m�todo para buscar el puerto con el c�digo que se pasa como argumento
	public void buscarPuerto(int codigo) {
		 NodoGrafo nodoABuscar = buscar(codigo);
		 System.out.print("El puerto buscado es: " + nodoABuscar.getDato().toString() );
		
	}


}
