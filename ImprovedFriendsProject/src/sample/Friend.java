package sample;

public class Friend {
    private String name = "";
    private int age = 0;
    private String favouriteAnimal = "";
    private String favouriteColour = "";


    Friend(String name, int age, String favouriteAnimal, String favouriteColour) {
        this.name = name;
        this.age = age;
        this.favouriteAnimal = favouriteAnimal;
        this.favouriteColour = favouriteColour;
    }

    public Friend(String line) {
        int indexOfComma = line.indexOf(',');
        name = line.substring(0, indexOfComma);
        line = line.substring(indexOfComma + 1);
        indexOfComma = line.indexOf(',');
        age = Integer.parseInt(line.substring(0, indexOfComma));
        favouriteAnimal = line.substring(indexOfComma + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public void setFavouriteAnimal(String favouriteAnimal) {
        this.favouriteAnimal = favouriteAnimal;
    }

    public String getFavoriteColour() {
        return favouriteColour;
    }

    public void setFavoriteColor(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    public String toString() {
        return name + "," + age + "," + favouriteAnimal + "," + favouriteColour;
    }
}
