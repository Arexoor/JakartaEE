package com.elbers.Ue4.A4_Schichtarchitektur_entwickeln;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DatabaseService {
    private static DatabaseService instance;
    private EntityManager em;
    private EntityManagerFactory emf;

    private DatabaseService() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public static synchronized DatabaseService getInstance() {
        if(instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public synchronized void addDataModel(DataModelEntity entry) {
        if(entry == null) {
            System.out.println("Entry is empty!!");
            return;
        }

        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();
    }

    public List<DataModelEntity> readDataModelFromDatabase() {
        TypedQuery<DataModelEntity> query = em.createQuery("SELECT s FROM DataModelEntity s", DataModelEntity.class);
        List<DataModelEntity> dataModels = query.getResultList();
        return dataModels;
    }

    public void close() {
        em.close();
        emf.close();
        instance = null;
    }
}
