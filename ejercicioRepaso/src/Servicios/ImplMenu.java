package Servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Empleados;

public class ImplMenu implements IntMenu {
	//Metodo para mostrar las opciones del menu
	@Override
	public void MostrarMenu() {
		System.out.println("Introduzca una opcion:");
		System.out.println("1.-->Registrar Empleado");
		System.out.println("2.-->Modificar Empleado");
		System.out.println("3.-->Exportar fichero");
		System.out.println("4.-->Cerrar App");
	}
	//Metodo para guardar en un ficherio externo segun la opcion que se elija
	@Override
	public void GuardarFichero(List<Empleados> listaEmpleados) {
		int opcion = 0;
		int empleado;
		FileWriter fw = null;
		PrintWriter pw = null;
		File ruta;
		Scanner scan = new Scanner(System.in);
		System.out.println("Elige una opcion de las siguientes:");
		System.out.println("1-->Exportar solo un empleado.");
		System.out.println("2-->Exportar toda la lista de empleados");
		do {
			opcion = scan.nextInt();
			if (opcion < 1 || opcion > 2) {
				System.out.println("Esa opción no existe.");
			} else {
				if (opcion == 1) {
					System.out.println("¿Que empleado quiere guardar de la lista?(1..." + listaEmpleados.size() + ")");
					do {
						empleado = scan.nextInt();
						if (empleado < 1 || empleado > listaEmpleados.size()) {
							System.out.println("Ese empleado no existe");
						}
					} while (empleado < 1 || empleado > listaEmpleados.size());
					//Para guardar los datos de un solo empleado
					try {
						ruta = new File("unSoloEmpleado.txt");
						fw = new FileWriter(ruta);
						pw = new PrintWriter(fw);
						pw.println("--------Empleado Elegido-----------");
						pw.println(listaEmpleados.get(empleado - 1).toString());
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (null != fw)
								fw.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				} else {
					//Para guardar la lista de empleados que hay en el menu de todos los empleados
					try {
						ruta = new File("todosLosEmpleados.txt");
						fw = new FileWriter(ruta);
						pw = new PrintWriter(fw);
						pw.println("--------Todos Los empleados-----------");
						for (int i = 0; i < listaEmpleados.size(); i++) {
							pw.println(listaEmpleados.get(i).toString());
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (null != fw)
								fw.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		} while (opcion < 1 || opcion < 2);
		System.out.println("¡¡Se ha guardado toda la información en la carpeta del proyecto!!");
	}
	//Metodo que le asigna un nuevo numero a cada empleado de la lista
	@Override
	public List<Empleados> AsignarNumeroEmpleado(List<Empleados> listaEmpleados) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			listaEmpleados.get(i).setNumEmpleado(i + 1);
		}
		return listaEmpleados;
	}

}
