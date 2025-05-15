
# Transações Simplificado

Uma API REST para realizar transações monetárias.Desenvolvido com Java e Spring Boot.




## Variáveis de Ambiente

Para rodar esta aplicação, você precisa de:

Java: JDK 21 ou superior.
Maven: Versão 3.0.0 ou superior.
Git: Para clonar o repositório.
Docker (opcional): Caso queira rodar a aplicação em um container.


##  Como Configurar o Projeto

1. Clone o Repositório

2. Compile o Projeto

```bash
 mvn clean install
```

3. Execute o Projeto

```bash
mvn spring-boot:run
```
4. Como Rodar em um Container (Opcional)

4.1. Crie a Imagem Docker
Certifique-se de que o Docker está instalado e execute:

```bash
docker build -t transacoes_simplificado 
```

4.2. Execute o Container

```bash
docker run -p 8080:8080 transacoes_simplificado
```

## Documentação da API

#### Receber Transações

```http
  POST /transfer
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `value` | `BigDecimal` | **Obrigatório**. O valor da transação 
| `payer` | `Long` | **Obrigatório**. Quem enviou o valor
| `payee` | `Long` | **Obrigatório**. Quem recebeu o valor


