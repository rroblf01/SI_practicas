package practica4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Formatter;

public class Main {

	public static void main(String[] args) {
		cod1();
	}
	
	public static void cod1() {
String alf = ".,;()¿?¡!-0123456789 aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ";
		int orden = 5;
		int tamMatriz = 11;
		int minLong = (int) (Math.log10(alf.length())/Math.log10(orden));
		minLong++;
		
		char[] alfabeto = alf.toCharArray();
		String[] codigo = new String[alf.length()];
		
		for(int i = 0; i < alf.length();i++) {
			codigo[i] = obtenerCodigo(i,orden,minLong+"");
			           
		}
		
		String[] cadenaCodificada = pasarCadena(tamMatriz);
		String frase = "";
		for(int i = 0; i < cadenaCodificada.length; i++) {
			
			if(cadenaCodificada[i].length() <tamMatriz) {
				frase += cadenaCodificada[i];
			}else {
				frase += cadenaCodificada[i].substring(0,orden);
				
			}
			
		}
		
		
		String[] cadenaAComprobar = new String[frase.length()/(minLong)];

		char[] cadenaAux = frase.toCharArray();
		int pos = 0;
		cadenaAComprobar[0] = "";
		for(int i = 0; i < frase.length(); i++) {
			if(i%minLong == 0 && i != 0) {
				pos++;
				if(pos < frase.length()/minLong )
					cadenaAComprobar[pos] = "";
			}
			cadenaAComprobar[pos] += cadenaAux[i];
			
		}

		String solucion = "";
		for(int i = 0; i < cadenaAComprobar.length; i++) {
			for(int j = 0; j < codigo.length; j++) {
				
				if(cadenaAComprobar[i].equals(codigo[j]) ) {
					solucion += alfabeto[j];
					if(solucion.substring(solucion.length()-1,solucion.length()).equals(" ")  && solucion.substring(solucion.length()-2,solucion.length()-1).equals(" ") ) {
						solucion += '\n';
					}
                                 
					
					
				}
			}
		}
		System.out.println(solucion);
	}
	
