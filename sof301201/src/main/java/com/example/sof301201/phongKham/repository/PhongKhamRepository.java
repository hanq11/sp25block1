package com.example.sof301201.phongKham.repository;

import com.example.sof301201.phongKham.model.PhongKham;
import com.example.sof301201.phongKham.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhongKhamRepository {
    private Session session;

    public PhongKhamRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<PhongKham> getAll() {
        return session.createQuery("FROM PhongKham").list();
    }

    public PhongKham getOne(Integer id) {
        return session.find(PhongKham.class, id);
    }

    public void add(PhongKham phongKham) {
        try {
            session.getTransaction().begin();
            session.save(phongKham);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(PhongKham phongKham) {
        try {
            session.getTransaction().begin();
            session.merge(phongKham);
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
}
