=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

CIS 120 Game Project README

PennKey: lulinda

=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=



===================

=: Core Concepts :=

===================



- List the four core concepts, the features they implement, and why each feature

  is an appropriate use of the concept. Incorporate the feedback you got after

  submitting your proposal.



  1. 2D Array: used to store the state of the game, 2048 is played on a 4x4 grid; thus, each of the 16 values are stored
  in the 2D array


  2. JUnit Testing Component: used to test the various methods which modify the 2D array, the 2D array contains the most
  important information about the state of the game; thus, the methods which modify the array must be properly tested



  3. Collections: My game uses a LinkedList to store versions of the game after every move.  This allowed me to implement
  and undo button.  A LinkedList is the proper choice because it maintains order, and the order of the moves is critical
  for implementing an undo button.



  4. FileIO: used to read and write high scores to a file, high scores are read in at the beginning of the game and
  output to the screen, then at the end of the game, if the user wins, their high score is written to the file




=========================

=: Your Implementation :=

=========================



- Provide an overview of each of the classes in your code, and what their

  function is in the overall game.
  
  Game- a class containing all the frames and buttons needed for the game
  GameCourt- a class containing the main logic for the game, and describes how the game should respond to various key
  press events
  GameArray- a class storing the state of the game as a 2D array
  Tile- an object class describing the features and methods of each of the individual tiles
  HighScores- a class containing the main logic and file input needed to print out high scores to the screen
  Score- an object class describing the features and methods of each of the individual scores
  WinScreen- a class containing the main logic needed to output the win screen
  LoseScreen- a class containing the main logic needed to output the lose screen


- Were there any significant stumbling blocks while you were implementing your

  game (related to your design, or otherwise)?

  File IO was particularly difficult to implement.


- Evaluate your design. Is there a good separation of functionality? How well is

  private state encapsulated? What would you refactor, if given the chance?

  My design has a good separation of functionality.  Each aspect of the game, from the game array to each of the win/lose
  screen is properly encapsulated and maintained within their own individual class, and then all parts are finally put
  together in the Game class.  I would refactor some of my code.  For example, the win and lose screen are very similar, I
  could have them extend some common Screen interface


========================

=: External Resources :=

========================



- Cite any external resources (libraries, images, tutorials, etc.) that you may

  have used while implementing your game.
  
  Images: 0.png, 2.png, 4.png, 8.png, 16.png, 32.png, 64.png, 128.png, 256.png, 512.png, 1024.png, 2048.png
  Resources: Java Oracle JavaDocs
  Libraries: java.util, java.io, java.awt