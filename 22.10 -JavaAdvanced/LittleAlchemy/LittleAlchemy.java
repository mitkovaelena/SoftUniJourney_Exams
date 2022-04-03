import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] pieces = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int goldPieces = 0;

        ArrayList<Integer> sequence = new ArrayList<>();
        for (int piece : pieces) {
            sequence.add(piece);
        }

        String command = reader.readLine();

        while (!command.equals("Revision")) {
            String[] commandTokens = command.split(" ");
            if (commandTokens[0].equals("Apply")) {
                for (int i = 0; i < Integer.parseInt(commandTokens[2]) && !sequence.isEmpty(); i++) {
                    int piece = sequence.get(0);
                    sequence.remove(0);
                    piece--;
                    if (piece == 0) {
                        goldPieces++;
                    } else {
                        sequence.add(piece);
                    }
                }
            } else if (goldPieces > 0) {
                goldPieces--;
                sequence.add(Integer.parseInt(commandTokens[2]));
            }
            command = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.size(); i++) {
            sb.append(sequence.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
        System.out.println(goldPieces);
    }
}
