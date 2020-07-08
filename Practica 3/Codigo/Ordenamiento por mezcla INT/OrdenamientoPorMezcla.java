/**
*
* @author sdelaot
*/
public class OrdenamientoPorMezcla {
private int [] lista;
public OrdenamientoPorMezcla( int cuantosItems ) {
lista = new int[cuantosItems];
}
public OrdenamientoPorMezcla( int [] items ) {
if( items==null ) {
items = new int[10];
}
lista = items;
}
public void llenarArreglo() {
int limiteSuperior = lista.length;
for( int n=0; n<limiteSuperior; n++ ) {
int numero = (int)(Math.random()*limiteSuperior);
if( Math.random()*10>5 ) {
numero *= -1;
}

lista[n] = numero;
}
}
public void mostrarLista( String mensaje ) {
System.out.println( " " + mensaje );
for( int n=0; n<lista.length; n++ ) {
System.out.print( " " + lista[n] );
if( n!=0 && n%20==0 ) {
System.out.println();
}
}
System.out.println();
}
public void mostrarLista( int [] unaLista ) {
for( int n=0; n<unaLista.length; n++ ) {
System.out.print( " " + unaLista[n] );
if( n!=0 && n%20==0 ) {
System.out.println();
}
}
System.out.println();
}
public int [] ordenarPorMezcla( int[] unaLista ) {
int i, j, k;
if( unaLista.length>1 ){
int nElementosIzq = unaLista.length / 2;
int nElementosDer = unaLista.length - nElementosIzq;
int [] listaIzquierda = new int[nElementosIzq];
int [] listaDerecha = new int[nElementosDer];
// Dividir
// Copiando de unaLista a listaIzquierda
llenarLista( unaLista, listaIzquierda, 0, nElementosIzq );
// Copiando unaLista a listaDerecha
llenarLista( unaLista, listaDerecha, nElementosIzq, nElementosIzq+nElementosDer
);
// Recursividad
listaIzquierda = ordenarPorMezcla(listaIzquierda);
listaDerecha = ordenarPorMezcla(listaDerecha);
// Unir
intercambiar( unaLista, listaIzquierda, listaDerecha );
}
// Muestra como se va haciendo el proceso de ordenamiento
this.mostrarLista(unaLista);
return unaLista;
}
private void llenarLista( int[] arreglo, int[] arreglo2, int inicio, int fin ) {


int contador = 0;
for( int i=inicio; i<fin; i++ ){
arreglo2[contador] = arreglo[i];
contador++;
}
}
private void intercambiar( int[] unaLista, int[] listaIzquierda, int[] listaDerecha ) {
int i = 0;
int j = 0;
int k = 0;
while(listaIzquierda.length!=j && listaDerecha.length!=k ) {
if( listaIzquierda[j]<listaDerecha[k] ) {
unaLista[i] = listaIzquierda[j];
i++;
j++;
}
else {
unaLista[i] = listaDerecha[k];
i++;
k++;
}
}
// lista final = unir listas
while( listaIzquierda.length!=j ) {
unaLista[i] = listaIzquierda[j];
i++;
j++;
}
while( listaDerecha.length!=k ) {
unaLista[i] = listaDerecha[k];
i++;
k++;
}
}
public int[] getLista() {
return lista;
}
public void setLista(int[] lista) {
this.lista = lista;
}
}
