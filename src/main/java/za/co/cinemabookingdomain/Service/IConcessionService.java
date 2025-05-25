package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Concession;
import java.util.List;

public interface IConcessionService {
    Concession create(Concession concession);
    Concession read(String id);
    Concession update(Concession concession);
    void delete(String id);
    List<Concession> getAll();
}
