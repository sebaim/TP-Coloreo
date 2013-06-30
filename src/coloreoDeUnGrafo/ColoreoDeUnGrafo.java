package coloreoDeUnGrafo;

import grafo.Grafo;

import java.util.Scanner;

import algoritmosDeGrafos.coloreo.BasicoSecuencial;

public class ColoreoDeUnGrafo {

	/**
	 * Se toma un input y se colorea generando el output
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el archivo a colorear (sin extension): ");
		String file = in.nextLine();
		String path = "LoteDePruebas/InputGenerados/";
		String outPath = "LoteDePruebas/OutputGenerados/";
		String ext = ".in";
		String outExt = ".out";
		
		Grafo g = new Grafo(path + file + ext);
		BasicoSecuencial b = new BasicoSecuencial(g);
		b.colorear();
		b.toFile(outPath + file + outExt);

	}

}
