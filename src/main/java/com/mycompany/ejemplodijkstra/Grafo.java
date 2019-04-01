package com.mycompany.ejemplodijkstra;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Yonathan
 */
public class Grafo{
    char[]  nodos;  // Letras de identificación de nodo
    int[][] grafo;  // Matriz de distancias entre nodos
    String  rutaMasCorta;                           // distancia más corta
    int     longitudMasCorta = Integer.MAX_VALUE;   // ruta más corta
    List<Nodo>  listNodos=null;                        // nodos revisados Dijkstra
 
    // construye el grafo con la serie de identificadores de nodo en una cadena
    Grafo(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
 
    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2]=distancia;
        grafo[n2][n1]=distancia;
    }
 
    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
     
    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimaDijkstra(char inicio, char fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMinimaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if(!listNodos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return "Adios";
        }
        tmp = listNodos.get(listNodos.indexOf(tmp));
        int distancia = tmp.distancia;  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack();
        int iteraciones=0;
        while(tmp != null) {
            iteraciones++;
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return "\tAcumulado: "+distancia + "\n\tRuta: " + ruta+"\n\tIteraciones: "+(iteraciones-1);
    }
 
    // encuentra la ruta más corta desde el nodo inicial a todos los demás
    public void encontrarRutaMinimaDijkstra(char inicio) {
        Queue<Nodo>   cola = new PriorityQueue(); // cola de prioridad
        Nodo            ni = new Nodo(inicio);          // nodo inicial
         
        listNodos = new LinkedList();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty()) {        // mientras que la cola no esta vacia
            Nodo tmp = cola.poll();     // saca el primer elemento
            System.out.println("Pasé por: "+ tmp.id);
            listNodos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j<grafo[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if(grafo[p][j]==0) continue;        // si no hay conexión no lo evalua
                if(estaTerminado(j)) continue;      // si ya fue agregado a la lista de terminados
                Nodo nod = new Nodo(nodos[j],tmp.distancia+grafo[p][j],tmp);
                // si no está en la cola de prioridad, lo agrega
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for(Nodo x: cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }
 
    // verifica si un nodo ya está en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodos[j]);
        return listNodos.contains(tmp);
    }
}
