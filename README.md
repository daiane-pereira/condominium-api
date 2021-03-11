## Condominium-API
API Rest em Java, utilizando Spring Boot, com a finalidade de consultar permissões de usuários vinculados a um condomínio.

### Pré-requisitos:

**Instalações**:
- JDK: v.11
- Gradle: v.6.8.2

**Configuração da base de dados**:

Configurar no arquivo **application.yml**, a propriedade **path**, o caminho do arquivo texto que contem a base de dados, conforme exemplo abaixo.
```
file-database:
  path: C:\Users\Joao\Documents\database.txt
```

### Executar a aplicação:

Acessar a pasta do projeto e executar os seguintes comandos:

```
gradle build
gradle bootRun
```

### Serviços disponíveis:

**Consulta de permissões por e-mail**

Consulta todas as permissões do usuário em condomínios que ele esteja vinculado, a partir do seu e-mail.
- Método HTTP: GET
- Endpoint: {url}/user-permissions/email/{e-mail}
