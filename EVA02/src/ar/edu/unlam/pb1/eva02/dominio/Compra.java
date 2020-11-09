package ar.edu.unlam.pb1.eva02.dominio;

public class Compra {

	/* Atributos */
	private Artista nombreArtista;
	private Membresia tipoMembresia;
	private String nombreMembresia;
	private boolean deseaRealizarCompra;
	private boolean efectivizoCompra;
	private int importeTotal;
	private int cantidadMembresiasAdquiridas;
	private String tiposMembresiasAdquiridas;
	private String artistasAdquiridos;
	
	/* Constructor */
	public Compra(Membresia tipoMembresia, Artista nombre) {
		
		this.tipoMembresia = tipoMembresia;
		this.nombreArtista = nombre;
		
		this.deseaRealizarCompra = false;
		this.efectivizoCompra = false;
		this.importeTotal = 0;
		this.cantidadMembresiasAdquiridas = 0;
		this.tiposMembresiasAdquiridas = "";
		this.artistasAdquiridos = "";
		
	} // end Constructor
	
	
	public Compra() {
		this.artistasAdquiridos = "";
		this.cantidadMembresiasAdquiridas = 0;
		this.tiposMembresiasAdquiridas = "";
	}
	
	/* Métodos */

	
	public void realizarCompra(Membresia tipoMembresia) {
		
		switch(tipoMembresia.toString()) {
		
		case "FREE":
			this.importeTotal += tipoMembresia.getPrecioMembresia();
			break;
			
		case "GOLD":
			this.importeTotal += tipoMembresia.getPrecioMembresia();
			break;
			
		case "PLATINIUM": 
			this.importeTotal += tipoMembresia.getPrecioMembresia();
			break;
		
		} // end switch
		
		cantidadMembresiasAdquiridas++;
		artistasAdquiridos += nombreArtista + " ";
		tiposMembresiasAdquiridas += nombreMembresia + " ";
		
	} // end realizarCompra
		
	public int getCantidadMembresiasCompradas() {
		return this.cantidadMembresiasAdquiridas;
	} // end getCantidadMembresiasCompradas
	
	public String getArtistasAdquiridos() {
		return this.getArtistasAdquiridos();
	} // end getArtistasAdquiridos
	
	public String getTiposMembresiasAdquiridas() {
		return this.tiposMembresiasAdquiridas;
	} // end getTiposMembresiasAdquiridas
	
	public int getImporteTotal() {
		return this.importeTotal;
	}
	
} // end Compra class
