
# O que o projeto faz:
- Cria um post no facebook usando o Selenium WebDriver;
- Pega um novo token no site e Valida a criação do Post via API, usando o rest-assured;
- Deleta o post criado no facebook usando o Selenium WebDriver;
- Pega um novo token no site e Validar se Deletou os Posts via API usando o rest-assured;
- Gera o report global do testes usando o frameword cucumber-extentsreport ("target\cucumber-reports\report.html").

**Scenarios:**
- Write post on Facebook.
- Validate the created post on Facebook by API.
- Delete the post on Facebook.
- Validate post deleted on Facebook by API.

** Feature fica no caminho "resource/features/WritePost.feature".

# Step Definition:
- Existe dois, um para os testes via Selenium e Outro via API;

## Passo  a Passo:
1. Precisa criar um profile chamado "reiload", foi criado o profile para remover as notificações(popups);
2. Criar uma pasta driver na raiz e colocar os drivers e setar o mesmo no sistema operacional ("/drivers/chromedriver.exe");
   O chrome pelo maven não está funcionando com a ultima versão do browser.
3. Precisa criar um arquivo "conf.properties" dentro do resource, com as configurações de usuário do facebook.

website = xxx  
delay_wait = 50  
sleep =  3000  
host = https://graph.facebook.com  
token = xxx  
user = xxx  
password = xxxx  

## Como Rodar:

- Realizar as configuraçãoes acima e abrir o arquivo RunnerTest.java e executar o mesmo.

## Utilizados:
- intellij
- maven
- selenium webdriver
- rest assured
- hamcrest
- cucumber

## Links
http://rest-assured.io/  
https://cucumber.io/  
https://www.seleniumhq.org/  
http://hamcrest.org/JavaHamcrest/
https://mvnrepository.com/

