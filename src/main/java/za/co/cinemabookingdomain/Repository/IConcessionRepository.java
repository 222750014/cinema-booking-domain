// File: IConcessionRepository.java
package za.co.cinemabookingdomain.Repository;

import za.co.cinemabookingdomain.Domain.Concession;

import java.util.List;

public interface IConcessionRepository {
    Concession create(Concession concession);
    Concession read(String id);
    Concession update(Concession concession);
    boolean delete(String id);
    List<Concession> getAll();
}
