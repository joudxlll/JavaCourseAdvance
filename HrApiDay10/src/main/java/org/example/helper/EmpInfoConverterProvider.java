package org.example.helper;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import org.example.dto.EmpInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class EmpInfoConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.getName().equals(EmpInfo.class.getName())) {
            return new EmpInfoParamConverter();
        }
        return null;
    }

}
