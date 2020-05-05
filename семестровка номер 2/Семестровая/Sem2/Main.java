package Sem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Ренат\\Desktop\\Семестровая\\примеры.txt"));
        FileWriter writer = new FileWriter("C:\\Users\\Ренат\\Desktop\\Семестровая\\ответы3.txt");
        int x = 200;
        for(int count=0;count<50;count++){
            String line = in.readLine();
            String [] st = line.split(" ");
            int[] arr =new int [x];
            for (int i = 0;i<x;i++){
                arr[i]=Integer.parseInt(st[i]);
            }
            writer.write("Сортировка на "+ x + " элементах\n");
            long start = System.nanoTime();
            Introsort.sort(arr);
            long finish = System.nanoTime();
            writer.write(Arrays.toString(arr)+"\n");
            writer.write("Затрачено времени: "+(int)(finish-start)+"\n");
            x+=200;
        }
        writer.close();
        in.close();
    }
}
