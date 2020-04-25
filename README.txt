This is just my attempt to create a roguelike small game based on Space Station 13 world.

I'm an inexperienced programmer and this is my first project, so I'll be happy to take any advice you have.

=== A short guide to installing dependencies in IntelliJ IDEA ===

1. Clone the repository
2. File -> Project Structure -> Modules -> Dependencies -> + -> JARs or directories -> specify/path/to/javafx-sdk-11.0.2/lib (it's located in 'robust/') -> Apply
3. Edit Configurations -> VM Options -> --module-path /path/to/javafx-sdk-14/lib --add-modules javafx.controls,javafx.fxml
4. File -> Project Structure -> Modules -> Dependencies -> + -> JARs or directories -> specify/path/to/richtextfx-fat-0.10.4.jar (it's located in 'robust/') -> Apply
5. Try to run the program
