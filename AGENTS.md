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
- **Composables**: Breaking down UI into small, reusable `@Composable` functions.
- **Modifiers**: Use Kobweb's `Modifier` (import `com.varabyte.kobweb.compose.ui.Modifier`) for styling layout, spacing, and size.
- **State Management**: Use `remember` and `mutableStateOf` for local state.
- **Type Safety**: Leverage Kotlin's strong type system. Avoid `dynamic` unless absolutely necessary.

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

## Agent Protocol
When making changes:
1.  **Analyze**: Understand the existing component structure before creating new ones.
2.  **Context**: Read `libs.versions.toml` if you need to check dependencies.
3.  **Implement**: Write code in `site/src/jsMain/kotlin/...`.
4.  **Verify**: Ensure the code compiles and follows the structure above.
5.  **Clean**: Do not leave unused imports or commented-out code.
