package com.example.sof301201.dieuHoa.repository;

import com.example.sof301201.dieuHoa.model.DieuHoa;
import com.example.sof301201.dieuHoa.model.LoaiDieuHoa;
import com.example.sof301201.dieuHoa.utils.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LoaiDieuHoaRepository {
    private Session session;

    public LoaiDieuHoaRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public LoaiDieuHoa getOne(Integer id) {
        return session.find(LoaiDieuHoa.class, id);
    }

    public List<LoaiDieuHoa> getAllLoaiDieuHoa() {
        return session.createQuery("FROM LoaiDieuHoa").list();
    }
}
