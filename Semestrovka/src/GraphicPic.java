import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GraphicPic {
    private Figure[] arrayList; //массив из фигур
    private int count; //количество фигур в списке

    GraphicPic(){
        arrayList = new Figure[100];
        count=0;
    }

    GraphicPic(String file) throws IOException{
        arrayList = new Figure[100];
        count = 0;

        FileReader next = new FileReader(file);
        BufferedReader in = new BufferedReader(next);
        String line;

        while ((line = in.readLine())!=null){

            StringTokenizer st = new StringTokenizer(line);
            add(new Figure(st.nextToken(),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),st.nextToken()));

        }
        in.close();
    }

    public void add(Figure f){
        if (count == arrayList.length) {
            arrayList = Arrays.copyOf(arrayList, arrayList.length * 2);
        }
        arrayList[count]=f;
        count++;
    }

    public void show(){
        for(int i=0;i<count;i++){
            System.out.println(arrayList[i].getInfo());
        }
    }

    public void delete(Figure.Type t){
        for(int i=0;i<count;i++){
            if(arrayList[i].getType().equals(t)){
                arrayList[i] = arrayList[count-1];
                count--;
                i--;
            }
        }

    }

    public void insert(Figure f) {
        for(int i=0;i<count;i++){
            if(arrayList[i].equals(f)){
                arrayList[i].setColor(f.getColor());
            }
        }
    }

    public GraphicPic hasSquareBiggerThanS(double s){
        GraphicPic pic = new GraphicPic();
        for(int i=0;i<count;i++){
            if(arrayList[i].getSquare()>s){
                pic.add(arrayList[i]);
            }
        }
        return pic;

    }

    public GraphicPic getByColor(Figure.Color[] color){
        GraphicPic pic = new GraphicPic();
        for(int i = 0;i<count;i++){
            for (int j=0;j<color.length;j++){
                if(arrayList[i].getColor().equals(color[j])){
                    pic.add(arrayList[i]);
                }
            }
        }
        return pic;
    }

}
//    public GraphicPic commonWith(Figure r){
//        GraphicPic pic = new GraphicPic();
//        for(int i=0;i<count;i++){
//            switch (arrayList[i].getType()){
//                case Circle:
//                int rad = arrayList[i].getX2();
//                int cx = arrayList[i].getX1();
//                int cy = arrayList[i].getY1();
//
//            }
//        }
//    }
