package input;

import exception.ExceptionInvalidoUsuario;
import model.Usuario;

public interface IEliminarUsuarioInput {
    boolean deleteUsuario(Usuario usuario) throws ExceptionInvalidoUsuario;
}
