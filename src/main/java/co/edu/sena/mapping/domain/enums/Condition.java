package co.edu.sena.mapping.domain.enums;

public enum Condition {

	ACTIVO("ACTIVO"),
	INACTIVO("IN-ACTIVO");
	
	private String description;
	
	private Condition(String s) {
		description = s;
	}
	
	public String getDescription() {
		return description;
	}
}
