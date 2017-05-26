package br.com.reflection.exemplo.basico;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import br.com.reflection.exemplo.anotacao.NomePropriedade;
import br.com.reflection.exemplo.model.User;
import br.com.reflection.exemplo.util.FunctionAnnotation;

public class ExemploMethodAndField {
  
  /**
   * Será retornado os metodos do obj passado como parametro 
   * 
   * @param obj
   */
  public static Method[] getMethod(Object obj){
    Class<?> classe = obj.getClass();
    return classe.getDeclaredMethods();
  }
  
  /**
   * Será retornado os atributos publicos do obj passado como parametro 
   * 
   * @param obj
   */
  public static Field[] getPublicAtributes(Object obj){
    Class<?> classe = obj.getClass();
    return classe.getFields();
  }
  
  /**
   * 
   * 
   * @param obj
   */
  public static Field[] getAllAtributes(Object obj){
    Class<?> classe = obj.getClass();
    return classe.getDeclaredFields();
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
   * 
   * TODO
   * @param clazz
   * @param annotation
   */
  
  public static void getAnnotationByMethod(Class<?> clazz, Class<? extends Annotation> annotation){
    List<Annotation> list = FunctionAnnotation.getAnnotationByMethodValue(clazz,NomePropriedade.class);
    NomePropriedade nome;
    for(Annotation annotationMethod: list){
      nome = (NomePropriedade)annotationMethod;
      System.out.println("Valor da annotation : " + nome);
    }
  }
  
  
  
  public static void getAnnotationByField(Class<?> clazz, Class<? extends Annotation> annotation){
    List<Annotation> list = FunctionAnnotation.getAnnotationByFieldsValue(clazz,NomePropriedade.class);
    NomePropriedade nome;
    for(Annotation annotationMethod: list){
      nome = (NomePropriedade)annotationMethod;
      System.out.println("Valor da annotation : " + nome);
    }
  }
  
  /**
   * O metodo "getFields()" da classe Class retorna somente os atributos publicos do Object 
   * 
   * @param obj
   */
  public static void showAllPublicAtributes(Object obj){
    Field[] fieldList = getPublicAtributes(obj);

    System.out.println("A classe " + obj.getClass().getName() +  " possui os seguintes atributos:");
    for(Field field: fieldList)
      System.out.println("Nome do atributo:"+ field.getName());
  }
  
   /**
    * 
    * TODO
    * @param args
    */
  public static void showAllAtributes(Object obj){
    Field[] fieldList = getAllAtributes(obj);

    System.out.println("A classe " + obj.getClass().getName() +  " possui os seguintes atributos:");
    for(Field field: fieldList)
      System.out.println("Nome do atributo:"+ field.getName());
  }
  
  public static void main(String[] args) {
    
    User user = new User();
    System.out.println("Show all methods");
    showAllMethod(user);
    System.out.println("Show publics methods");
    showAllPublicAtributes(user);
    System.out.println("Show all methods od class");
    showAllAtributes(user);
    System.out.println("Valor das annotation dos metodos");
    getAnnotationByMethod(user.getClass(),NomePropriedade.class);
    
    
  }
}
