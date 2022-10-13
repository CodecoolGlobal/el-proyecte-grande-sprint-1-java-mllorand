package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.AffinityLabel;
import com.codecool.elproyectegrande.persistance.AffinityLabelDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffinityLabelService {
    AffinityLabelDAO affinityLabelDAO;

    public AffinityLabelService(AffinityLabelDAO affinityLabelDAO) {
        this.affinityLabelDAO = affinityLabelDAO;
    }

    public Iterable<AffinityLabel> findAll() {
        return affinityLabelDAO.findAll();
    }
}
