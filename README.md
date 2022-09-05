# Projeto Todo-List - TDD com Spring

<br />

<div align="center">
    <img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
</div>

<br /><br />

## Diagrama de Classes

```mermaid
classDiagram
class Tarefa {
  - id : Long
  - nome : String
  - descricao: String
  - responsavel: String
  - data: LocalDate
  - status: Boolean
  + findAll()
  + findById(Long id)
  + findAllByNome(String nome)
  + post(Tarefa tarefa)
  + put(Tarefa tarefa)
  + delete(Long id)
}
```
<br /><br />

# Referências

<br />

<a href="https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-introduction" target="_blank">Documentação Oficial do Spring Testing</a>

<a href="https://junit.org/junit5/" target="_blank">Página Oficial do JUnit5</a>

<a href="https://junit.org/junit5/docs/current/user-guide/" target="_blank">Documentação Oficial do JUnit 5</a>

<a href="https://www.h2database.com/html/main.html" target="_blank">Documentação Oficial do Banco de dados  H2</a>

<a href="https://gasparbarancelli.com/post/banco-de-dados-h2-com-spring-boot" target="_blank">Banco de dados H2 com Spring Boot</a>

