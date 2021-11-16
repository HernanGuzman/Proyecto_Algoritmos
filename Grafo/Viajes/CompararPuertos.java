package Viajes;

import java.util.Comparator;

public class CompararPuertos implements Comparator<NodoGrafo>{

	@Override
	public int compare(NodoGrafo nodo1, NodoGrafo nodo2) {
		if (nodo1.getDato().getCodigo() < nodo2.getDato().getCodigo() ) {
			return -1;
		}else {
			return 1;
		
		}
		
	}

}
