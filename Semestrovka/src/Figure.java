public class Figure  {
    private Type type;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;

    public Figure(String type, int x1, int y1, int x2, int y2, String color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        for(Type typ : Type.values()){
            if (typ.type.equals(type)) {
                this.type =typ;
            }
        }

        for(Color cl : Color.values()){
            if(cl.clr.equals(color)){
                this.color=cl;
            }
        }
    }

    public enum Type{
        Rectangle("Rectangle"),
        Circle("Circle"),
        Section("Section");

        String type;

        Type(String type){
            this.type = type;
        }

    }

    public enum Color{
        Red("red"),
        White("white"),
        Black("black"),
        Blue("blue"),
        Yellow("yellow");

        String clr;

        Color (String cl){
            this.clr = cl;
        }
    }

    public Type getType() {
        return type;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getInfo(){
        return type +" "+ x1 +" "+ y1 +" "+ x2 +" "+ y2 +" "+ color;
    }

    public double getSquare(){
        switch (type){
            case Rectangle:
                return(x2-x1)*(y1-y2);
            case Circle:
                return Math.PI*x2*x2;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Figure)) return false;
        Figure figure = (Figure)o;
        if (getX1() == figure.getX1() &&
                getY1() == figure.getY1() &&
                getX2() == figure.getX2() &&
                getY2() == figure.getY2() &&
                getType() == figure.getType()){
            return true;
        }
        else return false;



    }
}
