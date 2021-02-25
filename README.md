# Java Atos Bot
Bot criado em Java utilizando a ferramenta Selenium Webdriver, uma coleção de APIs open-source usadas para teste de aplicações web.

# Dependências
Todas as dependências do projeto foram gerenciadas pela ferramenta de automoção de compilação Maven e estão presentes num arquivo XML(POM) na src.

# O que faz
Ao ser executado, o bot acessa o endereço https://biblioteca.aneel.gov.br/index.html e realiza buscas por novos atos do dia com base em palavras chaves já definidas no código. Os resultados encontrados são enviados por e-mail, em forma de alerta, com algumas informações importantes a respeito do ato.

# Requisitos 
Além do arquivo executável do bot, é necessário o navegador web Google Chrome (https://www.google.com/intl/pt-BR/chrome/) e a ferramenta de automatização de testes ChromeDriver (https://chromedriver.chromium.org/downloads), que será utilizada pelo Selenium Webdriver. ChromeDriver precisa ser salvo numa pasta nomeada "chrome", na unidade de armazenamento dados "C" como no caminho "C:\chrome\chromedriver.exe". É importante que a versão do Google Chrome seja compatível com a versão do ChromeDriver e vice-versa. 

Como é um projeto em Java, é necessário também o download e a instalação do JRE (Java Runtime Environment) (https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR). 

*Java versão 8, atualização 251.

# formato do email
![alt text](https://github.com/mantisoficial/bot-java/blob/main/projectImages/emailExemplo.jpg?raw=true)
