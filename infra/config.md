# Instrucoes para executar no github codespace

## Configurando ambiente
1. Escolha a maquina 4-core 32GB
2. No terminal coloque o java version para 17 usando sdk install java 17.0.13-tem
3. Instalar extensao Java Extension Pack que instalar as extensoes "Debugger for Java" e "Maven for Java", se nao instale-as (Todas com o fornecedor da Microsoft)

## Configurando a execucao
1. Criei uma pasta .vscode na raiz do projeto e crie os 3 arquivos a seguir: launch.json, settings.json e tasks.json
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

6. Na barra lateral acima de extensoes e abaixo de controle de codigo fonte, clique no Executar e Depurar e na aba que aparecer clique no triangulo verde para iniciar a depuracao. 

7. Aparecendo quaisquer modais perguntando por alguma acao, marque yes em todas elas.

## Configuracoes opcionais

* Extensao Postman (Postman)
* Extensao Docker (Microsoft)
* Extensao Markdown All in One (Yi Zhang)
* Extensao Database Client (Weijan Chen)
  * Nesse caso, use as conf de dev para criar conexao com a base