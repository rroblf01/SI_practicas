/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;
    

public class NodoHuffman {
    private NodoHuffman izq, der;
    private double value;
    private String camino;
    private char nombre;
    
    public NodoHuffman(double value){
        this.value = value;
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

    public NodoHuffman getIzq() {
        return izq;
    }

    public void setIzq(NodoHuffman izq) {
        this.izq = izq;
    }

    public NodoHuffman getDer() {
        return der;
    }

    public void setDer(NodoHuffman der) {
        this.der = der;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
