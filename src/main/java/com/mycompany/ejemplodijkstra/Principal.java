package com.mycompany.ejemplodijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class Principal {
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    public HashMap<String, Grafo>grafos;
    char[] nodosOD;
    String respuesta;
    public void Principal(){
        Ejemplos e = new Ejemplos();
        String opcion="";
        try{
            do{
                System.out.println("\n\n1. Grafo Taller");
                System.out.println("2. Laberinto.");
                System.out.println("3. Taller Clase.\n");
                System.out.println("0. Salir.");
                System.out.println("Seleccione una opcion.");
                opcion = entradaDatos.readLine();
                switch(opcion){
                    case"1":
                        Grafo gG = new Grafo("abcdefgh");
                        nodosOD = e.GrafoAH(gG);
                        respuesta = gG.encontrarRutaMinimaDijkstra(nodosOD[0], nodosOD[1]);
                        System.out.println("\nRuta más Corta: \n"+respuesta);
                        break;
                    case"2":
                        Grafo gL = new Grafo("abcdefghijklmnñ");
                        nodosOD = e.GrafoLaberinto(gL);
                        respuesta = gL.encontrarRutaMinimaDijkstra(nodosOD[0], nodosOD[1]);
                        System.out.println("\nRuta más Corta: \n"+respuesta);
                        break;
                    case"3":
                        Grafo gTC = new Grafo("abcdefgi");
                        nodosOD = e.GrafoTallerClase(gTC);
                        respuesta = gTC.encontrarRutaMinimaDijkstra(nodosOD[0], nodosOD[1]);
                        System.out.println("\nRuta más Corta: \n"+respuesta);
                        break;
                    case"0":
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }while(!opcion.equals("0"));
        }catch(IOException ioe){
            
        }
    }
}
