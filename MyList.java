public class MyList {

    private Node list;//ліст це посилання на самий перший елемент, тобто воно починає ланцюг
    private int size = 0;//кількість елементів

    private static class Node {//ланцюг самого списку
        String data;//змінна яка зберігає значення ланцюга
        Node next;//посилання на слідуюче значення

        Node(String data) {
            this.data = data;//запис значення у ланцюг
        }
    }

    public void add(String element) {//додавання в кінець
        Node newNode = new Node(element);//новий ланцюг

        if (list == null) {//перевірка чи пустий ланцюг
            list = newNode;//якщо порожній - новий елемент стає першим
        } else {
            Node newEl = list;//якщо ланцюг не порожній - нова змінна щоб йти по списку
            while (newEl.next != null) {//поки є слідующі елементи - далі йдемо
                newEl = newEl.next;//проходимо інші елементи
            }
            newEl.next = newNode;//коли ланцюг закінчився - додаємо слово з кінця і новий елемент стає останній, а останній передостаннім
        }
        size++;//збільшення розміру
    }

    public void add(int index, String element) {//додавання по індексу
        if (index < 0 || index > size) {
            System.out.println("Неправильний індекс");
            return;//якщо елемент меньший за 0 або індекс більший за розмір - помилка
        }

        Node newNode = new Node(element);//створення нового ланцюга

        if (index == 0) {
            newNode.next = list;//новий елемент вказує на СТАРИЙ перший
            list = newNode;//новий елемент стає перщим
        } else {
            Node newEl = list;//змінна для проходу по всім елементам

            for (int i = 0; i < index - 1; i++) {//прохід по всім елементам щоб знайти потрібний за потрібним індексом
                newEl = newEl.next;//вперед
            }
            newNode.next = newEl.next;//новий елемент тепер вказує на той що вказував старий
            newEl.next = newNode;//новий стає за іншим індексом
        }
        size++;
    }

    public void remove(int index) {//видалення по індексу
        if (index < 0 || index >= size) {
            System.out.println("Неправильний індекс");
            return;
        }

        if (index == 0) {
            list = list.next;//старий перший елемент тепер стає другим і додається якісь новий
        } else {
            Node newEl = list;//змінна для проходу по всім елементам

            for (int i = 0; i < index - 1; i++) {
                newEl = newEl.next;//прохід по всім елементам щоб знайти потрібний
            }
            newEl.next = newEl.next.next;//пропускаємо елемент який видаляємо
        }
        size--;//зменшення розміру
    }

    public String get(int index) {//елемент по індексу
        if (index < 0 || index >= size) {
            return "Неправильний індекс";
        }
        Node newEl = list;

        for (int i = 0; i < index; i++) {
            newEl = newEl.next;//прохід по всім елементам переходимо на слідуючий
        }
        return newEl.data;//змінна для проходу по всім елементам
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return size;
    }

    public String getElements() {
        if (list == null)//якщо список порожній - 0
            return "()";//виводимо дужки

        String result = "(";//початок строки
        Node newEl = list;

        while (newEl != null) {//поки є елементи
            result += newEl.data;//додаємо елементи в строку

            if (newEl.next != null)
                result += ", ";//якщо елемент не останній - кома
            newEl = newEl.next;//далі
        }
        return result + ")";//закриття
    }
}