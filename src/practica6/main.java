package practica6;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		String alf="a�bcde�fghi�jklmn�o�pqrstu�vwxyzA�BCDE�FGHI�JKLMN�O�PQRSTU�VWXYZ0123456789 ,.:-()";
		char[] alfabeto = alf.toCharArray();
		String texto = "NBHQ��HBHQ��ahYBWQ(B�AhQHt�Aaya�QaAQ�tB:�tyAhQ�9hBQQwBWAhBQrdQHyWQAw�BhM�dQHt�AayAh�WQBHYDQPBWyA:dQA:QQ)��(tA:�dQaAHaAQA:Qm�Wa�QaAQHtHQ�W�AQB��HdQ:BwAW9B�BQQA:Q�thH�QaAQ:�HQB��W9A�ywyAW9�HdQBtW�tAQ:�QB�B9BhBQQ��w�QtWBQhAB:yaBaQyWAfy9B�:AQrQmB9B:D";
		char[] textoArray = texto.toCharArray();
		int a = 32;
		int b = 34;
		int inverso = calcularInverso(a,alfabeto.length);
		
		//String respuesta1 = ejercicio1(inverso, b, alfabeto, textoArray);
		//System.out.println(respuesta1+"\n\n\n");
		
		String texto_02="p5nty)s.�mfg�-r)3qvvcEhU3te-rfmiEd mdv  bm�l45m-h( gDcl(8�-p,s.�C��gh-�oeuvAA�5md(on.m��49�-�oe.zwy�0.d(  uMcB14mha3PfJwfd�m-�� sMmf1U)o(3ahvk�12 )a5";
		String clave = "10 de abril";
		//String respuesta2 = ejercicio2(clave.toCharArray(), texto_02.toCharArray(),alfabeto, true);
		//System.out.println(respuesta2);
		
		String texto_03= "C3HUu()cQtoEZs�xu:S IilauKhLgsY3�tG�Xf";
		String pre_respuesta = ejercicio2(clave.toCharArray(), texto_03.toCharArray(),alfabeto, true);
		String respuesta3 = ejercicio1(inverso, b, alfabeto, pre_respuesta.toCharArray());
		System.out.println(respuesta3);
	}
	
	public static String ejercicio1(int aInversa, int b, char[] alfabeto, char[] textoArray) {
		String respuesta = "";
		int menosAInvB = ((((-1 * aInversa) + alfabeto.length)%alfabeto.length)* b)% alfabeto.length;
		for(int i = 0; i < textoArray.length; i++) {
			for(int j = 0; j < alfabeto.length; j++) {
				if(textoArray[i] == alfabeto[j]) {
					int posicion = (j*aInversa + menosAInvB)% alfabeto.length;
					respuesta += alfabeto[posicion];
					if(respuesta.substring(respuesta.length()-1,respuesta.length()).equals(" ")  && respuesta.substring(respuesta.length()-2,respuesta.length()-1).equals(" ") ) {
						respuesta += '\n';
					}
				}
			}
		}	
		return respuesta;
	}
	
	public static String ejercicio2(char[] clave, char[] texto, char[] alfabeto, boolean descifrar) {
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
			/*if(respuesta.substring(respuesta.length()-1,respuesta.length()).equals(" ")  && respuesta.substring(respuesta.length()-2,respuesta.length()-1).equals(" ") ) {
				respuesta += '\n';
			}*/
		}
		return respuesta;
	}
	public static int calcularInverso(int a, int Z) {
		int inverso = 0;
		for(int i = 0; i < Z; i++) {
			if((a*i)%Z == 1) {
				inverso = i;
			}
		}
		return inverso;
	}

}
