package com.agenda.service;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contato;

import java.sql.SQLException;
import java.util.List;

public class AgendaTelefonica {

    private final ContactDAO dao = new ContactDAO();

    public void adicionarContato(Contato contato) throws SQLException {
        dao.create(contato);
    }

    public void removerContato(String nome) throws SQLException {
        dao.delete(nome);
    }

    public Contato buscarContato(String nome) throws SQLException {
        return dao.findByName(nome);
    }

    public List<Contato> listarContatos() throws SQLException {
        return dao.listAll();
    }

    public void atualizarContato(Contato contato) throws SQLException {
        dao.update(contato);
    }
}
