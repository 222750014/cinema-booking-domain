package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Concession;
import java.util.List;

public interface IConcessionService{
    Concession create(Concession concession);
    Concession read(String id);
    Concession update(Concession concession);
    void delete(String id);
    List<Concession> getAll();
}
