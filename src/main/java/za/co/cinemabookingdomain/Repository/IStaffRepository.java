package za.co.cinemabookingdomain.Repository;

import za.co.cinemabookingdomain.Domain.Staff;
import java.util.List;

public interface IStaffRepository {
    static IStaffRepository getRepository() {
        return IStaffRepository.getRepository();
    }

    Staff create(Staff staff);
    Staff read(String employeeId);
    Staff update(Staff staff);
    boolean delete(String employeeId);

    List<Staff> getAllStaff();
}
