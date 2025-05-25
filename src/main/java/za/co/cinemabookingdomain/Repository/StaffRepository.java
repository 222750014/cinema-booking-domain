package za.co.cinemabookingdomain.Repository;

import za.co.cinemabookingdomain.Domain.Staff;
import java.util.*;

public class StaffRepository implements IStaffRepository {

    private static StaffRepository repository = null;
    private final Map<String, Staff> staffDB;

    private StaffRepository() {
        this.staffDB = new HashMap<>();
    }

    public static StaffRepository getRepository() {
        if (repository == null) {
            repository = new StaffRepository();
        }
        return repository;
    }

    @Override
    public Staff create(Staff staff) {
        if (staff == null || staffDB.containsKey(staff.getEmployeeId())) {
            return null;
        }
        staffDB.put(staff.getEmployeeId(), staff);
        return staff;
    }

    @Override
    public Staff read(String employeeId) {
        return staffDB.get(employeeId);
    }

    @Override
    public Staff update(Staff staff) {
        if (staff == null || !staffDB.containsKey(staff.getEmployeeId())) {
            return null;
        }
        staffDB.put(staff.getEmployeeId(), staff);
        return staff;
    }

    @Override
    public boolean delete(String employeeId) {
        return staffDB.remove(employeeId) != null;
    }

    @Override
    public List<Staff> getAll() {
        return new ArrayList<>(staffDB.values());
    }
}
