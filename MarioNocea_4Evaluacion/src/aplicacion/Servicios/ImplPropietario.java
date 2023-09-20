package aplicacion.Servicios;
import java.util.List;
import java.util.Scanner;

import aplicacion.Entidades.Propietarios;
import aplicacion.Entidades.Usuarios;
import aplicacion.Entidades.Veterinarios;
public class ImplPropietario implements IntPropietario {
	/**
	 * Metodo para crear un propietario
	 */
	@Override
	public void CrearPropietario(List<Propietarios> bd,Usuarios nuevoUsuario) {
		Scanner sc=new Scanner(System.in);
		int numeroMascotas;
		String nombre,apellido;
		System.out.println("Introduzca su numero de mascotas: ");
		Propietarios nuevoPropietario=new Propietarios();
		numeroMascotas=sc.nextInt();
		numeroMascotas=sc.nextInt();
		nombre=nuevoUsuario.getNombre();
		apellido=nuevoUsuario.getApellidos();
		nuevoPropietario.setNombre(nombre);
		nuevoPropietario.setApellidos(apellido);
		nuevoPropietario.setNumeroMascotas(numeroMascotas);
		bd.add(nuevoPropietario);
	}

}
