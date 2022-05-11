package ee.pw.edu.pl.Sprzedaze.converter;

import javax.persistence.AttributeConverter;

public class BooleanToIntConverter implements AttributeConverter<Boolean, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean value) {
        return (value != null && value) ? 1 : 2;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        return 1  == value;
    }
}
