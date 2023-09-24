package Servicios;

import java.util.List;
import entidades.Empleados;
public interface IntMenu {
	public void MostrarMenu();
	public void GuardarFichero(List<Empleados> listaEmpleados);
	public List<Empleados> AsignarNumeroEmpleado(List<Empleados> listaEmpleados);
}
