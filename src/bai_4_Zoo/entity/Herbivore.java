package bai_4_Zoo.entity;

public class Herbivore extends Animal {
    String favoriteGrass;

    public Herbivore() {
    }

    public Herbivore(String id, String name, int birthYear, String cage, String favoriteGrass) {
        super(id, name, birthYear, cage);
        this.favoriteGrass = favoriteGrass;
    }

    public String getFavoriteGrass() {
        return favoriteGrass;
    }

    public void setFavoriteGrass(String favoriteGrass) {
        this.favoriteGrass = favoriteGrass;
    }

    @Override
    public String toString() {
        return "Herbivore{" +
                ", id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthYear=" + super.getBirthYear() +
                ", cage='" + super.getCage() + '\'' +
                "favoriteGrass='" + this.getFavoriteGrass() + '\'' +
                '}';
    }

    @Override
    public String getInforToCSV() {
        return "herbivore"+","+this.getId() + "," +
                this.getName() + ","  +
                this.getBirthYear() + "," +
                this.getCage() + "," +
                this.getFavoriteGrass()
                ;
    }
}

