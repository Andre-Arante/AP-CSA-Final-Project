import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.*;

public class Commands extends ListenerAdapter {
    public Game g;
    public Roast r = new Roast();

    private String prefix = "!";
    private int remaining;
    private String guesses;

    public void onMessageReceived(MessageReceivedEvent event) {

        // Get the command
        String[] args = event.getMessage().getContentRaw().split(" ");

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("**Wordle**");
        eb.setColor(Color.red);
        eb.addBlankField(false);

        if (args[0].equalsIgnoreCase(prefix + "play")) {
            try {
                g = new Game();
                g.startGame();
                eb.setDescription("Guess a 5-letter word.");

                event.getChannel().sendMessageEmbeds(eb.build()).queue();
                eb.clear();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (args[0].equalsIgnoreCase(prefix + "guess")) {
            eb.getFields().clear();
            try {
                if (g.isValidWord(args[1])) {
                    if (g.getRemaining() > 1) {
                        g.guess(args[1]);
                        remaining = g.getRemaining();
                        guesses = g.formatGuesses();
                        eb.addField("Guesses remaining: " + remaining, guesses, false);
                    } else if (g.wordGuessed()) {
                        eb.addField("ANSWER: ", g.toString(), false);
                        eb.addField("WELL DONE", "You successfully guessed the word with " + g.getRemaining() + " tries left", false);
                        eb.setColor(Color.green);
                    } else {
                        eb.addField("GAME OVER", "Your word was " + g.toString(), false);
                    }
                }
                else {
                    eb.addField("", "Please enter a valid, 5-letter word", false);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            event.getChannel().sendMessageEmbeds(eb.build()).queue();
            eb.clear();
        }
        else if (args[0].equalsIgnoreCase(prefix + "roast")) {
            String user = event.getAuthor().getName();

            if (args.length == 1) {
                try {
                    r.generateRoast();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                StringBuilder msg = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    msg.append(args[i]).append(" ");
                }
                r.setRoast(msg.toString());
            }
            eb.addField("Guesses remaining: " + remaining, guesses, false);
            eb.addField(user + " says", r.getRoast(), false);

            event.getChannel().sendMessageEmbeds(eb.build()).queue(message -> message.addReaction("\uD83E\uDD41").queue());
            eb.clear();
        }
    }
}

