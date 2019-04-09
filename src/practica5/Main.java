package practica5;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
                    String alf = "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ .,;:()¿?¡!-0123456789aábcdeéfghiíjklmnñoópqrstuúvwxyz";
                    char[] alfabeto = alf.toCharArray();
                    String[] codigoCreado = crearAlfabeto(alf);  
                    int[] B = {1,0,1,0,1,0,1,1,1,
                               1,0,1,0,1,1,0,0,1,
                               1,0,1,1,0,1,1,0,0,
                               0,1,0,1,0,0,1,1,0,
                               0,0,1,1,1,0,0,1,1,
                               1,1,1,1,0,0,0,0,0};
                    int[][] A = conseguirA(B);
                    int[][] H = conseguirH(A);
                    int[][] G = conseguirG(A);
                    
                    String[] m = pasarCadena(15);

                    String[] cola = new String[1];
                    cola[0] = "";
                    int[][] mArray = stringToArrayInt(m,cola);
                    int[][] mArrayT = transpuesta(mArray);
                    int[][] HCorrecta = transpuesta(H);
                    int[][] s = multiply(HCorrecta, mArrayT);   
                    
                    int[][] e = encontrarE(HCorrecta,s);
                    int[][] c = conseguirC(mArrayT,e);
                    String[] mensaje = conseguirMensaje(c,cola[0]);
                    
                    String solucion = "";
                    for(int i = 0; i < mensaje.length; i++) {
			for(int j = 0; j < codigoCreado.length; j++) {
				
				if(mensaje[i].equals(codigoCreado[j]) ) {
					solucion += alfabeto[j];
					if(solucion.substring(solucion.length()-1,solucion.length()).equals(" ")  && solucion.substring(solucion.length()-2,solucion.length()-1).equals(" ") ) {
						solucion += '\n';
					}
                                 
					
					
				}
			}
		}
		System.out.println(solucion);
                    
        }
        
        public static String[] conseguirMensaje(int[][] c, String cola){
            String solucion = "";
            
            for(int i = 0; i < c[0].length; i++){
                for(int j = 0; j < 6; j++){
                    solucion += ""+c[j][i];
                }
            }
            solucion += cola;
        
            char[] codigo = solucion.toCharArray();
            String[] mensaje = new String[codigo.length/7];
            mensaje[0] = "";
            int pos = 0;
            for(int i = 0; i < codigo.length; i++){
                if(i % 7 == 0 && i > 0){
                    pos++;
                    mensaje[pos] = "";
                }
                mensaje[pos] += codigo[i];
            }
            
            return mensaje;
        }
        public static int[][] conseguirC(int[][] m, int[][] e){
            int[][] solucion = new int[m.length][m[0].length];
            for(int i = 0; i < m[0].length; i++){
                for(int j = 0; j < m.length; j++){
                    solucion[j][i] = (m[j][i] + e[j][i])%2;
  
                }
            }
            return solucion;
        }
        public static int[][] encontrarE(int[][] H, int[][] s){
            int[] hamming = new int[s[0].length];
            int[][] solucion = new int[H[0].length][s[0].length];
            
            for(int i = 0; i <s[0].length; i++){
                
                boolean encontrado = false;
                
                for(int w = 0; w < H[0].length; w++){
                    if(!encontrado){
                        boolean correcto = true;
                        for(int j = 0; j <H.length; j++){
                            if(H[j][w] != s[j][i]){
                                correcto = false;
                            }
                        }
                        if(correcto && !encontrado){
                            encontrado = true;
                            for(int j = 0; j < solucion.length; j++){
                                if(j == w){
                                    solucion[j][i] = 1;
                                }else{
                                    solucion[j][i] = 0;
                                }
                            }
                        }
                    }   
                }
                
                if(!encontrado){
                    for(int j = 0; j < H[0].length; j++){
                        
                        for(int w = 0; w < H[0].length; w++){
                            boolean correcto = true;
                            int contadorDistanciaHamming = 0;
                            for(int wAux=0; wAux < H.length; wAux++){
                                int aux = (H[wAux][j] + H[wAux][w])%2;
                                if(H[wAux][j] != H[wAux][w]){
                                    contadorDistanciaHamming++;
                                }
                                if(!( aux == s[wAux][i])){
                                    correcto = false;                                
                                }
                                
                                
                            }
                            
                            if(correcto && !encontrado){
                                hamming[i] = contadorDistanciaHamming++;
                                
                                encontrado = true;
                                    for(int p = 0; p < solucion.length; p++){
                                        if(p == w || p == j){
                                            solucion[p][i] = 1;
                                        }else{
                                            solucion[p][i] = 0;
                                        }
                                    }
                                    
                                }
                            
                            
                        }
                    }
                }else{
                    System.out.println("No encontrada en "+i);
                }               
            } 
            int aux = 0;
            for(int i = 0; i < hamming.length; i++){
                aux += hamming[i];
            }
            aux = aux / hamming.length;
            System.out.println(aux);
            return solucion;
        }
        
        public static boolean iguales(int[] a, int[] b){
            boolean respuesta = true;
            
            for(int i = 0; i < a.length; i++){
                if(a[i] != b[i]){
                    respuesta = false;
                }
            }
            
            return respuesta;
        }
        public static int[][] transpuesta(int[][] a){
            int[][] aT = new int[a[0].length][a.length];
            for (int x=0; x < a.length; x++) {
                for (int y=0; y < a[x].length; y++) {
                    aT[y][x] = a[x][y];
                }
            }
            
            return aT;
        }
        
        public static int[][] stringToArrayInt(String[] m, String[] cola){
            int[][] retornar;
            if( m[m.length-1].length() != m[0].length()){
                retornar = new int[m.length-1][m[0].length()];
            }else{
                retornar = new int[m.length][m[0].length()];
            }
            
            for(int i = 0; i < m.length; i++){
                if(m[i].length() == m[0].length()){
                    char[] aux = m[i].toCharArray();
                    for(int j = 0; j < m[i].length(); j++){
                        retornar[i][j] = Character.getNumericValue(aux[j]);
                    }
                }else{
                    cola[0] = m[i];
                }
            }
            
            return retornar;
        }
        
        public static int[][] conseguirA(int[] B){
            int[][] A = new int[9][6];
                int aux = 0;
		int pos = 0;
                    for(int i = 0; i < B.length; i++) {
			if(i % 9 == 0 && i != 0) {
				aux++;
				pos = 0;
			}
			A[pos][aux] = B[i];
			pos++;
			
		}
            return A;
        } 
        
        public static String[] crearAlfabeto(String alf){
		int orden = 2;
		int minLong = (int) (Math.log10(alf.length())/Math.log10(orden));
		minLong++;
		
		String[] codigo = new String[alf.length()];
		
		for(int i = 0; i < alf.length();i++) {
			codigo[i] = obtenerCodigo(i,orden,minLong+"");
		}
                
                return codigo;
        }
        
        public static String obtenerCodigo(int numero, int orden, String longitud){
		   ArrayList<String> binario = new ArrayList<String>();
		   String minLong = "%0"+longitud+"d";
		   int resto;
		   String binarioString = "";

		   do{
                       
		      resto = numero%orden;
		      numero = numero/orden;
		      binario.add(0, Integer.toString(resto));
		   }while(numero >= orden); //Haremos el bucle hasta que el cociente no se pueda dividir mas

		   binario.add(0, Integer.toString(numero)); //Cogeremos el ultimo cociente

		   //Cogemos cada uno de los elementos del ArrayList y los juntamos en un String
		   for(int i = 0; i < binario.size(); i++){
		       binarioString += binario.get(i);
		   }
			
		   return String.format(minLong, Integer.parseInt(binarioString));
	}
        
        public static int[][] conseguirH(int[][] A){
            int[][] AT = new int[A[0].length][A.length];
		for (int x=0; x < AT.length; x++) {
			for (int y=0; y < AT[x].length; y++) {
			   AT[x][y] = ((A[y][x] * (-1)) + 2) % 2;
			 }
		}
                int[][] H = new int[AT.length + AT[0].length][AT[0].length];
            for (int x=0; x < AT.length; x++) {
			for (int y=0; y < AT[x].length; y++) {
			   H[x][y] = AT[x][y];
			}
		}
		
		
		for (int y=0; y < H[0].length; y++) {
			for (int x=AT.length; x < H.length; x++) {
				int aux = y + AT.length;
				
				if(x == aux) {
					
					H[x][y] = 1;
				}else {
					
					H[x][y] = 0;
				}
			}
		}
		
		return H;
        }
        public static int[][] conseguirG(int[][] A) {
		int[][] G = new int[A.length+A[0].length][A[0].length];
		
                for (int y=0; y < G[0].length; y++) {
			for (int x=0; x < G[0].length; x++) {
				if(x == y) {	
					G[x][y] = 1;
				}else {				
					G[x][y] = 0;
				}
			}
		}
                int posicion = 0;
                for(int y=0; y < G[0].length; y++){
                    for(int x=G[0].length; x < G.length; x++ ){
                        G[x][y] = A[posicion][y];
                        posicion++;
                    }
                    posicion = 0;
                }
                
		return G;
		
		
	}

        public static int[][] multiply(int[][] a, int[][] b) {
	    int[][] c = new int[a.length][b[0].length];
	    // se comprueba si las matrices se pueden multiplica
	    if (a[0].length == b.length) {
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    // aqu� se multiplica la matriz
	                    c[i][j] = ((a[i][k] * b[k][j])+c[i][j])%2;
	                }
	            }
	        }
	        
	        return c;
	    }else {
	    	return a;
	    }

	    
	}
        
        public static String[] pasarCadena(int tamMatriz) {
		int[] lista= {1,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,0
				,1,0,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,0,0,1,0,1,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,1,
				0,1,0,1,0,1,1,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1,0,0
				,1,1,1,1,1,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,
				0,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0
				,0,1,1,0,1,1,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,
				1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,0,1,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,0,0,1,1,0,
				1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,
				0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,1,1,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,
				0,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,
				1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,0,1,0,0,1,1,1,1,0,0,1,0,1,0,0,1,
				0,0,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,1
				,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1
				,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,1,
				0,0,1,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0
				,1,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,0,
				0,0,1,1,0,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,0,1,1,
				1,0,1,0,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,
				1,1,1,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,0,
				1,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,
				0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,1,1,
				1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,
				1,1,0,1,0,0,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,
				0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,
				0,0,1,0,1,0,0,1,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,0,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,1,1,0,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,
				0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,1,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,
				1,1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,0,
				0,1,1,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,0,0,
				0,1,0,0,1,0,0,1,1,0,1,1,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,0,1,0,
				0,0,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,
				0,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0,
				0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,0,0,0,
				0,0,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,1,0,0,0,
				0,1,1,1,1,0,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,1,0,1,1,1,1,1,
				0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,1,1,0,1,1,1,0,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,
				0,0,1,0,0,1,0,0,1,0,0,0,1,1,1,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,
				1,0,0,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1
				,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0
				,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,0
				,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1
				,1,0,1,0,1,0,1,1,0,1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,0,0,1
				,0,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0,1
				,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0
				,0,1,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0
				,1,0,1,1,1,1,1,0,0,0,0,0,1,0,1,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,1,1
				,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,0,0,0,0,1,1,1,0
				,1,0,0,0,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0
				,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,0
				,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,0,1,0,0,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0
				,0,1,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,0
				,0,0,0,0,1,1,1,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,0,1,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1
				,1,1,0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1,0,0,0
				,0,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,0,1,0,1,0};
                String[] retornar;
		if(lista.length%tamMatriz > 0) {
			retornar = new String[(lista.length/tamMatriz)+1];
		}else {
			retornar = new String[(lista.length/tamMatriz)];
		}
		
		int pos = 0;
		retornar[0] = "";
		
		for(int i = 0; i < lista.length; i++) {
			if(i%tamMatriz == 0 && i != 0) {
				pos++;
				if(pos < lista.length/(tamMatriz-1) )
					retornar[pos] = "";
			}
			retornar[pos] += lista[i];
			
		
			
		}
		return retornar;
	}
}
