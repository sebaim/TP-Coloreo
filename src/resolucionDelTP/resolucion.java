package resolucionDelTP;

import algoritmosDeGrafos.coloreo.BasicoSecuencial;
import grafo.Grafo;

/**
 * Resolucion del problema del TP
 * 
 */
public class resolucion {

	public static void main(String[] args) {

	// se cargan en memoria los grafos desde el archivo input.
	Grafo grafo90 = new Grafo("src/resolucionDelTP/caso_500N_90Adyacencia.in"); // 90% de adyacencia
	Grafo grafo50 = new Grafo("src/resolucionDelTP/caso_500N_50Adyacencia.in"); // 50% de adyacencia
	Grafo grafo75 = new Grafo("src/resolucionDelTP/caso_500N_75Adyacencia.in"); // 75% de adyacencia

	System.out.println(grafo90.gradoMax());
	System.out.println(grafo90.gradoMin());
	
	// Se corre entre 100 y 100000 veces el algoritmo b�sico secuencial
	// y se busca la cantidad mas chica de colores y en que corrida salio
	// con una entrada que en este caso es el grafo de 75% de adyacencia.
	int nroCromaticoMinimo = grafo50.getTam();
	int nroDePasada = 0;
	int cantDePasadas = 100; //TODO cuantas?
	for ( int i = 1; i <= cantDePasadas; i++){
		
		grafo50.ordenaAleatorio();
				
		BasicoSecuencial b = new BasicoSecuencial(grafo50); // TODO cual alg usar??
		b.colorear();
			
		if (b.getMaximoColores() < nroCromaticoMinimo){			
			nroCromaticoMinimo = b.getMaximoColores();
			nroDePasada = i;
		}
	}
	System.out.println("Cantidad m�nima de coloreo: " + nroCromaticoMinimo);
	System.out.println("N�mero de Pasada: " + nroDePasada);
	

	}
}
