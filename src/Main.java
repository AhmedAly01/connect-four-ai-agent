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
        long startTime1 = System.nanoTime();
        System.out.println(aiAgent.value(state));
        long endTime1 = System.nanoTime();
        long executionTime = (endTime1 - startTime1) / 1000000;
        System.out.println(state.next.boardState);
        long startTime2 = System.nanoTime();
        System.out.println(aiAgent.abValue(state, Integer.MIN_VALUE, Integer.MAX_VALUE));
        long endTime2 = System.nanoTime();
        long executionTime2 = (endTime2 - startTime2) / 1000000;
        System.out.println("Execution time minimax : " + executionTime + "ms" + " Expanded nodes " +aiAgent.expM) ;
        System.out.println("Execution time alpha beta: " + executionTime2 + "ms"+ " Expanded nodes " +aiAgent.expab);
    }
}
