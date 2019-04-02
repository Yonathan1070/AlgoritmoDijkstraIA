package com.mycompany.ejemplodijkstra;

import java.io.Serializable;

/**
 *
 * @author Yonathan
 */
public class HMNodos implements Serializable{
    private String id;

    public HMNodos(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
