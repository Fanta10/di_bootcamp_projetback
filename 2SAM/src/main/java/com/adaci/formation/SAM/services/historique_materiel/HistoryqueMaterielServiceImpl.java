package com.adaci.formation.SAM.services.historique_materiel;

import com.adaci.formation.SAM.models.Employe;
import com.adaci.formation.SAM.models.HistoriqueMateriel;
import com.adaci.formation.SAM.models.Materiel;
import com.adaci.formation.SAM.repository.HistoriqueMaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryqueMaterielServiceImpl implements HistoriqueMaterielService{
    @Autowired
    HistoriqueMaterielRepository historiqueMaterielRepository;
    @Override
    public List<HistoriqueMateriel> getAll() {
        return historiqueMaterielRepository.findAll();
    }

    @Override
    public HistoriqueMateriel create(HistoriqueMateriel historiqueMateriel) {
        return historiqueMaterielRepository.save(historiqueMateriel);
    }


    @Override
    public void delete(long id) {
        historiqueMaterielRepository.deleteById(id);

    }

    @Override
    public HistoriqueMateriel update(long id, HistoriqueMateriel historiqueMateriel) {
        return historiqueMaterielRepository.save(historiqueMateriel);
    }

    @Override
    public Optional<HistoriqueMateriel> getByEmploye(Employe employe) {
        return null;
    }

    @Override
    public Optional<HistoriqueMateriel> getByMateriel(Materiel materiel) {
        return historiqueMaterielRepository.findByMateriel(materiel);
    }

    @Override
    public int duree(Materiel mater) {
        Optional<HistoriqueMateriel> materiel = historiqueMaterielRepository.findByMateriel(mater);
        int duree_restante = 0;
        if (materiel.isPresent()){
            Date localDate = new Date();
            int year = localDate.getYear();
            int yeargiven = materiel.get().getMateriel().getDate_utilisation().getYear();

            duree_restante = year - yeargiven;
        }
        return duree_restante;
    }


}
