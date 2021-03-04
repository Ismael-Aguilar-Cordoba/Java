package modelo;


import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCoches {

	//Creo variables staticas para todo (La lista de coches y sus propiedades)
	public static List<CochesBean> listaCoche = new ArrayList<CochesBean>();
	public static String id = null;
	public static String matricula = null;
	public static String marca = null;
	public static String modelo = null;
	public static String color = null;
	
	//
	public static final String nombreFichero = "coches.dat";
	public static final String ExportadoTxt = "cars.txt";
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) throws IOException {
		
		
		//Creo aquí el fichero
		File file = new File(nombreFichero);
		
		
		if (file.exists()) { 
			System.out.println("El fichero coches.dat existe");
			}
		else {
			System.out.println("El fichero coches.dat todavía no ha sido creado");
		}

		int opcion;

		Scanner lector = new Scanner(System.in);
		do {   

		System.out.println("Escriba un numero del 1 al 6 según la opción que desee");
		System.out.println("1 - Añadir coche");
		System.out.println("2 - Borrar coche");
		System.out.println("3 - Consultar coche");
		System.out.println("4 - Listado de Coches");
		System.out.println("5 - Exportar coches a archivo de texto");
		System.out.println("6 - Terminar Programa");
		
		opcion = Integer.parseInt(lector.nextLine());
		
		
		switch ( opcion ) {
		
//Primera opción de añadir coche.
	      case 1:
	    	  
	    	//Recogemos los datos
	    	System.out.println("Introzca un id:");
	  		id = new String (lector.nextLine());
	  		
	  		System.out.println("Introzca una matricula:");
	  		matricula = new String (lector.nextLine());
	  		
	  		System.out.println("Introzca una marca:");
	  		marca = new String (lector.nextLine());
	  		
	  		System.out.println("Introzca un modelo:");
	  		modelo = new String (lector.nextLine());
	  		
	  		System.out.println("Introzca un color:");
	  		color = new String (lector.nextLine());
		
	  		//Construimos el coche:
	  		CochesBean coche = new CochesBean();	
	  		coche.setId(id);
			coche.setMatricula(matricula);
			coche.setMarca(marca);
			coche.setModelo(modelo);
			coche.setColor(color);
			
			listaCoche.add(coche);
			
			try (FileOutputStream fos = new FileOutputStream(file);
				 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
				oos.writeObject(listaCoche);
				System.out.println("Objeto introducido");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  	
	           break;
	           
//Segunda opción de Borrar coche:
	      case 2:
	    	  
	    	  try (FileInputStream fis = new FileInputStream(file);
	    				 ObjectInputStream ois = new ObjectInputStream(fis)) {
	    		  
	    	  System.out.println("Introduzca la Id del coche que desea Borrar:");
	    	  id = lector.nextLine();
	    	  
	    	  for(int i = 0; i < listaCoche.size(); i++) {
	    		 if(listaCoche.get(i).getId().equals(id)) {
	    			 System.out.println("Se va a borrar el siguiente coche");
	    			 System.out.println(listaCoche.remove(i));
	    		 }  
	    	  }
	    	  
	    	  }
	           break;
	             
//Buscar Coche:
	      case 3:
	    	  
	    	  try (FileInputStream fis = new FileInputStream(file);
	    				 ObjectInputStream ois = new ObjectInputStream(fis)) {
	    		  
	    	  List<CochesBean> listaCoche = (List<CochesBean>)ois.readObject();
	    	  
	    	  System.out.println("Introduzca la Id del coche que desea Consultar:");
	    	  id = lector.nextLine();
	    	  
	    	  for(int i = 0; i < listaCoche.size(); i++) {
	    		 if(listaCoche.get(i).getId().equals(id)) {
	    			 System.out.println(listaCoche.get(i));
	    		 }  
	    	  }
	    	  
	    	  } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   	  	    	  
	    	  break;
	           
//Listado de coches
	      case 4:
	    	 
	    	  try (FileInputStream fis = new FileInputStream(file);
	    				 ObjectInputStream ois = new ObjectInputStream(fis)) {
  				
						List<CochesBean> listaCoche = (List<CochesBean>)ois.readObject();
	    				
	    				System.out.println("Objeto leido");
	    				System.out.println("Imprimiendo coches:");
	    				
	    				for(CochesBean p : listaCoche){
		  					System.out.println(p);
		  				}
	    				
	    	  } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	           break;
	           
//EXPORTAR A TXT
	      case 5: 	  
	    	 
	    	  File texto = new File(ExportadoTxt);
	    	 
	    	  try (FileWriter fw = new FileWriter(texto, false); 
				PrintWriter pw = new PrintWriter(fw);){
				
	    		for (CochesBean i : listaCoche) {
	    			pw.println("Coche: [id=" + i.getId() + ", matricula=" + i.getMatricula() + ", marca=" + i.getMarca() + ", modelo=" + i.getModelo()
	    					+ ", color=" + i.getColor() + "]");
	    			
	    		}
	    		  
				System.out.println("Archivo Txt creado");
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    		

	    	  
  
	    	  
	           break;
	      case 6:
	           System.out.println("Cerrando Programa.....");
	           break;
	           
	      default:
	           System.out.println("Opción no válida, intente con un numero del 1 al 6 según las opciones anteriores" );
	           break;
	      }
		 
		
		}while (opcion != 6);  
		
		lector.close();
		System.out.println("Programa finalizado");
	}
     

	//Fin del programa.
       
	}


	
	
	
	
	
	

