package usecase;

import exception.ExceptionUsuarioNoExiste;
import model.TIPOUSUARIO;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.IEliminarUsuarioOutput;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EliminarUsuaruioUseCaseTest {

    @Mock
    IEliminarUsuarioOutput eliminarUsuarioOutput;

    @InjectMocks
    EliminarUsuarioUseCase usuarioUseCase;

    @Test
    public void encontrarUsuario_EliminarUsuario() {
        Usuario usuario = Usuario.crearUsuario(UUID.randomUUID(), "LEONARDO DI MARIA", "12345678", "Calle mayo 2030", TIPOUSUARIO.DOCTOR);

        when(eliminarUsuarioOutput.delete(usuario)).thenReturn(true);

        boolean eliminarUsuario = usuarioUseCase.deleteUsuario(usuario);

        Assertions.assertTrue(eliminarUsuario);
        verify(eliminarUsuarioOutput).delete(usuario);


    }

    @Test
    public void eliminarUsuario_devuelveFalse() {
        Usuario usuario = Usuario.crearUsuario(UUID.randomUUID(), "Pedrito ", "13345238", "Castro y bazan 300", TIPOUSUARIO.PACIENTE);

        when(eliminarUsuarioOutput.delete(usuario)).thenReturn(false);

        boolean eliminarUsuario = usuarioUseCase.deleteUsuario(usuario);

        Assertions.assertFalse(eliminarUsuario);
        verify(eliminarUsuarioOutput).delete(usuario);


    }

    @Test
    public void eliminarUsuario_NoExisteUsuario() throws ExceptionUsuarioNoExiste {
        Usuario usuario = Usuario.crearUsuario(UUID.randomUUID(), "Pedrito Lopez", "13000238", "Castro y bazan 300", TIPOUSUARIO.PACIENTE);

        when(eliminarUsuarioOutput.delete(usuario)).thenThrow(new ExceptionUsuarioNoExiste("El usuario no existe"));

        assertThrows(ExceptionUsuarioNoExiste.class, () -> {
            usuarioUseCase.deleteUsuario(usuario);
        });
    }
}
