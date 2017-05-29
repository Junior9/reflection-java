package br.com.reflection;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import br.com.reflection.model.Produto;
import br.com.reflection.model.User;
import br.com.reflection.util.ReflectionUtil;

public class MethodReflection {
  
  private Method method;
  private ReflectionUtil util;
  private User user;
  private Produto produto;
  private Double valorDouble;
  private String valorString;
  
  @Before
  public void initTests(){
    this.util = new ReflectionUtil();
    this.method  = null;
    this.produto = new Produto(1,"geladeira",2000.0);
    this.user = new User("Francisco","fran@fran.com","senha1234");
  }
  
  @Test
  public void getMethodDescontoAtProduto() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    getValueDoubleAtMethod("getDesconto",produto);
    assertEquals(new Double(100.0) ,valorDouble);
  }
  
  @Test
  public void getMethodGetPrecoProduto() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    getValueDoubleAtMethod("getPreco",produto);
    assertEquals(new Double(2000.0),valorDouble);
  }
  
  @Test
  public void getMethodGetNomeUser() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    getValueStringAtMethod("getNome",user);
    assertEquals("Francisco",valorString);
  }

  
  private void getValueDoubleAtMethod(String nomeMethod,Object object)
    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    
    method =  util.getMethodByClass(Produto.class,nomeMethod);
    valorDouble = (Double) method.invoke(object);
  }
  
  private void getValueStringAtMethod(String nomeMethod,Object object)
    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    
    method =  util.getMethodByClass(User.class,nomeMethod);
    valorString  = (String) method.invoke(object);
  }
  
}
