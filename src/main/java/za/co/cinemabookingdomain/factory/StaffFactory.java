package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Staff;

public class StaffFactory {

    public static Staff createStaff(String name, String role, String employeeId) {
        return new Staff.Builder()
                .setName(name)
                .setRole(role)
                .setEmployeeId(employeeId)
                .build();
    }


}
