package entidades;

import java.util.Scanner;

import Validaciones.Validacion;

public class NIE extends Documentacion {
	char letraInicial;
	String numero;
	char letraFinal;

	public NIE() {
	}

	public NIE(char letraI, String numero, char letraF) {
		super();
		this.letraInicial = letraI;
		this.numero = numero;
		this.letraFinal = letraF;
	}

	public NIE(String cadena) {
		super();
		this.letraInicial = cadena.charAt(0);
		this.numero = cadena.substring(1, cadena.length());
		this.letraFinal = cadena.charAt(cadena.length() - 1);
	}

	public char getLetraInicial() {
		return letraInicial;
	}

	public void setLetraInicial(char letraInicial) {
		this.letraInicial = letraInicial;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getLetraFinal() {
		return letraFinal;
	}

	public void setLetraFinal(char letraFinal) {
		this.letraFinal = letraFinal;
	}

	@Override
	public String mostrar() {
		return letraInicial + numero + letraFinal;
	}

	/**
	 * Funcion que valida si una cadena de caracteres que se pasa como parÃ¡metro
	 * tiene un NIE vÃ¡lido.
	 * 
	 * @param nie cadena con el NIE a validar
	 * @return true si la cadena nie es un NIE vÃ¡lido o false en caso contrario
	 */

	public static NIE nuevoNIE() {
		NIE ret = null;
		Scanner in;
		boolean valido = false;
		String cadena;
		do {
			System.out.println("Introduzca el NIE completo:");
			in = new Scanner(System.in);
			cadena = in.nextLine();
			if (cadena.length() > 3)
				valido = true;
		} while (!valido);

		ret = new NIE(cadena);
		return ret;
	}

	@Override
	public boolean validar() {
		return Validacion.validarNIE(this.mostrar());
	}

}
