package za.co.cinemabookingdomain.repository;

import org.springframework.stereotype.Repository;
import za.co.cinemabookingdomain.domain.Staff;

import java.util.*;

@Repository
public class StaffRepository implements IStaffRepository {

    private final Map<String, Staff> staffDB = new HashMap<>();

    @Override
    public Staff create(Staff staff) {
        if (staff == null || staffDB.containsKey(staff.getEmployeeId())) return null;
        staffDB.put(staff.getEmployeeId(), staff);
        return staff;
    }

    @Override
    public Staff read(String employeeId) {
        return staffDB.get(employeeId);
    }

    @Override
    public Staff update(Staff staff) {
        if (staff == null || !staffDB.containsKey(staff.getEmployeeId())) return null;
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
