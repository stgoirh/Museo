package museo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Museo museoActual = new Museo(0, "Museo Regional de La Araucanía", "Av. Alemania 84", "Chile", "2747948");
		Museo museoStgo = new Museo(0, "Museo Nacional de Bellas Artes", "José Miguel de La Barra 650", "Chile", "(2) 2499 1600");
		Administrador admin = new Administrador(museoActual);
		Mantenimiento mantenimiento = new Mantenimiento(museoActual);
		mantenimiento.crearExposicion("exposicion de prueba", "hoy", "mañana", "área este");
		Nacionalidad nac1 = new Nacionalidad("chileno", "Chile");
		Autor autor1 = new Autor("autor de prueba", nac1 );
		Obra obra1 = new Obra(autor1 , "prueba", "esta es una obra de prueba","11 marzo");
		mantenimiento.agregarNuevaObra(obra1);
		DetallePrestamo detalle1 = new DetallePrestamo();
		DetalleDevolucion detalle2 =new DetalleDevolucion();
		Seguro seguro1 = new Seguro(0, "seguro de prueba", "hoy", 2000000000);
		Prestamo pres1 = new Prestamo(0, "hoy", "prestamo de prueba", "este es un prestamo de prueba", museoActual, museoStgo, seguro1, detalle1);
		Devolucion dev1 = new Devolucion(0, "hoy", "devolucion de prueba", "esta es una devolucion de prueba", museoActual, museoStgo, seguro1, detalle2);
		pres1.agregarObra(obra1);
	    int aux = 0;//indice auxiliar
	        boolean ciclo_menu = true;
	        int opcion;
	        do {
	            System.out.println("1.-menu usuario"
	                    + "\n2.-menu mantenimiento"
	                    + "\n3.-menu administrador"
	                    + "\n4.-menu prestamos"
	                    + "\n0.-salir"
	                    + "\ningrese opción");
	            opcion = validarNumero();
	            switch (opcion) {
	                case 1:
	                    //menu usuario
	                    boolean ciclo_usuario = true;
	                    do {                        
	                        System.out.println("1.-ver eventos"
	                                + "\n2.-ver detalles del museo"
	                                + "\n3.-buscar obra"
	                                + "\n0.-salir"
	                                + "\ningrese opción");
	                        opcion = validarNumero();
	                        switch(opcion){
	                            case 1:
	                                //ver eventos
	                            	museoActual.mostrarObrasEnExposicion();
	                                break;
	                            case 2:
	                                //ver museo
	                            	System.out.println(museoActual.getNombreMuseo());
	                            	System.out.println(museoActual.getDireccion());
	                            	System.out.println(museoActual.getContacto());	                            
	                                break;
	                            case 3:
	                                //buscar obra
	                            	String nomObra = sc.nextLine();
	                            	if(!museoActual.buscarObra(nomObra)) {
	                            		System.out.println("obra no encontrada");
	                            	}	                            	
	                                break;    
	                            case 0:
	                                //salir
	                                ciclo_usuario = false;
	                                break;
	                            default:
	                                System.out.println("opción no válida");
	                                break;
	                        }
	                    } while (ciclo_usuario);
	                    break;
	                case 2:
	                    boolean ciclo_mantenimiento = true;
	                    do {                        
	                        //menu mantenimiento
	                        System.out.println("1.-añadir nueva obra a museo"
	                        		+ "\n2.-añadir obra a mantenimiento"
	                                + "\n3.-quitar obra de mantenimiento"
	                                + "\n4.-actualizar descripcion de obra"
	                                + "\n5.-cambiar obra de lugar"
	                                + "\n6.-modificar obra"
	                                + "\n7.-dar obra de baja"
	                                + "\n8.-crear evento"
	                                + "\n9.-modificar personal"
	                                + "\n10.-ver cola de manteniemiento"
	                                + "\n0.-salir"
	                                + "\ningrese opción");
	                        opcion = validarNumero();
	                     
	                        switch (opcion) {
	                            case 1:
	                                //añadir obra a museo
	                            	System.out.println("ingrese nombre de autor");
	                            	String nomAutor = sc.nextLine();
	                            	System.out.println("ingrese gentilicio");
	                            	String gentilicio = sc.nextLine();	       
	                            	System.out.println("ingrese pais");
	                            	String pais = sc.nextLine();
	                            	System.out.println("ingrese nombre de obra");
	                            	String nombreObra = sc.nextLine();
	                            	System.out.println("ingrese descripción");
	                            	String descripcion = sc.nextLine();
	                            	System.out.println("ingrese fecha de ingreso");
	                            	String fechaIngreso = sc.nextLine();
	                            	Nacionalidad nacionalidad = new Nacionalidad(gentilicio, pais);
	                            	Autor autor = new Autor(nomAutor, nacionalidad);
	                            	Obra obra = new Obra(autor, nombreObra, descripcion, fechaIngreso);
	                            	mantenimiento.agregarNuevaObra(obra);
	                                break;
	                            case 2:	                            
	                            	//añadir obra a mantenimiento	  
	                            	aux = 0;
	                            	for (Obra obr : museoActual.getObrasEnExposicion()) {
	                            		System.out.println("indice: "+ aux + " nombre: " + obr.getNombreObra());
	                            		aux++;
									}
	                            	System.out.println("ingrese indice de la obra");
	                            	mantenimiento.agregarAMantenimiento(museoActual.getObrasEnExposicion().get(validarNumero()));
	                            	break;
	                            case 3:
	                                //quitar obra de mantenimiento
	                            	aux = 0;
	                            	
	                            	for (Obra obr : mantenimiento.getObrasEnMantenimiento()) {
	                            		System.out.println("indice: "+aux + ": nombre: " + obr.getNombreObra());
	                            		aux++;
									}
	                            	System.out.println("ingrese indice de la obra");
	                            	mantenimiento.quitarDeMantenimiento(mantenimiento.getObrasEnMantenimiento().get(validarNumero()));	                            	
	                                break;
	                            case 4:
	                                //actualizar descripcion de obra
	                            	aux = 0;
	                            	for (Obra obr : museoActual.getObrasEnExposicion()) {
	                            		System.out.println("indice: "+ aux + " nombre: " + obr.getNombreObra());
	                            		aux++;
									}
	                            	aux = 0;
	                            	System.out.println("ingrese indice de la obra");
	                            	aux = validarNumero();
	                            	System.out.println("ingrese nueva descripción");
	                            	String desc = sc.nextLine();
	                            	mantenimiento.actualizarDescipcionObra(mantenimiento.getObrasEnMantenimiento().get(aux), desc);	                            
	                                break;
	                            case 5:
	                            	//cambiar obra de lugar
	                            	aux = 0;
	                            	for (Obra obr : museoActual.getObrasEnExposicion()) {
	                            		System.out.println("indice: "+ aux + " nombre: " + obr.getNombreObra());
	                            		aux++;
									}
	                            	aux = 0;
	                            	System.out.println("ingrese indice de la obra");
	                            	aux = validarNumero();
	                            	System.out.println("ingrese nueva descripción");
	                            	String loc = sc.nextLine();	                                
	                            	mantenimiento.cambiarDeLocacion(mantenimiento.getObrasEnMantenimiento().get(aux), loc);
	                                break;
	                            case 6:
	                                //modificar obra
	                                break;
	                            case 7:
	                                //dar obra de baja
	                                break;
	                            case 8:
	                                //crear evento
	                                break;
	                            case 9:
	                                //modificar personal
	                                break;
	                            case 10:
	                            	//ver cola de mantenimiento	                            	
	                            	aux = 0;
	                            	System.out.println("obras en mantenimiento");
	                            	for (Obra obr : mantenimiento.getObrasEnMantenimiento()) {
	                            		System.out.println(aux + ": nombre: " + obr.getNombreObra());
	                            		aux++;
									}
	                            	break;
	                            case 0:
	                                //salir
	                                ciclo_mantenimiento = false;
	                                break;
	                            default:
	                                System.out.println("opción no válida");
	                                break;
	                        }
	                    } while (ciclo_mantenimiento);
	                    break;
	                case 3:
	                    //menu administrador
	                    //hacer login
	                    boolean ciclo_admin = true;
	                    System.out.println("ingrese usuario");
	                    String usuario = sc.nextLine();
	                    System.out.println("ingrese usuario");
	                    String contrasena = sc.nextLine();
	                    if (admin.login(usuario, contrasena)) {
	                    	do {                        
		                        System.out.println("1.-contratar funcionario"
		                                + "\n2.-despedir funcionario"
		                                + "\n3.-ver prestamos actuales"
		                                + "\n0.-salir"
		                                + "\ningrese opción");
		                        opcion = validarNumero();
		                        switch(opcion){
		                            case 1:
		                                //contratar funcionario
		                            	System.out.println("ingrese nombre");
		                            	String nombre = sc.nextLine();
		                            	System.out.println("ingrese telefono");
		                            	String telefono = sc.nextLine();
		                            	System.out.println("ingrese rut");
		                            	int rut = validarNumero();
		                            	Personal empleado = new Personal(nombre, telefono, rut, nac1);
		                            	admin.agregarEmpleado(empleado);
		                                break;
		                            case 2:
		                                //despedir funcionario
		                            	aux = 0;
		                            	System.out.println("obras en mantenimiento");
		                            	for (Personal per : museoActual.getPersonalMuseo()) {
		                            		System.out.println(aux + ": nombre: " + per.getNombre());
		                            		aux++;
										}
		                            	System.out.println("ingrese indice de empleado");
		                            	admin.despedirEmpleado(museoActual.getPersonalMuseo().get(validarNumero()));
		                            	
		                                break;
		                            case 3:
		                                //ver prestamos actuales
		                            	for (Prestamo pr : museoActual.getPrestamos()) {
		                            		System.out.println("folio: " + pr.getFolio() + ", obras prestadas a museo" + pr.getMuseoDestino().getNombreMuseo() + "comentario: " + pr.getComentario());		                            		
										}
		                                break;
		                            case 0:
		                                //salir
		                            	ciclo_admin = false;
		                                break;
		                            default:
		                                System.out.println("opción no válida");
		                                break;
		                        }
		                    } while (ciclo_admin);
	                    }else {
	                    	System.out.println("usuario o contraseña incorrectos");
	                    }
	                    
	                    break;
	                case 4:   
	                    //menu prestamos
	                    boolean ciclo_prestamos = true;
	                    do {                        
	                        System.out.println("1.-ver prestamos"
	                                + "\n2.-ver devoluciones"
	                                + "\n3.-ver prestamo y detalle"
	                                + "\n4.-ver devolución y detalle"
	                                + "\n5.-comenzar prestamo"
	                                + "\n6.-comenzar devolución"
	                                + "\n0.-salir"
	                                + "\ningrese opción");
	                        opcion = validarNumero();
	                        switch(opcion){
	                             case 1:
	                                //ver prestamos
	                            	 for (Prestamo pr : museoActual.getPrestamos()) {
		                            		System.out.println("folio: " + pr.getFolio() + ", obras prestadas a museo" + pr.getMuseoDestino().getNombreMuseo() + "comentario: " + pr.getComentario());		                            		
										}
	                                break;
	                            case 2:
	                                //ver devoluciones
	                            	for (Devolucion de : museoActual.getDevoluciones()) {
	                            		System.out.println("folio: " + de.getFolio() + "obras en museo: "+ de.museoDestino +", obras por devolver a museo" + de.getMuseoDestino().getNombreMuseo() + "comentario: " + de.getComentario());		                            		
									}
	                                break;
	                            case 3:
	                            	aux = 0;
	                                //ver prestamo detallado
	                            	 for (Prestamo pr : museoActual.getPrestamos()) {
		                            		System.out.println("indice: " + aux + ", obras prestadas a museo" + pr.getMuseoDestino().getNombreMuseo() + "comentario: " + pr.getComentario());		                            		
		                            		aux++;
										}
	                            	 System.out.println("ingrese indice de prestamo");
	                            	 int folioP = validarNumero();
	                            	 museoActual.getPrestamos().get(folioP).getDetalle().mostrarDetalle();
	                                break;
	                            case 4:
	                                //ver devolucíon detallada
	                                break;
	                            case 0:
	                                break;
	                            default:
	                                System.out.println("opcion no válida");
	                                break;
	                        }
	                    } while (ciclo_prestamos);
	                    break;
	                case 0:
	                    //salir
	                    ciclo_menu = false;
	                    break;
	                default:
	                    System.out.println("opcion no válida");
	                    break;
	            }
	        } while (ciclo_menu);
	    }
	    public static int validarNumero(){
	        int numero = 999;
	        String temp = "";
	        Scanner sc = new Scanner(System.in);
	        try{
	            temp = sc.nextLine();
	            numero = Integer.parseInt(temp);
	        }catch(NumberFormatException e){
	            
	        }
	        return numero;
	    }

		/*
		 * Scanner sc = new Scanner(System.in); Museo museo1 = new Museo(1,
		 * "museo Temuco", "direccion 123", "Chile", "123456789"); Administrador admin =
		 * new Administrador(museo1); Museo museo2 = new Museo(1, "museo Valdivia",
		 * "direccion 123", "Chile", "1234567893"); Nacionalidad chileno = new
		 * Nacionalidad("chileno", "Chile"); Mantenimiento mantenimientoMuseo = new
		 * Mantenimiento(museo1); Autor autor1 = new Autor("nombre prueba", chileno);
		 * Obra obra1 = new Obra(autor1, "obra de prueba", "esta es una obra de prueba",
		 * "11 marzo"); System.out.println("ingrese usuario"); String usuario =
		 * sc.nextLine(); System.out.println("ingrese contraseña"); String contrasena =
		 * sc.nextLine(); if (admin.login(usuario, contrasena)) {
		 * System.out.println("ingreso exitoso");
		 * mantenimientoMuseo.agregarNuevaObra(obra1);
		 * System.out.println(museo1.getObrasEnExposicion().get(0).getNombreObra());
		 * Seguro seguro1 = new Seguro(1, "este es el seguro1", "20 de noviembre",
		 * 20000000); DetallePrestamo detalleP = new DetallePrestamo();
		 * DetalleDevolucion detalleD = new DetalleDevolucion(); Prestamo prestamo1 =
		 * new Prestamo(0, "hoy", "primer prestamo", "prestamo de prueba", museo1,
		 * museo2, seguro1, detalleP); prestamo1.agregarObra(obra1);
		 * prestamo1.comenzarPrestamo();
		 * System.out.println(museo2.getObrasEnExposicion().get(0).getNombreObra());
		 * Devolucion devolucion1 = new Devolucion(1, "hoy", "primera devolucion",
		 * "devolucion de prueba", museo1, museo2, seguro1, detalleD);
		 * devolucion1.agregarObra(obra1); devolucion1.devolverObras();
		 * System.out.println(museo2.getObrasEnExposicion().isEmpty());
		 * System.out.println(museo1.getObrasEnExposicion().get(0).getNombreObra());
		 * detalleP.mostrarDetalle(); detalleD.mostrarDetalle();
		 * 
		 * } else { System.out.println("ingreso fallido"); }
		 */

	

}
