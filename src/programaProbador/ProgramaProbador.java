package programaProbador;

import grafo.Grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProgramaProbador {

	public static void main(String[] args) {

		// Definicion de constantes
		final String INPUT_PATH = "LoteDePruebas/InputGenerados/";
		final String OUTPUT_PATH = "LoteDePruebas/OutputGenerados/";
		final String IN_EXTENSION = ".in";
		final String OUT_EXTENSION = ".out";

		// DECLARACION DE VARIABLES:
		Scanner console = new Scanner(System.in);
		String name = null;
		String fileName = null;
		File fentrada = null;
		File fsalida = null;
		FileReader frentrada = null;
		FileReader frsalida = null;
		BufferedReader brentrada = null;
		BufferedReader brsalida = null;

		// Peticion del archivo a probar
		System.out
				.println("Ingrese el nombre del archivo a probar (sin la extension):");
		name = console.nextLine();

		// Se abren los dos archivos (de entrada y de salida)
		try {

			fentrada = new File(INPUT_PATH + name + IN_EXTENSION);
			frentrada = new FileReader(fentrada);
			brentrada = new BufferedReader(frentrada);

			fsalida = new File(OUTPUT_PATH + name + OUT_EXTENSION);
			frsalida = new FileReader(fsalida);
			brsalida = new BufferedReader(frsalida);

			// Se carga en mem el grafo de entrada
			Grafo grafo = new Grafo(INPUT_PATH + name + IN_EXTENSION);

			// Se carga en mem un un vector con el nro de nodo y su color
			int[] vectorColoreo = new int[grafo.getTam()];
			// Primera linea con info:
			// CANT_NODOS CANT_COLORES GRADO_MAX
			String primeraLinea = brsalida.readLine();
			String[] primeraLineaSpliteada = primeraLinea.split("\t");

			String linea = brsalida.readLine();
			while(linea != null){

				// Se lee una linea con el formato:
				// NODO_i Color
				
				String[] lineaParseada = linea.split("\t");

				int nodo = Integer.parseInt(lineaParseada[0]);
				int color = Integer.parseInt(lineaParseada[1]);

				// Se pregunta si ya estan coloreados
				if (vectorColoreo[nodo] != 0) {

					System.out.println("Nodo " + nodo + " ya coloreado.");
				} else {

					vectorColoreo[nodo] = color;
				}
				
				linea = brsalida.readLine();
			}

			// Se pregunta si todos los nodos estan pintados
			for (int i = 0; i < grafo.getTam(); i++) {

				if (vectorColoreo[i] == 0) {

					System.out.println("No se coloreo el nodo: " + i);
				}
			}

			// Se verifica que no haya nodos adyacentes con el mismo color
			for (int i = 0; i < grafo.getTam(); i++) {
				for (int j = i + 1; j < grafo.getTam(); j++) {

					if (grafo.sonAdyacentes(i, j)) {

						if (vectorColoreo[i] == vectorColoreo[j]) {

							System.out.println("Los nodos " + i + " y " + j
									+ " tienen el mismo color.");
						}

					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Fin del proceso.");
				if (null != frsalida)
					frsalida.close();
				if (null != frentrada)
					frentrada.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
