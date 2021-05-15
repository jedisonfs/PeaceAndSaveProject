package co.edu.sena.mapping.domain.enums;

public enum Condition {

	ACTIVO("Esta activo"),
	INACTIVO("Esta in-activo");
	
	private String description;
	
	private Condition(String s) {
		description = s;
	}
	
	public String getDescription() {
		return description;
	}
}
