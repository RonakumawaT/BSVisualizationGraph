import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] data = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        JFrame frame = new JFrame("Binary Search Visualization");
        BinarySearch panel = new BinarySearch(data, 14);    
        frame.add(panel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        

    }
}