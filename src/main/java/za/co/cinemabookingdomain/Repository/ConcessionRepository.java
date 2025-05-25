package za.co.cinemabookingdomain.Repository;

import za.co.cinemabookingdomain.Domain.Concession;

import java.util.*;

public class ConcessionRepository implements IConcessionRepository {

    private static ConcessionRepository repository = null;
    private final Map<String, Concession> concessionDB;

    private ConcessionRepository() {
        this.concessionDB = new HashMap<>();
    }

    public static ConcessionRepository getRepository() {
        if (repository == null)
            repository = new ConcessionRepository();
        return repository;
    }

    @Override
    public Concession create(Concession concession) {
        if (concession != null)
            concessionDB.put(concession.getId(id), concession);
        return concession;
    }

    @Override
    public Concession read(String id) {
        return concessionDB.get(id);
    }

    @Override
    public Concession update(Concession concession) {
        if (concession != null && concessionDB.containsKey(concession.getId(id)))
            concessionDB.put(concession.getId(id), concession);
        return concession;
    }

    @Override
    public boolean delete(String id) {
        return concessionDB.remove(id) != null;
    }

    @Override
    public List<Concession> getAll() {
        return new HashSet<>(concessionDB.values());
    }
}
