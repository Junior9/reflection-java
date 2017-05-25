package br.com.reflection.exemplo.basico;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import br.com.reflection.exemplo.anotacao.ColunaJtable;
import br.com.reflection.exemplo.model.User;

public class ExemploAnnotation {
  
  /**
   * @param obj
   * @throws SecurityException 
   * @throws NoSuchMethodException 
   * @throws InvocationTargetException 
   * @throws IllegalArgumentException 
   * @throws IllegalAccessException 
   */
  public static void getMethodByAnnotation(Object obj,Class<? extends Annotation> annotationClass,String nomeMethod) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    Class<?> classe = obj.getClass();
    Method[] methods = classe.getMethods();
    
    for(Method method: methods){
      if(method.isAnnotationPresent(annotationClass)){
        Annotation annotation = method.getAnnotation(annotationClass);
        System.out.println("O metodo: "+method.getName() + " tera seu valor na coluna: " + annotation.toString());
      }
    }
  }
  
  public static void main(String[] args) {
    User user = new User();
    try {
      getMethodByAnnotation(user,ColunaJtable.class,"colNum");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}