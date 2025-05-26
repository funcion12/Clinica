package output;

import model.Usuario;

public interface ICrearUsuarioOutput {
    boolean save(Usuario usuario);
    boolean delete(Usuario usuario);
    boolean update(Usuario usuario);
    boolean exist(Usuario usuario);
}
