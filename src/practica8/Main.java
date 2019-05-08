package practica8;

import java.math.BigInteger;

import practica7.PotenciacionModular;

public class Main {

	public static void main(String[] args) {
		run();

	}
	
	public static void run () {
		String alf="aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		BigInteger base = new BigInteger(""+alf.length());
		BigInteger p = new BigInteger("131414242343537725243372873");
		BigInteger g = new BigInteger("10");
		String A= "íyr5IR6ípDSAúY";
		String B= "eXPKeSítÍííDN,";
		BigInteger a = new BigInteger("63332323232451757353");
		String msj_cifrado=")bJ.WpfA)DJfHqsú1s:-FwódslkíxÁJnseóaDóíÉpaDúTF:-l7ÑñnnI:íNTny5A9ó9ÁEsqoú Hñ0D8óríouooMJsñ5róE),fzdBÉÓnf5fbÑóúxp7íETnñgK8ócéftáHÉ5o:UjBáDSYP69bñUUmg79hhFuií TKó1yázy.fd5bnNf.Ó):";
			
		Criptografia cript = new Criptografia();
		BigInteger clave = cript.calcularClave(B, alf, a, p);
		
		String claveTexto = cript.enteroATexto(clave,base,alf);
		
		String claveDescifrada = cript.decofificar(claveTexto.toCharArray(), msj_cifrado.toCharArray(), alf.toCharArray(), true);
		System.out.println(claveDescifrada);
	}

}
