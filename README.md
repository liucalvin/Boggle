# Boggle
An interactive boggle game on android, with a solver to find all valid words from a given dictionary. 

The solver uses a custom ternary search tree and depth first search to efficiently determine if an input word exists in the dictionary. 

The app is built with MVVM architecture, using:
- Koin for dependency injection
- Room for local database storage
- Junit, Robolectric, and Mockito for testing
- Stateflow and Kotlin coroutines for concurrency
