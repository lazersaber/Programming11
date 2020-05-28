//this class represents friends.  The fields are name, age, favourite animal, and favourite colour
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
        return "Friend [" +
                "Name = '" + name + '\'' +
                ", Age = " + age +
                ", Favourite Animal = '" + favouriteAnimal + '\'' +
                ", Favourite Colour = '" + favouriteColour + '\'' +
                ']';
    }
}
