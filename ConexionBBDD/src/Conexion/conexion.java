package Conexion;
import java.sql.*;
public class conexion {
public static void main(String[] args)  {
  
    Connection BaseDatos = null;
    Statement st = null;
  
    //Donde se localiza la base de datos
    String url="jdbc:postgresql://localhost:5432/gestorBibliotecaPersonal";
  
    //Credenciales de la base de datos
    String usuario="postgres";
    String contrasena="mariomanu7.";
  
    try {
        //Conexion con la base de datos
        BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
  
        // Se hara una consulta  de la tabla CDS y Cantante, y se mandara a imprimir.
        st = BaseDatos.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros\r\n"
        		+ "ORDER BY id_libro ASC ");
  
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
  
        rs.close();
        st.close();
        BaseDatos.close();
    } catch (Exception e) {
        System.err.println( e.getMessage() );
        }
    }
  
}

