# AP-CSA-Final-Project

# LINK TO REFLECTION
https://docs.google.com/document/d/1fwOId4vf3KCECTpTOlSy9eAthrYu7w5Ggs108EqjrD8/edit?usp=sharing

### Description
My project is an implementation of Wordle that I programmed in Java that can be played in a discord server with friends thanks to a discord bot. On top of the base implementation of Wordle, other users can sabotage by randomly generating an insult or using their own to distract the player, or can even make their own guesses to help out. 

### How to Play
To start a game, any user can type “!play” in the chat. Guesses are made by prefixing a guess with “!guess” and distractions can be created by typing “!roast.” The discord bot in the background uses an EventListener onMessageRecieved called to listen for commands from the user.  

### How it works
The game logic is stored in Game.java, where the implementation for a game of Wordle is stored. The most notable functions here are getWord() which randomly selects a word from a list of 5-letter words and isValid() which makes sure a user’s guess exists in that same list. Once a user makes a guess, mark() is called to underline letters contained in the word, or bold letters that are in the correct position. 
