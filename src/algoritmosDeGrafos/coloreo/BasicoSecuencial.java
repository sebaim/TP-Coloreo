package algoritmosDeGrafos.coloreo;

import grafo.Grafo;

public class BasicoSecuencial {

	private int maximoColores = 1;  //  Usado para la máxima cantidad de colores
	
	public int[] colorear(Grafo g) {

		int[] vectorDeColoreo = new int[g.getTam()];

		int zz = 1;// Marca de adyacencia
		int aux = 1;// Variable de corte
		
		// Etapa de Coloracion
		for (int i = 0; i < g.getTam(); i++) {
			vectorDeColoreo[i] = 1;
			zz = 0;
			aux = 1;
			
			while (aux == 1) {
				for (int j = 0; j < g.getTam(); j++) {
					if (g.sonAdyacentes(i, j)) {
						if (vectorDeColoreo[i] == vectorDeColoreo[j]) {
							zz = 1;
						} 
					} 
				}
				
				if (zz == 1) {
					aux = 1;
					zz = 0;
					vectorDeColoreo[i]++;
				} else {
					aux = 0;
				}
				
				// Se almacena la cantidad máxima cantidad de colores
				if (vectorDeColoreo[i] > this.maximoColores) {
					this.maximoColores = vectorDeColoreo[i];
				}
			}
		}


/*		g.mostrarMatriz();
		for (int i = 0; i < g.getTam(); i++) {

			System.out.println(i + ": " + vectorDeColoreo[i]);
		}
		System.out.println(this.maximoColores);
*/

		return vectorDeColoreo;

	}

	public int getMaximoColores(){
		
		return this.maximoColores;
	}
	
	public static void main(String[] args) {

		Grafo g = new Grafo(6);
		g.setearAdyacencia(0, 1);
		g.setearAdyacencia(0, 2);
		g.setearAdyacencia(1, 3);
		g.setearAdyacencia(2, 3);
		g.setearAdyacencia(3, 4);
		g.setearAdyacencia(4, 5);

		BasicoSecuencial b = new BasicoSecuencial();

		b.colorear(g);

	}

}
