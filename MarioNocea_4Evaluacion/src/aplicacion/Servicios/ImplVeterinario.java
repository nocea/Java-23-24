package aplicacion.Servicios;
import java.util.List; 
import java.util.Scanner;

import aplicacion.Entidades.Usuarios;
import aplicacion.Entidades.Veterinarios;
public class ImplVeterinario implements IntVeterinario {
/**
 * Metodo para crear un veterinario
 */
	@Override
	public void crearVeterinario(List<Veterinarios> bd,Usuarios nuevoUsuario) {
		Scanner sc=new Scanner(System.in);
		String numeroColegiado,nombre,apellido;
		System.out.println("Introduzca su numero de colegiado: ");
		numeroColegiado=sc.next();
		nombre=nuevoUsuario.getNombre();
		apellido=nuevoUsuario.getApellidos();
		Veterinarios nuevoVeterinario=new Veterinarios();
		nuevoVeterinario.setNombre(nombre);
		nuevoVeterinario.setApellidos(apellido);
		nuevoVeterinario.setNumeroColegiado(numeroColegiado);
		bd.add(nuevoVeterinario);
	}
	

}
