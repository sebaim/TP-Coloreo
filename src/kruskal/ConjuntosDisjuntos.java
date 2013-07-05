package kruskal;

public class ConjuntosDisjuntos {
	double[] padre;
	
	public ConjuntosDisjuntos(Integer tam)
	{
		this.padre = new double[tam];
	for( int i = 0 ; i < tam ; ++i )
        padre[ i ] = i;      //Inicialmente el padre de cada v�rtice es el mismo v�rtice	
	}
	
	//M�todo para encontrar la raiz del v�rtice actual X
	double Find( int x ){
	    if( x == padre[ x ] ){          //Si estoy en la raiz
	        return x;                   //Retorno la raiz
	    }
	    else return Find( (int) padre[ x ] ); //De otro modo busco el padre del v�rtice actual, hasta llegar a la raiz.
	}
	
	//M�todo que me determina si 2 v�rtices estan o no en la misma componente conexa
	boolean sameComponent( double x , double y ){
	    if( Find( (int) x ) == Find( (int) y ) ) return true;   //si poseen la misma ra�z
	    return false;
	}
	
	//M�todo para unir 2 componentes conexas
	void Union( int x , int y ){
	    int xRoot = (int) Find( x );    //Obtengo la raiz de la componente del v�rtice X
	    int yRoot = (int) Find( y );    //Obtengo la raiz de la componente del v�rtice Y
	    padre[ xRoot ] = yRoot;   //Mezclo ambos arboles o conjuntos, actualizando su padre de alguno de ellos como la raiz de otro
	}
	
}
