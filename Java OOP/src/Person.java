public class Person {
    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        this.setName(name);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setLastName(String lastName) {
        if (lastName==null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setAge(int age) {
        if (age<0 || age>120){
            throw new IllegalArgumentException("Age should be in the range [0...120]");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
