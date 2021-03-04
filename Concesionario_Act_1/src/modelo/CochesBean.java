package modelo;

import java.io.Serializable;

public class CochesBean implements Serializable{

	private static final long serialVersionUID = 1522321201674843842L;
	
	
	//Variables privadas
	private String id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	
	//Constructor
	public CochesBean(String id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}



	public CochesBean() {
		// TODO Auto-generated constructor stub
	}



	//Gettets y Setters
	public String getId() {
		return id;
	}


	public void setId(String id2) {
		this.id = id2;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}



	//ToString
	@Override
	public String toString() {
		return "Coche: [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", color=" + color + "]";
	}
	
	
	
	
	
	
	
	

}
