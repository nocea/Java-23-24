package aplicacion.Servicios;
import aplicacion.Entidades.Usuarios;


import java.util.List;
import java.util.Scanner;
public class ImplUsuario implements IntUsuario {

	@Override
	/**
	 * metodo para comprobar si es veterinario o no
	 */
	public Boolean Esveterinario() {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		
		do {
		System.out.println("¿Es usted Veterianario o Propietario?[Introduzca 1 o 2]");
		opcion=sc.nextInt();
		
		}while(opcion<1||opcion>2);
		if(opcion==1) {
			return true;}
		else if (opcion==2) {
			return false;}
		return null;
	}
	@Override
	public Usuarios CrearUsuario() {
		Usuarios usuNuevo=new Usuarios();
		String nombre,apellidos;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		nombre=sc.next();
		System.out.println("Introduce tus apellidos:");
		apellidos=sc.next();
		usuNuevo.setNombre(nombre);
		usuNuevo.setApellidos(apellidos);
		return usuNuevo;
	}
}
