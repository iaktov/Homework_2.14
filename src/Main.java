import Service.StringListImpl;

public class Main {


    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(10);
        stringList.add(0, "hello");
        stringList.remove(0);
        System.out.println(stringList.get(0));

    }
}