package Students;

public class Boy extends Student {

    @Override
    void doExercise() {
        this.setExercises(this.getExercises()+30);
    }
}