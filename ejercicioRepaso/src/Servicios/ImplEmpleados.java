package Servicios;

import java.util.Scanner;

import entidades.Empleados;

public class ImplEmpleados implements IntEmpleados {

	@Override
	public  Empleados registroEmpleado() {
		Empleados nuevoEmpleado=new Empleados();
		Scanner scan =new Scanner(System.in);
		System.out.println("Ha iniciado el registro de Empleados");
		System.out.println("Porfavor introduzca todos sus datos");
		System.out.print("Nombre del Empleado:");
		nuevoEmpleado.setNombre(scan.next());
		System.out.println(nuevoEmpleado.getNombre());
		return nuevoEmpleado;
	}

	@Override
	public Empleados modificarEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

}
