# Instruções para executar no github codespace

## Configurando ambiente

1. Escolha a máquina 4-core 32GB
2. No terminal coloque o java 17:

> sdk install java 17.0.13-tem

3. Instalar extensão "Extension Pack for Java" (Do fornecedor da Microsoft).

## Configurando a execução

1. Entre na pasta infra pelo terminal e execute: 

> docker compose up -d

2. Na barra lateral acima de extensões e abaixo de controle de código fonte, clique no Executar e Depurar e na aba que 
aparecer clique no triangulo verde para iniciar a depuração. 

3. Aparecendo quaisquer modais perguntando por alguma ação, marque yes em todas elas.

4. OBS: Na primeira vez que o código roda, ele funciona normalmente, no entanto se você parar a aplicação e tentar rodar 
novamente pode aparecer um problema como: "Build failed, do you want to continue?", nesse caso, selecione "Fix" e em 
seguida escolha a opcao "Update Project Configuration" para corrigir o problema. 

5. Se o caso acima continuar acontecendo, use o clean workspace cache e tenta novamente.

6. E se insistir com problemas relacionados ao MapStruct apenas clique em continue no modal que aparecer.

## Configurações opcionais

* Extensão Postman (Postman)
  * Lembrar de usar token de autorizacao no modo copia e cola pra logar
* Extensão Database Client (Weijan Chen)
  * Nesse caso, use as conf de dev para criar conexão com a base
* Extensão Docker (Microsoft)

## Observações

No modo vscode usando codespace não existe ambiente de prod, no docker compose, ha uma configuração para ambiente de 
prod local, mas ela nao faz sentido lá, pois a princípio a aplicação é para executar na máquina do usuário.