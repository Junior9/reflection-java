package br.com.reflection.exemplo.basico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploHierarquiaClass {
  
  public static void hierarquia(String nomeClass,int nivel){
    String espaco = "";
    try {
      Class<?> classe = Class.forName(nomeClass);
      List<Class<?>> listParentClass = getSuperclasseEInterfaces(classe);
      
      for(int x=0;x<nivel;x++)
        espaco +=" ";
      
      for(Class<?>classeParente: listParentClass){
        System.out.println(espaco+"->"+classeParente.getName());
        
        if(classeParente != Object.class)
          hierarquia(classeParente.getName(), nivel+1);
      }
    } catch (ClassNotFoundException e) {
       System.out.println("Classe nao encontrada:" + nomeClass);
       System.out.println("Erro:" + e.getMessage());
      e.printStackTrace();
    }
  }

  private static List<Class<?>> getSuperclasseEInterfaces(Class<?> classe){
    List<Class<?>> lista = new ArrayList<>();
    //Add classe pai
    if(classe.getSuperclass() != null)
      lista.add(classe.getSuperclass());
    //Pega todas as interfaces implementa pela class
    lista.addAll(Arrays.asList(classe.getInterfaces()));
    return lista;
  }
  
  public static void main(String[] args) {
    hierarquia(ArrayList.class.getName(),0);
  }
  
}
