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
	Grafo grafo90 = new Grafo("src/resolucionDelProblema/caso_500N_90Adyacencia.in"); // 90% de adyacencia
	Grafo grafo50 = new Grafo("src/resolucionDelProblema/caso_500N_50Adyacencia.in"); // 50% de adyacencia
	Grafo grafo75 = new Grafo("src/resolucionDelProblema/caso_500N_75Adyacencia.in"); // 75% de adyacencia

	
	
	// Se corre entre 100 y 100000 veces el algoritmo básico secuencial
	// y se busca la cantidad mas chica de colores y en que corrida salio
	// con una entrada que en este caso es el grafo de 75% de adyacencia.
	int nroCromaticoMinimo = 0;
	int nroDePasada = 0;
	int cantDePasadas = 10; //TODO cuantas?
	for ( int i = 1; i <= cantDePasadas; i++){
		
		BasicoSecuencial b = new BasicoSecuencial(grafo75); // TODO cual alg usar??
		b.colorear();
		if (b.getMaximoColores() > nroCromaticoMinimo){
			
			nroCromaticoMinimo = b.getMaximoColores();
			nroDePasada = i;
		}
	}
	System.out.println("Cantidad mínima de coloreo: " + nroCromaticoMinimo);
	System.out.println("Número de Pasada: " + nroDePasada);
	

	}
}
