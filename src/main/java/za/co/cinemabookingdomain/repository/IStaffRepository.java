package za.co.cinemabookingdomain.repository;

import za.co.cinemabookingdomain.domain.Staff;
import java.util.List;

public interface IStaffRepository {
    Staff create(Staff staff);
    Staff read(String employeeId);
    Staff update(Staff staff);
    boolean delete(String employeeId);
    List<Staff> getAll();
}
