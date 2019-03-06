package practica3;

public class Main {
	private static Nodo nodos[];
	private static Nodo copiaNodos[];
        private static double total;
        private static double entropia;
        private static double longitudMedia;
	
	

	public static void main(String[] args) {
              	double nums[] = {83.0, 69.0, 67.0, 82.0, 69.0, 84.0, 79.0, 32.0, 68.0, 69.0, 32.0, 85.0, 78.0, 79.0, 32.0, 83.0, 69.0, 67.0, 82.0, 69.0, 84.0, 79.0, 32.0, 83.0, 69.0 ,71.0, 85.0, 82.0, 79.0};
                cargarDatos(nums);
                ejecutar();
                imprimir();
                
                System.out.println("\n\n");
                
                cargarDatos(  Fcuadrado(nums) );
                ejecutar();
                imprimir();
                
                

	}
        
        public static double[] Fcuadrado(double nums[]){         
            double numsAux[] = new double[(int)Math.pow(nums.length, 2)];
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length; j++){
                    numsAux[count] = nums[i] * nums[j];
                    count++;
                }
            }
            
            return numsAux;
        }
        
        public static void cargarDatos(double nums[]){
		nodos = new Nodo[nums.length];
                total = 0;
		for(int i = 0; i < nums.length; i++) {
                    total += nums[i];
                    nodos[i] = new Nodo(nums[i]);
		}
                
                copiaNodos = nodos;
        }

	public static void ejecutar() {	
            while(nodos.length > 1){
                ordenar();
                juntar();
            }
            
            nodos[0].rellenar();

            calcularEntropia();
            calcularLongitudMedia();
	}
	public static void calcularLongitudMedia(){
            double longitud = 0;
            for(int i = 0; i < copiaNodos.length; i++){
                longitud += (double) copiaNodos[i].getCamino().length() * copiaNodos[i].getF();
            }
            longitudMedia = longitud/total;
            
        }
	public static void calcularEntropia() {
		double total = 0;
		for(int i = 0; i< copiaNodos.length; i++) {
			total += copiaNodos[i].getF();
		}
		double P[] = new double[copiaNodos.length];
		double resultado = 0;
		for(int i = 0; i< copiaNodos.length; i++) {
			P[i] = copiaNodos[i].getF() / total;
			resultado += (P[i] * (Math.log10(1/P[i])) / Math.log10(2) );
		}
		
	      entropia = resultado;
	   
	}
        
        public static void ordenar(){
        
            for(int i = 0; i < nodos.length; i ++){
                for(int j = 0; j < (nodos.length - 1); j++){
                   if(nodos[j].getF() > nodos[j+1].getF()){
                       Nodo nodoTemporal = nodos[j+1];
                       nodos[j+1] = nodos[j];
                       nodos[j] = nodoTemporal;
                   } 

                }
            }
        }
        
        public static void juntar(){
            Nodo[] nodosAuxiliares = new Nodo[nodos.length - 1];
            Nodo nodoNuevo = new Nodo(nodos[0].getF() + nodos[1].getF());
            nodoNuevo.setIzq(nodos[0]);
            nodoNuevo.setDer(nodos[1]);

            nodosAuxiliares[0] = nodoNuevo;
            for(int i = 1; i < nodosAuxiliares.length; i++ ){
                nodosAuxiliares[i] = nodos[i+1];
            }
            nodos = nodosAuxiliares;
        
        }
        
	public static void imprimir() {
            double P;
            double eficacia = entropia / longitudMedia;
            System.out.println("La entropia es: "+entropia+" La Longitud media es: "+longitudMedia+ " La eficacia es: "+eficacia);
            System.out.println("P                           f       Camino");
            for(int i = 0;i < copiaNodos.length; i++) {
                P = copiaNodos[i].getF() / total;
		System.out.println(P+"        "+copiaNodos[i].getF()+"    "+copiaNodos[i].getCamino());
            }
	}
}
