package practica8;

import java.math.BigInteger;
import java.util.ArrayList;

public class Criptografia {

	public Criptografia() {
		
	}
	
	public BigInteger calcularClave (String Btexto, String alf, BigInteger a, BigInteger p) {
		BigInteger BNumerico = textoAEntero(Btexto, alf, alf.length());
		BigInteger modulo = new BigInteger(""+alf.length());
        BigInteger clave =  BNumerico.modPow(a, p);
        return clave;
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
	
	public static String decofificar(char[] clave, char[] texto, char[] alfabeto, boolean descifrar) {
		String respuesta = "";
		int[] textoAInt = new int[texto.length];
		int[] claveAInt = new int[clave.length];
		for(int i = 0; i < clave.length; i++) {
			for(int j = 0; j < alfabeto.length; j++) {
				if(alfabeto[j] == clave[i]) {
					claveAInt[i] = j;
				}
			}
		}
		int[] claveAIntExtendida = new int[texto.length];
		
		for(int i = 0; i < claveAIntExtendida.length; i++) {
			claveAIntExtendida[i] = claveAInt[i%claveAInt.length];
		}
		
		for(int i = 0; i < texto.length; i++) {
			for(int j = 0; j < alfabeto.length; j++) {
				if(alfabeto[j] == texto[i]) {
					textoAInt[i] = j;
				}
			}
		}
		
		for(int i = 0; i < textoAInt.length; i++) {
			int posicion;
			if(descifrar) {
				if(textoAInt[i] - claveAIntExtendida[i] < 0) {
					posicion = ((textoAInt[i] - claveAIntExtendida[i])+alfabeto.length)%alfabeto.length;
				}else {
					posicion = (textoAInt[i] - claveAIntExtendida[i])%alfabeto.length;
				}
			}else {
				posicion = (textoAInt[i] + claveAIntExtendida[i])%alfabeto.length;
			}
			
			respuesta += alfabeto[posicion];
			if(respuesta.substring(respuesta.length()-1,respuesta.length()).equals(" ")  && respuesta.substring(respuesta.length()-2,respuesta.length()-1).equals(" ") ) {
				respuesta += '\n';
			}
		}
		return respuesta;
	}
}
