package vn.edu.iuh.fit.www_lab_week2.backend.enums;

public enum ProductStatus {
    ACTICE(1),
    NOACTIVE(0),
    TERMINATED(-1);

    private int value;

    public int getValue() {
        return value;
    }

    ProductStatus(int value) {
        this.value = value;
    }
}
