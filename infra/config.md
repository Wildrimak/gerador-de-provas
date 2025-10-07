# Manual de Configuração e Execução do Projeto "gerador-de-provas" no GitHub Codespaces

## Visão Geral

Este manual fornece instruções detalhadas para configurar o ambiente de desenvolvimento do projeto `gerador-de-provas` e seus componentes (backend e frontend) dentro de um ambiente GitHub Codespaces.

## Passo 1: Preparação Automática do Ambiente

Sua primeira interação com o Codespaces cuidará da maior parte da configuração.

1.  **Inicialização do Contêiner:** Ao iniciar o Codespace, o VS Code detectará os arquivos de configuração (`devcontainer.json`) e começará a construir o ambiente. Este processo instala as versões corretas das ferramentas, dependências e extensões recomendadas do VS Code.
2.  **Aguarde a Conclusão:** Apenas monitore os logs no terminal integrado até que a configuração esteja 100% completa.

## Passo 2: Configurando e Executando o Backend (`questions`)

O backend consiste em uma aplicação Java/Spring e seus serviços de suporte (infraestrutura), gerenciados via Docker.

1.  **Subir a Infraestrutura com Docker:**
    * Navegue até a pasta `infra/` pelo terminal do VS Code.
    * Execute o comando `docker compose up -d`.

    ```bash
    cd infra
    docker compose up -d
    ```

2.  **Executar a Aplicação Principal:**
    * Acesse a visualização **"Run and Debug"** na barra de atividades à esquerda do VS Code (ícone de play com um bug).
    * No painel que se abre, uma configuração de inicialização para o projeto já estará disponível.
    * Clique no ícone de play verde (▶️) para compilar e iniciar a aplicação principal. O console de depuração mostrará os logs de inicialização do Spring Boot.

## Passo 3: Configurando e Executando o Frontend (`questions-frontend`)

O frontend é uma aplicação Angular que roda em seu próprio servidor de desenvolvimento.

1.  **Preparar e Iniciar o Servidor Angular:**
    * Abra um **novo terminal** no VS Code para não interromper os outros processos.
    * Navegue até a pasta do projeto frontend: `cd questions-frontend`.
    * **a. Instalação de Dependências (Primeira Execução):** Na primeira vez que for executar o frontend, pode ser necessário instalar as dependências. Se a aplicação não iniciar ou solicitar, execute o comando abaixo.
        * **O que isso faz?** Este comando lê o arquivo `package.json` e baixa todas as bibliotecas necessárias para o projeto.
        ```bash
        npm install
        ```
    * **b. Iniciar o Servidor de Desenvolvimento:** Com as dependências instaladas, inicie o servidor.
        * **O que isso faz?** Este comando compila a aplicação Angular e a hospeda em um servidor local, que monitora alterações nos arquivos e recarrega a página automaticamente.
        ```bash
        ng serve
        ```

2.  **Acessar a Aplicação:**
    * O terminal indicará que a aplicação está disponível, tipicamente em `http://localhost:4200`.
    * O GitHub Codespaces detectará que a porta está em uso e oferecerá um botão para abri-la em uma nova aba do seu navegador, já com o redirecionamento correto.

## Passo 4: Configurações Opcionais (Desenvolvimento Web)

Se você estiver usando o Codespaces diretamente no navegador, estas configurações manuais são recomendadas:

* **Postman:** Para testar os endpoints da API, faça login na extensão do Postman com seu token de autorização.
* **Conexão com o Banco de Dados:** Utilize a extensão de cliente de banco de dados instalada para se conectar à instância Docker. As credenciais de acesso podem ser encontradas nos arquivos de configuração do ambiente (`docker-compose.yml`).