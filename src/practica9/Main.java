package practica9;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		run();

	}

	public static void run () {
		String alf="abcdefghijklmnÒopqrstuvwxyzABCDEFGHIJKLMN—OPQRSTUVWXYZ·ÈÌÛ˙¡…Õ”⁄0123456789 ,.:!-ø?()";

		
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
	
		BigInteger nuevap  = new BigInteger("2290182972660"); 
		BigInteger nuevaq  = new BigInteger("2290182972708");
		BigInteger dJuan = eJuan.modInverse(nuevap.multiply(nuevaq));
		
		Decodificar dec = new Decodificar();
		BigInteger C = dec.textoAEntero(mensaje,alf, alf.length());
		
		BigInteger M = C.modPow(dJuan, nJuan);
		BigInteger base = new BigInteger(""+alf.length());
		
		String frase = dec.enteroATexto(M, base,alf);
		
		int k = dec.calcularK(base, nJuan);

		String[] frases = dec.dividirTexto(mensaje, k);
		
		String solucion = "";
	
		for(int i = 0; i < frases.length;i++) {
			BigInteger Caux = dec.textoAEntero(frases[i], alf, alf.length());
			BigInteger Caux2 = Caux.modPow(dJuan, nJuan);
			String fraseaux = dec.enteroATexto(Caux2, base, alf);
			if(fraseaux.length() < k-1) {
				for(int j = fraseaux.length(); j < k-1;j++) {
					fraseaux = "a"+fraseaux;
				}
			}
			solucion += fraseaux;
		}

		solucion = solucion.replace("  ", "\n");
		System.out.println(solucion);
		
		
	
		
		  
		BigInteger nPepa=new BigInteger("62439738695706104201747"); 
		BigInteger ePepa= new BigInteger("356812573"); 
		BigInteger qPepa=new BigInteger("249879448303");
		BigInteger pPepa =new BigInteger("249879448349");
				
		
		int kPepa = dec.calcularK(base, nPepa);
		kPepa--;
		String fraseACod = "ES MI CASA.";
		System.out.println(fraseACod.length()+ " "+kPepa);

		BigInteger mPepa = dec.textoAEntero(fraseACod, alf, alf.length());

		BigInteger cPepa = mPepa.modPow(ePepa, nPepa);
		ArrayList<String> auxPepa = dec.obtenerEnteros(cPepa, base);
		for(String i:auxPepa) {
			System.out.print(i+ " ");
		}
		System.out.println();
		String decPepa = dec.enteroATexto(cPepa, base, alf);
		System.out.println(decPepa);
		
		
		
	}
}
