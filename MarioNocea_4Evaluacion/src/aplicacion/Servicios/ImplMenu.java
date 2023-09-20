package aplicacion.Servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import aplicacion.Entidades.Propietarios;
import aplicacion.Entidades.Veterinarios;

public class ImplMenu implements IntMenu {
/**
 * metodo para guardar el fichero
 */
	@Override
	public void GuardarFichero(List<Veterinarios> bdVeterinarios, List<Propietarios> bdPropietarios) {
		FileWriter fw=null;
		PrintWriter pw=null;
		String ruta="C:\\archivos\\archivo1.txt";
		try {
			fw=new FileWriter(ruta);
			pw=new PrintWriter(fw);
			pw.println("--------Lista Veterinarios-----------");
			pw.println("nombre;apellidos;numeroColegiados");
			for (int i = 0; i < bdVeterinarios.size(); i++) {
				pw.println(bdVeterinarios.get(i).getNombre()+";"+bdVeterinarios.get(i).getApellidos()+";"+bdVeterinarios.get(i).getNumeroColegiado());
			}
			pw.println("--------Lista Propietarios----------");
			pw.println("nombre;apellidos;numeroMascotas");
			for (int i = 0; i < bdPropietarios.size(); i++) {
				pw.println(bdPropietarios.get(i).getNombre()+";"+bdPropietarios.get(i).getApellidos()+";"+bdPropietarios.get(i).getNumeroMascotas());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
		          
		           if (null != fw)
		              fw.close();
		           } catch (Exception e2) {
		              e2.printStackTrace();
		           }
		}
		System.out.println("¡¡Se ha guardado toda la información!!");
		
	}

	@Override
	//Leo el fichero y lo muestro por consola linea a linea
	public void MostrarFichero() {
		File archivo=null;
		FileReader fr =null;
		BufferedReader br=null;
		String ruta="C:\\archivos\\archivo1.txt";
		try {
			
			archivo=new File(ruta);
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
