package com.ebac.modulo36.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.Optional;

public class DireccionModel {

    private final MongoCollection<Document> collection;

    public DireccionModel(MongoDatabase database) {
        collection = database.getCollection("direccion");
    }

    public void guardar(Document document) {
        // Insertar el nuevo libro en la colección
        collection.insertOne(document);
    }

    public void obtener() {
        // Obtener todos los documentos (direccino) de la colección
        FindIterable<Document> direcciones = collection.find();

        // Mostrar los resultados
        for (Document direccion : direcciones) {
            ObjectId id = direccion.getObjectId("_id");
            int idUsuario = direccion.getInteger("idUsuario");
            String calle = direccion.getString("calle");
            int numero = direccion.getInteger("numero");
            String estado = direccion.getString("estado");
            System.out.println("Id: " + id + ", Id usuario: " + idUsuario + ", calle: " + calle + " , numero: " + numero + " , estado: " + estado) ;

            System.out.println(direccion);
        }
    }

    public Optional<Document> obtenerPorId(Document document) {
        // Obtener todos los documentos (direccion) que hagan match con el documento enviado
        Document direccion = collection.find(document).first();

        if (!Objects.isNull(direccion)) {
            // Mostrar los resultados
            System.out.println(direccion);
            return Optional.of(direccion);
        }

        return Optional.empty();
    }

    public void actualizar(Document documentoActual, Document documentoNuevo) {
        // Actualizar el libro que cumple con el filtro
        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if (updateResult.getModifiedCount() > 0) {
            System.out.println("Direccion actualizada con éxito.");
        } else {
            System.out.println("La direccion no fue encontrada.");
        }
    }

    public void eliminar(Document document) {
        // Eliminar la direccion que cumple con el filtro
        DeleteResult deleteResult = collection.deleteOne(document);

        if (deleteResult.getDeletedCount() > 0) {
            System.out.println("Direccion eliminada con éxito.");
        } else {
            System.out.println("La direccion no fue encontrada.");
        }
    }

}
