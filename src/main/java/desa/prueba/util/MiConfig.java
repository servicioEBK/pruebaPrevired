package desa.prueba.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MiConfig {
	@Value("${persona.eliminada.ok}")
	private String peok;	
	@Value("${persona.vacio}")
	private String pvacio;
	@Value("${persona.rut.nulo}")
	private String prnulo;
	@Value("${persona.rut.existe}")
	private String prexiste;
	@Value("${persona.salario.limite}")
	private String pslimite;
	@Value("${persona.id.no.existe}")
	private String pinexiste;


	public String getPvacio() {
		return pvacio;
	}

	public void setPvacio(String pvacio) {
		this.pvacio = pvacio;
	}

	public String getPrnulo() {
		return prnulo;
	}

	public void setPrnulo(String prnulo) {
		this.prnulo = prnulo;
	}

	public String getPrexiste() {
		return prexiste;
	}

	public void setPrexiste(String prexiste) {
		this.prexiste = prexiste;
	}

	public String getPslimite() {
		return pslimite;
	}

	public void setPslimite(String pslimite) {
		this.pslimite = pslimite;
	}

	public String getPeok() {
		return peok;
	}

	public void setPeok(String peok) {
		this.peok = peok;
	}

	public String getPinexiste() {
		return pinexiste;
	}

	public void setPinexiste(String pinexiste) {
		this.pinexiste = pinexiste;
	}


}
