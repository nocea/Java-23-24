package entidades;

public class Empleados {
	private String nombre,apellidos,dni,titulacion,fechaNac;
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	private int numEmpleado;
	private long numSegu,numCuen;
	public int getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public long getNumSegu() {
		return numSegu;
	}
	public void setNumSegu(long numSegu) {
		this.numSegu = numSegu;
	}
	public long getNumCuen() {
		return numCuen;
	}
	public void setNumCuen(long numCuen) {
		this.numCuen = numCuen;
	}

}
