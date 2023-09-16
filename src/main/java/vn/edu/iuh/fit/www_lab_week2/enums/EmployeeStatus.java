package vn.edu.iuh.fit.www_lab_week2.enums;

public enum EmployeeStatus {
    ACTICE(1),
    NOACTIVE(0),
    TERMINATED(-1);

    private int value;

    public int getValue() {
        return value;
    }

    EmployeeStatus(int value) {
        this.value = value;
    }
}
