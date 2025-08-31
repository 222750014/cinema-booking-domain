package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Staff;
import za.co.cinemabookingdomain.service.IStaffService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements IStaffService {

    private final List<Staff> staffDatabase = new ArrayList<>();

    @Override
    public List<Staff> getAllStaff() {
        return staffDatabase;
    }

    @Override
    public Optional<Staff> getStaffById(String id) {
        return staffDatabase.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Staff addStaff(Staff staff) {
        staffDatabase.add(staff);
        return staff;
    }

    @Override
    public void deleteStaffById(String id) {
        staffDatabase.removeIf(s -> s.getId().equals(id));
    }
}
