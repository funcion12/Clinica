package usecase;

import exception.ExceptionInvalidoUsuario;
import exception.ExceptionUsuarioExiste;
import input.ICrearUsuarioInput;
import model.Usuario;
import output.ICrearUsuarioOutput;

public class CrearUsuarioUseCase implements ICrearUsuarioInput {

    private final ICrearUsuarioOutput usuarioOutput;

    public CrearUsuarioUseCase(ICrearUsuarioOutput usuarioOutput) {
        this.usuarioOutput = usuarioOutput;
    }

    @Override
    public boolean crearUsuario(Usuario usuario) throws ExceptionInvalidoUsuario, ExceptionUsuarioExiste {
        if(usuario == null) throw new ExceptionInvalidoUsuario("El usuario es nulo");
        if(usuarioOutput.exist(usuario)) throw new ExceptionUsuarioExiste("El usuario ya existe");

        return usuarioOutput.save(usuario);
    }

}
