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
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		Boolean esVeterinario;
		do {
			System.out.println("Introduzca una opcion:");
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				//Registro de Empleado
				empleadoNuevo=interfazEmpleados.registroEmpleado();
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				System.out.println("ha salido");
				break;
			}
		}while(opcion!=4);

	}

}
