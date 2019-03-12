package com.app.system.util;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanMapper extends ConfigurableMapper {

    @Override
    public <S, T> List<T> mapAsList(Iterable<S> source, Class<T> targetClass) {
        return super.mapAsList(source, targetClass);
    }

}
