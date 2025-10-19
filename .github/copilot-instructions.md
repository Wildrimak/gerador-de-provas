# Copilot instructions for gerador-de-provas

Short, actionable guidance for code-generating agents working on this repository.

- Project layout: backend lives in `questions/` (Spring Boot, Java 17). Frontend is `super-mentores-frontend/` (Angular 20 + Angular Material). Infra examples are in `infra/`.

- Build & run (developer):
  - Backend uses Maven. From `questions/` run `mvn clean compile` or use the provided VS Code task "Maven Build".
  - Local DBs in `infra/docker-compose.yml`: `database-dev` binds to host port 5432 and `database-prod` to 5433. Credentials are username `wildrimak` / password `dificil` and DB names `questoes` or `questoes-dev`.
  - App profiles: default `spring.profile.active` is `local-prod` (see `src/main/resources/application.yml`). When running locally you may prefer `local` profile which uses `questoes-dev` on port 5432.
  - Docker compose quick start (from project root): `cd infra && docker compose up -d`.

- Where to make changes:
  - Controllers: `src/main/java/br/com/wildrimak/questions/api/controllers/` — map incoming requests to DTOs. Follow existing controllers for response shaping and exception handling.
  - DTOs and mappers: DTO records are in `api/dtos/` and MapStruct mappers in `api/mappers/`. MapStruct + Lombok are used; mappers often include `@AfterMapping` logic (example: `QuestaoMapper.java`) to wire child relationships.
  - Domain and persistence: domain models and repositories are under `dominio/` and `data/` packages respectively. Flyway migrations live in `src/main/resources/db/migration/` and must match schema expectations.
  - Validation: Uses Jakarta Validation / Hibernate Validator. Prefer DTO-level validation annotations.

- Codegen & conventions:
  - MapStruct is configured via Maven annotation processors (see `pom.xml`). New mappers should be interfaces annotated with `@Mapper(uses = ...)` and may rely on other mappers.
  - Entities use Lombok builders and `@Builder` patterns. When creating child entities (e.g., Alternativa → Questao) maintain bidirectional setup like in `QuestaoMapper.mapAlternativas` (set child.questao = parent).
  - Keep IDs generation and DB-managed fields out of DTO-to-entity mappings — many mappers explicitly ignore `id` and `alternativas` fields.

- Tests and verification:
  - Unit tests live in `src/test/java`. Use `mvn test` to run them. There is a sample `QuestionsApplicationTests`.
  - After edits that affect JPA entities or schema, update or add Flyway migrations in `src/main/resources/db/migration/`.

- Important integration points:
  - Flyway runs at startup; ensure migrations are idempotent and ordered (V0001, V0002...). See `V0004__remove_coluna_resumo_da_tabela_questao.sql` for examples.
  - Application ports: backend defaults to 8081 for `local-prod`. Frontend (Angular) typically uses 4200.
  - Database connections and credentials are stored in `application.yml` for local environments — avoid hardcoding secrets elsewhere.

- Common pitfalls to avoid:
  - Don't assume MapStruct will set relationship back-references automatically. Many mappers call helper methods and `@AfterMapping` to set `child.setParent(parent)`.
  - Hibernate 6.x compatibility: the `pom.xml` pins `hibernate-core` to 6.5.3 and explicitly excludes the starter's hibernate-core to avoid 6.6.x bugs.
  - When adding annotation processors (MapStruct/Lombok), ensure `mvn clean compile` runs to regenerate sources; IDEs may need manual reimport or annotation processing enabled.

- Quick references (files/examples to consult):
  - `questions/pom.xml` — dependency, plugin and annotation-processor configuration.
  - `questions/src/main/resources/application.yml` — profile and datasource URLs/ports.
  - `questions/src/main/java/br/com/wildrimak/questions/api/mappers/QuestaoMapper.java` — example of MapStruct + manual mapping + @AfterMapping relationship wiring.
  - `questions/src/main/resources/db/migration/` — Flyway migration examples.
  - `infra/docker-compose.yml` and `infra/config.md` — how to bring up local Postgres for dev and prod-like profiles.

  -- Frontend notes:
    - The new frontend lives in `super-mentores-frontend/` and uses Angular 20 and Angular Material. Follow Angular style and CLI conventions. Unit tests live alongside source files using the Angular testing setup (Karma/Jasmine or Vitest depending on project config).

If anything above is unclear or you need more detailed examples (e.g., how to add a new entity, create a mapper, or write a Flyway migration), tell me which area and I'll expand a short snippet-based guide.

## Angular / TypeScript guidelines (project-specific)

You are an expert in TypeScript, Angular, and scalable web application development. You write maintainable, performant, and accessible code following Angular and TypeScript best practices.

### TypeScript Best Practices
- Use strict type checking
- Prefer type inference when the type is obvious
- Avoid the `any` type; use `unknown` when type is uncertain

### Angular Best Practices
- Always use standalone components over NgModules
- Must NOT set `standalone: true` inside Angular decorators. It's the default.
- Use signals for state management
- Implement lazy loading for feature routes
- Do NOT use the `@HostBinding` and `@HostListener` decorators. Put host bindings inside the `host` object of the `@Component` or `@Directive` decorator instead
- Use `NgOptimizedImage` for all static images.
  - `NgOptimizedImage` does not work for inline base64 images.

### Components
- Keep components small and focused on a single responsibility
- Use `input()` and `output()` functions instead of decorators
- Use `computed()` for derived state
- Set `changeDetection: ChangeDetectionStrategy.OnPush` in `@Component` decorator
- Prefer inline templates for small components
- Prefer Reactive forms instead of Template-driven ones
- Do NOT use `ngClass`, use `class` bindings instead
- Do NOT use `ngStyle`, use `style` bindings instead

### State Management
- Use signals for local component state
- Use `computed()` for derived state
- Keep state transformations pure and predictable
- Do NOT use `mutate` on signals, use `update` or `set` instead

### Templates
- Keep templates simple and avoid complex logic
- Use native control flow (`@if`, `@for`, `@switch`) instead of `*ngIf`, `*ngFor`, `*ngSwitch`
- Use the async pipe to handle observables

### Services
- Design services around a single responsibility
- Use the `providedIn: 'root'` option for singleton services
- Use the `inject()` function instead of constructor injection