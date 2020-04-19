import java.io.IOException;

public class MaIN {
    public static void main(String[] args) throws IOException {
        System.out.println("Созданный список GraphicPic: ");
        GraphicPic graphicPic = new GraphicPic("C:\\Users\\Ренат\\Desktop\\Semestrovka\\src\\text");
        graphicPic.show();
        System.out.println("--------------------------------------");
        System.out.println("Результат метода insert");
        Figure f = new Figure("Rectangle",1,5,5,2,"yellow");
        graphicPic.insert(f);
        graphicPic.show();
        System.out.println("--------------------------------------");
        System.out.println("Результат метода delete");
        graphicPic.delete(Figure.Type.Rectangle);
        graphicPic.show();
        System.out.println("Результат метода hasSquareBiggerThanS");
        GraphicPic pic = graphicPic.hasSquareBiggerThanS(10);
        pic.show();
        System.out.println("--------------------------------------");
        System.out.println("Результат метода getByColor");
        GraphicPic pic2 = graphicPic.getByColor(new Figure.Color[] {Figure.Color.Black,Figure.Color.Red});
        pic2.show();


        Tests test=new Tests();

        System.out.println("Тесты для метода show");
        test.testShow1();
        System.out.println("-----------------------------");
        test.testShow2();
        System.out.println("-----------------------------");
        test.testShow3();
        System.out.println("-----------------------------");

        System.out.println("Тесты для метода insert");
        test.testInsert1();
        System.out.println("-----------------------------");
        test.testInsert2();
        System.out.println("-----------------------------");
        test.testInsert3();
        System.out.println("-----------------------------");

        System.out.println("Тесты для метода delete");
        test.testDelete1();
        System.out.println("-----------------------------");
        test.testDelete2();
        System.out.println("-----------------------------");
        test.testDelete3();
        System.out.println("-----------------------------");

        System.out.println("Тесты для метода hasSquare");
        test.testHasSquare1();
        System.out.println("-----------------------------");
        test.testHasSquare2();
        System.out.println("-----------------------------");
        test.testHasSquare3();
        System.out.println("-----------------------------");

        System.out.println("Тесты для метода getByColor");
        test.testGetByColor1();
        System.out.println("-----------------------------");
        test.testGetByColor2();
        System.out.println("-----------------------------");
        test.testGetByColor3();
        System.out.println("-----------------------------");

    }

}
