package com.ebac.modulo36;

import com.ebac.modulo36.model.DireccionModel;
import com.ebac.modulo36.model.UsuarioModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class Contexto {

    public static void main(String[] args) {
        String connectionString = "mongodb://root:toor@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("modulo60");

        UsuarioModel usuarioModel = new UsuarioModel(database);
        DireccionModel direccionModel = new DireccionModel(database);

        // Crear un usuario
        /*Document document = new Document("nombre", "Isaac")
                .append("edad", 31)
                .append("profesion", "Programador Java");
        usuarioModel.guardar(document);*/

        // Crear direccion
       /* Document document = new Document("idUsuario", 1)
                .append("calle", "Reforma")
                .append("numero", 1234)
                .append("estado","CDMX");
        direccionModel.guardar(document);*/

        // Listar
        // usuarioModel.obtener();
        // direccionModel.obtener();

        // Listar usuairo por id
        ObjectId objectId = new ObjectId("64b9d18405148c2056cf6f2b");
        Document documentoABuscar = new Document("_id", objectId);
        Optional<Document> usuarioEncontrado = usuarioModel.obtenerPorId(documentoABuscar);

        // Listar direccion por id
        ObjectId objectIdDireccion = new ObjectId("68127f4772345f1482d1fe45");
        Document documentoABuscarDireccion = new Document("_id", objectIdDireccion);
        Optional<Document> direccionEncontrada = direccionModel.obtenerPorId(documentoABuscarDireccion);

        // Actualizar usuario
        /*usuarioEncontrado.ifPresent(usuarioActual -> {
            Document document = new Document("nombre", "PedroActualizado").append("edad", 20);
            Document usuarioActualizado = new Document("$set", document);

            usuarioModel.actualizar(usuarioActual, usuarioActualizado);
        });
        usuarioModel.obtener();*/

        // Actualizar direccion
            direccionEncontrada.ifPresent(direccionActual -> {
            Document filtro = new Document("_id", direccionActual.getObjectId("_id"));
            Document document = new Document("idUsuario", 1)
                    .append("calle", "Reforma")
                    .append("numero", 1000)
                    .append("estado","CDMX");
            Document direccionActualizada = new Document("$set", document);
            direccionModel.actualizar(filtro, direccionActualizada);

            });

        direccionModel.obtener();

        // Eliminar usuario
        /*usuarioModel.obtener();
        usuarioEncontrado.ifPresent(usuarioModel::eliminar);
        usuarioModel.obtener();*/
    }
}
