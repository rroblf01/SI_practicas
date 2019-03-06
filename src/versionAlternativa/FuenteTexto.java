package versionAlternativa;

import java.util.ArrayList;

public class FuenteTexto {
	
	private static char[] letras;
	private static int[] numVeces;//frecuencia
	private static double[] probabilidades;

	public static void main(String[] args) {
		String cita = "La noche cae, brumosa ya y morada. Vagas claridades malvas y verdes perduran"
				+ " tras la torre de la iglesia. El camino sube, lleno de sombras, de campanillas, "
				+ "de fragancia de hierba, de canciones, de cansancio y de anhelo.";
		
		rellenaLista(cita);
		cuentaNumCaracteres(cita);
		ordenaDecrecientementeFrecuencias();
		calculaProbabilidades();
		
		System.out.println("Ejercicio 1:");
		ejercicio1(cita);
		System.out.println("Ejercicio 2:");
		ejercicio2(cita);
		
//		Para ver en columnas letra - frecuencia - probabilidad
//		for(int i = 0; i<numVeces.length; i++){
//			System.out.print(letras[i] + " ");
//			System.out.print(numVeces[i]+" ");
//			System.out.println(probabilidades[i]);
//		}

	}

	private static void ejercicio1(String texto) {		
		int indiceD = getIndiceLetra('d');
		
		System.out.println("La letra " +letras[indiceD] + " tiene frecuencia: " + numVeces[indiceD] +
				" y su probabilidad es: " + probabilidades[indiceD] + "\n");

	}


	private static int getIndiceLetra(char letra) {
		for(int i = 0; i<letras.length; i++)
			if(letras[i]==letra)
				return i;
		return 0;
	}
	

	private static void rellenaLista(String poema) {//crea lista con caracteres sin repetir valores
		ArrayList<Character> listaLetras = new ArrayList<Character>();
		
		for(int i = 0; i<poema.length(); i++){
			if(!listaLetras.contains(poema.charAt(i)))
				listaLetras.add(poema.charAt(i));
		}
		
		letras = new char[listaLetras.size()];//paso arraylist a array de char
		for(int i = 0; i<listaLetras.size(); i++)
			letras[i] = listaLetras.get(i);
			
	}
	
	
	private static void cuentaNumCaracteres(String poema) {//cuenta numero veces que aparecen las letras
		numVeces = new int[letras.length];
		
		for(int i = 0; i<letras.length; i++){
			for(int j = 0; j<poema.length(); j++)
				if(letras[i] == poema.charAt(j))
					numVeces[i]++;
		}
		
	}
	
	
	private static void ordenaDecrecientementeFrecuencias(){//método burbuja, antes necesito tener numVeces relleno
		int temp;
		char letraTemp;
		
        for(int i = 0; i<numVeces.length; i++)
            for (int j = 0; j<numVeces.length-1; j++)
                if (numVeces[j] < numVeces[j+1]){	//que queden al final los más pequeños
                    temp = numVeces[j];
                    numVeces[j] = numVeces[j+1];
                    numVeces[j+1] = temp;
                    
                    letraTemp = letras[j];
                    letras[j] = letras[j+1];
                    letras[j+1] = letraTemp;                  
                }     		
	}
	

	private static void calculaProbabilidades() {
		probabilidades = new double[letras.length];
		int suma = 0;
	
		for(int i = 0; i<numVeces.length; i++)
			suma+= numVeces[i];
			
		for(int i = 0; i<numVeces.length; i++)
			probabilidades[i] = numVeces[i]/(float)suma; //Es correcto? Pq en Main dividimos entre length del texto entero	
				
	}
	

	private static void ejercicio2(String texto) {					
		for(int i = 0; i<4; i++){
			System.out.println(letras[i] + " " + numVeces[i]+" " + probabilidades[i]);
		}
	}

}
