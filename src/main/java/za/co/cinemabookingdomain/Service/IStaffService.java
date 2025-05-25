package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Staff;
import java.util.List;

public interface IStaffService {
    Staff create(Staff staff);
    Staff read(String id);
    Staff update(Staff staff);
    void delete(String id);

    List<Staff> getAllStaff(String id);

    List<Staff> getAll();
}
