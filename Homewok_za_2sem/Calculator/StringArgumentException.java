package Calculator;

public class StringArgumentException extends Exception {
    private int index;

    StringArgumentException(String string, String longNum) {
        index = string.indexOf(longNum);
        if (index == 0) {
            System.out.println("Слишком длинный превый аргумент");
        } else {
            System.out.println("Слишком длинный второй аргумент");
        }
    }
}