import java.io.IOException;

public class Tests {
    public static void testShow1() throws IOException {
        GraphicPic pic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        pic.show();
    }
    public static void testShow2() throws IOException {
        GraphicPic pic2 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 2.txt");
        pic2.show();
    }
    public static void testShow3() throws IOException {
        GraphicPic pic3 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 3.txt");
        pic3.show();
    }


    public static void testInsert1() throws IOException{
        //Проверим с файлом где только одному элементу надо поменять цвет
        GraphicPic pic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        Figure f = new Figure("Rectangle",1,5,5,2,"yellow");
        pic.insert(f);
        pic.show();
    }
    public static void testInsert2() throws IOException{
        //Проверим с файлом где нескольким элементам надо поменять цвет
        GraphicPic pic2 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 2.txt");
        Figure f = new Figure("Rectangle",1,5,5,2,"yellow");
        pic2.insert(f);
        pic2.show();
    }
    public static void testInsert3() throws IOException{
        //Проверим с файлом где никакому элементу не надо менять цвет
        GraphicPic pic3 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 3.txt");
        Figure f = new Figure("Rectangle",1,5,5,2,"yellow");
        pic3.insert(f);
        pic3.show();
    }


    public static void testDelete1() throws IOException{
//        Проверим с файлом где нужно удалить только 1 элемент
        GraphicPic pic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        pic.delete(Figure.Type.Rectangle);
        pic.show();
    }
    public static void testDelete2() throws IOException{
//        Проверим с файлом где нужно удалить несколько элементов
        GraphicPic pic2 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 2.txt");
        pic2.delete(Figure.Type.Circle);
        pic2.show();
    }
    public static void testDelete3() throws IOException{
//        Проверим с файлом где не нужно удалять элементы
        GraphicPic pic3 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 3.txt");
        pic3.delete(Figure.Type.Rectangle);
        pic3.show();
    }


    public static void testHasSquare1() throws IOException{
//        Проверим с файлом где все элементы должны быть больше заданной площади
        GraphicPic pic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 4.txt");
        GraphicPic test1 = pic.hasSquareBiggerThanS(3);
        test1.show();
    }
    public static void testHasSquare2() throws IOException{
//        Проверим с файлом где несколько элементов удовлетворяют условию
        GraphicPic pic2 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        GraphicPic test2 = pic2.hasSquareBiggerThanS(11);
        test2.show();
    }
    public static void testHasSquare3() throws IOException{
//        Проверим с файлом где площадь будет отрицательной
        GraphicPic pic3 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 3.txt");
        GraphicPic test1 = pic3.hasSquareBiggerThanS(-5);
        test1.show();
    }


    public static void testGetByColor1() throws IOException{
//         Проверим с файлом где только 1 элемент будет подходить под условие
        GraphicPic pic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        GraphicPic test1 = pic.getByColor(new Figure.Color[] {Figure.Color.Black,Figure.Color.White,Figure.Color.Blue});
        test1.show();
    }
    public static void testGetByColor2() throws IOException{
//         Проверим с файлом где все элементы будут подходить под условие
        GraphicPic pic2 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 3.txt");
        GraphicPic test2 = pic2.getByColor(new Figure.Color[] {Figure.Color.Yellow,Figure.Color.Red,Figure.Color.Blue});
        test2.show();
    }
    public static void testGetByColor3() throws IOException{
//         Проверим с файлом где никакой элемент не будет подходить под условие
        GraphicPic pic3 = new GraphicPic("C:\\Users\\Ренат\\Desktop\\тесты\\пример 1.txt");
        GraphicPic test3 = pic3.getByColor(new Figure.Color[] {Figure.Color.White,Figure.Color.Blue});
        test3.show();
    }
}