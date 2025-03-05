# QuestionsFrontend

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.1.4.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## Relacionamento entre componentes

1. home
    1.1 cadastra-questoes
        1.1.1 processa-questoes
            >> Exibe area de texto para cadastro de questoes
            >> Exibe outra area de texto para insercao do gabarito
            >> Exibe um botao processar -> Se a api retornar erro, deve trocar o componente visualiza-questoes por um componente que lista os motivos do erro e o que deve corrigir.
            >> Exibe um botao retornar
        1.1.2 visualiza-questoes
        1.1.3 visualiza-falhas-processamento
    1.2 gera-prova 