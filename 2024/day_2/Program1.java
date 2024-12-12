import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Program1 {
    public static void main(String[] args) throws IOException {
        File file = new File("2024/day_2/input_1.txt");
        AtomicInteger count = new AtomicInteger();
        Files.lines(file.toPath()).forEach(line -> {
            int[] inputs = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

            if (inputs[0] < inputs[1]) {
                for (int i = 0; i < inputs.length - 1; i++) {
                    int diff = (inputs[i + 1] - inputs[i]);
                    if (diff > 3 || diff < 1) {
                        return;
                    }
                }
            } else {
                for (int i = 0; i < inputs.length - 1; i++) {
                    int diff = (inputs[i] - inputs[i + 1]);
                    if (diff > 3 || diff < 1) {
                        return;
                    }
                }
            }
            count.incrementAndGet();
        });
        System.out.println(count.get());
    }
}