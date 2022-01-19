package entidades;

import java.util.Scanner;

import Validaciones.Validacion;
import utils.Datos;

public class Atleta extends Participante {
	private long idAtleta;
	private float altura;
	private float peso;

	private DatosPersona persona;

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(idAtleta, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

// Metodo nuevo atleta que pido al usuario su id, peso y altura.
	public static Atleta nuevoAtleta() {
		Atleta ret = null;
		Scanner in;
		long idAtleta = -1;
		DatosPersona dp = null;
		float altura = 0;
		float peso = 0;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id de la nueva persona:");
			in = new Scanner(System.in);
			idAtleta = in.nextInt();
			if (idAtleta > 0)
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el peso del nuevo atleta:");
			in = new Scanner(System.in);
			peso = in.nextFloat();
			;
			if (peso > 0)
				valido = true;
		} while (!valido);
		do {
			System.out.println("Introduzca la altura del nuevo atleta:");
			in = new Scanner(System.in);
			altura = in.nextFloat();

			if (altura > 0)
				valido = true;
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();
		ret = new Atleta(idAtleta, peso, altura, dp);
		return ret;
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	// Metodon toString que devuelve el nombre, documentacion, fecha de nacimiento,
	// peso y altura, usando metodos de la clase Datospersona.
	@Override
	public String toString() {
		return persona.getNombre() + "(" + persona.getNifnie() + ")" + "del año" + persona.getFechaNac() + "/t" + peso
				+ "Kgs" + altura + "m";
	}

}
