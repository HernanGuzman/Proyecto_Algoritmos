package Viajes;
import java.util.ArrayList;
import java.util.Collections;
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
    public NodoGrafo buscar(int codigo){
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
    public void recorrerAdyacentes(int PosNodo, Distancias distancias, int tipoComparacion) {
    	//guardamos el nodo de la posici�n
    	NodoGrafo Nodo = puertos.get(PosNodo);
    	//recorremos los adyacentes de el nodo guardado
    	for(int i = 0; i< Nodo.getAdyacentes().size(); i++) {
    		//guardo la arista del nodo
    		Viaje viaje = Nodo.getAdyacentes().get(i);
    		//buscamos la posici�n del viaje
    		int  PosViaje = BuscarPosicionNodoGrafo(viaje.getCodigoDest());
    		if(tipoComparacion == 1) {
    			//seteamos en la posisi�n, lo que el peso que ya ten�a m�s el valor del costo
        		distancias.setDistancia(PosViaje, ( distancias.getValor(PosNodo)+ viaje.getCosto()));
    		}
    		else {
    			//seteamos en la posisi�n, lo que el peso que ya ten�a m�s el valor del dia de viaje
        		distancias.setDistancia(PosViaje, ( distancias.getValor(PosNodo)+ viaje.getDiasViaje()));
    		}
    		
    	}
    }
    
    public void BuscarCaminoMinimo (int codigoSalida,int codigoLlegada, int tipoComparacion ) {
    	Distancias distancia = new Distancias(puertos.size());
    	distancia.Inicializar();
    	int  PosNodo = BuscarPosicionNodoGrafo(codigoSalida);
    	int posLlegada = BuscarPosicionNodoGrafo(codigoLlegada);
    	distancia.setDistancia(PosNodo, 0);
    	
    	//listar los adyacentes
    	for(int j =0; j< puertos.size(); j++) {
    		//VALIDAR SI FUE VISITADO
    		if(!distancia.getVisitado(j)) {
    			recorrerAdyacentes(j, distancia, tipoComparacion);
    			distancia.setVisitado(j);
    		}
    	}
    	ImprimirCaminoMasCorto(distancia, codigoSalida, posLlegada, tipoComparacion);
    }
    
    
    //imprimimos los caminos m�s cortos
    private void ImprimirCaminoMasCorto(Distancias distancia, int codigo, int posLlegada, int tipoComparacion) {
		NodoGrafo G = buscar(codigo);
		NodoGrafo llegada = buscar(posLlegada);
		
		if(distancia.getValor(posLlegada) != 999999999) {
			//validamos para saber si llega o no a un puerto
			if(tipoComparacion == 1) {
				System.out.println("El costo m�s bajo desde el puerto " + 
						G.getDato().getNombre() + " a "+ llegada.getDato().getNombre() + " es: "
								+ distancia.getValor(posLlegada)+" pesos");
			}
			else {
				System.out.println("La distancia m�s corta desde el puerto " + 
						G.getDato().getNombre() + " a "+ llegada.getDato().getNombre() + " es: "
								+ distancia.getValor(posLlegada) + " dias");
			}
			
		}else {
    		System.out.println("No existe el viaje de " + 
					G.getDato().getNombre() + " a "+ llegada.getDato().getNombre());
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
		//primero oredenamos por c�digo 
		ordenarPorCodigo();
		//luego recorro el array ordenado
		for(int i=0; i< puertos.size();i++) {
			System.out.println( puertos.get(i).getDato().toString());
		}
	}
	
	//m�todo para buscar el puerto con el c�digo que se pasa como argumento
	public void buscarPuerto(int codigo) {
		 NodoGrafo nodoABuscar = buscar(codigo);
		 System.out.print("El puerto buscado es: " + nodoABuscar.getDato().toString() );
		
	}
	
	public void listarViajesPuerto(int codigo) {
		 NodoGrafo nodoABuscar = buscar(codigo);
		 if(nodoABuscar.getAdyacentes().size() > 0) {
			 System.out.print("Los viajes que salen desde el Puerto " + nodoABuscar.getDato().getCodigo() + " " +
		     nodoABuscar.getDato().getNombre() + " son:  \n");
			 for(int i = 0; i < nodoABuscar.getAdyacentes().size(); i++) {
				 System.out.print( "Cod. Puerto Destino: " + nodoABuscar.getAdyacentes().get(i).getCodigoDest() + "\n");
				 //BUSCO EL PUERTO PARA SABER EL NOMBRE
				 NodoGrafo nodoDestino = buscar(nodoABuscar.getAdyacentes().get(i).getCodigoDest());
				 System.out.print( "Nombre Puerto Destino: " + nodoDestino.getDato().getNombre()+ "\n");
				 System.out.print( "Costo: " + nodoABuscar.getAdyacentes().get(i).getCosto()+ "\n");
				 System.out.print( "Dias de viaje: " + nodoABuscar.getAdyacentes().get(i).getDiasViaje()+ "\n");
				 System.out.print("\n");
				 
				 
			 }
		 }else {
			 System.out.print( "No existen viajes para el puerto " + nodoABuscar.getDato().getCodigo() + " " +
				     nodoABuscar.getDato().getNombre());
		 }
		 
		
	}
	
	public void ordenarPorCodigo() {
		Collections.sort(puertos, new CompararPuertos()); 
				
	}
	
	


}
