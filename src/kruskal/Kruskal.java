package kruskal;

import grafo.GrafoPonderado;
import kruskal.ConjuntosDisjuntos;
import java.util.Scanner;

public class Kruskal {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el archivo a analizar (sin extension): ");
		String file = in.nextLine();
		String path = "LoteDePruebas/InputGenerados/";
		String outPath = "LoteDePruebas/OutputGenerados/";
		String ext = ".in";
		String outExt = ".out";
		
		GrafoPonderado g = new GrafoPonderado(path + file + ext);		
		double[][] matArcos = new double[g.getCantAristas()][3]; //[{Vértice origen, Vértice destino, Peso}]
		int contArc=0;
//		Cargo la matriz de Arcos
		for(int x=0; x<g.getTam(); x++)
		{
			for(int y=x; y<g.getTam(); y++)
			{
				
				if(g.getPesoArista(x,y) > 0)
					{
					matArcos[contArc][0]=x+1;
					matArcos[contArc][1]=y+1;
					matArcos[contArc][2]=g.getPesoArista(x,y);
					contArc++;
					}				
			}
		}
		
//		Orderno la matriz de arcos
		
		for(int x=0; x<contArc;x++)
			for(int y=0; y<contArc-1;y++)
			{	
				double[] auxArco = new double[3];
				if(matArcos[y][2]>matArcos[y+1][2]) 
				{
					auxArco[0]=matArcos[y][0];
					auxArco[1]=matArcos[y][1];
					auxArco[2]=matArcos[y][2];
					
					matArcos[y][0]=matArcos[y+1][0];
					matArcos[y][1]=matArcos[y+1][1];
					matArcos[y][2]=matArcos[y+1][2];
					
					matArcos[y+1][0]=auxArco[0];
					matArcos[y+1][1]=auxArco[1];
					matArcos[y+1][2]=auxArco[2];
				}
			}
		
// empiezo a procesar el Bosque de Conjuntos Disjuntos
		
	ConjuntosDisjuntos conjDisj = new ConjuntosDisjuntos(g.getTam());
	
	double origen,destino,peso;
	double total=0;
	int numAristas=0;
	int[] MST = new int[g.getTam()];
			
	for( int i = 0 ; i < g.getCantAristas() ; ++i ){     //Recorremos las aristas ya ordenadas por peso
	    origen = matArcos[i][0]-1;    //Vértice origen de la arista actual
	    destino = matArcos[i][1]-1;  //Vértice destino de la arista actual
	    peso = matArcos[i][2];        //Peso de la arista actual
	    //Verificamos si estan o no en la misma componente conexa
	    if( !conjDisj.sameComponent( origen , destino ) ){  //Evito ciclos
	        total += peso;              //Incremento el peso total del MST
	        MST[ numAristas++ ] = i;  //Agrego al MST la arista actual
	        
	        conjDisj.Union( (int)origen , (int)destino );  //Union de ambas componentes en una sola
	      }
	    
	}
	
	System.out.println("Peso total del camino: "+ Double.toString(total));
	System.out.println("Recorrido por aristas: ");
	for(int x=0;x<numAristas;x++)
		System.out.println(MST[x]+1);
	System.out.println("Aristas: ");
	System.out.println("Origen	Destino	Peso");
	for(int x=0;x<g.getCantAristas();x++){
		System.out.println(Double.toString(matArcos[x][0])+'\t'+Double.toString(matArcos[x][1])+'\t'+Double.toString(matArcos[x][2]));
	}

	}
}
