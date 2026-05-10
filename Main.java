public class Main {
    public static void main(String[] args) {

        MyList myList = new MyList();

        myList.add("коза");
        myList.add("деспоти");
        myList.add("папайя");

        System.out.println(myList.getElements());
        System.out.println("Розмір: " + myList.getSize());
        System.out.println("Буфер: " + myList.getCapacity());

        myList.remove(2);

        System.out.println("Після видалення: " + myList.getElements());

        System.out.println("Елемент [0]: " + myList.get(0));
    }
}