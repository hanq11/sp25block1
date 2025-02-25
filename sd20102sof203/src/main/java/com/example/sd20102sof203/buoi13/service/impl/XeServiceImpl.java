package com.example.sd20102sof203.buoi13.service.impl;

import com.example.sd20102sof203.buoi13.model.Xe;
import com.example.sd20102sof203.buoi13.repository.XeRepository;
import com.example.sd20102sof203.buoi13.service.XeService;

import java.util.ArrayList;

public class XeServiceImpl implements XeService {
    XeRepository xeRepository = new XeRepository();

    @Override
    public ArrayList<Xe> getAll() {
        return xeRepository.getAll();
    }
}
