package com.ebac.modulo35;

import com.ebac.modulo35.dto.Direccion;
import com.ebac.modulo35.dto.Usuario;
import com.ebac.modulo35.model.DireccionModel;
import com.ebac.modulo35.model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Contexto {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("coneccionLocalMySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UsuarioModel usuarioModel = new UsuarioModel(entityManager);

        // Crear usuario
        /*Usuario usuarioJuan = new Usuario();
        usuarioJuan.setNombre("Juan");
        usuarioJuan.setEdad(20);
        usuarioModel.guardar(usuarioJuan);

        // Obtener usuario
        Usuario usuario = usuarioModel.obtenerPorId(1);
        System.out.println("Usuario Juan: " + usuario);

        // Actualizar usuario
        usuario.setEdad(50);
        usuarioModel.actualizar(usuario);

        Usuario usuarioJuanActualizado = usuarioModel.obtenerPorId(1);
        System.out.println("Usuario Juan actualizado: " + usuarioJuanActualizado);*/

        /*Usuario usuario = usuarioModel.obtenerPorId(1);

        usuarioModel.eliminar(usuario);
        usuario = usuarioModel.obtenerPorId(1);
        System.out.println("Usuario Juan: " + usuario);*/

        //crearUsuarios(15, usuarioModel);

        usuarioModel.obtenerUsuarios()
                .forEach(System.out::println);

        DireccionModel direccionModel = new DireccionModel(entityManager);

        // Crear dirección
       /* Direccion direccionNueva = new Direccion();
        direccionNueva.setIdUsuario(1);
        direccionNueva.setCalle("Av. Reforma");
        direccionNueva.setNumero(123);
        direccionNueva.setEstado("CDMX");
        direccionModel.guardar(direccionNueva);


        Direccion direccion = direccionModel.obtenerPorId(1);
        System.out.println("Dirección: " + direccion);


        direccion.setEstado("Estado de México");
        direccion.setNumero(999);
        direccionModel.actualizar(direccion);


        Direccion direccionActualizada = direccionModel.obtenerPorId(1);
        System.out.println("Dirección actualizada: " + direccionActualizada);


        direccionModel.eliminar(direccion);
        direccion = direccionModel.obtenerPorId(1);
        System.out.println("Dirección después de eliminar: " + direccion);


        direccionModel.obtenerDirecciones()
                .forEach(System.out::println);*/

        // Cerrar la conexion
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void crearUsuarios(int num, UsuarioModel usuarioModel) {
        Usuario usuario;
        for (int i = 0; i < num; i++) {
            usuario = new Usuario();
            usuario.setNombre("Usuario-"+i);
            usuario.setEdad(20+i);

            usuarioModel.guardar(usuario);
        }
    }
}
