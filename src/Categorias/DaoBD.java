package Categorias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoBD {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;

    public DaoBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
        } catch (ClassNotFoundException ex) {
                  System.out.println("Error al  cargar el driver");
//            Logger.getLogger(DaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void connect(){
        try {
            this.connection=DriverManager.getConnection("jdbc:mysql://localhost/video", "java","123");
        } catch (SQLException ex) {
            System.out.println("Error al conectar  "+ ex.toString());
            //Logger.getLogger(DaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void createStatement(String sql){
        try {
            this.statement=(PreparedStatement) this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("error al ejecutar la sentencia"+ ex.toString());
            //Logger.getLogger(DaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void set(int index, Object param){
        try{
            this.statement.setObject(index, param);
        }catch (SQLException ex){
            System.out.println("error al aggregar parametro" + ex.toString());
        }
    }
    public boolean execute (boolean result){
        if(result){
            try {
                this.resultset=this.statement.executeQuery();
                return true; 
            } catch (SQLException ex) {
                System.out.println("error al ejecutar" + ex.toString());
                return false;
            }
        }else{
            try {
                int cont = this.statement.executeUpdate();
                this.resultset = statement.getGeneratedKeys();
                return cont>0;
            } catch (SQLException ex) {
                    System.out.println("error al ejecutar" + ex.toString());
                return false;
            }
        }
    }
    public ResultSet getData(){
      return  this.resultset;
    }
    
}
