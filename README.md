# bot-Atos-do-Dia-java
Bot criado em Java a partir da biblioteca de automatização de testes Selenium.

# como funciona 
Ao ser executado, em um arquivo .jar, o bot acessa o site https://biblioteca.aneel.gov.br/index.html e realiza buscas por novos atos referentes as palavras chaves já definidas.
Se houver resultado para alguma das pequisas, estes são enviados por email para um endereço definido anteriormente.

*As pesquisas são realizadas de hora em hora, por um total de 10 horas;

*A partir da segunda pesquisa, resultados repetidos não serão reenviados;
