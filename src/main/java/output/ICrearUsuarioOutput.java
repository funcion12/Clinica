package output;

import model.Usuario;

public interface ICrearUsuarioOutput {
    boolean save(Usuario usuario);
    boolean exist(Usuario usuario);


}
