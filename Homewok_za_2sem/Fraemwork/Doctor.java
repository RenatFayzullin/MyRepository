package Fraemwork;

@StoreInFile(name = "Doctor.txt")
public class Doctor {
    @MyField(name = "surname")
    private String surname;

    @MyField(name = "name")
    private String name;
    @MyField(name = "Patronymic")
    private String Patronymic;

    public Doctor(String surname) {
        this.surname = surname;
    }
    public Doctor() {}

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", surname=' " + surname + '\'' +
                ", Patronymic =' " + Patronymic + '\'' +
                '}';
    }

}
