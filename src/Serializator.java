import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializator {

    public boolean serialization(List<Human> humans) {
        boolean flag = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\svyatoslav\\IdeaProjects\\Serialization\\human.data")))
        {
            oos.writeObject(humans);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Human> deserialization() {
        List<Human> humans = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\svyatoslav\\IdeaProjects\\Serialization\\human.data"))) {
            humans = (List<Human>) ois.readObject();
            for (Human human: humans) {
                human.setOccupation(defineOccupation(human));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return humans;
    }

    private String defineOccupation(Human human){
        int age = human.getAge();
        String occupation = "";
        if (age < 3){
            occupation = "stays at home";
        } else if (age >=3 && age <7){
            occupation = "goes to kindergarten";
        }else if (age >=7 && age <18){
            occupation = "goes to school";
        }else if (age >=18 && age <23){
            occupation = "goes to university";
        }else if (age >=23 && age <65){
            occupation = "works";
        }else if (age >=65){
            occupation = "pension";
        }
        return occupation;
    }

}
