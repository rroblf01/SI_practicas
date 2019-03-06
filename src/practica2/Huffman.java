/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

public class Huffman {
    private static NodoHuffman[] nodos;
    private static NodoHuffman[] copiaNodos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      ejercicio1();
    	
   // 	ejercicio2();
//    	
    	ejercicio3();
    }
    
    public static void ejercicio1() {
    	nodos = new NodoHuffman[10]; 
        nodos[0] = new NodoHuffman(0.3);
        nodos[1]= new NodoHuffman(0.2);
        nodos[2]= new NodoHuffman(0.1);
        nodos[3]= new NodoHuffman(0.1);
        nodos[4]= new NodoHuffman(0.05);
        nodos[5]= new NodoHuffman(0.05);
        nodos[6] = new NodoHuffman(0.05);
        nodos[7]= new NodoHuffman(0.05);
        nodos[8]= new NodoHuffman(0.05);
        nodos[9]= new NodoHuffman(0.05);

      
        copiaNodos = nodos;
            
        empezar(1);
    }
    
    public static void ejercicio2() {
    	double nums[] = {27.0, 16.0, 4.0, 56.0, 22.0, 2.0, 78.0, 45.0, 36.0, 13.0, 12.0, 7.0};
    	
    	double suma = 0.0;
    	for(double n:nums) {
    		suma+=n;
    	}
    	
    	nodos = new NodoHuffman[nums.length];
    	for(int i = 0; i<nums.length; i++) {
    		nodos[i] = new NodoHuffman(nums[i]/suma);
    	}

      
        copiaNodos = nodos;
            
        empezar(2);
    }
    
    public static void ejercicio3() {
    	double nums[] = Alfabeto.letrasRellenar();
    	int total = Alfabeto.imprimeArray();
    	char letras[] = Alfabeto.getLetras();
    			
    	
    	double suma = 0.0;
    	for(double n:nums) {
    		suma+=n;
    	}
    	
    	nodos = new NodoHuffman[total];
    	for(int i = 0; i<total; i++) {
    		nodos[i] = new NodoHuffman(nums[i]/suma);
    		nodos[i].setNombre(letras[i]);
    	}
    	copiaNodos = nodos;
    	 empezar(3);
    }
    
    
    
    public static void empezar(int modo){
        while(nodos.length > 1){
            ordenar();
            decirValores();
            System.out.println("");
            juntar();
        }
        
        decirValores();
        nodos[0].rellenar();
        decirCaminos(modo);
    }
    public static void ordenar(){
        
        for(int i = 0; i < nodos.length; i ++){
            for(int j = 0; j < (nodos.length - 1); j++){
               if(nodos[j].getValue() > nodos[j+1].getValue()){
                   NodoHuffman nodoTemporal = nodos[j+1];
                   nodos[j+1] = nodos[j];
                   nodos[j] = nodoTemporal;
               } 
                
            }
        }
    }
    
    public static void decirCaminos(int modo){
        double lC = 0;
         System.out.println("\n\nClave      cod      long");
        for(int i = 0; i < copiaNodos.length; i ++){
        	if(modo == 3) {
        		 System.out.println(copiaNodos[i].getNombre()+ "       "+copiaNodos[i].getCamino()+"       "+
                         copiaNodos[i].getCamino().length());
                 lC +=  copiaNodos[i].getValue() * (double) copiaNodos[i].getCamino().length();
        	}else {
        		 System.out.println(copiaNodos[i].getValue()+ "       "+copiaNodos[i].getCamino()+"       "+
                         copiaNodos[i].getCamino().length());
                 lC +=  copiaNodos[i].getValue() * (double) copiaNodos[i].getCamino().length();	
        	}
           
        }
        
        System.out.println("l( C ) = "+lC);
    }
   
    public static void decirValores(){
        for( int i = 0; i < nodos.length; i++){
           // System.out.print(nodos[i].getValue()+ " ");
        }
    }
    
    public static void juntar(){
        NodoHuffman[] nodosAuxiliares = new NodoHuffman[nodos.length - 1];
        NodoHuffman nodoNuevo = new NodoHuffman(nodos[0].getValue() + nodos[1].getValue());
        nodoNuevo.setIzq(nodos[0]);
        nodoNuevo.setDer(nodos[1]);
        
        nodosAuxiliares[0] = nodoNuevo;
        for(int i = 1; i < nodosAuxiliares.length; i++ ){
            nodosAuxiliares[i] = nodos[i+1];
        }
        nodos = nodosAuxiliares;
        
    }
   
}
