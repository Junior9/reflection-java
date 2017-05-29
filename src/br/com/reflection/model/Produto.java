package br.com.reflection.model;

public class Produto {
  
  private int id;
  private String nome;
  private Double preco;
    
  public Produto() {}
  
  public Produto(int id, String nome, Double preco) {
    super();
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public int getId() {
    return id;
  }
  public String getNome() {
    return nome;
  }
  public Double getPreco() {
    return preco;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setPreco(Double preco) {
    this.preco = preco;
  }
  
  public Double getDesconto(){
    return 100.0;
  }
}
