package br.com.dio.hangman;

import br.com.dio.hangman.exception.GameIsFinishedException;
import br.com.dio.hangman.exception.LetterAlreadyInputedException;
import br.com.dio.hangman.model.HangmanChar;
import br.com.dio.hangman.model.HangmanGame;

import java.util.Scanner;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        var characters = Stream.of(args)
                .map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new).toList();

        System.out.println(characters);
        var hangmanGame = new HangmanGame(characters);
        System.out.println("Bem vindo ao jogo da forca, tente adivinhar a palavra, boa sorte!");
        System.out.println(hangmanGame);
        var option = -1;
        while (true){
            System.out.println("Selecione uma das opções:");
            System.out.println("1- informar uma letra");
            System.out.println("2- verificar status do jogo");
            System.out.println("3- sair do jogo");
            option = scanner.nextInt();
            switch(option){
                case 1 -> inputCharacter(hangmanGame);
                case 2 -> showGameStatus(hangmanGame);
                case 3 -> System.exit(0);
                default -> System.out.println("Opção inválida, tente novamente!");
            }
            }
        }

    private static void showGameStatus(final HangmanGame hangmanGame) {
        System.out.println(hangmanGame.getStatus());
        System.out.println(hangmanGame);
    }

    private static void inputCharacter(final HangmanGame hangmanGame) {
        System.out.println("Informe uma letra:");
        var character = scanner.next().charAt(0);
        try {
            hangmanGame.inputCharacter(character);
        } catch(LetterAlreadyInputedException ex){
            System.out.println(ex.getMessage());
        } catch(GameIsFinishedException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        System.out.println(hangmanGame);
    }
}
