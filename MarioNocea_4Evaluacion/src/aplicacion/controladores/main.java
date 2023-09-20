package aplicacion.controladores;
import aplicacion.Entidades.Veterinarios;
import aplicacion.Entidades.Usuarios;
import aplicacion.Entidades.Veterinarios;
import aplicacion.Entidades.Propietarios;
import aplicacion.Servicios.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class main {

	public static void main(String[] args) {
		IntUsuario interfazUsuarios=new ImplUsuario();
		IntPropietario interfazPropietarios=new ImplPropietario();
		IntVeterinario interfazVeterinarios=new ImplVeterinario();
		IntMenu interfazMenu=new ImplMenu();
		List<Veterinarios> listaVeterinarios=new ArrayList<>();
		List<Propietarios> listaPropietarios=new ArrayList<>();
		Usuarios nuevoUsuario=new Usuarios();
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		Boolean esVeterinario;
		do {
			System.out.println("Introduzca una opcion:");
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				//pregunto si es veterinario
				esVeterinario=interfazUsuarios.Esveterinario();
				//creo un usuario
				nuevoUsuario=interfazUsuarios.CrearUsuario();
				if(esVeterinario) {
					//lo guardo en distintas listas
					interfazVeterinarios.crearVeterinario(listaVeterinarios,nuevoUsuario);
					break;
				}
				if(!esVeterinario) {
					interfazPropietarios.CrearPropietario(listaPropietarios, nuevoUsuario);
					break;
				}
			case 2:
				//Guardo en el fichero
				interfazMenu.GuardarFichero(listaVeterinarios, listaPropietarios);
				//System.out.println(listaVeterinarios.get(0).getNombre()+" "+listaVeterinarios.get(0).getApellidos()+" es veterinario/a  y su número de colegiado es"+listaVeterinarios.get(0).getNumeroColegiado());
				break;
			case 3:
				//muestro el fichero
				interfazMenu.MostrarFichero();
				break;
			case 4:
				System.out.println("ha salido");
				break;
			}
		}while(opcion!=4);
		
	}

}
