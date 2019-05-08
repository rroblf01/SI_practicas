package practica9;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		run();

	}

	public static void run () {
		String alf="abcdefghijklmnÒopqrstuvwxyzABCDEFGHIJKLMN—OPQRSTUVWXYZ·ÈÌÛ˙¡…Õ”⁄0123456789 ,.:!-ø?()";
  
		BigInteger nPepa=new BigInteger("62439738695706104201747"); 
		BigInteger ePepa= new BigInteger("356812573"); 
		BigInteger qPepa=new BigInteger("249879448303");
		BigInteger pPepa =new BigInteger("249879448349");

		
		BigInteger nBenito=new BigInteger("743330222539755158153");
		BigInteger eBenito=new BigInteger("80263681");
		BigInteger qBenito=new BigInteger("27264083009");
		BigInteger pBenito = new BigInteger("27264083017");

		
		BigInteger nMaria=new BigInteger("8849169404252643679");
		BigInteger eMaria=new BigInteger("196413997");
		BigInteger qMaria=new BigInteger("2974755337"); 
		BigInteger pMaria=new BigInteger("2974755367");
		
		BigInteger nJuan=new BigInteger("5244938048376303456108649");
		BigInteger eJuan=new BigInteger("114340249");
		BigInteger qJuan=new BigInteger("2290182972661");
		BigInteger pJuan=new BigInteger("2290182972709");
		
		//Juan recibe
		
		String mensaje ="j˙I,ø Qb9,a5Ljw5DdgnwwEu ·FsTlEp.ÈCkÕR.xjdj0XøÒ8th”xuZ.Sg—mAEIÕPJjÛÌJ2t:7cPAp…C2nc…”?Ò·møJ)trZ4gF˙?kZ…AXÒd6Fø0cm4hO?Jxc,q 2P,V7tÛ—ndo⁄Aad”PAGLcbWD—(1pncYPnNKw:iÈÛEMÌvfZPDPa6ÕKU3mXk”)Ef1e…y4GjLdxE";
	
		BigInteger dJuan = eJuan.modInverse(nJuan);
		
		Decodificar dec = new Decodificar();
		BigInteger C = dec.textoAEntero(mensaje,alf, alf.length());
		
		BigInteger M = C.modPow(dJuan, nJuan);
		BigInteger base = new BigInteger(""+alf.length());
		
		String frase = dec.enteroATexto(M, base,alf);
		
		int k = dec.calcularK(base, nJuan);

		String[] frases = dec.dividirTexto(mensaje, k);
		
		BigInteger c = new BigInteger("0");
		int kAux = k-1;
		
		for(int i = 0; i < frases.length;i++) {
			BigInteger Caux = dec.textoAEntero(frases[i], alf, alf.length());
			c = c.add( Caux.multiply(base.pow(kAux) )  );
			kAux--;
		}
		
		BigInteger b = c.modPow(dJuan, nJuan);
		ArrayList<String>  B = dec.obtenerEnteros(b, base);
		for(String aux: B) {
			BigInteger auxA = new BigInteger(aux);
			System.out.print(dec.enteroATexto(auxA, base, alf));
		}
		
	}
}
