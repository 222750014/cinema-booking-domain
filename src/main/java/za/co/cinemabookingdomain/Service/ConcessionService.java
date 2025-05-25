package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Concession;
import za.co.cinemabookingdomain.Repository.ConcessionRepository;
import za.co.cinemabookingdomain.Repository.IConcessionRepository;
import za.co.cinemabookingdomain.Service.IConcessionService;

import java.util.List;

public class ConcessionService implements IConcessionService {

    private static IConcessionService service;
    private final IConcessionRepository repository;

    // Set up a singleton by creating a constructor
    private ConcessionService() {
        repository = ConcessionRepository.getRepository();
    }

    public static IConcessionService getService() {
        if (service == null) {
            service = new ConcessionService();
        }
        return service;
    }

    @Override
    public Concession create(Concession concession) {
        return this.repository.create(concession);
    }

    @Override
    public Concession read(String id) {
        return this.repository.read(id);
    }

    @Override
    public List<Concession> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Concession update(Concession concession) {
        return this.repository.update(concession);
    }

    @Override
    public void delete(String id) {  // Change to String if the repository requires it
        this.repository.delete(id); // Ensure this matches the repository method
    }
}