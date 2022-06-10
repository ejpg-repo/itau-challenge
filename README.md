# Untitled WS - validação de senha
---

Para executar o projeto, é necessário o Java 11 e Apache Maven.

Na raiz do projeto, com uma linha de comando do linux, windows, ou mac, execute 
o comando: mvn spring-boot:run.

A aplicação irá inicializar na porta 8010, certifique-se de que ela não esteja
em uso por outra aplicação.

Após a inicialização, a documentação da API pode ser lida em: http://localhost:8010/swagger-ui/index.html

---

Descrição da solução de validação de senha: Para a validação foi utilizada a expressão regular

> ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+_])(?:([0-9a-zA-Z!@#$%^&*()-+_])(?!\\1)){9,}$

Onde:
(?=.*[0-9]) ao menos um digito
(?=.*[a-z]) ao menos uma letra minuscula
(?=.*[A-Z]) ao menos uma letra maiuscula
(?=.*[!@#$%^&*()-+_]) ao menos um caracter especial
(?:([0-9a-zA-Z!@#$%^&*()-+_])(?!\1)) grupo de não captura
{9,} limitador de quantidade de caracter

---

Cobertura e abrangência de testes: foram testados a funcionalidade do recurso solicitado a implementação (teste de unidade), e o tratamento de resposta pela exposição do endpoint (teste de integração).

---

Tecnologias utilizadas no projeto: Java SE 11, Apache Maven, Spring Boot, Spring WebMvc, Swagger, JUnit 5, Spring Test Framework, AssertJ.

