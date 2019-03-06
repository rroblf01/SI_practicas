package ejercicio1;

public class Main {
	private static char citaLiteraria[];
	private static char letras[];
	private static int frecuencia[];
	private static float probabilidad[];

	public static void main(String[] args) {
		 String cita = "La noche cae, brumosa ya y morada. Vagas claridades malvas y verdes perduran"
				+ " tras la torre de la iglesia. El camino sube, lleno de sombras, de campanillas, "
				+ "de fragancia de hierba, de canciones, de cansancio y de anhelo.";
		 
		letras = new char[55];
		frecuencia = new int[55];
		probabilidad = new float[55];
		
		letras[52]=' ';
		letras[53]='ñ';
		letras[54] = 'Ñ';
		
		 
		citaLiteraria = cita.toCharArray();
		rellenarArray();	
		imprimeArray();
		ordenarMayores();
		
		System.out.println("\nOrdenados:\n");
		
		imprimeArray();
		
	}


	public static void rellenarArray() {
		int pos = 0;
		for(int i = 65; i <= 90; i++ ) {
			letras[pos] = (char)i;
			letras[pos+26] = (char)(i+32);
			
			
			for(int j = 0; j < citaLiteraria.length; j++) 			
				if(letras[pos] ==  citaLiteraria[j] )
					frecuencia[pos]++;
			
				else if(letras[pos]+32 ==  citaLiteraria[j]) 
					frecuencia[pos+26]++;
							 	
			
			pos++;	
			
		}
		
		for(int j = 0; j < citaLiteraria.length; j++) {
			if(citaLiteraria[j] == ' ') 
				frecuencia[52]+=1;
				
			else if (citaLiteraria[j]=='ñ')
				frecuencia[53]+=1;
				
			else if (citaLiteraria[j]=='Ñ')
				frecuencia[54]+=1;
				
		}
	}

	
	public static void imprimeArray() {
		for(int i = 0; i < 55; i++) {
			probabilidad[i] = frecuencia[i] / (float) citaLiteraria.length;
			System.out.print(letras[i]+ " ");
			System.out.println(frecuencia[i]+" "+ probabilidad[i]);
			
		}
	}
	
	private static void ordenarMayores() {//método burbuja
		char temporalLetra;
		int temporalFrecuencia;
		float temporalProbabilidad;
		
		for(int i = 0; i < 55; i++ ) 
			for(int j = 0; j < 54; j++) {
				if(frecuencia[j] < frecuencia[j+1]) {
					temporalLetra = letras[j];
					letras[j] = letras[j+1];
					letras[j+1] = temporalLetra;
					
					temporalFrecuencia = frecuencia[j];
					frecuencia[j] = frecuencia[j+1];
					frecuencia[j+1] = temporalFrecuencia;
					
					temporalProbabilidad = probabilidad[j];
					probabilidad[j] = probabilidad[j+1];
					probabilidad[j+1] = temporalProbabilidad;
				}
			}
			
	}
	
}
