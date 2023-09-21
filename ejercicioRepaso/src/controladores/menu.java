package controladores;
import entidades.Empleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Servicios.ImplEmpleados;
import Servicios.ImplMenu;
import Servicios.IntEmpleados;
import Servicios.IntMenu;
public class menu {

	public static void main(String[] args) {
		IntEmpleados interfazEmpleados=new ImplEmpleados();
		List <Empleados> listaEmpleados=new ArrayList<>();
		Empleados empleadoNuevo=new Empleados();
		IntMenu interfazMenu=new ImplMenu();
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		try {
		do {
			interfazMenu.MostrarMenu();
			opcion=sc.nextInt();
			switch (opcion) {		
			case 1:
				//Registro de Empleado
				listaEmpleados.add(empleadoNuevo=interfazEmpleados.RegistroEmpleado());
				listaEmpleados=interfazMenu.AsignarNumeroEmpleado(listaEmpleados);
				System.out.println("Se han guardado los datos del empleado.");
				break;
			case 2:
				//Modificar datos del empleado
				//Si la lista esta vacia no te deja modificar
				if(listaEmpleados.isEmpty()) {
					System.out.println("No existe ningun empleado registrado.");
				}
				else {
				listaEmpleados=interfazEmpleados.ModificarEmpleado(listaEmpleados);
				}
				break;
			case 3:
				interfazMenu.GuardarFichero(listaEmpleados);
				break;
			case 4:
				System.out.println("ha salido");
				break;
			}
		}while(opcion!=4);
		}catch(Exception e) {
			System.out.println("Se ha producido una error");
		}

	}

}
