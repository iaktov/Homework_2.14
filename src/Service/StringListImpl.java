package Service;

import Interface.StringList;

import java.util.Arrays;
import java.util.List;

public class StringListImpl implements StringList {

    private final String[] ourList;
    private int capacity;

    public StringListImpl() {

        ourList = new String[10];
    }

    public StringListImpl(int capacity) {

        ourList = new String[capacity];
    }


    @Override
    public String add(String item) {
        validateSize();
        validateData(item);
        ourList[capacity++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateData(item);
        validateSize();
        validateIndex(index);

        if (index == capacity) {
            ourList[capacity++] = item;
            return item;
        }

        System.arraycopy(ourList, index, ourList, index + 1, capacity - index);
        ourList[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateData(item);
        validateIndex(index);
        ourList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateData(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new RuntimeException("Элемент не найден");
        }
        if (index == capacity) {
            ourList[capacity--] = null;
            return item;
        }

        System.arraycopy(ourList,capacity + 1, ourList, index,capacity - index);

        capacity--;
        return item;

//        return remove(index); как короткий и быстрый способ
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index == capacity) {
            ourList[capacity--] = null;
            return ourList[index];
        }

        System.arraycopy(ourList,capacity + 1, ourList, index,capacity - index);

        capacity--;
        return ourList[index];

    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < capacity; i++) {
            if (ourList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = capacity - 1; i >= 0; i--) {
            if (ourList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return ourList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public void clear() {
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(ourList, capacity);
    }

    @Override
    public int size() {
        return capacity;
    }





    private void validateData(String item) {
        if (item == null) {
            throw new RuntimeException("Данные не были введены, попробуйте снова");
        }
    }

    private void validateSize() {
        if (capacity == ourList.length) {
            throw new RuntimeException("Массивы заполнен, нельзя добавить новые элементы");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > capacity) {
            throw new RuntimeException("введен некорректный индекс, введите, повторно");
        }
    }
}
