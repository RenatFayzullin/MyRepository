package Students;

public class Girl extends Student {

    @Override
    void doExercise() {
        this.setExercises(this.getExercises()+20);
    }
}