# ibm-shop-backend
IBM Shop Backend User Api Repositories
## Estória 
Eu como Micro Serviço de Usuário do Sistema de E-commerce IBM Shop. 
Quero consultar  um usuário  e obter todos  os dados  no sistema IBM Shop. 
Cenários: 
 
### CONSULTA 
#### Cenario  1: Consulta  por id 
Retornar  dados  da entidade  Usuario: 
 
Campo Valor esperado 
- id_usuario Id da tabela(autoincremento) 
- nome: Nome do usuario 
- sobrenome: Sobrenome do usuario 
- telefone: Telefone do usuario 
- cpf: CPF do usuario 
- data_criacao: Data da criação  do usuário 
- data_modificacao: Data de update do  usuário 
 
#### Cenário 2: Consulta por CPF 
- Quando o usuário buscar o CPF inválido  deverá retornar uma mensagem("CPF 
inválido"). 
- Quando o usuário buscar um CPF fora do formato correto. Por exemplo: caracteres 
faltantes, caracteres diferentes do . e -. Retorna uma mensagem("CPF inexistente na 
nossa base de dados, por gentileza digitar  nos formatos: xxx.xxx.xxx-xx ou xxxxxxxxx-
xx") 
- Quando o usuário NÃO informar um CPF deverá retornar uma mensagem ("Por 
gentileza, informe um CPF válido") 
#### Cenário 3: Consulta por Nome 
- Quando o usuário  buscar um Nome com menos de 2 caracteres  ou inexistente 
deverá retornar  uma mensagem ("Não existe no nosso  banco de dados")   
#### Cenário 4: Nenhum dado encontrado 
- Se o usuário  digitar  um dado  que não exista  na base de dados  ele receberá  uma 
mensagem ("Sua busca  não existe no nosso  banco de dados") 
#### Cenário 5: Campos obrigatórios não informados 
- Quando o usuário NÃO informar todos os campos na sua requisição deverá retornar 
uma mensagem ("Atenção! Existe campos que não foram preenchidos") 
#### Cenário 6: Informar campos inválidos 
- Quando o usuário  informar campos inválidos deverá  retornar  uma mensagem 
("Por gentileza,  o campo [nome do campo] é invalido.  ") Obs.: será  necessário 
uma mensagem  de erro personalizada  para  cada atributo. 
#### Cenário 7:  sem Telefone 
- Quando usuário informar um TELEFONE  fora do formato, retornar uma mensagem 
("Formato do telefone inválido. Por favor, informe um telefone no seguinte formato 
+xxx (xx) xxxxx-xxxx") 
  
  
  
  
  
### MANUTENÇÃO 
Eu como operador  (Usuário) do Sistema  de E-commerce IBM Shop. 
Quero realizar,  via tela, manutenção  de usuário  no Sistema  IBM Shop. 
Para poder  realizar  as devidas tratativas  com a entidade: 
Cenários 
  
#### Cenário  1: Cadastrar  Usuário 
- Nome  
   - Obrigatório 
   - Quando o usuário  informar um Nome com menos de 2 caracteres  deverá retornar  uma mensagem  ("Nome inválido")   
  
- Sobrenome 
   - Obrigatório 
   - Limite de caracteres 250char 
- Cpf 
   - Obrigatório 
   - Quando o usuário infomar o CPF inválido  deverá retornar uma  mensagem("CPF inválido"). 
   - Quando o usuário informar um CPF fora do formato correto. Por exemplo: caracteres faltantes, caracteres diferentes do . e -. Retorna uma  mensagem("CPF inválido, por gentileza digitar  nos formatos: xxx.xxx.xxx-xx ou xxxxxxxxx-xx") 
- Data  criação 
   - o Automática (formato da data dd/mm/yyyy) 
- Data  modificação 
   - Automática  (formato da data dd/mm/yyyy) 
- Telefone 
   - Validação da quantidade mínima de caracteres e  informe um telefone no seguinte formato +xxx (xx) xxxxx-xxxx") 
   - Quando usuário informar um TELEFONE  fora do formato, retornar uma mensagem ("Formato do telefone inválido. Por favor, informe um telefone no seguinte formato +xxx (xx) xxxxx-xxxx") 
  
  
#### Cenário 3: Não informar os campos obrigatórios 
 - Caso o usuário não informe os atributos corretamente deverá receber uma  mensagem de erro  ("Os campos [nome do campo] são obrigatórios")   
  
#### Cenário 4:  Informar Usuário já cadastrado 
- Quando o usuário informar um CPF já cadastrado deverá receber uma mensagem  ("CPF já castrado no nosso banco de dados")  
  
#### Cenário 5: Editar Usuário 
- Usuário não pode alterar  CPF deverá receber uma mensagem ("Você não pode  alterar o campo CPF") 
- As mesmas validações de POST serão consideradas para PUT 
  
#### Cenário 6: Excluir Usuário 
- Quando o usuário informar um id  inexistente deverá receber uma mensagem  ("Usuário não encontrado na nossa base de dados")  
  
#### Cenário 7: Informar campos inválidos 
- [Especificado no cenário 2] 
