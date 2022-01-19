package utils;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luis
 */
public class Utilidades {

	/**
	 * FunciÃ³n que pide al usuario que introduzca 's' o 'S' para SÃ­ o 'n' o 'N'
	 * para No y devuelve true o false en cada caso. Si el usuario no introduce ni
	 * 's' ni 'S' ni 'n' ni 'N' entonces avisa al usuario y le vuelve a pedir a que
	 * lo introduzca de nuevo.
	 *
	 * @return true si el usuario introduce 's' o 'S'; false si el usuario introduce
	 *         'n' o 'N'
	 */
	public static boolean leerBoolean() {
		boolean ret;
		Scanner in;
		char resp;
		do {
			System.out.println("Pulse s para SÃ­ o n para No");
			in = new Scanner(System.in, "ISO-8859-1");
			resp = in.nextLine().charAt(0);
			if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
		if (resp == 's' || resp != 'S') {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	/**
	 * FunciÃ³n que pide al usuario que introduzca un valor decimal por la entrada
	 * estÃ¡ndar. Si el formato introducido no es correcto, avisa al usuario y le
	 * vuelve a pedir que lo introduzca de nuevo.
	 *
	 * @return el valor double introducido por el usuario
	 */
	public static double leerDouble() {
		double ret = 0.0;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor decimal (xx.xx)");
			in = new Scanner(System.in, "ISO-8859-1");
			try {
				ret = in.nextDouble();
				correcto = true;
			} catch (InputMismatchException ime) {
				System.out.println("Formato introducido incorrecto.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	/**
	 * FunciÃ³n que pide al usuario que introduce un valor para una fecha a partir
	 * de 3 enteros para el dÃ­a, mes y aÃ±o respectivamente. Si los valores
	 * introducidos no producen una fecha correcta, avisa al usuario y le pide que
	 * los introduzca de nuevo. Si no lo consigue, devolverÃ¡ null
	 *
	 * @return una fecha de la clase java.time.LocalDate o null si hay error
	 */
	public static java.time.LocalDate leerFecha() {
		LocalDate ret = null;
		int dia, mes, anio;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el dÃ­a (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el aÃ±o");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();

			try {
				ret = LocalDate.of(anio, mes, dia);
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	/**
	 * FunciÃ³n que pide al usuario que introduce un valor para una fecha a partir
	 * de 3 enteros para el dÃ­a, mes y aÃ±o respectivamente Y una hora a partir de
	 * ptrps 3 valores para la hora, minutos y segundos. Si los valores introducidos
	 * no producen una fecha u hora correctas, avisa al usuario y le pide que los
	 * introduzca de nuevo. Si no lo consigue, devolverÃ¡ null
	 *
	 * @return una fecha-hora de la clase java.time.LocalDateTime o null si hay
	 *         error
	 */
	public static java.time.LocalDateTime leerFechaHora() {
		LocalDateTime ret = null;
		int dia, mes, anio;
		int hora, min, seg;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el dÃ­a (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el aÃ±o");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();
			System.out.println("Introduzca un valor para la hora del dÃ­a (0...23)");
			in = new Scanner(System.in, "ISO-8859-1");
			hora = in.nextInt();
			System.out.println("Introduzca un valor para los minutos (0...59)");
			in = new Scanner(System.in, "ISO-8859-1");
			min = in.nextInt();
			System.out.println("Introduzca un valor para los segundos (0...59)");
			in = new Scanner(System.in, "ISO-8859-1");
			seg = in.nextInt();

			try {
				ret = LocalDateTime.of(anio, mes, dia, hora, min, seg);
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha-hora introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	/**
	 * FunciÃ³n que quita los espacios en blanco del comienzo y del final de una
	 * cadena de caracteres que se pasa como parÃ¡metro y, ademÃ¡s, sustituye todas
	 * las vocales que tengan tilde por la correspondiente sin tilde, devolviendo la cadena resultante
	 * 
	 * @param s cadena original
	 * @return cadena original sin espacios en blanco al comienzo y final de la cadena y sin vocales con tildes
	 */
	public static String quitarEspaciosTildes(String s) {
		String ret = s.trim();
		return ret.replace('Ã¡', 'a').replace('Ã©', 'e').replace('Ã­', 'i').replace('Ã³', 'o').replace('Ãº', 'u')
				.replace('Ã�', 'A').replace('Ã‰', 'E').replace('Ã�', 'I').replace('Ã“', 'O').replace('Ãš', 'U');
	}

	public static String removeDiacriticalMarks(String string) {
		// Form.NFC acepta Ã± y distingue las tildes en espaÃ±ol
		return Normalizer.normalize(string, Form.NFC).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	/**
	 * Valida que una cadena de caracteres contiene dÃ­gitos Ãºnicamente
	 * 
	 * @param tfn cadena con el telefono a validar
	 * @return true si es un telefono vÃ¡lido o false en caso contrario
	 */
	public static boolean validarTelefono(String tfn) {
		return tfn.trim().chars().allMatch(Character::isDigit);
	}

	/**
	 * Valida que una cadena de caracteres contiene letras o espacios Ãºnicamente,
	 * longitud entre 3 y 50 caractreres
	 * 
	 * @param nombre cadena con el nombre a validar
	 * @return true si es un nombre vÃ¡lido o false en caso contrario
	 */
	public static boolean validarNombre(String nombre) {
		// regEx general para cadena de caracteres con longitud entre 1 y 50 caracteres,
		// aceptando dÃ­gitos, letras MAYUS y minÃºsculas, con tildes, dirÃ©resis y
		// diferentes sÃ­mbolos especiales
		// Pattern patron = Pattern.compile("[
		// 0-9A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–ÃœÂ¡!Â¿?@#$%()=+-â‚¬/.,]{1,50}");
		Pattern patron = Pattern.compile("[ A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–Ãœ-]{3,50}");
		Matcher comprobacion = patron.matcher(nombre);
		return comprobacion.matches();//
	}
}
