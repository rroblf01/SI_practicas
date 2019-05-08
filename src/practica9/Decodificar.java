package practica9;

import java.math.BigInteger;
import java.util.ArrayList;

public class Decodificar {

	public Decodificar() {
		
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
	public BigInteger obtenerNumero(BigInteger[] enteros, BigInteger base){
        BigInteger resultado = new BigInteger("0");
        int posicion = 0;
        for(int i = enteros.length-1; i >= 0 ; i--){
            
            resultado = resultado.add(enteros[posicion].multiply(base.pow(i)));
            posicion++;
        }
        
        return resultado;
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
	
	public int calcularK(BigInteger N, BigInteger n) {
		int k = 0;
		BigInteger Nk;
		do {
			Nk = N.pow(k);
			k++;
		}while(Nk.compareTo(n) < 0);
		k--;
		return k;
	}
	
	public String[] dividirTexto(String texto, int longitud) {
		String[] resultado = new String[longitud];
		int tam = texto.length()/longitud;
		for(int i = 0; i < resultado.length; i++) {
			resultado[i] = texto.substring((i*tam), (i*tam)+tam);

		}
		return resultado;
		
	}
	
	
	
}
