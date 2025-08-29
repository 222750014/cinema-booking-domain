package za.co.cinemabookingdomain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Staff;
import za.co.cinemabookingdomain.repository.IStaffRepository;

import java.util.List;

@Service
public class StaffService implements IStaffService {

    private final IStaffRepository repository;

    @Autowired
    public StaffService(IStaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Staff create(Staff staff) {
        return repository.create(staff);
    }

    @Override
    public Staff read(String id) {
        return repository.read(id);
    }

    @Override
    public Staff update(Staff staff) {
        return repository.update(staff);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<Staff> getAll() {
        return repository.getAll();
    }
}
