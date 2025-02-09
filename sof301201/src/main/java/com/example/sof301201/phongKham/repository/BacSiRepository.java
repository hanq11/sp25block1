package com.example.sof301201.phongKham.repository;

import com.example.sof301201.phongKham.model.BacSi;
import com.example.sof301201.phongKham.model.PhongKham;
import com.example.sof301201.phongKham.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public BacSi getOne(Integer id) {
        return session.find(BacSi.class, id);
    }

    public void update(BacSi bacSi) {
        try {
            session.getTransaction().begin();
            session.merge(bacSi);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<BacSi> search(String ten) {
        Query query = session.createQuery("FROM BacSi WHERE ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        return (List<BacSi>) query.list();
    }

    public List<BacSi> paging(int pageNo, int pageSize) {
        Query query = session.createQuery("From BacSi");
        query.setFirstResult(pageNo * pageSize);
        query.setMaxResults(pageSize);
        return (List<BacSi>) query.list();
    }
}
