package Servicios;

import java.util.ArrayList;
import java.util.List;

import entidades.Empleados;

public class ImplMenu implements IntMenu {

	@Override
	public void MostrarMenu() {
		System.out.println("Introduzca una opcion:");
		System.out.println("1.-->Registrar Empleado");
		System.out.println("2.-->Modificar Empleado");
		System.out.println("3.-->Exportar fichero");
		System.out.println("4.-->Cerrrar App");
	}

	@Override
	public void GuardarFichero(List<Empleados> listaEmpleados) {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Empleados> AsignarNumeroEmpleado(List<Empleados> listaEmpleados) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			listaEmpleados.get(i).setNumEmpleado(i);
		}
		return listaEmpleados;
	}

}
