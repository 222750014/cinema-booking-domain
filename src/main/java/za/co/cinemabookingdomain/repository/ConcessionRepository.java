package za.co.cinemabookingdomain.repository;

import za.co.cinemabookingdomain.domain.Concession;
import java.util.*;

public class ConcessionRepository implements IConcessionRepository {

    private static ConcessionRepository repository = null;
    private final Map<String, Concession> concessionDB;

    // Private constructor for singleton pattern
    private ConcessionRepository() {
        this.concessionDB = new HashMap<>();
    }

    // Singleton access method
    public static ConcessionRepository getRepository() {
        if (repository == null) {
            repository = new ConcessionRepository();
        }
        return repository;
    }

    @Override
    public Concession create(Concession concession) {
        if (concession != null) {
            concessionDB.put(concession.getId(), concession);
        }
        return concession;
    }

    @Override
    public Concession read(String id) {
        return concessionDB.get(id);
    }

    @Override
    public Concession update(Concession concession) {
        if (concession != null && concessionDB.containsKey(concession.getId())) {
            concessionDB.put(concession.getId(), concession);
        }
        return concession;
    }

    @Override
    public boolean delete(String id) {
        return concessionDB.remove(id) != null;
    }

    @Override
    public List<Concession> getAll() {
        return new ArrayList<>(concessionDB.values());
    }
}
