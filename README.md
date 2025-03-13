# Memory-Matching-Game

# Overview
This is a Memory Flipping Game implemented in Java Swing, designed to test and enhance a player’s memory skills. The game consists of a 4x4 grid of hidden color cards that the player flips over to find matching pairs. The objective is to match all pairs using memory and concentration.

# Features
- Graphical User Interface (GUI) – Built using Java Swing for an interactive experience.
  
- Randomized Grid – Cards are shuffled each game for replayability.

- Memory Testing Mechanism – Players match pairs of hidden cards by remembering their positions.

- Visual Feedback – Cards reveal their colors when flipped and reset if they don’t match.

- Game State Management – Disables matched cards and tracks the current selection.

# Technologies Used
- Java 8+

- Swing (JFrame, JButton, Timer)

- Event Handling (ActionListener)

- Grid Layout (GridLayout)

- Collections Framework (ArrayList, Shuffle)

# How It Works
1️. The game initializes with a 4x4 grid of hidden color cards.

2️. Players flip two cards at a time to find a matching pair.

3️. If the colors match, the cards stay revealed; otherwise, they flip back after a short delay.

4️. The game continues until all pairs are found.

# Code Overview

Main Components

Memorygame Class – Main game logic and GUI.

initializeGame() – Sets up the cards and shuffles them.

createAndShowGUI() – Creates the game interface using Swing.

CardFlipListener Class – Handles button click events.

checkForMatch() – Checks if two flipped cards are a matching pair.

# Example Screenshots

🖼️ Game Start
![image](https://github.com/user-attachments/assets/012f9840-ed35-4dc3-bf4b-9dea8d35cf4c)

🖼️ Matching Cards
![image](https://github.com/user-attachments/assets/540d6252-e305-447b-ba79-3c20a0866f2e)

🖼️ Game Completed
![image](https://github.com/user-attachments/assets/8eaedaf8-7928-4bce-8e0d-67155706806e)
