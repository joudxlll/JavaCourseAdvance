package org.example.models;

class Person extends PersonRecord {

    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Joud", 23, "Riyadh,SA");
        Person p2 = new Person("Shoug", 25, "Riyadh,SA");

        // p1.setAge(155);
        p1.setAge(122);

        System.out.println("First Person Name: "+p1.getName()+ "    Age: "+p1.getAge()+"   Address: "+ p1.getAddress());
        System.out.println("Second Person Name: "+p2.getName()+ "   Age: "+p2.getAge()+"   Address: "+ p2.getAddress());

    }

    public String getDetails(){
        return "First Person Name: "+ getName()+ "    Age: "+getAge()+"   Address: "+ getAddress() ;
    }

}