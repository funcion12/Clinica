package input;

import exception.ExceptionInvalidoUsuario;
import exception.ExceptionUsuarioExiste;
import model.Usuario;

public interface ICrearUsuarioInput{
    boolean crearUsuario(Usuario usuario) throws ExceptionInvalidoUsuario, ExceptionUsuarioExiste;

    }
