import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static String readBoard(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            List<String> lines = reader.lines().map(line -> line.replaceAll("\\s", "")).toList();
            String board = "";
            for (int i = 0; i <= 6; i++) {
                for (int j = 5; j >= 0; j--) {
                    board = board.concat(String.valueOf(lines.get(j).charAt(i)));
                }
            }
            return board;
        } catch (IOException | IndexOutOfBoundsException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        Minimax aiAgent = new Minimax(7);
        Minimax.State state = new Minimax.State(0, true, readBoard("test0.txt"));
        System.out.println(state.boardState);
        System.out.println(aiAgent.value(state));
        System.out.println(state.next.boardState);
        System.out.println(aiAgent.abValue(state, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