	public static String[] pasarCadena(int tamMatriz) {
		int[] lista= {2,0,3,0,4,4,0,4,1,4,2,0,1,2,0,1,4,3,4,2,3,4,2,4,0,4,0,0,0,1,0,1,3,1,2,0,0,4,2,3,2,2,0,1,1,1,3,3,1,4,3,1,
				1,3,3,0,4,1,2,4,1,2,4,0,2,1,0,4,0,1,0,0,0,4,0,1,0,0,1,0,1,0,2,2,1,2,1,2,4,0,1,2,1,3,2,1,2,3,4,1,1,1,0,4,2,3,2,
				1,1,1,0,1,4,3,1,4,3,1,0,3,4,1,1,1,0,0,3,3,3,2,2,2,0,4,1,0,4,4,0,4,3,0,4,0,1,1,0,1,3,2,3,2,2,3,0,1,0,4,0,0,0,1,0,
				4,0,1,4,0,1,0,1,1,0,1,2,0,1,1,2,2,1,2,1,0,0,1,1,1,1,1,0,0,3,3,3,2,2,2,1,2,4,0,4,1,2,1,2,4,0,0,1,2,1,1,0,4,4,3,4,
				0,4,1,1,2,0,3,3,1,2,2,4,1,4,0,1,1,2,1,1,2,3,1,1,1,4,0,1,2,1,2,3,1,1,4,1,1,0,0,1,1,1,0,0,2,0,4,0,1,0,0,0,4,0,1,0,
				0,1,0,1,0,2,2,1,2,1,2,4,0,0,4,4,2,3,3,2,2,3,1,2,4,1,2,0,3,4,1,3,4,2,1,4,0,0,2,2,2,3,1,0,4,1,0,4,4,3,4,4,3,2,4,1,
				4,0,1,2,3,1,2,3,4,2,4,1,3,4,0,2,2,3,4,1,3,4,0,0,4,4,2,3,3,2,2,3,1,2,4,1,2,0,3,4,1,3,4,2,0,4,0,1,2,1,2,3,2,0,2,1,
				1,4,1,4,3,0,3,3,2,1,2,0,1,4,3,4,2,3,1,2,0,1,1,1,1,4,3,3,3,3,4,4,0,1,4,1,0,4,1,4,0,1,1,0,0,0,4,0,1,0,0,0,4,0,1,0,
				0,1,2,1,2,2,1,2,0,1,0,4,0,0,0,1,0,4,0,1,0,4,1,0,1,1,0,2,1,0,1,1,2,2,1,2,1,0,0,1,1,4,0,1,0,1,1,0,1,0,1,2,0,4,0,1,
				3,3,0,2,3,4,3,4,1,0,1,1,2,1,1,2,1,3,3,3,1,1,1,4,3,3,3,1,1,0,4,1,0,0,0,0,0,4,1,0,0,0,4,0,3,2,4,2,3,2,2,1,0,1,1,1,
				4,3,3,3,4,3,1,4,3,1,1,0,4,4,2,1,4,2,0,4,0,0,1,1,1,2,1,4,4,0,1,2,1,3,2,1,2,3,4,1,4,1,0,4,0,1,0,4,1,4,4,1,1,0,1,2,
				1,2,1,1,3,2,4,0,4,0,0,0,1,0,1,3,0,4,4,1,2,1,4,0,2,2,1,4,1,2,2,0,4,4,2,2,3,0,4,0,1,3,1,4,3,1,3,4,0,1,0,1,1,3,1,3,
				0,0,1,0,3,1,3,4,1,2,1,3,4,1,4,2,4,1,2,2,1,4,4,0,2,4,0,4,1,1,3,4,1,3,3,0,4,4,0,4,0,1,4,3,4,0,4,0,2,1,0,4,1,3,2,4,
				3,2,1,2,0,1,1,2,1,4,0,0,1,4,4,1,3,3,1,2,1,4,4,1,3,0,1,1,3,4,4,0,1,3,3,4,0,4,0,2,0,1,1,4,1,2,1,1,0,4,0,1,1,0,1,2,
				1,0,2,0,0,4,1,2,1,3,2,2,0,1,3,4,0,4,2,3,2,3,4,1,0,1,1,0,1,3,2,3,2,2,3,0,1,0,4,0,0,0,1,0,4,0,0,4,4,1,2,1,4,0,2,2,
				1,4,1,2,2,1,0,4,3,3,4,1,2,4,0,4,4,4,0,0,4,0,2,1,1,1,1,0,4,4,3,3,3,3,0,1,2,4,0,2,2,3,0,1,2,4,0,1,2,1,3,2,1,2,3,4,
				1,4,1,2,0,3,3,1,2,4,2,1,0,4,0,1,1,0,1,2,1,0,0,0,1,0,1,2,1,2,1,2,2,0,4,0,0,4,3,4,3,3,4,3,4,1,0,1,1,2,1,1,2,1,3,3,
				3,0,4,4,4,0,0,4,1,1,0,4,1,0,0,0,0,0,4,1,0,2,0,4,0,1,2,1,2,3,2,0,3,1,1,0,1,1,0,1,0,0,3,1,3,3,1,2,0,3,4,2,2,4,4,0,
				4,0,1,4,3,4,0,4,0,0,1,1,3,4,4,0,1,3,3,4,1,4,0,1,2,3,1,2,3,4,2,4,0,4,0,1,4,3,4,0,4,0,2,2,1,2,4,1,2,4,0,4,4,0,4,0,
				1,1,1,0,0,1,2,1,0,0,4,1,0,0,0,4,1,0,0,4,0,1,2,1,3,2,1,2,3,4,1,0,1,1,1,4,3,3,3,4,3,3,1,2,4,1,1,0,2,4,0,3,3,3,0,4,
				1,1,0,2,1,3,3,1,0,0,1,2,4,2,3,4,4,3,4,0,4,0,1,4,3,4,0,4,0,2,1,1,1,1,1,0,0,0,0,4,0,4,0,0,4,3,4,3,3,4,3,0,1,2,4,1,
				3,2,4,1,2,3,3,1,1,1,1,2,1,1,1,1,4,1,2,2,1,1,2,1,1,0,0,1,1,1,3,0,1,1,0,1,3,0,0,2,2,0,4,0,3,3,4,3,1,1,1,3,4,1,2,1,
				4,0,2,3,0,4,0,4,3,1,2,1,4,3,2,3,3,3,1,0,1,3,2,3,2,0,0,0,4,0,1,0,0,0,4,0,1,0,1,1,2,0,1,0,4,0,3,4,4,2,0,0,4,1,2,1,
				3,2,2,0,1,3,4,0,0,3,3,3,4,0,2,0,0,4,0,0,4,4,4,0,4,4,4,0,0,0,3,2,4,2,2,2,3,2,1,3,2,3,1,3,4,3,0,4,2,0,4,0,2,3,1,3,
				4,3,1,4,3,3,0,0,0,0,0,2,2,1,2,2,3,2,3,2,4,0,4,0,0,4,2,1,1,2,0,3,4,4,3,1,2,3,2,4,3,4,1,0,2,1,2,2,2,3,3,0,0,0,2,2
				,3,3,2,2,4,1,0,4,4,3,0,2,2,0,1,0,4,0,0,0,1,0,4,0,2,0,3,1,2,3,1,2,0,3,1,2,1,4,0,1,3,2,3,4,2,1,2,4,1,1,1,4,3,3,3,
				0,2,1,2,2,1,0,1,1,0,4,4,0,1,0,4,0,1,1,0,1,2,1,0,0,0,1,0,1,2,1,2,1,2,2,0,4,0,3,0,2,2,4,2,3,2,1,0,4,1,1,2,1,1,3,2,
				1,1,1,1,2,2,2,0,0,1,1,1,1,4,0,0,1,1,0,1,1,2,0,4,2,1,3,2,2,0,4,1,0,3,0,0,1,4,1,1,0,2,0,1,1,1,3,1,1,0,1,1,0,0,3,0,
				2,1,3,3,2,1,4,3,3,0,4,0,1,0,0,1,2,1,2,2,1,2,0,4,0,0,2,1,4,1,1,2,1,1,0,3,4,0,3,3,4,0,3,2,2,0,0,2,0,4,4,2,4,4,2,0,
				1,4,0,2,2,0,2,3,1,2,1,0,3,4,0,3,3,4,0,3,2,2,4,0,2,4,2,3,0,2,3,0,0,0,4};
		String[] retornar;
		if(lista.length%11 > 0) {
			retornar = new String[(lista.length/tamMatriz)+1];
		}else {
			retornar = new String[(lista.length/tamMatriz)];
		}
		
		int pos = 0;
		retornar[0] = "";
		
		for(int i = 0; i < lista.length; i++) {
			if(i%tamMatriz == 0 && i != 0) {
				pos++;
				if(pos < lista.length/(tamMatriz-1) )
					retornar[pos] = "";
			}
			retornar[pos] += lista[i];
			
		
			
		}
		return retornar;
	}
	
	public static String obtenerCodigo(int numero, int orden, String longitud){
		   ArrayList<String> binario = new ArrayList<String>();
		   String minLong = "%0"+longitud+"d";
		   int resto;
		   String binarioString = "";

		   do{
                       
		      resto = numero%orden;
		      numero = numero/orden;
		      binario.add(0, Integer.toString(resto));
		   }while(numero >= orden); //Haremos el bucle hasta que el cociente no se pueda dividir mas

		   binario.add(0, Integer.toString(numero)); //Cogeremos el ultimo cociente

		   //Cogemos cada uno de los elementos del ArrayList y los juntamos en un String
		   for(int i = 0; i < binario.size(); i++){
		       binarioString += binario.get(i);
		   }
			
		   return String.format(minLong, Integer.parseInt(binarioString));
	}
}
