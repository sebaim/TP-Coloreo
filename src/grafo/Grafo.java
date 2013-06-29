package grafo;

/** 
 * Clase que manipula un grafo implementando matriz de adyacencia.
 */
public class Grafo {

	int[][] matriz;
	int tam;

	public Grafo(Integer tam) {

		matriz = new int[tam][tam];
		this.tam = tam;
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

	public int gradoMax() {

		int retorno = 0;

		for (int i = 0; i < this.tam; i++) {

			int aux = 0;

			for (int j = 0; j < this.tam; j++) {

				if (matriz[i][j] == 1) {

					aux++;
				}

			}

			if (aux > retorno) {

				retorno = aux;
			}
		}

		return retorno;
	}

	public int gradoMin() {

		int retorno = this.tam;

		for (int i = 0; i < this.tam; i++) {

			int aux = 0;

			for (int j = 0; j < this.tam; j++) {

				if (matriz[i][j] == 1) {

					aux++;
				}

			}

			if (aux < retorno) {

				retorno = aux;
			}
		}

		return retorno;
	}

	public static void main(String[] args) {

		Grafo g = new Grafo(1);
		g.mostrarMatriz();
	}

}
