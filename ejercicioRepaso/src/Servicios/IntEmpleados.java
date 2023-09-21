package Servicios;
import java.util.List;

import entidades.Empleados;
public interface IntEmpleados {
	public Empleados RegistroEmpleado();
	public List<Empleados> ModificarEmpleado(List<Empleados> listaEmpleados);
}
