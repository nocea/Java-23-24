package Servicios;

import java.util.Scanner;
import entidades.Empleados;

public class ImplEmpleados implements IntEmpleados {

	@Override
	public Empleados registroEmpleado() {
		Empleados nuevoEmpleado = new Empleados();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ha iniciado el registro de Empleados");
		System.out.println("Porfavor introduzca todos sus datos");
		System.out.print("Nombre del Empleado:");
		nuevoEmpleado.setNombre(scan.next());
		System.out.print("Apellidos del Empleado:");
		nuevoEmpleado.setApellidos(scan.next());
		nuevoEmpleado.setFechaNac(creaFecha());
		System.out.print("Titulacion mas alta del empleado:");
		nuevoEmpleado.setTitulacion(scan.next());
		System.out.println("Numero de Seguridad social del empleado(12):");
		nuevoEmpleado.setNumSegu(compruebaNumero(12, "Debe tener 12 digitos"));
		System.out.println("Numero de Cuenta del empleado(12 últimos digitos):");
		nuevoEmpleado.setNumCuen(compruebaNumero(12,"Debe tener 12 digitos"));
		return nuevoEmpleado;
	}

	@Override
	public Empleados modificarEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creacionDNI() {
		// Metodo para registrar un dni y si lo introduce mal poder volver a
		// introducirlo.
		String numerosDNI;
		char letraDNI;
		char sino;
		Boolean estaBien = true;
		Scanner scan = new Scanner(System.in);
		do {
			do {
				// Pregunto los digitos del dni
				System.out.print("Numeros dni(8 sin letra):");
				numerosDNI = scan.next();
				// Compruebo si tiene al menos 8 digitos
				if (numerosDNI.length() < 8) {
					System.out.println("Tu dni debe tener al menos 8 digitos");
				}
			} while (numerosDNI.length() < 8);
			// Pido la letra del dni
			System.out.print("Introduce la letra de tu DNI(solo se guardara el primer caracter de lo que guardes):");
			letraDNI = scan.next().charAt(0);
			do {
				// Pregunto si es correcto
				System.out.print("¿Es correcto tu DNI(s/n)?-->" + numerosDNI + "-" + letraDNI + ":");
				sino = scan.next().charAt(0);
				sino = Character.toLowerCase(sino);
				// Si no es ni 's'ni 'n' vuelve a repetir la pregunta solo.
				if (sino != 's' && sino != 'n') {
					System.out.println("Debe introducir 's' para aceptar y 'n' para volver a introducir su dni");
					estaBien = false;
				}
				// Como ya solo puede ser s o n,controlo la n como false y la s como true.
				else {
					if (sino == 'n') {
						estaBien = false;
					} else {
						estaBien = true;
					}
				}
			} while (sino != 's' && sino != 'n');
		} while (!estaBien);
		// Devuelvo el numero mas la letra
		return numerosDNI + "-" + letraDNI;
	}

	@Override
	public long compruebaNumero(int cifrasNumero, String msgErr) {
		long numero;
		int cifras=0;
		Scanner scan = new Scanner(System.in);
		do {
			numero = scan.nextLong();
			while (numero != 0) { 
				numero = numero / 10; 
				cifras++; 
			}
			if (cifras != cifrasNumero) {
				System.out.println(msgErr);
				cifras=0;
			}
		} while (cifras != cifrasNumero);
		return numero;
	}

	@Override
	public String creaFecha() {
		int dia,mes,año;
		Scanner scan =new Scanner(System.in);
		System.out.println("Introduce tu año de nacimiento:");
		año=scan.nextInt();
		System.out.println("Introduce tu mes de nacimiento:");
		do {
			mes=scan.nextInt();
			if(mes<1&&mes>12) {
				System.out.println("Tu mes debe de estar entre 1 y 12");
			}
		}while(mes<1&&mes>12);
		return null;
	}

}
