package algoritmosDeGrafos.coloreo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import grafo.Grafo;

public class Powell {

	private int maximoColores = 1;  //  Usado para la máxima cantidad de colores
	private Grafo grafo = null;
	private int[] vectorDeColoreo = null;
	private int[] orden = null;		// Usado para el orden en que quedan los nodos
	
	public Powell(Grafo g){
		
		this.grafo = g;
		vectorDeColoreo = new int[grafo.getTam()];

	}
	
	public void colorear() {

		// TODO ordenar los vectores segun el grado de mayor a menor
		// TODO this.orden = this.grafo.ordenaMayorAMenor();
		
		// TODO hacer el coloreo dependiendo de ese ordenamiento
		// TODO CTRL C + CTRL V del basico secuencial

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
		
		Grafo g = new Grafo(5);
		
		g.setearAdyacencia(0, 1);
		g.setearAdyacencia(0, 2);
		g.setearAdyacencia(1, 2);
		g.setearAdyacencia(2, 3);
		g.setearAdyacencia(3, 4);
		
		
		Powell b = new Powell(g);
		b.colorear();

	}

}
