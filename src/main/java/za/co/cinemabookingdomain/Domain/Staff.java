
package za.co.cinemabookingdomain.Domain;

public class Staff {

    private final String name;
    private final String role;
    private final String employeeId;

    private Staff(Builder builder) {
        this.name = builder.name;
        this.role = builder.role;
        this.employeeId = builder.employeeId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public static class Builder {
        private String name;
        private String role;
        private String employeeId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public Builder copy(Staff staff) {
            this.name = staff.getName();
            this.role = staff.getRole();
            this.employeeId = staff.getEmployeeId();
            return this;
        }

        public Staff build() {

            return new Staff(this);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
