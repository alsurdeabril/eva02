package ar.edu.unlam.pb1.eva02.prueba;

import java.util.Scanner;

import ar.edu.unlam.pb1.eva02.dominio.Artista;
import ar.edu.unlam.pb1.eva02.dominio.Membresia;


public class PruebaMembresia {

public static void main(String[] args) {
		
		
		/* Atributos, objetos, instanciación */
		
		Scanner input = new Scanner(System.in);
		int opcionArtistas = 0;
		int opcionMembresias = 0;
		int opcionSigueComprando = 0;
		int montoCompra = 0;
		int montoCompraTotal = 0;
		String membresiaElegida = "";
		int cantidadMembresiasCompradas = 0;
		
	
		/* Artistas*/
		Artista aquiver = Artista.AQUIVER;
		Artista hiraeth = Artista.HIRAETH;
		Artista iridescent = Artista.IRIDESCENDT;
		Artista artistaElegido = null;
		
		/* Membresias */
		Membresia free = new Membresia("Free", 0, "\nAcceso a previews de álbumes, transmisiones en vivo sin posibilidad de realizar comentarios,\nsubtítulos solo disponibles para contenido que no sea en vivo.\n *Solo para uso en dispositivos móviles.*\n");
		
		Membresia gold = new Membresia("Gold", 20, "\nAcceso a todos los álbumes en formato standard, transmisiones en vivo con posibilidad de \nrealizar comentarios, subtítulos disponibles para contenido en vivo. \n*Para uso en dispositivos móviles y web.*\n");
		
		Membresia platinium = new Membresia("Platinium", 30, "\nAcceso a todos los álbumes en formato standard, transmisiones en vivo con posibilidad de \nrealizar comentarios, subtítulos disponibles para contenido en vivo.\n*Para uso en dispositivos móviles, web y SmartTv.*\n");

		
		System.out.println("Bienvenido a Attach!");
		 
		do {
		
		
		do {
			
		opcionArtistas = mostrarMenuArtistas(input, aquiver, hiraeth, iridescent);
					
			if (opcionArtistas != 1 && opcionArtistas != 2 && opcionArtistas != 3 && opcionArtistas != 0) {
				System.out.println("Ingresá una opción válida: ");
			} // end conditional mensaje de validación
			
	
			
		} while (opcionArtistas < 0 || opcionArtistas > 3);
		
		// ---------------- ACÁ SE TERMINÓ EL CICLO DO- WHILE DEL MENÚ PRINCIPAL--------------------
	
	
		
		if (opcionArtistas == 0) { // mensaje de despedida
			
			System.out.println("Esperamos que regreses pronto!");
		} // end conditional 
		
	
		
// ------- SI EL USUARIO DECIDE SEGUIR SE GUARDA LA INFORMACIÓN DEL ARTISTA QUE SELECCIONÓ---------
		
		artistaElegido = guardarArtistaSeleccionado(opcionArtistas, aquiver, hiraeth, iridescent, artistaElegido);
		
		
		
		
// -------- ACÁ EMPIEZA LA PARTE DEL MENÚ DE MEMBRESÍAS -----------
		if (opcionArtistas == 1 || opcionArtistas == 2 || opcionArtistas == 3) {
			do {
				opcionMembresias = mostrarMenuMembresias(input, artistaElegido, free, gold, platinium);
				
				if (opcionMembresias != 1 && opcionMembresias != 2 && opcionMembresias != 3 && opcionMembresias != 0) {
					System.out.println("Ingresá una opción válida: ");
				} // end conditional mensaje de validación
				
			} while (opcionMembresias < 0 || opcionMembresias > 3);
			
		
	// ---------- ACÁ SE CIERRA EL CICLO DO WHILE DE MEMBRESIAS----------------	
			
			if (opcionMembresias == 0) {
					System.out.println("Esperamos que regreses pronto!");
				} // end conditional 
		
			
			
		} // end if opción artistas es seleccionado
// ----------- SE CIERRA EL CONDICIONAL DEL ARTISTA SELECCIONADO----------
	

		// ------- SI EL USUARIO DECIDE SEGUIR SE GUARDA LA INFORMACIÓN DE LA MEMBRESIA QUE SELECCIONÓ---------
		switch (opcionMembresias) {
		
		case 1:
			montoCompra += free.getPrecioMembresia();
			membresiaElegida += free.getTipoMembresia();
			cantidadMembresiasCompradas++;
			montoCompraTotal += montoCompra;
			break;
			
		case 2:
			montoCompra += gold.getPrecioMembresia();
			membresiaElegida += gold.getTipoMembresia();
			cantidadMembresiasCompradas++;
			montoCompraTotal += montoCompra;
			break;
			
		case 3:
			montoCompra += platinium.getPrecioMembresia();
			membresiaElegida+= platinium.getTipoMembresia();
			cantidadMembresiasCompradas++;
			montoCompraTotal += montoCompra;
			break;
		
		} // end switch de la opción de membresías
		
		// --------- ACÁ SE LE NOTIFICA DE LA COMPRA -----------
		if (opcionMembresias == 1 || opcionMembresias == 2 || opcionMembresias == 3) {
			System.out.println("Tu compra fue realizada con éxito! \nCompraste: " + artistaElegido + " " + membresiaElegida + "\nTotal: USD" + montoCompra );
			// ------- SE LE PREGUNTA AL USUARIO SI QUIERE SEGUIR COMPRANDO ---------
		do {
			opcionSigueComprando = preguntarContinuaComprando(input);
			//------- Mensaje de opción inválida -------------
		if (opcionSigueComprando != 1 && opcionSigueComprando != 2) {
		System.out.println("Por favor, ingresá una opción valida: ");
	
		} else if (opcionSigueComprando == 1) {
			opcionMembresias = 0;
			montoCompra = 0;
		} // end conditional
		
		} while (opcionSigueComprando < 1 || opcionSigueComprando > 2);
			//------ Se termina el ciclo do-while del sigue comprando ------------
		} // end conditional de la notificación de la compra
		
	//---------------------SE LE INFOMA EL IMPORTE PRECIO TOTAL Y LA CANTIDAD DE LO COMPRADO-----------------
		 informarPrecioCantidadTotal(opcionSigueComprando, montoCompraTotal, cantidadMembresiasCompradas);

		} while (opcionSigueComprando == 1 && opcionArtistas != 0);
//---------------- Acá se termina el do - while del ciclo en el que el usuario decide volver a comprar---------
		
		
	} // end main

private static int preguntarContinuaComprando(Scanner input) {
	int opcionSigueComprando;
	System.out.println("Deseas agregar alguna membresía más? \n1- Si \n2- No");
opcionSigueComprando = input.nextInt();
	return opcionSigueComprando;
}

private static void informarPrecioCantidadTotal(int opcionSigueComprando, int montoCompraTotal,
		int cantidadMembresiasCompradas) {
	if (opcionSigueComprando == 2) {
	
		System.out.println("El total de tu compra es: USD" + montoCompraTotal + "\nLa cantidad de membresías que adquiriste fueron: " + cantidadMembresiasCompradas + "\nGracias por confiar en nosotros!" );
	
	 } // end conditional
}

private static int mostrarMenuMembresias(Scanner input, Artista artistaElegido, Membresia free, Membresia gold,
		Membresia platinium) {
	int opcionMembresias;
	System.out.println("Artista seleccionado: " + artistaElegido + "\n");
	
	System.out.println("1 - Membresia: " + free.toString() +  "\nPrecio: USD" + free.getPrecioMembresia() + "\nBeneficios: " + free.getDescripcion());
	
	System.out.println("2 - Membresía: " + gold.toString() + "\nPrecio: USD" + gold.getPrecioMembresia() + "\nBeneficios: " + gold.getDescripcion());
	
	System.out.println("3 - Membresía: " + platinium.toString() + "\nPrecio: USD" + platinium.getPrecioMembresia() + "\nBeneficios: " + platinium.getDescripcion());
	
	System.out.println("* Tené en cuenta que una vez que compres tu membresía solo la vas a poder utilizar \n para el artista que seleccionaste. ");
	
	System.out.println("\nA continuación, para realizar la compra seleccioná el número de la membresía: \n(Si deseas salir, ingresá 0.)");
	opcionMembresias = input.nextInt();
	return opcionMembresias;
}

private static Artista guardarArtistaSeleccionado(int opcionArtistas, Artista aquiver, Artista hiraeth,
		Artista iridescent, Artista artistaElegido) {
	switch (opcionArtistas) {
	
	case 1:
		artistaElegido = aquiver;
		break;
		
	case 2:
		artistaElegido = hiraeth;
		break;
		
	case 3:
		artistaElegido = iridescent;
		break;
	
	
	} // end switch de los artistas elegidos por el usuario
	return artistaElegido;
}

private static int mostrarMenuArtistas(Scanner input, Artista aquiver, Artista hiraeth, Artista iridescent) {
	int opcionArtistas;
	System.out.println("Ingresá la opción del artista al cual querés acceder: ");
	System.out.println("1 - " + aquiver + "\n2 - " + hiraeth + "\n3- " + iridescent + "\n0 - Ninguno, quiero salir!");
		opcionArtistas = input.nextInt();
	return opcionArtistas;
}

	
	
	
	
	
} // end PruebaMembresia
