package vn.edu.iuh.fit.www_lab_week2.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.ProductStatus;

import java.util.stream.Stream;
@Converter(autoApply = true )
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

    //Chuyển đổi  thành integer để lưu vào CSDL
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.getValue();
    }

    //Chuyển  đổi CSDL thành kiểu Enum
    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null){
            return null;
        }
        return Stream.of(ProductStatus.values())
                .filter(c-> c.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
