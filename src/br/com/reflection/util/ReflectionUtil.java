package br.com.reflection.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
  
  private Object obj = null;
  private Method method;
  
  /**
   * metodo retorna um Objct da classe passada por parametro, metodo utilizado para construtores simples sem parametros    * 
   * 
   * TODO
   * @param clazz
   * @return
   * @throws NoSuchMethodException
   * @throws SecurityException
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException
   */
  public Object getObjectByClassSampleConstructor(Class<?> clazz) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    Constructor<?> construtor =  clazz.getConstructor();
    obj = construtor.newInstance();
    
    if(obj.getClass() == clazz){
      return obj;
    }
    return null;
  }
  
  public Method getMethodByClass(Class<?> clazz, String  nomeMethod) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    method =clazz.getMethod(nomeMethod);
    
    if(method.getName().equals(nomeMethod))
      return method;
    
    return null;
  }

}
