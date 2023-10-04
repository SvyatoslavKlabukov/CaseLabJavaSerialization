import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//https://metanit.com/java/tutorial/6.10.php
        ArrayList<Human> people = new ArrayList<Human>();
        Human human1 = new Human("Petya", 11, "pupil");
        Human human2 = new Human("Vasya", 20, "student");
        Human human3 = new Human("Masha", 40, "worker");

        people.add(human1);
        people.add(human2);
        people.add(human3);

        Serializator serializator = new Serializator();
        serializator.serialization(people);
        ArrayList<Human> newPeople= new ArrayList<Human>();
        newPeople = (ArrayList<Human>) serializator.deserialization();
        System.out.println(newPeople);

    }
}