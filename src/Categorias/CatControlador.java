package Categorias;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CatControlador {
    private FrmCategorias vista;

    public CatControlador(FrmCategorias vista) {
        this.vista = vista;
    }
    
    public void add (Categoria cat) {
        DAOCategoria dao = new DAOCategoria();
        if (dao.buscar(cat.getNombre())==null){
            DTOCategoria dto = new DTOCategoria(cat.getId(),cat.getNombre());
            int id = dao.insert(dto);
            cat.setId(id);
            vista.cargarDatos(cat);
            vista.notificar("Se agregó",JOptionPane.INFORMATION_MESSAGE);
            this.cargarTodo();
        }else{
            vista.notificar("No se agregó",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarTodo() {
        DAOCategoria dao = new DAOCategoria();
        ArrayList array = dao.readAll();
        if (array!=null){
            vista.mostrarTodo(array);
        }
    }
    
}
