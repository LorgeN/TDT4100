package org.tanberg.oving5;

import com.google.common.collect.Lists;
import org.tanberg.oving2.Gender;

import java.util.List;
import java.util.Objects;

public class Person {

    private final String name;
    private final Gender gender;
    private final List<Person> children;
    private Person mother;
    private Person father;

    public Person(String name, char gender) {
        this(name, Gender.byId(gender));
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = Lists.newArrayList();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public int getChildCount() {
        return this.children.size();
    }

    public Person getChild(int n) {
        return this.children.get(n);
    }

    public boolean hasChild(Person child) {
        return this.children.contains(child);
    }

    public void addChild(Person child) {
        if (child == this) {
            throw new IllegalArgumentException("Can't be your own child?");
        }

        if (this.hasChild(child)) {
            return;
        }

        this.children.add(child);
        switch (this.getGender()) {
            case MALE:
                if (child.father != null) {
                    child.father.children.remove(child);
                }

                child.father = this;
                break;
            case FEMALE:
                if (child.mother != null) {
                    child.mother.children.remove(child);
                }

                child.mother = this;
                break;
        }
    }

    public void removeChild(Person child) {
        if (child == this) {
            throw new IllegalArgumentException("Can't be your own child?");
        }

        if (!this.hasChild(child)) {
            return;
        }

        this.children.remove(child);
        switch (this.getGender()) {
            case MALE:
                child.father = null;
                break;
            case FEMALE:
                child.mother = null;
                break;
        }
    }

    public void setMother(Person mother) {
        if (mother == this) {
            throw new IllegalArgumentException("Can't be your own mother?");
        }

        if (mother == null) {
            if (this.mother == null) {
                return;
            }

            this.mother.removeChild(this);
            return;
        }

        if (mother.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Not a female!");
        }

        mother.addChild(this);
    }

    public void setFather(Person father) {
        if (father == this) {
            throw new IllegalArgumentException("Can't be your own father?");
        }

        if (father == null) {
            if (this.father == null) {
                return;
            }

            this.father.removeChild(this);
            return;
        }

        if (father.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Not a male!");
        }

        father.addChild(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return name.equals(person.name) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", children=" + children.size() +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }
}
