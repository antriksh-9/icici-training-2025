package com.icici.colls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Fruit{
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit other = (Fruit) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

    
}

public class ArrayListDemo {
    public static void main(String[] args) {
        Set<Fruit> fruits = new HashSet<>();
        // List<Fruit> fruits = new LinkedList<>();

        fruits.add(new Fruit("mango"));
        fruits.add(new Fruit("apple"));
        fruits.add(new Fruit("grapes"));

        // list.add("abc");
        // list.add("fgf");
        // list.add("ghgh");
        // list.add("jkj");
        // list.add(34);

        for(Fruit s : fruits){
            // String s = (String)o;
            System.out.println(s);
        }

        System.out.println(fruits.contains(new Fruit("apple")));
    }
}
