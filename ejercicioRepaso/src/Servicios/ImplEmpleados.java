package Servicios;

import java.util.List;
import java.util.Scanner;
import entidades.Empleados;

public class ImplEmpleados implements IntEmpleados {

	@Override
	public Empleados RegistroEmpleado() {
		Empleados nuevoEmpleado = new Empleados();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ha iniciado el registro de Empleados");
		System.out.println("Porfavor introduzca todos sus datos");
		System.out.print("Nombre del Empleado:");
		nuevoEmpleado.setNombre(scan.next());
		System.out.print("Apellidos del Empleado:");
		nuevoEmpleado.setApellidos(scan.next());
		nuevoEmpleado.setFechaNac(CreaFecha());
		nuevoEmpleado.setDni(CreaDNI());
		System.out.print("Titulacion mas alta del empleado:");
		nuevoEmpleado.setTitulacion(scan.next());
		System.out.println("Numero de Seguridad social del empleado(12):");
		nuevoEmpleado.setNumSegu(CompruebaNumero(12, "Debe tener 12 digitos"));
		System.out.println("Numero de Cuenta del empleado(12 últimos digitos):");
		nuevoEmpleado.setNumCuen(CompruebaNumero(12,"Debe tener 12 digitos"));
		return nuevoEmpleado;
	}
	@Override
	public List<Empleados> ModificarEmpleado(List<Empleados> listaEmpleados) {
		Scanner scan=new Scanner(System.in);
		int numEmpleado;
		System.out.println("Introduzca su numero de empleado que quiera modificar(0..."+listaEmpleados.size()+")");
		do {
		numEmpleado=scan.nextInt();
		}while(numEmpleado>=0||numEmpleado<=listaEmpleados.size());
		return null;
	}
	//AREGLAR ESTE METODO NO CONTROLA LOS DIGITOS
	private String CreaDNI() {
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
	private long CompruebaNumero(int cifrasNumero, String msgErr) {
		long numero=0;
		long aux;
		int cifras=0;
		Scanner scan = new Scanner(System.in);
		do {
			numero = scan.nextLong();
			aux=numero;
			while (aux != 0) { 
				aux = aux / 10; 
				cifras++; 
			}
			if (cifras != cifrasNumero) {
				System.out.println(msgErr);
				cifras=0;
			}
		} while (cifras != cifrasNumero);
		return numero;
	}
	private String CreaFecha() {
		int dia,mes,año;
		String fechaFormat;
		Scanner scan =new Scanner(System.in);
		System.out.println("Introduce tu año de nacimiento:");
		año=scan.nextInt();
		do {
			System.out.println("Introduce tu mes de nacimiento:");
			mes=scan.nextInt();
			if(mes<1||mes>12) {
				System.out.println("Tu mes debe de estar entre 1 y 12");
			}
		}while(mes<1||mes>12);
		do {
			System.out.println("Introduce tu dia de nacimiento:");
			dia=scan.nextInt();
			if((dia < 1 || dia > 31) || (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) || (dia > 28 && mes == 2))
                System.out.println("Dia fuera de rango");
		}while ((dia < 1 || dia > 31) || (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) || (dia > 28 && mes == 2));
		fechaFormat=dia+"/"+mes+"/"+año;
		return fechaFormat;
	}

}
