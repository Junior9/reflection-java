package br.com.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AsyncProxy implements InvocationHandler {
  
  private Object obj;
  
  private AsyncProxy(Object obj) {
    this.obj = obj;
  }
  
  @Override
  public Object invoke(Object proxy, final Method method, final Object[] parameters) throws Throwable {

    Object result = null; 
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
      result= method.invoke(obj, parameters);
    }
    return result;
  }
  
  public static Object criarProxy(Object obj){
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), new AsyncProxy(obj));
  }

}