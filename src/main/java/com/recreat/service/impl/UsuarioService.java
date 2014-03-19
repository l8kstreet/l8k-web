/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.service.impl;

import com.mongodb.BasicDBObject;
import com.recreat.crypto.Crypto;
import com.recreat.service.IUsuarioService;
import com.recreat.type.UsuarioType;
import com.recreat.util.ConstanteCollections;
import com.recreat.util.MapUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaquise
 */
@Repository
public class UsuarioService implements IUsuarioService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UsuarioType> listar() throws Exception {
        return mongoTemplate.findAll(UsuarioType.class, ConstanteCollections.COLLECTION_USUARIO);
    }

    @Override
    public void insertar(UsuarioType usuario) throws Exception {
//        if (!mongoTemplate.collectionExists(UsuarioType.class)) {
//            mongoTemplate.createCollection(UsuarioType.class);
//        }

        if (validarUsuario(usuario)) {
            if (usuario.getContrasenha() != null) {
                usuario.setContrasenha(Crypto.getInstance().doEncrypt(usuario.getContrasenha()));
            }
            mongoTemplate.save(usuario, ConstanteCollections.COLLECTION_USUARIO);
        }
    }

    @Override
    public void actualizar(UsuarioType usuario) throws Exception {
        
        BasicDBObject newDocument = new BasicDBObject();
        if(usuario.getNombre() != null)
            newDocument.put("nombre", usuario.getNombre());        
        if(usuario.getCorreo() != null)
            newDocument.put("correo", usuario.getCorreo());        
        if(usuario.getUsuario() != null)
            newDocument.put("usuario", usuario.getUsuario());        
        if(usuario.getContrasenha() != null)
            newDocument.put("contrasenha", Crypto.getInstance().doEncrypt(usuario.getContrasenha()));        
        if(usuario.getFechaNacimiento() != null)
            newDocument.put("fechaNacimiento", usuario.getFechaNacimiento());        
        if(usuario.getPais() != null)
            newDocument.put("pais", usuario.getPais());        
        if(usuario.getEstado() != null)
            newDocument.put("estado", usuario.getEstado());
        
        ObjectId id = new ObjectId(usuario.getUsuarioId());
        Query query = query(where("_id").is(id));
        Update update = Update.fromDBObject(newDocument);

        mongoTemplate.updateFirst(query, update, ConstanteCollections.COLLECTION_USUARIO);
    }

    @Override
    public void eliminar(String usuarioId) throws Exception {
        ObjectId id = new ObjectId(usuarioId);
        Query query = query(where("_id").is(id));
        mongoTemplate.remove(query, ConstanteCollections.COLLECTION_USUARIO);
    }

    @Override
    public UsuarioType logearUsuario(String usuario, String contrasenha) throws Exception {
        contrasenha = Crypto.getInstance().doEncrypt(contrasenha);
        Query query = query(where("usuario").is(usuario).and("contrasenha").is(contrasenha));
        return mongoTemplate.findOne(query, UsuarioType.class, ConstanteCollections.COLLECTION_USUARIO);
    }

    private Boolean validarUsuario(UsuarioType usuario) {
        boolean result = true;

        if (usuario != null) {
            if (usuario.getNombre().isEmpty()) {
                result = false;
            }
            if (usuario.getCorreo().isEmpty()) {
                result = false;
            }
            if (usuario.getUsuario().isEmpty()) {
                result = false;
            }
            if (usuario.getContrasenha().isEmpty()) {
                result = false;
            }
            if (usuario.getEstado().toString().isEmpty()) {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
    
}
