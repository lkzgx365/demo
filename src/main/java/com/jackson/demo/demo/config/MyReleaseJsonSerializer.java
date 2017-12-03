package com.jackson.demo.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;

public class MyReleaseJsonSerializer extends JsonSerializer<Object> {

    private BeanPropertyWriter beanPropertyWriter;

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if(o == null){
            BeanPropertyWriter writer = this.getBeanPropertyWriter();
            Class<?> propertyType = writer.getPropertyType();
            try {
                Class<?> aClass = Class.forName(propertyType.getName());
                Constructor<?> c = aClass.getDeclaredConstructor();
                int count = c.getParameterCount();
                Object[] params = new Object[count];
                if(count == 0){
                    Object o1 = c.newInstance();
                    jsonGenerator.writeObject(o1);
                }else{
                    Class<?>[] types = c.getParameterTypes();
                    for(int i = 0 ; i< types.length; i++) {
                        if (types[i] == int.class || types[i] == Integer.class ){
                            params[i] = new Integer(-1);
                        }else if (types[i] == double.class || types[i] == Double.class){
                            params[i] = new Double(0.00);
                        }else if (types[i] == char.class || types[i] == Character.class){
                            params[i] = '无';
                        }else if(types[i] == BigDecimal.class){
                            params[i] = new BigDecimal(0.00);
                        }else if (types[i] == String.class){
                            params[i] = "";
                        }
                    }
                    Object o1 = c.newInstance(params);
                    jsonGenerator.writeObject(o1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            jsonGenerator.writeObject(o);
        }
    }

    public BeanPropertyWriter getBeanPropertyWriter() {
        return beanPropertyWriter;
    }

    public void setBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        this.beanPropertyWriter = beanPropertyWriter;
    }
}

