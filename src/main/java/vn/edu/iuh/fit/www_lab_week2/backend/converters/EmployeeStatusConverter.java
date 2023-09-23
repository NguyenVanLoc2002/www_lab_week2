package vn.edu.iuh.fit.www_lab_week2.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;

import java.util.stream.Stream;

//Tự động chuyển  đổi  đối với bất kì phương thucws nào  gọi EmployeeStatus
@Converter(autoApply = true )
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {

    //Chuyển đổi  thành integer để lưu vào CSDL
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.getValue();
    }

    //Chuyển  đổi CSDL thành kiểu Enum
    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null){
            return null;
        }
        return Stream.of(EmployeeStatus.values())
                .filter(c-> c.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
