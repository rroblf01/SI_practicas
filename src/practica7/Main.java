package practica7;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		PotenciacionModular potencia = new PotenciacionModular();
		BigInteger a = new BigInteger("2424242424");
		BigInteger b = new BigInteger("4444444444");
		BigInteger n = new BigInteger("201920192019");
		BigInteger respuesta1 = potencia.potenciaMod(a,b,n);
		System.out.println(respuesta1.toString());
		
		BigInteger numero = new BigInteger("123456789123456789");
		BigInteger orden = new BigInteger("81");
		ArrayList<String> resultado = potencia.obtenerEnteros(numero, orden);
                
		for(String frase: resultado) {
			System.out.print(frase+ " ");
		}
                System.out.println("");
                
                int[] lista={1,24,7,46,30,48,79,51,53};
                BigInteger[] listaBig = new BigInteger[lista.length];
                for(int i = 0; i < lista.length; i++){
                    listaBig[i] = new BigInteger(""+lista[i]);
                }
                BigInteger base = new BigInteger("81");
                
                BigInteger solucion = potencia.obtenerNumero(listaBig, base);
                System.out.println(solucion.toString());
                
                
                String frase = "24 de abril";
                String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
                int modulo = 81;
                
                BigInteger ejercicio21 = potencia.textoAEntero(frase,alf,modulo);
                System.out.println(ejercicio21.toString());
                
                BigInteger textoEnNumero = new BigInteger("1000000");
               String ejercicio22  = potencia.enteroATexto(textoEnNumero,base,alf);
               System.out.println(ejercicio22);
		
                BigInteger p= new BigInteger("428765575697899393132131414307");
                BigInteger g= new BigInteger("2");
                String A="bú32a4Í2lDíhUeÉB";
                String B="áuÁTJKWz7É I.Ñ2É";
                BigInteger b3= new BigInteger("1717171717171717");
               
               String ejercicio3 = potencia.Hellman(A,B,b3,g,p,alf);
               System.out.println("Ejercicio3: "+ejercicio3);
	}
	
	

}
