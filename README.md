# IBM Shop - Backend
## User API

---

## Sumário
1. [Modelo de Banco de Dados](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#modelo-de-banco-de-dados)
2. [Consulta](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#consulta)
   - [Cenário 1: Consulta por id](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cen%C3%A1rio-1-consulta-por-id)
   - [Cenário 2: Consulta por CPF](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cen%C3%A1rio-2-consulta-por-cpf)
   - [Cenário 3: Consulta por nome](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cen%C3%A1rio-3-consulta-por-nome)
3. [Manutenção](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#manuten%C3%A7%C3%A3o)
   - [Cenário 1: Cadastrar usuário](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cen%C3%A1rio--1-cadastrar-usu%C3%A1rio)
   - [Cenário 2: Editar usuário](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cenario-2-editar-usu%C3%A1rio)
   - [Cenário 3: Excluir usuário](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cenario-3-excluir-usu%C3%A1rio)
   - [Cenário 4: Reativar usuário](https://github.ibm.com/Caio-Figueiredo-de-Souza/ibmshop-backend-user-api#cen%C3%A1rio-4-reativar-usu%C3%A1rio)

---

## Modelo de Banco de Dados
Aqui vocês podem encontrar todas as entidades do banco de dados, seus atributos e os seus relacionamentos.
<!-- <img src="./readme-files/diagrama_db.png" /> -->
![Diagrama do banco de dados](./readme-files/diagrama_db.png)

---

## Consulta

### Estória
>  **Eu, como** Micro Serviço de Usuário do Sistema de E-commerce IBM,
>
>  **Quero** consultar um usuário e obter todos os dados no sistema IBM Shop.

---

### Cenários

#### **Cenário 1:** Consulta por Id

**O usuário informa um id existente de um usuário ativo no sistema.**
   - Retorna os seguintes dados da entidade Usuario:
    
      | Campo            | Valor esperado                |
      | ---------------- | ----------------------------- |
      | id_usuario       | Id da tabela (autoincremento) |
      | nome             | Nome do usuário               |
      | sobrenome        | Sobrenome do usuário          |
      | telefone         | Telefone do usuário           |
      | cpf              | CPF do usuário                |
      | data_criacao     | Data da criação do usuário    |
      | data_modificacao | Data de update do usuário     |

**O usuário informa um id inexistente ou o id de um usuário inativo no sistema.**
   - Retorna uma mensagem: _“Desculpe, não foi possível encontrar um usuário com este id. Verifique e tente novamente.”_

---

#### **Cenário 2:** Consulta por CPF

**O usuário informa um CPF existente e válido de um usuário ativo no sistema.**
   - Retorna os seguintes dados da entidade Usuario:

      | Campo            | Valor esperado                |
      | ---------------- | ----------------------------- |
      | id_usuario       | Id da tabela (autoincremento) |
      | nome             | Nome do usuário               |
      | sobrenome        | Sobrenome do usuário          |
      | telefone         | Telefone do usuário           |
      | cpf              | CPF do usuário                |
      | data_criacao     | Data da criação do usuário    |
      | data_modificacao | Data de update do usuário     |

**O usuário informa um CPF inexistente ou o CPF de um usuário inativo no sistema.**
   - Retorna uma mensagem: _“Desculpe, não foi possível encontrar um usuário com este cpf. Verifique e tente novamente.”_

**O usuário informa um CPF em um formato inválido.**
   - Retorna uma mensagem: _“Desculpe, não foi possível realizar a busca por CPF. O CPF não foi digitado corretamente. Verifique e tente novamente.”_

      | Exemplo de **formato** válido de CPF |
      |:-----------------------------------: |
      |           123.456.789-10             |

**O usuário não informa um CPF.**
   - Retorna uma mensagem: _“Desculpe, não foi possível realizar a busca por CPF. Digite um CPF e tente novamente.”_

---

### **Cenário 3:** Consulta por nome
**O usuário informa um nome existente e válido.**
   - Retorna os seguintes dados da entidade Usuario, para **todos** os registros encontrados de usuários que estão ativos no sistema:

      | Campo            | Valor esperado               |
      |------------------|------------------------------|
      | id_usuario       | ID da tabela (autoincremento)|
      | nome             | Nome do usuário              |
      | sobrenome        | Sobrenome do usuário         |
      | telefone         | Telefone do usuário          |
      | cpf              | CPF do usuário               |
      | data_criacao     | Data da criação do usuário   |
      | data_modificacao | Data de update do usuário    |   

**O usuário informa um nome inexistente.**
   - Retorna uma mensagem: _“Não foi possível encontrar um usuário com este nome. Verifique e tente novamente.”_

**O usuário informa um nome com menos de 2 caracteres.**
   - Retorna uma mensagem: _“Desculpe, não foi possível realizar a busca por nome. O nome informado deve ter, pelo menos, 2 caracteres."_

**O usuário não informa um nome**
   - Retorna uma mensagem: _“Desculpe, não foi possível realizar a busca por nome. Digite um nome e tente novamente.”_

---

## Manutenção

### Estória
>  **Eu, como** operador (Usuário) do Sistema  de E-commerce IBM Shop,
>
>  **Quero** realizar, via tela, manutenção de usuário no Sistema IBM Shop.

---

### Cenários
  
#### **Cenário  1:** Cadastrar usuário

**Nome**
   - Obrigatório
   - Deve ter, pelo menos, 2 caracteres.
   - Deve ter, no máximo, 255 caracteres.

**Sobrenome**
   - Obrigatório
   - Deve ter, pelo menos, 2 caracteres.
   - Deve ter, no máximo, 255 caracteres.

**CPF**
   - Obrigatório
   - Deve estar em um formato válido.

      | Exemplo de **formato** válido de CPF |
      |:-----------------------------------: |
      |           123.456.789-10             |

**Telefone**
   - Opcional
   - Deve estar em um formato válido.

      | Exemplos de **formato** válido de Telefone   |
      | :------------------------------------------: |
      | +xxx (xx) xxxxx-xxxx                         |
      | +xxx (xx) xxxx-xxxx                          |
      | +xx (xx) xxxxx-xxxx                          |
      | +xx (xx) xxxx-xxxx                           |

**Endereço**  
> _Ao cadastrar um usuário, um endereço também deve ser cadastrado._
   - **Rua**
      - Obrigatório
      - Tamanho máximo de 45 caracteres

   - **Número**
      - Obrigatório
      - Tamanho máximo de 10 caracteres

   - **Complemento**
      - Opcional
      - Tamanho máximo de 45 caracteres

   - **CEP**
      - Obrigatório
      - Deve estar em um formato válido

         | Exemplo de **formato** de CEP válido |
         | :----------------------------------: |
         | 12345-678                            |

   - **Cidade**
      - Obrigatório
      - Tamanho máximo de 45 caracteres

   - **Estado**
      - Obrigatório
      - Tamanho máximo de 45 caracteres

**País**  
> _Ao cadastrar um usuário, o país só deve ser salvo no banco de dados se ele ainda não existir._
   - **Nome**
      - Obrigatório
      - Tamanho máximo de 45 caracteres

   - **Código**
      - Obrigatório
      - Tamanho máximo de 45 caracteres
      - Deve estar em um formato válido

         | Exemplo de **formato** de código válido |
         | :-------------------------------------: |
         | +12                                     |
         | +123                                    |

**Data Criação**
   - Gerado automáticamente no momento do cadastro.
   - Não deve ser inserido pelo próprio usuário.
   - Deve ser a data atual do momento do cadastro.

**Data Modificação**
   - Gerado automáticamente no momento do cadastro.
   - Não deve ser inserido pelo próprio usuário.
   - Inicialmente, terá um valor igual a data de cadastro. Posteriormente a data de modificação será alterada sempre que as informações do usuário forem atualizadas.

**Ativo**
   - Gerado automáticamente
   - Não deve ser inserido pelo próprio usuário.
   - Inicialmente, será 'true'. Posteriormente esse valor poderá ser alterado para 'false' durante o [Cenário 3: Excluir Usuário]()

---

**Exemplo de uma entrada de objeto Usuario válida em JSON**
<pre>
   <code>
   {
      "nome": "Nome",
      "sobrenome": "Sobrenome da Silva",
      "telefone": "+055 (11) 12345-1234",
      "cpf": "455.449.218-49",
      "endereco": {
         "rua": "Rua",
         "numero": "12",
         "complemento": "AP 0",
         "cep": "00000-000",
         "bairro": "Nome do Bairro",
         "cidade": "São Paulo",
         "estado": "São Paulo",
         "pais": {
               "nome": "Brasil",
               "codigo": "+055"
         }
      }
   }
   </code>
</pre>

**Campos obrigatórios não preenchidos**   
   - Retorna uma mensagem: _"Não foi possível cadastrar o usuário. O campo ``nome_do_campo`` é obrigatório. Verifique e tente novamente."_

**Usuário já existente**  
O usuário tenta cadastrar um usuário com um CPF que já está cadastrado no sistema.
   - Retorna uma mensagem: _"Não foi possível cadastrar o usuário. Já existe um usuário cadastrado com este CPF. Verifique e tente novamente."_

---

#### **Cenario 2:** Editar usuário

**Id não informado**   
   - Retorna uma mensagem: _"Não é possível editar um usuário sem especificar um id. Verifique e tente novamente."_

**O usuário informa um id inexistente ou de um usuário inativo**
   - Retorna uma mensagem: _"Não existe nenhum usuário com esse id. Verifique e tente novamente."_

**O usuário não pode alterar o CPF**
   - Retorna uma mensagem: _"Não foi possível atualizar as suas informações. Não é permitido alterar o CPF."_

**O telefone deve estar em um formato válido**
   - Retorna uma mensagem: _"Não foi possível atualizar as suas informações. O telefone não está em um formato válido. Verifique e tente novamente."_
      | Exemplos de **formato** válido de Telefone   |
      | :------------------------------------------: |
      | +xxx (xx) xxxxx-xxxx                         |
      | +xxx (xx) xxxx-xxxx                          |
      | +xx (xx) xxxxx-xxxx                          |
      | +xx (xx) xxxx-xxxx                           |

**O CEP deve estar em um formato válido**
   - Retorna uma mensagem: _"Não foi possível atualizar as suas informações. O CEP não está em um formato válido. Verifique e tente novamente."_
      | Exemplo de **formato** de CEP válido |
      | :----------------------------------: |
      | 12345-678                            |


**O código do país deve estar em um formato válido**
   - Retorna uma mensagem: _"Não foi possível atualizar as suas informações. O código prefixo do país não está em um formato válido. Verifique e tente novamente."_
      | Exemplo de **formato** de código válido |
      | :-------------------------------------: |
      | +12                                     |
      | +123                                    |

---

#### **Cenario 3:** Excluir usuário

**Id não informado**   
   - Retorna uma mensagem: _"Não é possível excluir um usuário sem especificar um id. Verifique e tente novamente."_

**Id inexistente**
   - Retorna uma mensagem: _"Não existe nenhum usuário com esse id. Verifique e tente novamente."_

**Exclusão lógica de dados**  
>Ao excluir um usuário, os dados pessoais dele, bem como o endereço atrelado a ele, não devem ser excluídos >físicamente do banco de dados.  
>Para executar a exclusão lógica dos dados do usuário desejado, altere o valor do atributo ``ativo`` para ``false``. Isso irá simbolizar que aquele usuário não está inativo no sistema.

**Tentativa de desativar a conta de um usuário que já está desativada:**
   - Retorna uma mensagem: _"Este usuário já está com a conta desativada."_


---

#### **Cenário 4:** Reativar usuário
>Deve ser possível reativar o registro de um usuário que está desativado.  
>Nesse caso, o atributo ``ativo`` do usuário que se deseja reativar, deve ter o seu valor modificado de ``false`` para ``true``.  
>Em outras palavras, ``ativo = false --> ativo = true``.

**Id não informado**   
   - Retorna uma mensagem: _"Não é possível reativar um usuário sem especificar um id. Verifique e tente novamente."_

**Id inexistente**
   - Retorna uma mensagem: _"Não existe nenhum usuário com esse id. Verifique e tente novamente."_

**Tentativa de reativar a conta de um usuário que já está ativa:**
   - Retorna uma mensagem: _"Este usuário já possui está com a conta ativa."_

---
