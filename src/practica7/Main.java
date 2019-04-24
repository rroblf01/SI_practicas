package practica7;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String alf="aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		//1º 101400389190
		//2º a) [66,50,48,17,26,45,41,33,63]
		//	 b) 2404201924042019
		
		PotenciacionModular potencia = new PotenciacionModular();
		BigInteger a = new BigInteger("2424242424");
		BigInteger b = new BigInteger("4444444444");
		BigInteger n = new BigInteger("201920192019");
		BigInteger respuesta1 = potencia.potenciaMod(a,b,n);
		//System.out.println(respuesta1.toString());
		
		BigInteger numero = new BigInteger("123456789123456789");
		BigInteger orden = new BigInteger("81");
		ArrayList<String> resultado = potencia.obtenerEnteros(numero, orden);
		for(String frase: resultado) {
			System.out.println(frase);
		}
		
	}
	
	

}
