package practica7;

import java.math.BigInteger;
import java.util.ArrayList;

public class PotenciacionModular {

	public PotenciacionModular() {
	}
	
	public BigInteger potenciaMod(BigInteger a, BigInteger b, BigInteger n) {
		char[] bChar = b.toString(2).toCharArray();
		
		BigInteger Aaux = a;
		Integer aux = 1;
		BigInteger m = BigInteger.valueOf(aux.intValue());
		
		for(int i = bChar.length-1; i >= 0; i--) {
			if(bChar[i] == '1') {
				m = a.multiply(m);
				m = m.mod(n);
			}
			a = a.multiply(a);
			a = a.mod(n);
		}	
		
		return m;
	}
	
	public static ArrayList<String> obtenerEnteros(BigInteger numero, BigInteger orden){
			
		   ArrayList<String> binario = new ArrayList<String>();
		   BigInteger resto;
		   String binarioString = "";

		   do{
                    
		      resto = numero.mod(orden);
		      numero = numero.divide(orden);
		      binario.add(resto.toString());
		   }while(numero.compareTo(orden) >= 0); //Haremos el bucle hasta que el cociente no se pueda dividir mas

		   binario.add(numero.toString()); //Cogeremos el ultimo cociente

		   //Cogemos cada uno de los elementos del ArrayList y los juntamos en un String
		   for(int i = 0; i < binario.size(); i++){
		       binarioString += binario.get(i);
		   }
			
		   return binario;
	}
	

}
