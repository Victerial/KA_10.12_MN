public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
    }

    // Methods
    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + ".");
    }

    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 25, "male");
        Person person2 = new Person();

        person1.getGoal();
        person1.introduce();

        person2.getGoal();
        person2.introduce();
    }
}
