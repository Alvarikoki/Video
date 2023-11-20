/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categorias;

/**
 *
 * @author Álvaro Álvarez R
 */
public class DTOCategoria {
    private int id;
    private String nombre;

    public DTOCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    
    
}
