package Students;

abstract public class Student {
    private int height;
    private int exercises;

    abstract void doExercise();

    public void setHeight(int height) {
        this.height = height;
    }
    public void setExercises(int exercises) {
        this.exercises = exercises;
    }
    public int getHeight() {
        return height;
    }
    public int getExercises() {
        return exercises;
    }

}