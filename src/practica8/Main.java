package practica8;

import java.math.BigInteger;

import practica7.PotenciacionModular;

public class Main {

	public static void main(String[] args) {
		run();

	}
	
	public static void run () {
		String alf="a�bcde�fghi�jklmn�o�pqrstu�vwxyzA�BCDE�FGHI�JKLMN�O�PQRSTU�VWXYZ0123456789 ,.:-()";
		BigInteger base = new BigInteger(""+alf.length());
		BigInteger p = new BigInteger("131414242343537725243372873");
		BigInteger g = new BigInteger("10");
		String A= "�yr5IR6�pDSA�Y";
		String B= "eXPKeS�t���DN,";
		BigInteger a = new BigInteger("63332323232451757353");
		String msj_cifrado=")bJ.WpfA)DJfHqs�1s:-Fw�dslk�x�Jnse�aD���paD�TF:-l7��nnI:�NTny5A9�9�Esqo� H�0D8�r�ouooMJs�5r�E),fzdB��nf5fb���xp7�ETn�gK8�c�ft�H�5o:UjB�DSYP69b�UUmg79hhFui� TK�1y�zy.fd5bnNf.�):";
			
		Criptografia cript = new Criptografia();
		BigInteger clave = cript.calcularClave(B, alf, a, p);
		
		String claveTexto = cript.enteroATexto(clave,base,alf);
		
		String claveDescifrada = cript.decofificar(claveTexto.toCharArray(), msj_cifrado.toCharArray(), alf.toCharArray(), true);
		System.out.println(claveDescifrada);
	}

}
