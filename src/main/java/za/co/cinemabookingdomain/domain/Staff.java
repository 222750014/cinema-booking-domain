package za.co.cinemabookingdomain.domain;

public class Staff {

    private String id;
    private final String name;
    private final String role;
    private final String employeeId;

    private Staff(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.employeeId = builder.employeeId;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getEmployeeId() { return employeeId; }

    public void setId(String id) { this.id = id; }

    public static class Builder {
        private String id;
        private String name;
        private String role;
        private String employeeId;

        public Builder id(String id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setRole(String role) { this.role = role; return this; }
        public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
        public Builder copy(Staff staff) {
            this.id = staff.getId();
            this.name = staff.getName();
            this.role = staff.getRole();
            this.employeeId = staff.getEmployeeId();
            return this;
        }

        public Staff build() { return new Staff(this); }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
