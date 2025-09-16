package ss7_abstract_interface.thuc_hanh.animal_interface_edible;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.animal.Animal;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.animal.Chicken;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.animal.Tiger;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.edible.Edible;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Apple;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Fruit;
import ss7_abstract_interface.thuc_hanh.animal_interface_edible.fruit.Orange;


public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howEat());
            }
        }
        Fruit[] fruits=new Fruit[2];
        fruits[0]= new Apple();
        fruits[1]=new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howEat());
        }
    }
}
