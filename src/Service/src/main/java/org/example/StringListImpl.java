package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] ourList;
    private int capacity;

//    public StringListImpl(String item) {
//        this.ourList = new String[10];
//    }

    public StringListImpl(int capacity) {
        this.ourList = new String[capacity];
    }

    public String add(String item) {
        this.validateSize();
        this.validateData(item);
        this.ourList[this.capacity++] = item;
        return item;
    }

    public String add(int index, String item) {
        this.validateData(item);
        this.validateSize();
        this.validateIndex(index);
        if (index == this.capacity) {
            this.ourList[this.capacity++] = item;
            return item;
        } else {
            System.arraycopy(this.ourList, index, this.ourList, index + 1, this.capacity - index);
            this.ourList[index] = item;
            ++this.capacity;
            return item;
        }
    }

    public String set(int index, String item) {
        this.validateData(item);
        this.validateIndex(index);
        this.ourList[index] = item;
        return item;
    }

    public String remove(String item) {
        this.validateData(item);
        int index = this.indexOf(item);
        if (index == -1) {
            throw new RuntimeException("Элемент не найден");
        } else if (index == this.capacity) {
            this.ourList[this.capacity--] = null;
            return item;
        } else {
            System.arraycopy(this.ourList, this.capacity + 1, this.ourList, index, this.capacity - index);
            --this.capacity;
            return item;
        }
    }

    public String remove(int index) {
        this.validateIndex(index);
        if (index == this.capacity) {
            this.ourList[this.capacity--] = null;
            return this.ourList[index];
        } else {
            System.arraycopy(this.ourList, this.capacity + 1, this.ourList, index, this.capacity - index);
            --this.capacity;
            return this.ourList[index];
        }
    }

    public boolean contains(String item) {
        return this.indexOf(item) != -1;
    }

    public int indexOf(String item) {
        for(int i = 0; i < this.capacity; ++i) {
            if (this.ourList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(String item) {
        for(int i = this.capacity - 1; i >= 0; --i) {
            if (this.ourList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public String get(int index) {
        this.validateIndex(index);
        return this.ourList[index];
    }

    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public boolean isEmpty() {
        return this.capacity == 0;
    }

    public void clear() {
        this.capacity = 0;
    }

    public String[] toArray() {
        return (String[])Arrays.copyOf(this.ourList, this.capacity);
    }

    public int size() {
        return this.capacity;
    }

    private void validateData(String item) {
        if (item == null) {
            throw new RuntimeException("Данные не были введены, попробуйте снова");
        }
    }

    private void validateSize() {
        if (this.capacity == this.ourList.length) {
            throw new RuntimeException("Массивы заполнен, нельзя добавить новые элементы");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > this.capacity) {
            throw new RuntimeException("введен некорректный индекс, введите, повторно");
        }
    }
}

