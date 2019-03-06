package practica3;


public class Nodo {
    private Nodo izq, der;
    private double f;
    private String camino;
    private char nombre;
    
    public Nodo(double f){
        this.f = f;
        this.izq = null;
        this.der = null;
        this.camino = "";
        
    }

    public void setNombre(char nombre) {
    	this.nombre = nombre;
    }
    
    public char getNombre() {
    	return this.nombre;
    }
    
    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public double getF() {
        return f;
    }

    public void setF(double value) {
        this.f = value;
    }
    
    public void rellenar(){
        if(this.izq != null){
            this.izq.setCamino(this.getCamino()+ "0");
            this.izq.rellenar();
        }
        
        if(this.der != null){
            this.der.setCamino(this.getCamino() + "1");
            this.der.rellenar();
        }
    }

}
