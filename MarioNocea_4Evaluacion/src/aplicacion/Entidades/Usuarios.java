package aplicacion.Entidades;

public class Usuarios {
	//No utilizo código identificador porque los quiero añadir por su orden en la lista.
	private String nombre,apellidos;
	private boolean esVeterinario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isEsVeterinario() {
		return esVeterinario;
	}
	public void setEsVeterinario(boolean esVeterinario) {
		this.esVeterinario = esVeterinario;
	}
	
}
