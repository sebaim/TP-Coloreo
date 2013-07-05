package algoritmosDeGrafos.coloreo;

import grafo.GrafoPonderado;

public class Dijkstra {

	private GrafoPonderado grafoPonderado;
	private int nodoOrigen;
	private int nodoDestino;
	private double [] distancia;
	private boolean []vistos;
	private char []camino;
	
	public Dijkstra(GrafoPonderado grafoPonderado) {
		//this.nodoOrigen = nodoOrigen;
		//this.nodoDestino = nodoDestino;
		this.grafoPonderado = grafoPonderado;
		//this.monticulo = new TDAMonticulo();
		//seteo el tamaño e inicializo distancia
		this.distancia = new double[grafoPonderado.getTam()];
		this.vistos = new boolean [grafoPonderado.getTam()];
		this.camino = new char[255];
	}
	
	public double resuelveCaminoMasCorto(int nodoOrigen, int nodoDestino)
	{
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;
		inicializaDistancia();
		inicializaVisto();
		calculaDistanciaANodos(nodoOrigen);
		
		System.out.println(distancia.toString());
		if (distancia[nodoDestino]!= Double.MAX_VALUE)
			return distancia[nodoDestino];
		return (Double) null;
	}
	
	private void calculaDistanciaANodos (int nodoOrigen)
	{
		int vertice = 0;
		while (!todosVistos())
		{
			vertice = minimoDistanciaNoVisto();
			vistos[vertice] = true;
			
			for (int i=0; i< grafoPonderado.getTam(); i++){
				if (grafoPonderado.sonAdyacentes(vertice, i)){
					double nuevoPeso =  distancia[vertice]+ grafoPonderado.getPesoArista(vertice, i);
					if (distancia[i]> nuevoPeso )
						distancia[i]= nuevoPeso;
				}
			}			
		}
	}
	
	private boolean todosVistos()
	{
		boolean todosVistos = true;
		int i=0;
		
		while (todosVistos && i<grafoPonderado.getTam())
		{
			todosVistos = vistos[i]==true;
			i++;
		}
		
		return todosVistos;
	}
	
	private int minimoDistanciaNoVisto()
	{
		double minimo = Double.MAX_VALUE;
		int vertice = 0;
		for (int i =0 ; i< grafoPonderado.getTam(); i++){
			if (distancia[i]<minimo && vistos[i] == false){
				minimo = distancia[i];
				vertice = i;				
			}
		}
		return vertice;
			
	}
	
	private void inicializaVisto()
	{
		for (int i=0; i< grafoPonderado.getTam(); i++)
		{
			vistos[i] = false;
		}
		vistos[nodoOrigen] = true;
	}
	
	private void inicializaDistancia()
	{		
		for (int w = 0; w < grafoPonderado.getTam();w++){
			if (grafoPonderado.sonAdyacentes(nodoOrigen, w))
			distancia[w] = grafoPonderado.getPesoArista(nodoOrigen, w);
			else
			distancia[w]= Double.MAX_VALUE;			
		}
		distancia [nodoOrigen] = 0;
		
	}
	
	public void resuelve()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
