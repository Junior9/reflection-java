package br.com.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AsyncProxy implements InvocationHandler {
  
  private Object obj;
  
  private AsyncProxy(Object obj) {
    this.obj = obj;
  }
  
  @Override
  public ModelTesteProxy invoke(Object proxy, final Method method, final Object[] parameters) throws Throwable {
    ModelTesteProxy result = null; 

    System.out.println("Invoking " + method.getName() + " with args " + Arrays.toString(parameters) + "... ");
    
    if(method.getReturnType() == void.class){
      new Thread(){
         public void run(){
           try {
            method.invoke(obj, parameters);
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (IllegalArgumentException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
         }
      }.start();
      return null;
    }else{
      result= (ModelTesteProxy) method.invoke(obj, parameters);
    }
    return result;
  }
  
  public static ModelTesteProxy criarProxy(ModelTesteProxy obj){
    return (ModelTesteProxy) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), new AsyncProxy(obj));
  }

}