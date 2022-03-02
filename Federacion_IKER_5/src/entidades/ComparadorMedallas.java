package entidades;
import java.util.Collections;
import java.util.Comparator;

import utils.Datos;
public class ComparadorMedallas implements Comparator<Metal>{

	
	

	@Override
	public int compare(Metal o1, Metal o2) {
		return o1.maximaPurezaAlcanzada() - o2.maximaPurezaAlcanzada();
		
	}

	

}
