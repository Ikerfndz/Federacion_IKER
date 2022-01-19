package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import Validaciones.Validacion;
import utils.Datos;
import utils.Utilidades;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;

	private DatosPersona persona;

	public Manager(long id, String telefono, String direccion) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Manager(long id, String telefono, String direccion, DatosPersona dp) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = dp;
	}

	public static Manager nuevoManager() {
		Manager ret = null;
		Scanner in;
		long id = -1;
		DatosPersona dp = null;
		String tfn = "";
		String direccion = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo manager:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
		} while (!valido);
		valido = false;

		do {
			System.out.println("Introduzca el telefono del nuevo Manager:");
			in = new Scanner(System.in);
			tfn = in.nextLine();
			valido = Validacion.validarTelefono(tfn);
			if (tfn.length() > 3)
				valido = true;
		} while (!valido);
		do {
			System.out.println("Introduzca la direccion del nuevo Manager:");
			in = new Scanner(System.in);
			direccion = in.nextLine();
			if (direccion.length() > 3)
				valido = true;
		} while (!valido);
		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();
		ret = new Manager(id, direccion, direccion, dp);
		return ret;

	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	// Pedimos el id y el telefono del manager y llamamos a los metodos nombre,
	// documentacion, fechaNac y telefono2 de datos persona.
	@Override
	public String toString() {
		return id + persona.getNombre() + "(" + persona.getNifnie() + ")" + "del año" + persona.getFechaNac() + "Tfno: "
				+ telefono + "Tfno2: " + persona.getTelefono();
	}

}
