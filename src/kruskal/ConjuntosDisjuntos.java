package kruskal;

public class ConjuntosDisjuntos {
	double[] padre;
	
	public ConjuntosDisjuntos(Integer tam)
	{
		this.padre = new double[tam];
	for( int i = 0 ; i < tam ; ++i )
        padre[ i ] = i;      //Inicialmente el padre de cada vértice es el mismo vértice	
	}
	
	//Método para encontrar la raiz del vértice actual X
	double Find( int x ){
	    if( x == padre[ x ] ){          //Si estoy en la raiz
	        return x;                   //Retorno la raiz
	    }
	    else return Find( (int) padre[ x ] ); //De otro modo busco el padre del vértice actual, hasta llegar a la raiz.
	}
	
	//Método que me determina si 2 vértices estan o no en la misma componente conexa
	boolean sameComponent( double x , double y ){
	    if( Find( (int) x ) == Find( (int) y ) ) return true;   //si poseen la misma raíz
	    return false;
	}
	
	//Método para unir 2 componentes conexas
	void Union( int x , int y ){
	    int xRoot = (int) Find( x );    //Obtengo la raiz de la componente del vértice X
	    int yRoot = (int) Find( y );    //Obtengo la raiz de la componente del vértice Y
	    padre[ xRoot ] = yRoot;   //Mezclo ambos arboles o conjuntos, actualizando su padre de alguno de ellos como la raiz de otro
	}
	
}
