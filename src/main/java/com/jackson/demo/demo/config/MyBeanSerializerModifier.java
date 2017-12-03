package com.jackson.demo.demo.config;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyBeanSerializerModifier extends BeanSerializerModifier {

    private JsonSerializer<Object> _nullArrayJsonSerializer = new MyNullArrayJsonSerializer();

    private JsonSerializer<Object> _nullStringJsonSerializer = new MyNullStringJsonSerializer();

    private JsonSerializer<Object> _nullMapJsonSerializer = new MyNullMapJsonSerializer();

    private JsonSerializer<Object> _nullDateJsonSerializer = new MyNullDateJsonSerializer();

    private MyReleaseJsonSerializer _nullReleaseJsonSerializer = new MyReleaseJsonSerializer();

    private JsonSerializer<Object> _nullIntegerJsonSerializer = new MyIntegerJsonSerializer();

    private JsonSerializer<Object> _nullDoubleJsonSerializer = new MyDoubleJsonSerializer();

    private JsonSerializer<Object> _nullBigDecimalJsonSerializer = new MyBigDecimalJsonSerializer();

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List<BeanPropertyWriter> beanProperties) {
        // 循环所有的beanPropertyWriter
        for (int i = 0; i < beanProperties.size(); i++) {
            BeanPropertyWriter writer = beanProperties.get(i);
            // 判断字段的类型，如果是array，list，set则注册nullSerializer
            if (isArrayType(writer)) {
                //给writer注册一个自己的nullSerializer
                writer.assignNullSerializer(this.defaultNullArrayJsonSerializer());
            }else if(isStringType(writer)){
                writer.assignNullSerializer(this.defaultNullStringJsonSerializer());
            }else if(isMapType(writer)){
                writer.assignNullSerializer(this.defaultNullMapJsonSerializer());
            }else if(isDateType(writer)){
                writer.assignNullSerializer(this.defaultNullDateJsonSerializer());
            }else if(isIntegerType(writer)){
                writer.assignNullSerializer(this.defaultNullIntegerJsonSerializer());
            }else if(isDoubleType(writer)){
                writer.assignNullSerializer(this.defaultNullDoubleJsonSerializer());
            }else if(isBigDecimalType(writer)) {
                writer.assignNullSerializer(this.defaultNullBigDecimalJsonSerializer());
            }else{
                writer.assignNullSerializer(this.defaultNullReleaseJsonSerializer(writer));
            }
        }
        return beanProperties;
    }

    protected boolean isBigDecimalType(BeanPropertyWriter writer) {
        Class<?> clz = writer.getPropertyType();
        return clz.equals(BigDecimal.class);
    }


    protected boolean isDoubleType(BeanPropertyWriter writer) {
        Class<?> clz = writer.getPropertyType();
        return clz.equals(Double.class);
    }

    protected boolean isIntegerType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getPropertyType();
        return clazz.equals(Integer.class);
    }

    // 判断是什么类型
    protected boolean isArrayType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getPropertyType();
        return clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class);
    }

    protected boolean isStringType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getPropertyType();
        return clazz.equals(String.class);
    }

    protected boolean isMapType(BeanPropertyWriter writer) {
        Class<?> clazz = writer.getPropertyType();
        return clazz.equals(Map.class);
    }

    protected boolean isDateType(BeanPropertyWriter writer){
        Class<?> clz = writer.getPropertyType();
        return clz.equals(Date.class);
    }

    protected JsonSerializer<Object> defaultNullArrayJsonSerializer() {
        return _nullArrayJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullStringJsonSerializer(){
        return _nullStringJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullMapJsonSerializer(){
        return _nullMapJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullDateJsonSerializer(){
        return _nullDateJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullReleaseJsonSerializer(BeanPropertyWriter writer){
        _nullReleaseJsonSerializer.setBeanPropertyWriter(writer);
        return _nullReleaseJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullDoubleJsonSerializer() {
        return _nullDoubleJsonSerializer;
    }

    protected JsonSerializer<Object> defaultNullIntegerJsonSerializer() {
        return _nullIntegerJsonSerializer;
    }

    private JsonSerializer<Object> defaultNullBigDecimalJsonSerializer() {
        return _nullBigDecimalJsonSerializer;
    }
}

