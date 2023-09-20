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
		System.out.print("Apellidos del Empleado:");
		nuevoEmpleado.setApellidos(scan.next());
		nuevoEmpleado.setDni(creacionDNI());
		return nuevoEmpleado;
	}

	@Override
	public Empleados modificarEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creacionDNI() {
		//Metodo para registrar un dni y si lo introduce mal poder volver a introducirlo.
		String numerosDNI;
		char letraDNI;
		char sino;
		Boolean estaBien=true;
		Scanner scan =new Scanner(System.in);
		do {	
			do {
				//Pregunto los digitos del dni
				System.out.print("Numeros dni(8):");
				numerosDNI=scan.next();
				//Compruebo si tiene al menos 8 digitos
				if(numerosDNI.length()<8) {
					System.out.println("Tu dni debe tener al menos 8 digitos");
				}
			}while(numerosDNI.length()<8);
			//Pido la letra del dni
			System.out.print("Introduce la letra de tu DNI(solo se guardara el primer caracter de lo que guardes):");
			letraDNI=scan.next().charAt(0);
			do {
				//Pregunto si es correcto
			System.out.print("¿Es correcto tu DNI(s/n)?-->"+numerosDNI+"-"+letraDNI+":");
			sino=scan.next().charAt(0);
			sino=Character.toLowerCase(sino);
			//Si no es ni 's'ni 'n' vuelve a repetir la pregunta solo.
			if(sino!='s'&&sino!='n') {
				System.out.println("Debe introducir 's' para aceptar y 'n' para volver a introducir su dni");
				estaBien=false;
			}
			//Como ya solo puede ser s o n,controlo la n como false y la s como true.
			else {
				if(sino=='n') {
					estaBien=false;
				}
				else {
					estaBien=true;
				}
			}
			}while(sino!='s'&&sino!='n');
		}while(!estaBien);
		//Devuelvo el numero mas la letra
		return numerosDNI+"-"+letraDNI;
	}

}
