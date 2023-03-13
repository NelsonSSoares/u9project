<h1>IBM Shop - Backend</h1>
<h2>User API</h2>

<hr>

<h3>Modelagem do Banco de Dados</h3>
<p>Aqui vocês podem encontrar todas as entidades do banco de dados, seus atributos e os seus relacionamentos.</p>
<img src="./readme-files/diagrama_db.png" />

<hr>

<h3>Estória</h3> 
<p><strong>Eu, como</strong> Micro Serviço de Usuário do Sistema de E-commerce IBM</p>
<p><strong>Quero</strong> consultar um usuário e obter todos os dados no sistema IBM Shop.</p>
<p><strong>Cenários:</strong></p>

<h3>CONSULTA</h3>  
<h3>Cenario  1: Consulta  por id</h3>  
<p>Retornar  dados  da entidade  Usuario:</p> 

<table>
   <tr>
      <th>Campo</th>
      <th>Valor esperado</th>
   </tr>
   <tr>
      <td>id_usuario</td>
      <td>ID da tabela (autoincremento)</td>
   </tr>
   <tr>
      <td>nome</td>
      <td>Nome do usuário</td>
   </tr>
   <tr>
      <td>sobrenome</td>
      <td>Sobrenome do usuário</td>
   </tr>
   <tr>
      <td>telefone</td>
      <td>Telefone do usuário</td>
   </tr>
   <tr>
      <td>cpf</td>
      <td>CPF do usuário</td>
   </tr>
   <tr>
      <td>data_criacao</td>
      <td>Data da criação do usuário</td>
   </tr>
   <tr>
      <td>data_modificacao</td>
      <td>Data de update do usuário</td>
   </tr>
</table>

<hr>
 
<h3>Cenário 2: Consulta por CPF</h3>
<ul>
   <li>O usuário busca por um CPF inválido.</li>
   <ul>
      <li>Retorna uma mensagem: "CPF inválido."</li>
   </ul>
   <li>O usuário busca por um CPF com formato inválido.</li>
   <ul>
      <li>O CPF possui um formato inválido quando:</li>
      <ul>
         <li>Não possui o tamanho mínimo;</li>
         <li>É composto por caracteres diferentes de "." e "-"</li>
      </ul>
      <li>Retorna uma mensagem: "Formato de CPF inválido. Formatos aceitos: xxx.xxx.xxx-xx, xxxxxxxxx-xx ou xxxxxxxxxxx.".</li>
   </ul>
   <li>O usuário não informa um CPF.</li>
   <ul>
      <li>Retorna uma mensagem: "Por gentileza, informe um CPF válido.".</li>
   </ul>
</ul>

<hr>

<h3>Cenário 3: Consulta por nome</h3>
<ul>
   <li>O usuário busca por um nome com menos de 2 caracteres.</li>
   <ul>
      <li>Retorna uma mensagem: "Usuário não existente no banco de dados.</li>
   </ul>
   <li>O usuário busca por um nome que não existe no banco de dados.</li>
   <ul>
      <li>Retorna uma mensagem: "Usuário não existente no banco de dados.</li>
   </ul>
</ul>

<hr>

<h3>Cenário 4: Nenhum dado encontrado</h3>
<ul>
   <li>O usuário digita um dado que não existe no banco de dados.</li>
   <ul>
      <li>Retorna uma mensagem: "Desculpe, a sua busca não existe no nosso banco de dados."</li>
   </ul>
</ul>

<hr>

<h3>Cenário 5: Campos obrigatórios não informados</h3>
<ul>
   <li>O usuário <strong>não</strong> informa todos os campos obrigatórios na requisição.</li>
   <ul>
      <li>Retorna uma mensagem: "Atenção! Existem campos que ainda não foram preenchidos!</li>
   </ul>
</ul>

<hr>

