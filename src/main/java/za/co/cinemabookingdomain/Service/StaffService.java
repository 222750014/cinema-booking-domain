package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Staff;
import za.co.cinemabookingdomain.Repository.IStaffRepository;

import java.util.List;

public class StaffService implements IStaffService {

    private static StaffService service;  // singleton instance should be StaffService type, not interface
    private final IStaffRepository repository;

    // Private constructor for singleton pattern
    private StaffService() {
        repository = IStaffRepository.getRepository(); // Make sure this method exists and returns a repository instance
    }

    public static StaffService getService() {
        if (service == null) {
            service = new StaffService();
        }
        return service;
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

    // I assume this method should return all Staff without needing an id parameter
    @Override
    public List<Staff> getAllStaff() {
        return repository.getAllStaff(); // Assuming the repository has this method
    }
}
