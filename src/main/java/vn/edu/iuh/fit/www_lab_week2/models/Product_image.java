package vn.edu.iuh.fit.www_lab_week2.models;

public class Product_image {
    private long product_id;
    private String image_id;
    private String path;
    private String alternative;


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product_image() {
    }

    public Product_image(long product_id, String image_id, String path, String alternative) {
        this.product_id = product_id;
        this.image_id = image_id;
        this.path = path;
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "Product_image{" +
                "product_id=" + product_id +
                ", image_id='" + image_id + '\'' +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
