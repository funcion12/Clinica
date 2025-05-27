package usecase;

import exception.ExceptionInvalidoUsuario;
import input.IEliminarUsuarioInput;
import model.Usuario;
import output.ICrearUsuarioOutput;
import output.IEliminarUsuarioOutput;

public class EliminarUsuarioUseCase implements IEliminarUsuarioInput {

    private final IEliminarUsuarioOutput usuarioOutput;

    public EliminarUsuarioUseCase(IEliminarUsuarioOutput usuarioOutput) {
        this.usuarioOutput = usuarioOutput;
    }

    @Override
    public boolean deleteUsuario(Usuario usuario) throws ExceptionInvalidoUsuario {

        if(usuario == null) throw new ExceptionInvalidoUsuario("El usuario es nulo");

        return usuarioOutput.delete(usuario);
    }
}
