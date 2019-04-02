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
    private HashMap<String, HMGrafo>grafos;
    Sistema sistema = new Sistema();
    String nombre;
    char[] nodosOD;
    String respuesta;
    public void Principal(){
        grafos = new HashMap();
    }
    
    public void menu(){
        Ejemplos e = new Ejemplos();
        String opcion="";
        try{
            do{
                grafos = sistema.leerArchivo();
                System.out.println("\n\n1. Agregar Grafo.");
                System.out.println("2. Algoritmo de Dijkstra.");
                System.out.println("3. Ver Datos de los Grafos.");
                System.out.println("4. Borrar Grafo.\n");
                System.out.println("0. Salir.");
                System.out.println("Seleccione una opcion.");
                opcion = entradaDatos.readLine();
                switch(opcion){
                    case"1":
                        crearGrafo();
                        break;
                    case"2":
                        algoritmo();
                        break;
                    case"3":
                        verDatos();
                        break;
                    case"4":
                        eliminarGrafo();
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
    
    public void crearGrafo(){
        String idGrafo="";
        try{
            do{
                System.out.println("Digite un identificador para el grafo.");
                idGrafo = entradaDatos.readLine();
                if(grafos.containsKey(idGrafo)){
                    System.out.println("Grafo existente");
                }else{
                    guardarGrafo(idGrafo);
                    System.out.println("Datos Guardados Correctamente.\n");
                    break;
                }
            }while(grafos.containsKey(idGrafo));
        }catch(IOException ioe){
            System.err.println("Error: "+ioe.getMessage());
        }
    }
    
    public void guardarGrafo(String idGrafo){
        try{
            String opcion="";
            HMGrafo g = new HMGrafo(idGrafo);
            grafos.put(idGrafo, g);
            boolean agrega=false;
            do{
                System.out.println("Agregar nodo? (s/n)(S/N)");
                opcion=entradaDatos.readLine();
                switch(opcion){
                    case"s":
                    case"S":
                        agrega=true;
                        nombre="";
                        do{
                            System.out.println("Digite el caracter del nodo.");
                            nombre=entradaDatos.readLine();
                            if(nombre.length()<=0 || nombre.length()>1){
                                System.out.println("Digite un solo caracter.");
                            }else{
                                if(grafos.get(idGrafo).nodos.containsKey(nombre)){
                                    System.out.println("El nodo ya existe.");
                                }else{
                                    HMNodos nodo = new HMNodos(nombre);
                                    grafos.get(idGrafo).nodos.put(nombre, nodo);
                                    sistema.guardarArchivo(grafos);
                                    break;
                                }
                            }
                        }while(grafos.get(idGrafo).nodos.containsKey(nombre) || nombre.length()<=0 || nombre.length()>1);
                        break;
                    case"n":
                    case"N":
                        agrega=false;
                        for (HMNodos n : grafos.get(idGrafo).nodos.values()) {
                            boolean esNumero=false;
                            int cantidad=0;
                            do{
                                try{
                                    System.out.println("Digite la cantidad de enlaces para el nodo "+n.getId());
                                    cantidad = Integer.parseInt(entradaDatos.readLine());
                                    esNumero=true;
                                    if(cantidad>=grafos.get(idGrafo).nodos.size()){
                                        System.out.println("La cantidad de enlaces no puede ser mayor o igual a los nodos existentes");
                                    }else{
                                        for(int i=0;i<cantidad;i++){
                                            String adyacente="";
                                            do{
                                                System.out.println("Digite el Nodo adyacente de "+n.getId());
                                                adyacente=entradaDatos.readLine();
                                                if(adyacente.length()<=0 || adyacente.length()>1){
                                                    System.out.println("Digite un solo caracter");
                                                }else if(!grafos.get(idGrafo).nodos.containsKey(adyacente)){
                                                    System.out.println("El nodo no existe.");
                                                }else{
                                                    do{
                                                        try{
                                                            System.out.println("Digite el peso del enlace "+n.getId()+"->"+adyacente);
                                                            int peso = Integer.parseInt(entradaDatos.readLine());
                                                            esNumero=true;
                                                            Enlaces enlace = new Enlaces(n.getId(), adyacente, peso);
                                                            grafos.get(idGrafo).enlaces.put(n.getId()+adyacente, enlace);
                                                            sistema.guardarArchivo(grafos);
                                                            break;
                                                        }catch(NumberFormatException nfe){
                                                            esNumero=false;
                                                            System.out.println("Digite un numero.");
                                                        }
                                                    }while(!esNumero);
                                                }
                                            }while(adyacente.length()<=0 || adyacente.length()>1 || !grafos.get(idGrafo).nodos.containsKey(adyacente));
                                        }
                                    }
                                }catch(NumberFormatException nfe){
                                    System.out.println("Digite un numero.");
                                    esNumero=false;
                                }
                            }while(!esNumero || cantidad>=grafos.get(idGrafo).nodos.size());
                        }
                        break;
                    default:
                        agrega=true;
                        System.out.println("Opcion no válida.");
                        break;
                }
            }while(agrega);
        }catch(IOException ioe){
            System.err.println("Error: "+ioe.getMessage());
        }
    }
    
    public void algoritmo(){
        try{
            String idGrafo="";
            do{
                int c = 0;
                for (HMGrafo g : grafos.values()) {
                    c++;
                    System.out.println("Grafo "+c+": Codigo -> "+g.getId());
                }
                System.out.println("Digite el codigo del grafo al que desea aplicar el Algoritmo.");
                idGrafo = entradaDatos.readLine();
                if(grafos.containsKey(idGrafo)){
                    Ejemplos e = new Ejemplos();
                    String nodos="";
                    for (HMNodos n : grafos.get(idGrafo).nodos.values()) {
                        nodos += n.getId();
                    }
                    Grafo gDijkstra = new Grafo(nodos);
                    nodosOD = e.grafoDijkstra(grafos, idGrafo, gDijkstra);
                    respuesta = gDijkstra.encontrarRutaMinimaDijkstra(nodosOD[0], nodosOD[1]);
                    System.out.println("\nRuta más Corta: \n"+respuesta+"\n");
                }else{
                    System.out.println("El grafo no existe.");
                }
            }while(!grafos.containsKey(idGrafo));
        }catch(IOException ioe){
            System.err.println("Error: "+ioe.getMessage());
        }
    }
    
    public void verDatos(){
        int c = 0;
        for (HMGrafo g : grafos.values()) {
            c++;
            System.out.print("\n\nGrafo "+c+": Codigo -> "+g.getId());
            for (HMNodos n : g.nodos.values()) {
                System.out.println("");
                for (Enlaces e : g.enlaces.values()) {
                    if(e.getOrigen().equals(n.getId())){
                        System.out.print(e.getOrigen()+"["+e.getPeso()+";"+e.getDestino()+"],");
                    }
                }
            }
        }
    }
    
    public void eliminarGrafo(){
        int c = 0;
        for (HMGrafo g : grafos.values()) {
            c++;
            System.out.println("Grafo "+c+": Codigo -> "+g.getId());
        }
        try{
            boolean eliminado=false;
            String idGrafo="";
            do{
                eliminado=false;
                System.out.println("Digite el Codigo del Grafo");
                idGrafo = entradaDatos.readLine();
                if(grafos.isEmpty()){
                    System.out.println("No hay grafos en el sistema.");
                }else{
                    if(grafos.containsKey(idGrafo)){
                        grafos.remove(idGrafo);
                        eliminado=true;
                        sistema.guardarArchivo(grafos);
                        System.out.println("Grafo eliminado.");
                    }else{
                        System.out.println("El grafo no existe.");
                    }
                }
            }while(!eliminado);
        }catch(IOException ioe){
            System.err.println("Error: "+ioe.getMessage());
        }
    }
}
