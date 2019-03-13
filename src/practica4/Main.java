package practica4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Formatter;

public class Main {

	public static void main(String[] args) {
		cod1();

	}
	
	public static void cod1() {
String alf = "abcde ABCDEfghijklmnFGHIJKLMNopqrstuvwxyzOPQRSTUVWXYZ.,;¿?¡!";
		
		int minLong = (int) (Math.log10(alf.length())/Math.log10(2));
		minLong++;
		
		char[] alfabeto = alf.toCharArray();
		String[] codigo = new String[alf.length()];
		
		for(int i = 0; i < alf.length();i++) {
			codigo[i] = obtenerBinario(i);
		}
		
		String[] cadenaCodificada = pasarCadena();
		String frase = "";
		for(int i = 0; i < cadenaCodificada.length; i++) {	
			frase += cadenaCodificada[i].substring(0,4);
		}
		String[] cadenaAComprobar = new String[frase.length()/6];

		char[] cadenaAux = frase.toCharArray();
		int pos = 0;
		cadenaAComprobar[0] = "";
		for(int i = 0; i < frase.length(); i++) {
			if(i%6 == 0 && i != 0) {
				pos++;
				if(pos < frase.length()/6 )
					cadenaAComprobar[pos] = "";
			}
			if(cadenaAux[i] == '1') {
				cadenaAComprobar[pos] += "1";
			}else if(cadenaAux[i] == '0') {
				cadenaAComprobar[pos] += "0";
			}
			
		}
		
		String solucion = "";
		for(int i = 0; i < cadenaAComprobar.length; i++) {
			for(int j = 0; j < codigo.length; j++) {
				
				if(cadenaAComprobar[i].equals(codigo[j]) ) {
					solucion += alfabeto[j];
					
				}
			}
		}
		System.out.println(solucion);
		
	}
	
	public static String[] pasarCadena() {
		int[] lista= {0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,0,1,0,0,1,
				0,0,0,0,1,0,1,1,0,0,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,
				1,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,
				0,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,0,0,0,0,
				1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,
				0,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1,1,1,0,0,0,1,0,1,0,0,1,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,
				1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,
				0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,1,1,
				0,0,1,0,1,1,0,1,0,0,1,0,1,0,1,1,0,0,1,1,0,0,0,0,0,1,0,1,
				1,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,
				1,0,0,0,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,0,1,1,
				0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,1,0,1,0,0,1,1,
				0,0,0,0,1,0,1,1,0,1,0,0,1,1,0,0,1,0,0,1,1,0,1,0,0,0,1,1,
				1,0,1,0,0,1,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,
				0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,
				0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1,1,
				1,1,0,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,
				1,1,0,1,1,0,0,1};
		
		String[] retornar = new String[(lista.length/7)];
		int pos = 0;
		retornar[0] = "";
		
		for(int i = 0; i < lista.length; i++) {
			if(i%7 == 0 && i != 0) {
				retornar[pos]=retornar[pos].substring(0,4);
				pos++;
				if(pos < lista.length/6 )
					retornar[pos] = "";
			}
			if(lista[i] == 1) {
				retornar[pos] += "1";
			}else if(lista[i] == 0) {
				retornar[pos] += "0";
			}
		
			
		}
		return retornar;
	}
	
	public static String obtenerBinario(int numero){
		   ArrayList<String> binario = new ArrayList<String>();
		   int resto;
		   String binarioString = "";

		   do{
		      resto = numero%2;
		      numero = numero/2;
		      binario.add(0, Integer.toString(resto));
		   }while(numero > 2); //Haremos el bucle hasta que el cociente no se pueda dividir mas

		   binario.add(0, Integer.toString(numero)); //Cogeremos el ultimo cociente

		   //Cogemos cada uno de los elementos del ArrayList y los juntamos en un String
		   for(int i = 0; i < binario.size(); i++){
		       binarioString += binario.get(i);
		   }
			
		   return String.format("%06d", Integer.parseInt(binarioString));
	}
}
