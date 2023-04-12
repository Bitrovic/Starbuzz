package com.example.starbuzz;

public class Service {
    private String name;
    private String description;
    private int imageResourceId;
    private int categoryId;

    //Services je niz više elemenata Service
    public static final Service[] SERVICES = {
            new Service("Latte", "A couple of espresso shots with steamed milk.", R.drawable.latte, 0),
            new Service("Cappuccino", "Espresso, hot milk, and a steamed milk foam.", R.drawable.cappuccino, 0),
            new Service("Filter", "Highest quality beans roasted and brewed fresh.", R.drawable.filter, 0),
            new Service("Donuts", "You can't buy happiness, but you can buy donuts. And that's kind of the same thing.", R.drawable.donut, 1),
            new Service("Cake", "Happiness in every slice.", R.drawable.cake, 1),
            new Service("Cookies", "Cookies made from love.", R.drawable.cookie, 1),
            new Service("Coffee Dream", "That's how we dreamed a dream. It was a coffee dream. More precisely, about a beautiful place where you can drink high-quality coffee.", R.drawable.coffee_dream, 2),
            new Service("Greenet", "What's the point of making great coffee if you have no one to share it with?", R.drawable.greenet, 2),
            new Service("Kafeterija", "Coffee is like science, there is always something new to learn about it.", R.drawable.kafeterija, 2)
    };

    //Svako piće ima ime, opis, sliku i id kategorije
    private Service(String name, String description, int imageResourceId, int categoryId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.categoryId = categoryId;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString() {
        return this.name;
    }
    public int getCategoryId() { return this.categoryId; }
}
