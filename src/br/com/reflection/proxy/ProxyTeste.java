package br.com.reflection.proxy;

public class ProxyTeste {
  
  public static void main(String[] args) {
    ModelTesteProxy mp = new ModelTesteProxy();
    ModelTesteProxy proxyModel = (ModelTesteProxy) AsyncProxy.criarProxy(mp);
    
    System.out.println("Metodo chamado da classe real");
    mp.TestProxy();
    
    System.out.println("Metodo chamado da instancia pega no proxy dinamico");
    //proxyModel.TestProxy();
  }
}
