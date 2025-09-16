package ss7_abstract_interface.thuc_hanh.animal_interface_edible.animal;

import ss7_abstract_interface.thuc_hanh.animal_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Cục tác cục tác";
    }

    @Override
    public String howEat() {
        return "could be fried";
    }
}
