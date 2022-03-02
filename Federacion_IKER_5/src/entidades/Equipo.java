package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Validaciones.Validacion;
import utils.Utilidades;

public class Equipo extends Participante {
	private long idEquipo;
	public String nombre;
	private int anioinscripcion;
	private Manager manager;
	private Atleta[] atletas;

	public Equipo(long id, int anioinscripcion, Manager manager, Atleta[] atleta, String nombre) {
		super();
		this.idEquipo = id;
		this.anioinscripcion = anioinscripcion;
		this.manager = manager;
		this.atletas = atleta;
		this.nombre = nombre;
	}

	public Equipo(long idParticipante, Equipo e, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idEquipo = e.idEquipo;
		this.anioinscripcion = e.anioinscripcion;
		this.manager = e.manager;
		this.atletas = e.atletas;
	}

	@Override
	public long getId() {
		return idEquipo;
	}
	@Override
	public void setId(long id) {
		this.idEquipo = id;
	}
	public int getAnioinscripcion() {
		return anioinscripcion;
	}
	public void setAnioinscripcion(int anioinscripcion) {
		this.anioinscripcion = anioinscripcion;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Atleta[] getAtletas() {
		return atletas;
	}
	public void setAtletas(Atleta[] atletas) {
		this.atletas = atletas;
	}

	//Ejercicio 3
	@Override
	public String toString() {
		String ret = "";
		ret+= "EQ"+idEquipo + ". de " + manager.getPersona().getNombre() + " (" + manager.getDireccion()+") " + atletas.length + " componentes en el equipo:\n";
		for(Atleta a: atletas) {
			ret += a.getId()+". " + a.getPersona().getNombre() + "(" + a.getPersona().getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ ") "
					+ " Datos físicos:\t"+ a.getPeso()+ "Kgs.\t" + a.getAltura()+"m.\n";
		}
		ret += "Valido durante el " + anioinscripcion;
		return ret;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

//ejercicio 1 examen 8
	public static Equipo nuevoEquipo() {
		Equipo equipo = null;
		Atleta[] atleta = null;
		Manager manager = null;
		Scanner teclado;
		int numAtletas = -1;
		teclado = new Scanner(System.in);

		// Nombre
		String nombre= "";
		boolean nombreValido = false;
		do {
			System.out.println("Introduzca el nombre del nuevo equipo: ");
			nombre = teclado.nextLine();
			nombreValido = Validacion.validarNombre(nombre);
		} while (!nombreValido);

		// fecha de inscripcion
		boolean anioValida = false;
		int anioInscripcion = -1;
		do {
			System.out.println("Introduzca la fecha: ");
			anioInscripcion = teclado.nextInt();
			anioValida = Validacion.validarAnioInscripcion(anioInscripcion);
		} while (!anioValida);
		
		// id
		long idEquipo = -1;
		boolean idValido = false;
		do {
			System.out.println("Introduzca el id del nuevo equipo: ");
			idEquipo = teclado.nextLong();
			idValido = Validacion.validarIdEquipo(idEquipo);
		} while (!nombreValido);

		System.out.println("Introduzca los datos del manager: ");
		manager = Manager.nuevoManager();
		
		System.out.println("Introduce los datos de los " + numAtletas + " atletas");
		Atleta[] atletas = new Atleta[numAtletas];
		for (int i = 0; i < numAtletas; i++) {
		System.out.println("Introduce los datos del " + (i + 1) + " atleta");
		atletas[i] = Atleta.nuevoAtleta();
		
		}
		System.out.println("¿Los datos del equipo estan correctos?");
		boolean datosValidos = Utilidades.leerBoolean();
		equipo = new Equipo(idEquipo, anioInscripcion, manager, atleta, nombre);
		return equipo;
	}
}
