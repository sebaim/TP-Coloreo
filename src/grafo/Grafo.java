package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que manipula un grafo implementando matriz de adyacencia.
 */
public class Grafo {

	int[][] matriz;
	int tam;
	
	public Grafo(Integer tam) {

		this.matriz = new int[tam][tam];
		this.tam = tam;		
	}

	/*
	 * Se crea un grafo desde un archivo de input
	 */
	public Grafo(String path) {

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = null;

		try {
			file = new File(path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// Se lee la primera linea con la info del grafo
			linea = br.readLine();
			String[] spliteado = linea.split("\t");
			this.tam = Integer.parseInt(spliteado[0]);
			this.matriz = new int[this.tam][this.tam];
		
			// Se setean las adyacencias
			int cantAristas = Integer.parseInt(spliteado[1]);
			for(int i = 0; i < cantAristas; i++){
				
				linea = br.readLine();
				String[] stringAdyacencia = linea.split("\t");
				setearAdyacencia(Integer.parseInt(stringAdyacencia[0]),Integer.parseInt(stringAdyacencia[1]));
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public int getTam() {

		return this.tam;
	}

	public boolean sonAdyacentes(int i, int j) {

		if (matriz[i][j] == 1) {

			return true;
		} else {

			return false;
		}
	}

	public void setearAdyacencia(int i, int j) {

		if (i < tam && j < tam && i >= 0 && j >= 0) {
			matriz[i][j] = 1;
			matriz[j][i] = 1;
		}
	}

	public void quitarAdyacencia(int i, int j) {

		if (i < tam && j < tam && i >= 0 && j >= 0) {
			matriz[i][j] = 0;
		}
	}

	public void mostrarMatriz() {

		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {

				System.out.print(matriz[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	private void inviertoFilas(int fila1, int fila2) {
		int[] l1;
		int[] l2;
		l1 = this.matriz[fila1];
		l2 = this.matriz[fila2];

		this.matriz[fila1] = l2;
		this.matriz[fila2] = l1;
	}
	
	public void ordenaMayorAMenorGrado()
	{
		int grado1;
		int grado2;
		boolean ordenado = false;
		
		while (!ordenado)
		{
			ordenado = true;
			for (int i = 0; i< this.tam-1 ; i++)
			{
				grado1 = gradoVertice(i);
				grado2 = gradoVertice(i+1);
								
				if (grado1 < grado2)
				{
					inviertoFilas(i, i+1);
					ordenado = false;					
				}				
			}			
		}
	}
	
	public void ordenaMenorAMayorGrado()
	{
		int grado1;
		int grado2;
		boolean ordenado = false;
		
		while (!ordenado)
		{
			ordenado = true;
			for (int i = 0; i< this.tam-1 ; i++)
			{
				grado1 = gradoVertice(i);
				grado2 = gradoVertice(i+1);
								
				if (grado1 > grado2)
				{
					inviertoFilas(i, i+1);
					ordenado = false;					
				}				
			}			
		}	
	}
	
	public int gradoVertice(int vertice)
	{
		int retorno = 0;
		for (int i = 0; i< this.tam; i ++)
			retorno+=this.matriz[vertice][i];
		
		return retorno;
	}

	public int gradoMax() {

		int retorno = 0;

		for (int i = 0; i < this.tam; i++) {

			int aux;
			
			aux = gradoVertice(i);

//			for (int j = 0; j < this.tam; j++) {
//
//				if (matriz[i][j] == 1) {
//					aux++;
//				}
//			}
			if (aux > retorno) {
				retorno = aux;
			}
		}

		return retorno;
	}

	public int gradoMin() {

		int retorno = this.tam;

		for (int i = 0; i < this.tam; i++) {

			int aux;
			
			aux = gradoVertice(i);

//			for (int j = 0; j < this.tam; j++) {
//
//				if (matriz[i][j] == 1) {
//
//					aux++;
//				}
//
//			}

			if (aux < retorno) {

				retorno = aux;
			}
		}

		return retorno;
	}

	public static void main(String[] args) {

		Grafo g = new Grafo("LoteDePruebas/InputGenerados/grafoPruebaOrden.in");
		g.mostrarMatriz();
		g.ordenaMayorAMenorGrado();
		System.out.println("Ordenado de mayor a menor:");
		g.mostrarMatriz();
		
		g.ordenaMenorAMayorGrado();
		System.out.println("Ordenado de menor a mayor:");
		g.mostrarMatriz();
	}

}
