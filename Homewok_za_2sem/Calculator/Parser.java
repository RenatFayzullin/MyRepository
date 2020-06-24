package Calculator;

import java.util.InputMismatchException;

public class Parser {
    private long a;
    private long b;
    private String operation;
    private String string;
    private static final char[] OPERATIONS = {'+', '-', '*', '/'};

    Parser(String string) throws InputMismatchException, IllegalArgumentException, StringArgumentException {
        this.string = string;
        String[] parts = getParts(string);
        this.a = Long.parseLong(parts[0]);
        this.b = Long.parseLong(parts[2]);
        this.operation = parts[1];
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public String getOperation() {
        return operation;
    }

    private static String[] getParts(String string) throws IllegalArgumentException, InputMismatchException {
        String res[] = new String[]{"", "", ""};
        int k = 0;
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (!isNumber(symbol) && !isInOperation(symbol) && symbol != ' ') {
                throw new IllegalArgumentException();
            } else if (symbol != ' ') {
                res[k] += symbol;
            } else {
                k++;
            }
            if (k > 2) {
                throw new InputMismatchException();
            }
        }
        return res;
    }

    private static boolean isInOperation(char symbol) {
        for (char s : OPERATIONS) {
            if (symbol == s) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char symbol) {
        if (symbol >= '0' && symbol <= '9') {
            return true;
        } else {
            return false;
        }
    }

    private long parse(String string) throws StringArgumentException {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException ex) {
            throw new StringArgumentException(this.string, string);
        }
    }
}

