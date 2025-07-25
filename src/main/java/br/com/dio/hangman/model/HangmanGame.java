package br.com.dio.hangman.model;

import br.com.dio.hangman.exception.GameIsFinishedException;
import br.com.dio.hangman.exception.LetterAlreadyInputedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static br.com.dio.hangman.model.HangmanGamesStatus.LOSE;
import static br.com.dio.hangman.model.HangmanGamesStatus.PENDING;
import static br.com.dio.hangman.model.HangmanGamesStatus.WIN;

public class HangmanGame {

    private final static int HANGMAN_INITIAL_LINE_LENGTH = 9;
    private final static int HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR= 10;

    private final int lineSize;
    private final int hangmanInitialSize;
    private final List<HangmanChar> hangmanPaths;
    private final List<HangmanChar> characters;
    private final List<Character> failAttemps = new ArrayList<>();

    private String hangman;
    private HangmanGamesStatus status;


    public HangmanGame(final List<HangmanChar> characters) {
        var whiteSpaces = " ".repeat(characters.size());
        var characterSpace = "-".repeat(characters.size());
        this.lineSize = HANGMAN_INITIAL_LINE_LENGTH_WITH_LINE_SEPARATOR + whiteSpaces.length();
        this.status = HangmanGamesStatus.PENDING;
        this.hangmanPaths = buildHangmanPathsPositions();
        buildHangmanDesign(whiteSpaces, characterSpace);
        this.characters = setCharacterSpacesPositionInGame(characters, whiteSpaces.length());
        this.hangmanInitialSize = hangman.length();
    }

    public HangmanGamesStatus getStatus() {
        return status;
    }

    public void inputCharacter(final char character) {
        if (this.status != PENDING) {
            var message = this.status == WIN ?
                    "Parabéns você ganhou!" :
                    "Você perdeu, tente novamente";
            throw new GameIsFinishedException(message);
        }
        //letras erradas
        if(this.failAttemps.contains(character)){
            throw new LetterAlreadyInputedException("A letra '"+ character + "' já foi informada anteriormente!");
        }
        //letras corretas
        var found = this.characters.stream()
                .filter(c -> c.getCharacter() == character)
                .toList();


        if(found.isEmpty()){
            failAttemps.add(character);
            if(failAttemps.size() >=7){
                this.status = LOSE;
            }
            rebuildHangman(this.hangmanPaths.removeFirst());
            return;
        }

        if(found.stream().allMatch(HangmanChar::isVisible)){
            throw new LetterAlreadyInputedException("A letra '"+ character + "' já foi informada anteriormente!");
        }

        this.characters.forEach(c -> {
            if(c.getCharacter() == found.getFirst().getCharacter()){
                c.enableVisibility();
            }
        });
        if(this.characters.stream().noneMatch(HangmanChar::isInvisible)){
            this.status = HangmanGamesStatus.WIN;
        }
        rebuildHangman(found.toArray(HangmanChar[]::new));
    }

    @Override
    public String toString() {
        return this.hangman;
    }

    private List<HangmanChar> buildHangmanPathsPositions() {
        final var HEAD_LINE = 3;
        final var BODY_LINE = 4;
        final var BODY_lINE_BOTTOM = 5;
        final var LEGS_LINE = 6;
        return new ArrayList<>(
                List.of(
                        new HangmanChar(this.lineSize * HEAD_LINE + 6,'O' ),
                        new HangmanChar(this.lineSize * BODY_LINE + 6,'|' ),
                        new HangmanChar(this.lineSize * BODY_LINE + 5,'/'),
                        new HangmanChar(this.lineSize * BODY_LINE + 7,'\\'),
                        new HangmanChar(this.lineSize * BODY_lINE_BOTTOM + 6,'|' ),
                        new HangmanChar( this.lineSize * LEGS_LINE + 5,'/'),
                        new HangmanChar( this.lineSize * LEGS_LINE + 7,'\\')


                )
        );
    }

    private List<HangmanChar> setCharacterSpacesPositionInGame(final List<HangmanChar> characters, final int whiteSpacesAmount){
        final var LINE_LETTER = 6;
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).setPosition(this.lineSize * LINE_LETTER + HANGMAN_INITIAL_LINE_LENGTH + i);
        }
        return characters;
    }


    private void rebuildHangman(final HangmanChar... hangmanChars){
        var hangmanBuilder = new StringBuilder(this.hangman);
        Stream.of(hangmanChars).forEach(
                h -> hangmanBuilder.setCharAt(h.getPosition(), h.getCharacter()
        ));
        var failMessage = this.failAttemps.isEmpty() ? "" : "Tentativas" + this.failAttemps;
        this.hangman = hangmanBuilder.substring(0, hangmanInitialSize) + failMessage;


    }

    private void buildHangmanDesign(final String whiteSpaces, final String characterSpace ){
        this.hangman = "  -----  " + whiteSpaces + System.lineSeparator() +
                       " |   |  " + whiteSpaces + System.lineSeparator() +
                       " |   |  " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       " |      " + whiteSpaces + System.lineSeparator() +
                       "========" + characterSpace + System.lineSeparator()
        ;
    }
}
