package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	public Equipo equipo;
	public Atleta[] atleta;
	
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
	
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	// EJERCICIO 3 EXAMEN 6
	public String data() {
		String ret = "";
		ret = persona.getId() + "|" + persona.getNombre()+ "|" + persona.getFechaNac() + "|" + persona.getTelefono() + "|" + this.telefono + "|" + this.direccion;
		return ret;
	}

	
	public static void exportarManager () {
	
	File fOut = new File("managers.txt");
	FileWriter fw = null;
	BufferedWriter bw = null;
	String data;

	try {
		fw = new FileWriter(fOut);
		bw = new BufferedWriter(fw);
		for (int i = 0; i< Datos.MANAGERS.length; i++){
			Manager m = new Manager();
			m= Datos.MANAGERS[i];
		bw.write(m.data() + "\n");
		bw.close();

		}
	} catch (IOException e) {
		{
			e.printStackTrace();
		}

	} finally {

	}

	System.out.println(" ");
	
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
		return "D/Dña. " + persona.getNombre() + "con NIF:NIE " + persona.getNifnie() + "nacido el " + persona.getFechaNac() + "representa al equipo" + equipo.nombre + "de id " + equipo.id + "durante el año "+ equipo.getAnioinscripcion() + ", el cual esta conformado por los siguientes atletas: " + '\t' + atleta.toString();
		}

	public static void mapearNifNie() {
		

			System.out.println("Cargando de Manager.txt...");
			File f = new File("Manager.txt");
			FileReader fr = null;
			BufferedReader br = null;

			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String s;

				for (int i = 0; i < 6; i++) {
					s = (String) br.readLine();
					System.out.println(s);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
}
