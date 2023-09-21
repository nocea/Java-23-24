package Servicios;
import entidades.Empleados;
public interface IntEmpleados {
	public Empleados registroEmpleado();
	public Empleados modificarEmpleado();
	public String creacionDNI();
	public long compruebaNumero(int cifrasNumero,String msgErr);
	public String creaFecha();
}
