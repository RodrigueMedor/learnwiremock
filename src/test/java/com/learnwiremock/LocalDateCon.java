//package com.learnwiremock;
//
//import cucumber.deps.com.thoughtworks.xstream.converters.Converter;
//import cucumber.deps.com.thoughtworks.xstream.converters.MarshallingContext;
//import cucumber.deps.com.thoughtworks.xstream.converters.UnmarshallingContext;
//import cucumber.deps.com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
//import cucumber.deps.com.thoughtworks.xstream.converters.reflection.SerializableConverter;
//import cucumber.deps.com.thoughtworks.xstream.core.ClassLoaderReference;
//import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamReader;
//import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class LocalDateCon extends SerializableConverter implements Converter {
//
//    public LocalDateCon(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference) {
//        super(mapper, reflectionProvider, classLoaderReference);
//    }
//
//    public boolean canConvert(Class type) {
//        //return type.equals(LocalDate.class);
//        return LocalDate.class.isAssignableFrom(type);
//    }
//
//    private static final String  DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
//    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
//
//    @Override
//    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
//        LocalDate  date = (LocalDate) value;
//        String result = date.format(DEFAULT_DATE_FORMATTER);
//        writer.setValue(result);
//    }
//
//    @Override
//    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
//        LocalDate result = LocalDate.parse(reader.getValue(), DEFAULT_DATE_FORMATTER);
//        return result;
//    }
//
//}
