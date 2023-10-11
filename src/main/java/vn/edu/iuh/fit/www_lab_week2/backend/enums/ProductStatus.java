package vn.edu.iuh.fit.www_lab_week2.backend.enums;

public enum ProductStatus {
    ACTIVE(1),
    NO_ACTIVE(0),
    TERMINATED(-1);

    private int value;

    public int getValue() {
        return value;
    }

    ProductStatus(int value) {
        this.value = value;
    }
}
