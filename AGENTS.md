# Agents

This file tracks the agents and their responsibilities within this project, serving as the central context and rulebook for any AI agent working on this repository.

## Project Overview
This is a **static portfolio website** built using **Kotlin Multiplatform** (targeting JS) and the **Kobweb** framework (built on top of Compose HTML).

- **Framework**: Kobweb (Full-stack web framework for Kotlin)
- **UI Library**: Kobweb Silk (UI layer for Kobweb, similar to Material UI but for Compose HTML)
- **Language**: Kotlin 2.x
- **Build System**: Gradle (Kotlin DSL)

## Project Structure
The source code is located in `site/src/jsMain/kotlin/com/amandabicalho/portfolio`.

- `pages/`: Contains the actual pages of the website. Each `@Page` annotated composable becomes a route.
- `components/`: Reusable UI components (Headers, Footers, Cards, etc.).
- `sections/` (or `ui/`): Larger sections of the pages (e.g., HeroSection, AboutSection).
- `AppStyles.kt` / `SiteTheme.kt`: Global styles and theme definitions.
- `AppEntry.kt`: The main entry point `main()`.

## Development Rules & Best Practices

### 1. Kotlin & Compose Guidelines
- **Component Design**: Break down UI into small, reusable `@Composable` functions.
- **State Hoisting**: Move state up to common ancestors. Pass data down via parameters and events up via lambdas (e.g., `value: String, onValueChange: (String) -> Unit`).
- **Side Effects**: Use `LaunchedEffect` for suspend functions (like API calls) and `DisposableEffect` for cleanup usage.
- **Slot API**: Use `content: @Composable () -> Unit` parameters to create flexible wrapper components.
- **Modifiers**:
    - ALWAYS accept a `modifier: Modifier = Modifier` as the first optional parameter in UI components.
    - Use Kobweb's `Modifier` for layout/visuals.
    - Chain modifiers efficiently.
- **Naming**:
    - **PascalCase** for `@Composable` functions returning Unit (nouns if UI elements, e.g., `Button`).
    - **Verbs** (e.g., `RenderData`) are discouraged for UI components; use nouns (e.g., `DataView`).
- **Type Safety**: Leverage Kotlin's strong type system. Avoid `dynamic`.

### 2. Styling with Kobweb (Silk)
- **CSS-in-Kotlin**: Do not write raw CSS files. Use Kobweb's type-safe CSS DSL.
- **Responsiveness**: Use `Modifier.display`, `Modifier.col`, `Modifier.row` and `ResponsiveLayout` logic. Use Silk's `Breakpoint` for responsive logic (e.g., `Breakpoint.MD`, `Breakpoint.LG`).
- **Theming**: Adhere to the defined `SiteTheme`. Use theme colors and typography instead of hardcoded values.

### 3. Kobweb Specifics
- **Routing**: Create new pages by adding `@Page` annotation to a Composable in the `pages` package. The route is determined by the file path and function name.
- **Resources**: Static assets (images, fonts) go in `site/src/jsMain/resources/public`. Access them with absolute paths like `src="/image.png"`.
- **Links**: Use `Link` component from Silk or Kobweb for internal navigation to handle client-side routing correctly.

### 4. Code Style
- **Formatting**: Follow standard Kotlin coding conventions.
- **Detekt**: The project uses Detekt for static analysis. Ensure code is compliant.
- **Naming**: Use PascalCase for Composables, camelCase for variables/functions.

## Commands
- **Run Locally**: `./gradlew jsBrowserDevelopmentRun --continuous` (or use the Gradle task directly).
- **Build for Production**: `./gradlew jsBrowserDistribution`.

## Software Architecture Principles

### 1. SOLID
- **S**ingle Responsibility: Each component should do ONE thing well. Split large Composables into smaller sub-components.
- **O**pen/Closed: Components should be open for extension (via slots/parameters) but closed for modification.
- **L**iskov Substitution: (Less strictly applicable to functions, but relevant for interfaces).
- **I**nterface Segregation: Depend on small, specific interfaces rather than large, monolithic ones.
- **D**ependency Inversion: Inject dependencies (data/logic) rather than hardcoding them inside components.

### 2. KISS (Keep It Simple, Stupid)
- **Simplicity**: Prefer simple, readable solutions over clever, complex ones.
- **State**: minimize local state; rely on derived state where possible.

### 3. DRY (Don't Repeat Yourself)
- **Reusable UI**: Extract repeated UI patterns into custom components.
- **Theme Tokens**: Use `SiteTheme` variables for colors, spacing, and typography instead of hardcoded magic numbers.

### 4. Clean Code
- **Self-Documenting**: Use descriptive variable and function names.
- **Small Functions**: Keep functions small and focused.
- **No Magic Numbers**: Define constants or use theme values.
- **Composition over Inheritance**: Prefer composing UI elements (`Column { Header(); Content() }`) over inheritance structures.

## Git Workflow & Commit Guidelines

### 1. Branch Management Rules
- **CHECK BRANCH FIRST**: ALWAYS check the current branch (`git branch --show-current`) as the very first step.
- **NO DIRECT MAIN COMMITS**: Agents must NEVER commit directly to the `main` branch.
- **Feature Branches**: If on `main`, create a new branch for the task: `git checkout -b feature/description-of-task`.
- **Existing Branches**: If already on a specific feature branch (not `main`), you may proceed to work on it if it aligns with the task.

### 2. Commit Style (Conventional Commits)
Follow appropriate [Conventional Commits](https://www.conventionalcommits.org/) structure:
`type(scope): concise description`

- **Common Types**:
    - `feat`: New feature for the user
    - `fix`: Bug fix
    - `docs`: Documentation only changes
    - `style`: Formatting, missing semi-colons, etc (no code change)
    - `refactor`: Refactoring production code
    - `test`: Adding or refactoring tests
    - `chore`: Updating build tasks, package manager configs, etc

- **Examples**:
    - `feat(home): add hero section animation`
    - `fix(nav): correct link padding on mobile`
    - `docs(agents): update protocol with commit rules`

### 3. Commit Strategy
- **Small Patches**: Commit often. Do not wait until the entire task is finished to commit.
- **Logical Grouping**: Each commit should be a small, logical unit of work that still passes the build (if possible).
- **Concise Messaging**: Keep messages short and imperative (e.g., "add" not "added").

## Agent Protocol
When making changes:
1.  **Check Branch**: Verify you are NOT on `main`. Create a branch if necessary.
2.  **Analyze**: Understand the existing component structure before creating new ones.
3.  **Context**: Read `libs.versions.toml` if you need to check dependencies.
4.  **Implement**: Write code in `site/src/jsMain/kotlin/...`.
5.  **Commit**: Commit changes in small, logical steps using the guidelines above.
6.  **Verify**: Ensure the code compiles and follows the structure above.
7.  **Clean**: Do not leave unused imports or commented-out code.

