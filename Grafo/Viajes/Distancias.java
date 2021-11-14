package Viajes;

public class Distancias {
	private int[] distancia;
	private boolean[] visitados;
	
	public Distancias(int tamanio) {
		distancia = new int[tamanio];
		visitados = new boolean[tamanio];
	}
	
	public void Inicializar() {
		for(int i = 0; i<distancia.length; i++) {
			distancia[i] = 999999999;
			visitados[i] = false;
		}
	}
	
	public void setVisitado(int posicion) {
		
		visitados[posicion] = true;
	}
	
	public void setDistancia(int posicion, int valor) {
		if(distancia[posicion] > valor) {
			//PARA LLEGAR A LA POSICION SETEO EL VALOR
			distancia[posicion] = valor;
			
		}
		
	}
	
	public boolean getVisitado (int posicion) {
		return visitados[posicion];
	}
	public int getValor(int posicion) {
		
			return distancia[posicion];
	}
	
	public void getDistancias() {
		for(int i = 0; i< distancia.length;i++) {
			System.out.println(distancia[i]);
		}
	}
	
	

}
