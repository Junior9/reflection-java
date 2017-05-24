package br.com.reflection.exemplo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import br.com.reflection.model.User;

public class ExemploMethodAndField {
  
  /**
   * @param obj
   */
  public static Method[] getMethod(Object obj){
    Class<?> classe = obj.getClass();
    return classe.getMethods();
  }
  
  /**
   * @param obj
   */
  public static Field[] getFields(Object obj){
    Class<?> classe = obj.getClass();
    return classe.getFields();
  }
  
  /**
   * @param obj
   */
  public static void showAllMethod(Object obj){
    Method[] methodList = getMethod(obj);
    System.out.println("A classe " + obj.getClass().getName() +  " possui os seguintes metodos:");

    for(Method method: methodList)
      System.out.println("Nome do metodo:"+ method.getName());
  }
 
  /**
   * O metodo "getFields()" da classe Class retorna somente os atributos publicos do Object 
   * 
   * @param obj
   */
  public static void showAllFields(Object obj){
    Field[] fieldList = getFields(obj);

    System.out.println("A classe " + obj.getClass().getName() +  " possui os seguintes atributos:");
    for(Field field: fieldList)
      System.out.println("Nome do atributo:"+ field.getName());
  }
  
  public static void main(String[] args) {
     User user = new User();
     showAllMethod(user);
     showAllFields(user);
  }
  
}
