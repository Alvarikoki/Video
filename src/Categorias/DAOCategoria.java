package Categorias;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategoria {
    
    public int insert(DTOCategoria cat) {
        DaoBD bd = new DaoBD();
        bd.createStatement("Insert into categoria values(null,?)");
        bd.set(1, cat.getNombre());
        bd.execute(false);
        try {
            if (bd.getData().next()){
                int id = bd.getData().getInt(1);
                return id;
            }else{
                return 0;
            }
        } catch (SQLException ex) {
            return 0;
        }
    }
    
    public DTOCategoria buscar(String nombre) {
        DaoBD bd = new DaoBD();
        bd.createStatement("Select * from categoria where nombre=?");
        bd.set(1, nombre);
        bd.execute(true);
        try {
            if (bd.getData().next()){
                int id = bd.getData().getInt(1);
                String name = bd.getData().getString(2);
                return new DTOCategoria(id,name);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ArrayList readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("Select * from categoria");
        bd.execute(true);
        ArrayList<DTOCategoria> array = new ArrayList();
        try {
            while (bd.getData().next()){
                int id = bd.getData().getInt(1);
                String name = bd.getData().getString(2);
                DTOCategoria dto = new DTOCategoria(id,name);
                array.add(dto);
            }
            return array;
        } catch (SQLException ex) {
            return null;
        }

    }
}
