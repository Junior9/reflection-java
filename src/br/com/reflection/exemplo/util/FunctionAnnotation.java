package br.com.reflection.exemplo.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Util para a recuperação de informações de annotation TODO
 * <p>
 * Copyright (c) 2017 <b>Pad<font color='rgb(239,121,16)'>tec</font></b>
 * @author Francisco Carlos Moraes Junior
 *   */

public class FunctionAnnotation {

  public static Object getAnnotationByClassValue(Class<?> clazz, Annotation annotation) {
    Object value = null;
    if (clazz.isAnnotationPresent(annotation.getClass())) {
      value = clazz.getAnnotation(annotation.getClass());
    }
    return value;
  }

  public static List<Annotation> getAnnotationByMethodValue(Class<?> clazz, Class<? extends Annotation> annotation) {
    List<Annotation> values = new ArrayList<Annotation>();
    Method[] methods = clazz.getMethods();

    for (Method method : methods) {
      if (method.isAnnotationPresent(annotation)) {
        values.add(method.getAnnotation(annotation));
      }
    }
    return values;
  }

  public static List<Annotation> getAnnotationByFieldsValue(Class<?> clazz, Class<? extends Annotation> annotation) {
    List<Annotation> values = new ArrayList<Annotation>();
    Field[] fields = clazz.getFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(annotation)) {
        values.add(field.getAnnotation(annotation));
      }
    }
    return values;
  }

}
