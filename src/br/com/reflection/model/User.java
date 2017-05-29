package br.com.reflection.model;

import br.com.reflection.exemplo.anotacao.ColunaJtable;
import br.com.reflection.exemplo.anotacao.NomePropriedade;

public class User {
  
  public String nome;
  private String email;
  private String senha;

  public User(){};
  
  public User(String nome, String email, String senha) {
    super();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }

  @NomePropriedade(valor="Nome do usuario:")
  @ColunaJtable(colNum=1)
  public String getNome() {
    return nome;
  }
  
  @NomePropriedade(valor="Email do usuario:")
  @ColunaJtable(colNum=2)
  public String getEmail() {
    return email;
  }
  
  @NomePropriedade(valor="Senha: ")
  @ColunaJtable(colNum=3)
  public String getSenha() {
    return senha;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
}
