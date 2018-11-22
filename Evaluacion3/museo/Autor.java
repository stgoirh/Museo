/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo;

import java.util.ArrayList;

/**
 *
 * @author 19479689-7
 */
public class Autor extends Persona{    
    
    ArrayList<Obra> listaObrasAutor = new ArrayList<>();
    
    public Autor(String nombre, Nacionalidad nacionalidad) {
        super(nombre, nacionalidad);
    }
    public void agregarObra(Obra obra){
        this.listaObrasAutor.add(obra);
    }
    public void quitarObra(Obra obra){
        this.listaObrasAutor.remove(obra);
    }
}
