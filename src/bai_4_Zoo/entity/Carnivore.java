package bai_4_Zoo.entity;

public class Carnivore extends Animal{
    String favoritePrey;
    public Carnivore(){}
    public Carnivore(String id, String name, int birthYear, String cage, String favoritePrey) {
        super(id, name, birthYear, cage);
        this.favoritePrey = favoritePrey;
    }

    public String getFavoritePrey() {
        return favoritePrey;
    }

    public void setFavoritePrey(String favoritePrey) {
        this.favoritePrey = favoritePrey;
    }

    @Override
    public String toString() {
        return "Carnivore{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthYear=" + super.getBirthYear() +
                ", cage='" + super.getCage() + '\'' +
                "favoritePrey='" + this.getFavoritePrey() + '\'' +
                '}';
    }
    @Override
    public String getInforToCSV() {
        return "Carnivore"+","+this.getId()+","+
                this.getName()+","+
                this.getBirthYear() +","+
                this.getCage()+","+
                this.getFavoritePrey()
                ;
    }
}
