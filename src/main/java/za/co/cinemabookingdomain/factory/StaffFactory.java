package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Staff;

public class StaffFactory {

    public static Staff createStaff(String name, String role, String employeeId) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name is required");
        if (role == null || role.isEmpty())
            throw new IllegalArgumentException("Role is required");
        if (employeeId == null || employeeId.isEmpty())
            throw new IllegalArgumentException("Employee ID is required");

        return new Staff.Builder()
                .setName(name)
                .setRole(role)
                .setEmployeeId(employeeId)
                .build();
    }
}
