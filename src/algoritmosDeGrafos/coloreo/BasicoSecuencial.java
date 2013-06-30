package algoritmosDeGrafos.coloreo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import grafo.Grafo;

public class BasicoSecuencial {

	private int maximoColores = 1;  //  Usado para la máxima cantidad de colores
	Grafo grafo = null;
	int[] vectorDeColoreo = null;
	
	public BasicoSecuencial(Grafo g){
		
		grafo = g;
		vectorDeColoreo = new int[g.getTam()];
	}
	
	public void colorear() {

		int zz = 1;// Marca de adyacencia
		int aux = 1;// Variable de corte
		
		// Etapa de Coloracion
		for (int i = 0; i < grafo.getTam(); i++) {
			vectorDeColoreo[i] = 1;
			zz = 0;
			aux = 1;
			
			while (aux == 1) {
				for (int j = 0; j < grafo.getTam(); j++) {
					if (grafo.sonAdyacentes(i, j)) {
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
	}

	public int getMaximoColores(){
		
		return this.maximoColores;
	}
	
	/*
	 * Funcion para pasar el resultado a un arhivo de output
	 */
	public void toFile(String fileName){
		
		FileWriter fr = null;
		PrintWriter pr = null;
		
		
		try {	
			fr = new FileWriter(fileName);
			pr = new PrintWriter(fr);
			
			// En la primera linea se imprime:
			// CANT_NODOS	CANT_COLORES	GRADO_MAX
			pr.println(grafo.getTam() + "\t" + this.maximoColores + "\t" + grafo.gradoMax());
			// Se imprimen el nodo y su color
			for(int i = 0; i < grafo.getTam(); i++){
				
				pr.println(i + "\t" + this.vectorDeColoreo[i]);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally{
			
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {

		Grafo g = new Grafo(6);

		BasicoSecuencial b = new BasicoSecuencial(g);

		b.colorear();

	}

}
