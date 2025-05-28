import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BinarySearch extends JPanel {
    private int[] array;
    private int target;
    private int low = 0, high, mid = -1;
    private boolean found = false;

    public BinarySearch(int[] array, int target) {
        this.array = array;
        this.target = target;
        this.high = array.length - 1;

        new Thread(() -> {
            binarySearch();
        }).start();
    }

    private void binarySearch() {
        while (low <= high) {
            mid = (low + high) / 2;
            repaint();
            sleep(1000); // delay for visualization

            if (array[mid] == target) {
                found = true;
                break;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        repaint();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;
        int height = getHeight();

        for (int i = 0; i < array.length; i++) {
            if (i == mid) g.setColor(Color.RED);
            else if (i == low) g.setColor(Color.GREEN);
            else if (i == high) g.setColor(Color.BLUE);
            else g.setColor(Color.GRAY);

            int barHeight = (int) ((double) array[i] / Arrays.stream(array).max().getAsInt() * (height - 50));
            g.fillRect(i * width, height - barHeight, width - 2, barHeight);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), i * width + width / 4, height - barHeight - 5);
        }

        if (found) {
            g.setColor(Color.MAGENTA);
            g.drawString("Found " + target + " at index " + mid, 10, 20);
        } else if (low > high) {
            g.setColor(Color.MAGENTA);
            g.drawString("Target " + target + " not found", 10, 20);
        }
    }

}
