package practica2;

public class Alfabeto {
	private static char citaLiteraria[];
	private static char letras[];
	private static int frecuencia[];
	private static double probabilidad[];

	public static double[] letrasRellenar(){
		
		 String cita = "Existe una cosa muy misteriosa, pero muy cotidiana. "
		 		+ "Todo el mundo participa de ella, todo el mundo la conoce, pero muy pocos se paran a pensar en ella. "
		 		+ "Casi todos se limitan a tomarla como viene, sin hacer preguntas. Esta cosa es el tiempo.";
		 
		letras = new char[57];
		frecuencia = new int[57];
		probabilidad = new double[57];
		
		letras[52]=' ';
		letras[53]='ñ';
		letras[54] = 'Ñ';
		letras[55] = '.';
		letras[56] = ',';
		
		 
		citaLiteraria = cita.toCharArray();
		rellenarArray();	
		imprimeArray();
		ordenarMayores();
		
		
		imprimeArray();
		
		return probabilidad;
		
	}
	
	public static char[] getLetras() {
		return letras;
	}


	public static void rellenarArray() {
		int pos = 0;
		for(int i = 65; i <= 90; i++ ) {
			letras[pos] = (char)i;
			letras[pos+26] = (char)(i+32);
			
			
			for(int j = 0; j < citaLiteraria.length; j++) {
				if(letras[pos] ==  citaLiteraria[j] ) {
					
					frecuencia[pos]++;
				}
					
			
				else if(letras[pos]+32 ==  citaLiteraria[j]) 
					frecuencia[pos+26]++;
							 	
			}
			
			pos++;
		
			
		}
		
		for(int j = 0; j < citaLiteraria.length; j++) {
			
			if(citaLiteraria[j] == ' ') 
				frecuencia[52]+=1;
				
			else if (citaLiteraria[j]=='ñ')
				frecuencia[53]+=1;
				
			else if (citaLiteraria[j]=='Ñ')
				frecuencia[54]+=1;
			else if(citaLiteraria[j] == '.')
				frecuencia[55]+=1;
			else if(citaLiteraria[j] == ',')
				frecuencia[56]+=1;
		}
	}

	
	public static int imprimeArray() {
		int total = 0;
		System.out.println("\n\n");
		for(int i = 0; i < 57; i++) {
			probabilidad[i] = frecuencia[i] / (double) citaLiteraria.length;
			System.out.print(letras[i]+ " ");
			System.out.println(frecuencia[i]+" "+ probabilidad[i]);
			if(frecuencia[i] > 0)
				total++;
			
		}
		System.out.println("\n\n");
		
		return total;
	}
	
	private static void ordenarMayores() {//método burbuja
		char temporalLetra;
		int temporalFrecuencia;
		double temporalProbabilidad;
		
		for(int i = 0; i < 57; i++ ) 
			for(int j = 0; j < 56; j++) {
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
