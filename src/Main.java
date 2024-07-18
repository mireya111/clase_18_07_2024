import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Linea de conexion*/
        String url = "jdbc:mysql://localhost:3306/clase02";
        String usuario1 = "root";
        String contrasenia1 = "123456";
        /*Objeto de clase conexion*/
        Connection connection = null;
        /*Objeto de clase prepared....*/
        PreparedStatement consulta = null;
        /*Conectado*/
        try{
            connection=DriverManager.getConnection(url, usuario1, contrasenia1);
            /*Sentencia de actualización*/
            /*String consulta2 = "update estudiantePoo set b1 = ? where cedula = ?";
            consulta = connection.prepareStatement(consulta2);
            consulta.setDouble(1, 12.56);
            consulta.setString(2, "3989134597");*/
            /*Eliminar*/
            String consulta2 = "delete from estudiantePoo where cedula = ?";
            consulta = connection.prepareStatement(consulta2);
            consulta.setString(1, "0052717064");
            int intento = consulta.executeUpdate();
            if(intento>0){
                System.out.println("Se ha eliminado el estudiante");
            } else {
                System.out.println("No se ha eliminado el estudiante");
            }
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            /*Cerrar recursos*/
            try{
                if (consulta != null){
                    consulta.close();
                }
                if (connection != null){
                    connection.close();
                }

            }catch (SQLException exception2){
                System.out.println(exception2.getMessage());
            }
        }
    }
}