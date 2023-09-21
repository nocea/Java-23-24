package aplicacion.Servicios;
import aplicacion.Entidades.Propietarios;

import aplicacion.Entidades.Veterinarios;
import java.util.List;
public interface IntMenu {
	
	public void GuardarFichero(List<Veterinarios> bdVeterinarios,List<Propietarios>bdPropietarios);
	public void MostrarFichero();
	
}
