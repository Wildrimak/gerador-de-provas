# Instruções para executar no github codespace

## Configurando ambiente
1. Escolha a máquina 4-core 32GB
2. No terminal coloque o java version para 17 usando:

```
sdk install java 17.0.13-tem
```

3. Instalar extensão "Extension Pack for Java" que irá instalar as extensões "Debugger for Java" e "Maven for Java", se não,
instale-as (Todas com o fornecedor da Microsoft).

## Configurando a execução
1. Crie uma pasta ".vscode" na raiz do projeto e crie os 3 arquivos a seguir: launch.json, settings.json e tasks.json
2. No arquivo launch.json adicione:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Debug Questions",
      "request": "launch",
      "mainClass": "br.com.wildrimak.questions.QuestionsApplication",
      "vmArgs": "-Dspring.profiles.active=local",
      "projectName": "questions",
      "cwd": "${workspaceFolder}/questions",
      "preLaunchTask": "Maven Build"
    }
  ]
}
```
3. No arquivo settings.json adicione:

```json
{
  "java.project.referencedLibraries": [
    "questions/target/dependency/*.jar"
  ],
  "java.project.sourcePaths": ["questions/src/main/java"],
  "java.project.outputPath": "questions/target/classes",
  "java.compile.nullAnalysis.mode": "automatic"
}
```

4. No arquivo tasks.json adicione:
```json
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Maven Build",
      "type": "shell",
      "command": "mvn clean compile",
      "options": {
        "cwd": "${workspaceFolder}/questions"
      },
      "group": "build",
      "problemMatcher": ["$msCompile"]
    }
  ]
}
```
5. Entre na pasta infra pelo terminal e execute: 

> docker compose up -d

6. Na barra lateral acima de extensões e abaixo de controle de código fonte, clique no Executar e Depurar e na aba que 
aparecer clique no triangulo verde para iniciar a depuração. 

7. Aparecendo quaisquer modais perguntando por alguma ação, marque yes em todas elas.

8. OBS: Na primeira vez que o código roda, ele funciona normalmente, no entanto se você parar a aplicação e tentar rodar 
novamente pode aparecer um problema como: "Build failed, do you want to continue?", nesse caso, selecione "Fix" e em 
seguida escolha a opcao "Update Project Configuration" para corrigir o problema. 

## Configurações opcionais

* Extensão Postman (Postman)
  * Lembrar de usar token de autorizacao no modo copia e cola pra logar
* Extensão Database Client (Weijan Chen)
  * Nesse caso, use as conf de dev para criar conexão com a base
* Extensão Docker (Microsoft)

## Observações

No modo vscode usando codespace não existe ambiente de prod, no docker compose, ha uma configuração para ambiente de 
prod local, mas ela nao faz sentido lá, pois a princípio a aplicação é para executar na máquina do usuário.