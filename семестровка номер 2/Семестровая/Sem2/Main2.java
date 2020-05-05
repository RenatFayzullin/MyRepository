package First;

import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("C:\\Users\\Ренат\\Desktop\\Семестровая\\примеры.txt");

        int x = 200;
        for (int count=0;count<50;count++){
            int[]arr = new int[x];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) Math.round(Math.random() * 2000);
                writer.write( arr[i]+ " ");
            }
            x+=200;
            writer.write("\n");
        }
        writer.close();
    }
}
