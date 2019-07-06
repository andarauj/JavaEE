/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.db;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import static org.eclipse.persistence.jpa.jpql.JPAVersion.value;

/**
 *
 * @author Andre
 */
@Converter(autoApply=true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate value) {
        return (value==null) ? null :
        Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return (value==null) ? null : Instant.ofEpochMilli(value.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
