package Conexion;
//Importo todo lo relacionado con conexion sql y archivo de propiedades
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class conexion {
public static void main(String[] args)  {
	//Instancio el objeto Properties
	Properties propiedades=new Properties();
	//Esto se usa para indicar el archivo properties como se llama
	InputStream input = null;
	//Declaro las tres claves para la conexion
	String url=null;
	String usuario=null;
	String contrasena=null;
	try {
		//Le instancio el destino del .properties
	    input = new FileInputStream("conexionBBDD.properties");
	    //cargo sus propiedades
	    propiedades.load(input);
	    //guardo las propiedades que quiero.
	    url = propiedades.getProperty("url");
	    usuario=propiedades.getProperty("usuario");
	    contrasena=propiedades.getProperty("contrasena");
	} catch (IOException ex) {
	    ex.printStackTrace();
	} finally {
	    if (input != null) {
	        try {
	        	//Cierro el input
	            input.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
    Connection BaseDatos = null;
    Statement st = null; 
    try {
    	//Conecto la base de datos
        BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
        st = BaseDatos.createStatement();
        //Ejecuto la query
        ResultSet rs = st.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros\r\n"
        		+ "ORDER BY id_libro ASC ");
        //Mientras hay filas se guardan los datos de las columnas y se muestran
        while    ( rs.next() ) {
            int  idLibro= rs.getInt("id_libro");
            String titulo= rs.getString("titulo");
            String autor=rs.getString("autor");
            String isbn=rs.getString("isbn");
            String edicion=rs.getString("edicion");
            System.out.println("idLibro:"+idLibro);
            System.out.println("titulo:"+titulo);
            System.out.println("autor:"+autor);
            System.out.println("isbn:"+isbn);
            System.out.println("edicion:"+edicion);
        }
        //cierro el result ,el statement y la conexion
        rs.close();
        st.close();
        BaseDatos.close();
    } catch (Exception e) {
        System.err.println( e.getMessage() );
        }
    }
  
}

