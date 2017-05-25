package br.com.reflection.exemplo.elaborado.comReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import br.com.reflection.exemplo.anotacao.NomePropriedade;
import br.com.reflection.exemplo.model.Produto;
import br.com.reflection.exemplo.model.User;

/**
 * 
 * TODO
 * <p>
 * Copyright (c) 2017 <b>Pad<font color='rgb(239,121,16)'>tec</font></b>
 * @author tc.fjunior
 */

public class GeradorDeMapa {
  
  public static Map<String,Object> getMethodGet(Object obj){
    Map<String,Object> map = new HashMap<String,Object>();

    try {
      for(Method method: obj.getClass().getMethods()){
        if(isGetter(method)){
          String propriedade = deGetterParaPropriedade(method.getName());
            Object valor;
              valor = method.invoke(obj);
              map.put(propriedade, valor);
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return map;
  }

  public static Map<String,Object> getMethodGetByAnnotation(Object obj){
    Map<String,Object> map = new HashMap<String,Object>();

    try {
      String  annotationValue = "";
      for(Method method: obj.getClass().getMethods()){
        if(isGetter(method) && method.isAnnotationPresent(NomePropriedade.class)){
          annotationValue = method.getAnnotation(NomePropriedade.class).valor();
          Object valor;
          valor = method.invoke(obj);
          map.put(annotationValue, valor);
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return map;
  }
  
  private static boolean isGetter(Method m) {
    return m.getName().startsWith("get") &&
        m.getReturnType() != void.class &&
        m.getParameterTypes().length == 0;
  }
  
  private static String deGetterParaPropriedade(String nomeGetter){
    StringBuffer retorno = new StringBuffer();
    retorno.append(nomeGetter.substring(3, 4).toLowerCase());
    retorno.append(nomeGetter.substring(4));
    return retorno.toString();
  }
  
  private static void showProperties(Map<String,Object> map){
    for(String prop : map.keySet()){
      System.out.println(prop+" = "+map.get(prop));
    }
  }
  
  public static void main(String[] args) {
    User user = new User("Francisco","fran@fran.com","senha");
    Produto produto = new Produto(1,"Pasta de dente",1.55);
    
    //Exemplo usando annotation para pegar dados
    Map<String,Object> mapGetUser =  getMethodGetByAnnotation(user);
    
    //Exemplo sem annotation
    Map<String,Object> mapGetProduto = getMethodGet(produto);
    
    showProperties(mapGetUser);
    showProperties(mapGetProduto);
  }
}
