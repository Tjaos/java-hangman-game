package br.com.dio.hangman.model;

import java.util.List;

public class HangmanGame {

    private final static int HANGMAN_INITIAL_LINE_LENGTH = 9;
    private final static int HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR= 10;

    private final int lineSize;
    private final List<HangmanChar> characters;

    private String hangman;
    private HangmanGamesStatus status;


    public HangmanGame(final List<HangmanChar> characters) {
        var whiteSpaces = " ".repeat(characters.size());
        var characterSpace = "-".repeat(characters.size());
        this.lineSize = HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR + whiteSpaces.length();
        this.status = HangmanGamesStatus.PENDING;
        buildHangmanDesign(whiteSpaces, characterSpace);
        this.characters = setCharacterSpacesPositionInGame(characters, whiteSpaces.length());
    }

    @Override
    public String toString() {
        return this.hangman;
    }


    private List<HangmanChar> setCharacterSpacesPositionInGame(final List<HangmanChar> characters, final int whiteSpacesAmount){
        final var LINE_LETTER = 6;
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).setPosition(this.lineSize * LINE_LETTER + HANGMAN_INITIAL_LINE_LENGTH + i);
        }
        return characters;
    }


    private void buildHangmanDesign(final String whiteSpaces, final String characterSpace ){
        this.hangman = "  -----  " + whiteSpaces + System.lineSeparator() +
                       " |   |  " + whiteSpaces + System.lineSeparator() +
                       " |   |  " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       "==========" + characterSpace + System.lineSeparator()
        ;
    }
}
