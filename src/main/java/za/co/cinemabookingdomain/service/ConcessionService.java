package za.co.cinemabookingdomain.service;

import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Concession;
import za.co.cinemabookingdomain.repository.ConcessionRepository;
import za.co.cinemabookingdomain.repository.IConcessionRepository;

import java.util.List;

@Service
public class ConcessionService implements IConcessionService {

    private final IConcessionRepository repository;

    // Constructor for Spring dependency injection
    public ConcessionService() {
        repository = ConcessionRepository.getRepository();
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
    public void delete(String id) {
        this.repository.delete(id);
    }
}