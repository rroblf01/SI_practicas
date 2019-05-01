package practica7;

import java.math.BigInteger;
import java.util.ArrayList;

public class PotenciacionModular {

	public PotenciacionModular() {
	}
	
	public BigInteger potenciaMod(BigInteger a, BigInteger b, BigInteger n) {
		char[] bChar = b.toString(2).toCharArray();

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

		   do{       
		      resto = numero.mod(orden);
		      numero = numero.divide(orden);
		      binario.add(resto.toString());
		   }while(numero.compareTo(orden) >= 0); //Haremos el bucle hasta que el cociente no se pueda dividir mas

		   binario.add(numero.toString()); //Cogeremos el ultimo cociente
			
		   return binario;
	}
        
       public BigInteger obtenerNumero(BigInteger[] enteros, BigInteger base){
           BigInteger resultado = new BigInteger("0");
           int posicion = 0;
           for(int i = enteros.length-1; i >= 0 ; i--){
               
               resultado = resultado.add(enteros[posicion].multiply(base.pow(i)));
               posicion++;
           }
           
           return resultado;
       }
	

       public BigInteger textoAEntero(String frase, String alf, int modulo){
         char[] fraseChar = frase.toCharArray();
           char[] alfChar = alf.toCharArray();
           int[] listaNumeros = new int[fraseChar.length];
           for(int i = 0; i < fraseChar.length; i++){
               for(int j = 0; j < alfChar.length; j++){
                   if(fraseChar[i] == alfChar[j]){
                       listaNumeros[i] = j;
                       break;
                   }
               }
           }

           BigInteger[] listaBig = new BigInteger[listaNumeros.length];
                for(int i = 0; i < listaNumeros.length; i++){
                    listaBig[i] = new BigInteger(""+listaNumeros[i]);
                }
            BigInteger base = new BigInteger(""+modulo);
           
           return obtenerNumero(listaBig,base);
       }
       
       public String enteroATexto(BigInteger entero, BigInteger base, String alf){
           String frase = "";
           char[] alfChar = alf.toCharArray();
           ArrayList<String> posiciones = obtenerEnteros(entero, base);
           for(String posicionLetras: posiciones){
               frase += alfChar[Integer.parseInt(posicionLetras)];
           }
           frase =  new StringBuffer(frase).reverse().toString();
           return frase;
       }
       
       public String Hellman(String A, String B,BigInteger b, BigInteger g,BigInteger p,  String alf){
           
           BigInteger ANumerico = textoAEntero(A,alf,alf.length());
           BigInteger modulo = new BigInteger(""+alf.length());
           BigInteger clave =  ANumerico.modPow(b, p);

           String frase = enteroATexto(clave, modulo,alf);
           return frase;
       }
}
