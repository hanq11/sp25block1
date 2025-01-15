package com.example.sof301201.phongKham.repository;

import com.example.sof301201.phongKham.model.BacSi;
import com.example.sof301201.phongKham.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class BacSiRepository {
    private Session session;

    public BacSiRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<BacSi> getAll() {
        return session.createQuery("FROM BacSi").list();
    }

    public void add(BacSi bacSi) {
        try {
            session.getTransaction().begin();
            session.save(bacSi);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
