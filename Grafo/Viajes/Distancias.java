package Viajes;

public class Distancias {
	//array para guardar las distancias hacia cada nodo
	private int[] distancia; 
	
	//array para guardar los nodos visitados
	private boolean[] visitados;
	
	public Distancias(int tamanio) {
		distancia = new int[tamanio];
		visitados = new boolean[tamanio];
	}
	
	//Para inicializar dijkstra recorreos con un for los array y 
	//seteamos en 999999999 simulando el infinito y en false los booleanos
	public void Inicializar() {
		for(int i = 0; i<distancia.length; i++) {
			distancia[i] = 999999999;
			visitados[i] = false;
		}
	}
	
	//Actualizar el nodo visitado
	public void setVisitado(int posicion) {
		visitados[posicion] = true;
	}
	
	//Actualizar la distancia
	public void setDistancia(int posicion, int valor) {
		if(distancia[posicion] > valor) {
			//PARA LLEGAR A LA POSICION SETEO EL VALOR
			distancia[posicion] = valor;	
		}
	}
	
	//Función para saber si un nodo fue visitado
	public boolean getVisitado (int posicion) {
		return visitados[posicion];
	}
	
	//Retorna el valor de la posición que recibimos como argumento
	public int getValor(int posicion) {
			return distancia[posicion];
	}
	
	//Recorrido del vector distancias
	public void getDistancias() {
		for(int i = 0; i< distancia.length;i++) {
			System.out.println(distancia[i]);
		}
	}

}
