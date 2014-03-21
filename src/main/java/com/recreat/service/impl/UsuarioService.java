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
import java.util.List;
import javax.mail.internet.MimeMessage;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaquise
 */
@Repository
public class UsuarioService implements IUsuarioService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public List<UsuarioType> listar(UsuarioType usuario) throws Exception {
        
        Query query = new Query();// = query(where("_class").is(usuario.getClass()));
        
        if (usuario.getUsuarioId() != null) {
            ObjectId id = new ObjectId(usuario.getUsuarioId());
            query.addCriteria(where("_id").is(id));
        }
        if (usuario.getNombre() != null) {
            query.addCriteria(where("nombre").is(usuario.getNombre()));
        }
        if (usuario.getCorreo() != null) {
            query.addCriteria(where("correo").is(usuario.getCorreo()));
        }
        if (usuario.getUsuario() != null) {
            query.addCriteria(where("usuario").is(usuario.getUsuario()));
        }
        if (usuario.getFechaNacimiento() != null) {
            query.addCriteria(where("fechaNacimiento").is(usuario.getFechaNacimiento()));
        }
        if (usuario.getPais() != null) {
            query.addCriteria(where("pais").is(usuario.getPais()));
        }
        if (usuario.getEstado() != null) {
            query.addCriteria(where("estado").is(usuario.getEstado()));
        }
        
        return mongoTemplate.findAll(UsuarioType.class, ConstanteCollections.COLLECTION_USUARIO);
    }

    @Override
    public String insertar(UsuarioType usuario) throws Exception {
//        if (!mongoTemplate.collectionExists(UsuarioType.class)) {
//            mongoTemplate.createCollection(UsuarioType.class);
//        }

        if (usuario.getContrasenha() != null) {
            usuario.setContrasenha(Crypto.getInstance().doEncrypt(usuario.getContrasenha()));
        }
        mongoTemplate.save(usuario, ConstanteCollections.COLLECTION_USUARIO);
        return usuario.getUsuarioId();
    }

    @Override
    public void actualizar(UsuarioType usuario) throws Exception {

        BasicDBObject newDocument = new BasicDBObject();
        if (usuario.getNombre() != null) {
            newDocument.put("nombre", usuario.getNombre());
        }
        if (usuario.getCorreo() != null) {
            newDocument.put("correo", usuario.getCorreo());
        }
        if (usuario.getUsuario() != null) {
            newDocument.put("usuario", usuario.getUsuario());
        }
        if (usuario.getContrasenha() != null) {
            newDocument.put("contrasenha", Crypto.getInstance().doEncrypt(usuario.getContrasenha()));
        }
        if (usuario.getFechaNacimiento() != null) {
            newDocument.put("fechaNacimiento", usuario.getFechaNacimiento());
        }
        if (usuario.getPais() != null) {
            newDocument.put("pais", usuario.getPais());
        }
        if (usuario.getEstado() != null) {
            newDocument.put("estado", usuario.getEstado());
        }

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
    
    @Override
    public Boolean verificarUsuario(String usuario) throws Exception{
        Query query = query(where("usuario").is(usuario));
        Long result = mongoTemplate.count(query, ConstanteCollections.COLLECTION_USUARIO);
        
        if(result.intValue() > 0)
            return false;
        else
            return true;
    }

    @Override
    public void sendConfirmEmail(final UsuarioType usuario) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(usuario.getCorreo());
                message.setSubject("[l8kstreet] Verifique por favor su email '" + usuario.getCorreo() + "'");
                String url = String.format("http://192.168.5.141:8084/l8k-web/faces/login/confirm_verification/%s/%s", usuario.getUsuario(), usuario.getUsuarioId());
                String text = "<html>"
                        + "         <body>"
                        + "             <h3>Bienvenido a l8kstreet.</h3>"
                        + "             <p>Este correo electrónico se ha enviado de forma automática para confirmar la identidad del usuario que ha solicitado el registro en l8kstreet.</p>"
                        + "             <p>Para continuar con el registro y activar su cuenta en l8kstreet, pulsa el siguiente enlace para proceder con la confirmación.</p>"
                        + "             <p><a target='_blank' href='" + url + "'>" + url + "</a></p>"
                        + "             <p><small>(Si no es " + usuario.getUsuario() + " o no solicitó el registro en l8kstreet, por favor elimine este mensaje.)</small></p>"
                        + "         </body>"
                        + "    </html>";
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }
}
