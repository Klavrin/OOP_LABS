## What has been implemented?

- `Individual.java` is a general class for every specie;
- `Species.java` is an enum that matches each individual to its specified specie;
- `ReadFile.java` is a class that takes in a `filePath` parameter that allows us to read the file, either entirely or separately;
- `WriteFile.java` is a class that creates a directory and a file (if they don't exist), populating the file with json data using GSON;
- `Main.java` reads `input.json`, loops through all of the individuals, assigns them a specie and creates a file for each specie in the `/output` directory.

## What have I learned?

- Learned that java also has a package manager called maven;
- Learned how to add a dependency to a maven project, specifically GSON;
- Learned how to write smart enums in java;
- Learned how to read and write to a file;
- Learned to use the debugger tool (could have played with it more though);
- Learned what built-in dependencies java has.
