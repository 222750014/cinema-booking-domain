package za.co.cinemabookingdomain.service;
import za.co.cinemabookingdomain.domain.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(String id);
    Staff addStaff(Staff staff);
    void deleteStaffById(String id);
}
