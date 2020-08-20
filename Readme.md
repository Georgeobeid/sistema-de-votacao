Criação de um sistema de votação

Descrição geral do projeto: 
O objetivo do projeto foi elaborar um sistema de votação para que determinado usuário realize uma escolha (vote) em um destes três empreendimentos:  Le Jardin, Evian e Olímpia Thermas.
Primeiro, o usuário deve se cadastrar no site utilizando um e-mail e senha, que serão gravados no banco de dados. Caso o usuário já seja cadastrado, basta efetuar o login.
Após o login, o site abrirá uma página para que o usuário realize a votação entre três empreendimentos, podendo votar em apenas um deles.

Tecnologias utilizadas:
O projeto foi elaborado na linguagem Java versão 11, Maven, Spring boot framework versão 2.3.3, Hibernate e JSP (Java Server Pages). Além disso, foi usado o Intellij IDE como ambiente de desenvolvimento em um sistema operacional Windows.
A linguagem Java é uma linguagem orientada a objetos e multiplataforma, que permite rodar em diferentes sistemas, incluindo Android, Linux e Windows.
O Spring boot foi escolhido para facilitar o processo de configuração e publicação das aplicações, escolhendo os starters que estão incluídos no pom.xml do projeto. Estes starters, basicamente, são dependências que agrupam outras dependências. Outro ponto é que o projeto foi feito com a arquitetura MVC (Model-View-Controller).


Instalar, configurar e rodar o projeto:
Primeiro passo, deve ser instalado o Mysql na máquina a ser utilizada para rodar o projeto e ser criado um novo esquema (banco de dados) com o nome "test". Depois, devem ser criados um usuário e senha novos, que serão usados posteriormente.
Em seguida, o Github deve ser acessado ou o arquivo anexado baixado, descompactado e aberto o IDE Intellij, selecionar “open”, depois localizar o arquivo pom.xml do projeto na máquina e clicar em “as a project”.
Depois disso, acesso o arquivo Src/resources/application.properties e localize os seguintes campos:
spring.datasource.username=****
spring.datasource.password=****

Nos campos acima, mude os asteriscos com o usuário e a senha que foram gerados no banco de dados anteriormente.
Desta forma, o projeto está pronto para rodar, bastando entrar na classe WebApplication e “Run”. Após o projeto rodar, acesse no navegador da máquina o link http://localhost:8080/.
No primeiro acesso, deve ser cadastrado um usuário e senha, para que seja criado um login. 


Links para obter os resultados das votações:

1- Para obter o número e os nomes das pessoas que votaram no empreendimento Le Jardin: http://localhost:8080/votos/votoslejardin

2- Para obter o número e os nomes das pessoas que votaram no empreendimento Evian: http://localhost:8080/votos/votosevian

3- Para obter o número e os nomes das pessoas que votaram no empreendimento Olímpia Thermas: http://localhost:8080/votos/votosolimpiathermas
	

Observação: para acessar os resultados o usuário deve estar com login efetuado.

Autor: George Obeid
Data: 20/08/2020