<h3>Cenário 6: Informar campos inválidos</h3>
<ul>
   <li>O usuário informa campos inválidos.</li>
   <ul>
      <li>Retorna uma mensagem: "Atenção! O campo (nome_do_campo) não foi preenchido corretamente."</li>
      <ul>
         <li>Obs: Nesse caso, será necessária uma mensagem de erro personalizada para cada atributo.</li>
      </ul>
   </ul>
</ul>

<hr>

<h3>Cenário 7: sem Telefone</h3>
<ul>
   <li>O usuário informa um telefone inválido.</li>
   <ul>
      <li>Um telefone é considerado inválido quando:</li>
      <ul>
         <li>O número de telefone não atende o seguinte formato: "+xxx (xx) xxxxxx-xxxx"</li>
      </ul>
      <li>Retorna uma mensagem: "Formato do telefone inválido. Por favor, informe um telefone no seguinte formato: +xxx (xx) xxxxx-xxxx</li>
   </ul>
</ul>

<hr>

<h3>Manutenção</h3>
Eu como operador  (Usuário) do Sistema  de E-commerce IBM Shop. 
Quero realizar,  via tela, manutenção  de usuário  no Sistema  IBM Shop. 
Para poder  realizar  as devidas tratativas  com a entidade: 
Cenários 
  
<h3>Cenário 1: Cadastrar Usuário</h3>
<ul>
   <li>Nome</li>
   <ul>
      <li>Obrigatório</li>
      <li>Quando o usuário informar um Nome com menos de 2 caracteres, deverá retornar a mensagem: "Nome inválido"</li>
   </ul>

   <li>Sobrenome</li>
   <ul>
      <li>Obrigatório</li>
      <li>Limite de caracteres: 250</li>
   </ul>

   <li>CPF</li>
   <ul>
      <li>Obrigatório</li>
      <li>Quando o usuário informar o CPF inválido, deverá retornar uma mensagem: "CPF inválido".</li>
      <li>Quando o usuário informar um CPF fora do formato correto. Por exemplo: caracteres faltantes, caracteres diferentes do . e -. Retorna uma  mensagem("CPF inválido, por gentileza digitar  nos formatos: xxx.xxx.xxx-xx ou xxxxxxxxx-xx")</li>
   </ul>

   <li>Data criação</li>
   <ul>
      <li>Automática</li>
      <li>Formato: dd/MM/yyyy</li>
   </ul>

   <li>Data modificação</li>
   <ul>
      <li>Automática</li>
      <li>Formato: dd/MM/yyyy</li>
   </ul>

   <li>Telefone</li>
   <ul>
      <li>Validação da quantidade mínima de caracteres e  informe um telefone no seguinte formato +xxx (xx) xxxxx-xxxx")</li>
      <li>Quando usuário informar um TELEFONE  fora do formato, retornar uma mensagem ("Formato do telefone inválido. Por favor, informe um telefone no seguinte formato +xxx (xx) xxxxx-xxxx") </li>
   </ul>

</ul>
  
<h3>Cenário 2: Não informar os campos obrigatórios</h3>
<ul>
   <li>Caso o usuário não informe os atributos corretamente deverá receber uma  mensagem de erro  ("Os campos [nome do campo] são obrigatórios"</li>
</ul>
  
<h3>Cenário 3: Informar um usuário já cadastrado</h3>
<ul>
   <li>Quando o usuário informar um CPF já cadastrado deverá receber uma mensagem  ("CPF já castrado no nosso banco de dados") </li>
</ul>
  
<h3>Cenário 4: Editar usuário</h3>
<ul>
   <li>Usuário não pode alterar  CPF deverá receber uma mensagem ("Você não pode  alterar o campo CPF") </li>
   <li>As mesmas validações de POST serão consideradas para PUT </li>
</ul>

<h3>Cenário 5: Excluir usuário</h3>
<ul>
   <li>Quando o usuário informar um id  inexistente deverá receber uma mensagem  ("Usuário não encontrado na nossa base de dados")</li>
</ul>
  
<h3>Cenário 6: Informar campos inválidos</h3>
<ul>
   <li>[Especificado no cenário 2] </li>
</ul>