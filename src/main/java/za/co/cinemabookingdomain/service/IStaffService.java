package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Staff;
import java.util.List;

public interface IStaffService {
    Staff create(Staff staff);
    Staff read(String id);
    Staff update(Staff staff);
    void delete(String id);
    List<Staff> getAll();
}