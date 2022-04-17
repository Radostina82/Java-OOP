public class Main {
    public static void main(String[] args) {
        try {

            Person person1 = new Person("Franco", "Nice", 35);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
