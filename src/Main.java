import java.util.ArrayList;
import java.util.Scanner;

class Board {
    ArrayList<String> board = new ArrayList<>();
    int count = 0;

    void addElements() {
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
        board.add(" ");
    }

    void printBoard() {
        System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " ");
    }

    boolean updateBoard(int position, String markIt) {
        if (board.get(position - 1).equals(" ")) {
            board.set(position - 1, markIt);
            return true;
        } else {
            System.out.println("Position is taken, choose another one");
            return false;
        }
    }

    boolean checkWinner(String marked) {
        return  board.get(0).equals(marked) && board.get(1).equals(marked) && board.get(2).equals(marked) ||
                board.get(3).equals(marked) && board.get(4).equals(marked) && board.get(5).equals(marked) ||
                board.get(6).equals(marked) && board.get(7).equals(marked) && board.get(8).equals(marked) ||
                board.get(0).equals(marked) && board.get(3).equals(marked) && board.get(6).equals(marked) ||
                board.get(1).equals(marked) && board.get(4).equals(marked) && board.get(7).equals(marked) ||
                board.get(2).equals(marked) && board.get(5).equals(marked) && board.get(8).equals(marked) ||
                board.get(0).equals(marked) && board.get(4).equals(marked) && board.get(8).equals(marked) ||
                board.get(2).equals(marked) && board.get(4).equals(marked) && board.get(6).equals(marked);
    }

    boolean checkDraw() {
        if (count == 9) {
            System.out.println("Game is a draw!");
            return true;
        } else {
            return false;
        }
    }

}

class Player {
    Scanner scanner = new Scanner(System.in);
    String name;
    String mark;

    Player(String mark) {
        this.mark = mark;
        if (mark.equals("X")) {
            System.out.println("Player 1 is taken 'X', enter name: ");
        } else {
            System.out.println("Player 2 is taken 'O', enter name: ");
        }
        name = scanner.next();
    }
}

class Game {
    Board board = new Board();
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    Player currentPlayer = player1;

    void play() {
        board.addElements();
        board.printBoard();
        String message = " choose your position from 1 to 9";
        System.out.println(currentPlayer.name + message);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int position = scanner.nextInt();
            if (board.updateBoard(position, currentPlayer.mark)) {
                board.printBoard();

                if (board.checkWinner(currentPlayer.mark)) {
                    System.out.println(currentPlayer.name + " " + "is winner!");
                    break;
                } else if (board.checkDraw()) {
                    System.out.println("Game is a draw!");
                    break;
                } else {
                    if (currentPlayer == player1) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                }
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.play();

    }
}