package br.com.reflection;

import static org.junit.Assert.assertTrue;
import java.lang.reflect.InvocationTargetException;
import org.junit.Before;
import org.junit.Test;
import br.com.reflection.model.Produto;
import br.com.reflection.model.User;
import br.com.reflection.util.ReflectionUtil;

public class ContructorReflection {

  private Object obj;
  private ReflectionUtil util;
  private Boolean boolResult;
  
  @Before
  public void initTests(){
    this.util = new ReflectionUtil();
    this.boolResult = Boolean.FALSE;
  }
  
  @Test
  public void carregaProdutoByReflection() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    obj = util.getObjectByClassSampleConstructor(Produto.class); 
    if(obj instanceof Produto)
      boolResult = Boolean.TRUE;
    assertTrue(boolResult);
  }
  
  @Test
  public void carregaUserByReflection() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    obj = util.getObjectByClassSampleConstructor(User.class); 
    if(obj instanceof User)
      boolResult = Boolean.TRUE;
    assertTrue(boolResult);
  }
}
