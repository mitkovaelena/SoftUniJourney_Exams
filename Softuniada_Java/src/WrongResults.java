import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WrongResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());

        Integer[][][] cube = new Integer[n][n][n];
        Integer[][][] outCube = new Integer[n][n][n];

        for (int currentRow = 0; currentRow < n; currentRow++) {
            String[] input = reader.readLine().split(" \\| ");
            for (int currentLayer = 0; currentLayer < n; currentLayer++) {
                String layerPart = input[currentLayer];
                for (int currentCol = 0; currentCol < n; currentCol++) {
                    String[] nums = layerPart.split(" ");
                    cube[currentLayer][currentRow][currentCol] = Integer.parseInt(String.valueOf(nums[currentCol]));
                    outCube[currentLayer][currentRow][currentCol] = Integer.parseInt(String.valueOf(nums[currentCol]));
                }
            }
        }


        List<Integer> coord = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        Integer wrongValue = cube[coord.get(0)][coord.get(1)][coord.get(2)];
        Integer wrongValuesCount = 0;

        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    if (cube[i][j][k].equals(wrongValue)) {
                        wrongValuesCount++;
                        int sum = 0;
                        try {
                            if (!cube[i + 1][j][k].equals(wrongValue)) sum += cube[i + 1][j][k];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        try {
                            if (!cube[i - 1][j][k].equals(wrongValue)) sum += cube[i - 1][j][k];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        try {
                            if (!cube[i][j + 1][k].equals(wrongValue)) sum += cube[i][j + 1][k];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        try {
                            if (!cube[i][j - 1][k].equals(wrongValue)) sum += cube[i][j - 1][k];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        try {
                            if (!cube[i][j][k + 1].equals(wrongValue)) sum += cube[i][j][k + 1];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        try {
                            if (!cube[i][j][k - 1].equals(wrongValue)) sum += cube[i][j][k - 1];
                        } catch (IndexOutOfBoundsException ignored) {
                           
                        }
                        outCube[i][j][k] = sum;
                    }
                }
            }
        }

        System.out.println("Wrong values found and replaced: " + wrongValuesCount);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                StringBuilder sb1 = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    sb1.append(outCube[j][k][l] + " ");
                }
                sb.append(sb1.toString().trim() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
