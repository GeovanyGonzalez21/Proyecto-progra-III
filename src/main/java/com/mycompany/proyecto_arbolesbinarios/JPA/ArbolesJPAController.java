/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_arbolesbinarios.JPA;

import com.mycompany.proyecto_arbolesbinarios.EntityClases.ArbolEC;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ArbolesJPAController {
    private EntityManager entityManager;

    ArbolesJPAController() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nombre_de_tu_unidad_de_persistencia");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertarArbol(ArbolEC arbol) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(arbol);
        transaction.commit();
    }

    public ArbolEC buscarArbolPorId(int id) {
        return entityManager.find(ArbolEC.class, id);
    }

    public void actualizarArbol(ArbolEC arbol) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(arbol);
        transaction.commit();
    }

    public void eliminarArbol(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ArbolEC arbol = entityManager.find(ArbolEC.class, id);
        if (arbol != null) {
            entityManager.remove(arbol);
        }
        transaction.commit();
    }

    public List<ArbolEC> obtenerTodosLosArboles() {
        return entityManager.createQuery("SELECT a FROM Arbol a", ArbolEC.class).getResultList();
    }
}