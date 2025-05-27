package usecase;

import exception.ExceptionUsuarioExiste;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.ICrearUsuarioOutput;
import model.TIPOUSUARIO;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearUsuarioUseCaseTest {

    @Mock
    ICrearUsuarioOutput crearUsuarioOutput;

    @Test
    public void crearUsuarioNoExiste_crearUsuario() throws ExceptionUsuarioExiste {
        Usuario usuario = Usuario.crearUsuario(UUID.randomUUID(), "LEONARDO DI MARIA", "12345678", "Calle mayo 2030", TIPOUSUARIO.DOCTOR);

        CrearUsuarioUseCase crearUsuarioUseCase = new CrearUsuarioUseCase(crearUsuarioOutput);

        when(crearUsuarioOutput.exist(usuario)).thenReturn(false);
        when(crearUsuarioOutput.save(usuario)).thenReturn(true);

        boolean result = crearUsuarioUseCase.crearUsuario(usuario);

        Assertions.assertTrue(result);
    }

    @Test
    public void crearUsuarioExiste_NoCrearUsuario() throws ExceptionUsuarioExiste {
        Usuario usuario = Usuario.crearUsuario(UUID.randomUUID(), "LEONARDO DI MARIA", "12345678", "Calle mayo 2030", TIPOUSUARIO.DOCTOR);

        CrearUsuarioUseCase crearUsuarioUseCase = new CrearUsuarioUseCase(crearUsuarioOutput);

        when(crearUsuarioOutput.exist(usuario)).thenReturn(true);

        Assertions.assertThrows(ExceptionUsuarioExiste.class, () -> crearUsuarioUseCase.crearUsuario(usuario));
    }
}

