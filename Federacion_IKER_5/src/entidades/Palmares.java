package entidades;

public class Palmares<T extends Metal,S extends Participante> {

	private long idPalmares;
	private T medalla;
	private S participante;
	private Prueba prueba;
	private String observaciones;
	
	public Atleta atleta;
	
	
	public Palmares() {
		
	}

	public Palmares(long idPalmares, T medalla, S participante, Prueba prueba, String observaciones) {
		this.idPalmares = idPalmares;
		this.medalla = medalla;
		this.participante = participante;
		this.prueba = prueba;
		this.observaciones = observaciones;
	}
	
	
	

	public long getIdPalmares() {
		return idPalmares;
	}

	public void setIdPalmares(long idPalmares) {
		this.idPalmares = idPalmares;
	}

	public T getMedalla() {
		return medalla;
	}

	public void setMedalla(T medalla) {
		this.medalla = medalla;
	}

	public S getParticipante() {
		return participante;
	}

	public void setParticipante(S participante) {
		this.participante = participante;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "[Palmares: " + idPalmares + medalla.toString()+ prueba.getNombre() + prueba.getFecha() + prueba.getLugar() + atleta.getDorsal()+ atleta.getCalle()+ "]" ;
	}
	
	
	
}
