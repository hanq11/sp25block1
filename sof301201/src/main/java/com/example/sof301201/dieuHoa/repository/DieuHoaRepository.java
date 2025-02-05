package com.example.sof301201.dieuHoa.repository;

import com.example.sof301201.dieuHoa.model.DieuHoa;
import com.example.sof301201.dieuHoa.utils.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class DieuHoaRepository {
    private Session session;

    public DieuHoaRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public DieuHoa getOne(Integer id) {
        return session.find(DieuHoa.class, id);
    }

    public List<DieuHoa> getAll() {
        return session.createQuery("FROM DieuHoa").list();
    }

    public void them(DieuHoa dieuHoa) {
        try {
            session.getTransaction().begin();
            session.save(dieuHoa);
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void sua(DieuHoa dieuHoa) {
        try {
            session.getTransaction().begin();
            session.merge(dieuHoa);
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoa(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
