package org.example;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private final Integer[] integerList;
    private int capacity;

    public IntegerListImpl(int capacity) {
        this.integerList = new Integer[capacity];
    }
    public IntegerListImpl(Integer item) {
        this.integerList = new Integer[10];
    }


    @Override
    public Integer add(Integer item) {
        this.validateSize();
        this.validateData(item);
        this.integerList[this.capacity++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        this.validateData(item);
        this.validateSize();
        this.validateIndex(index);
        if (index == this.capacity) {
            this.integerList[this.capacity++] = item;
            return item;
        } else {
            System.arraycopy(this.integerList, index, this.integerList, index + 1, this.capacity - index);
            this.integerList[index] = item;
            ++this.capacity;
            return item;
        }
    }

    @Override
    public Integer set(int index, Integer item) {
        this.validateData(item);
        this.validateIndex(index);
        this.integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        this.validateData(item);
        int index = this.indexOf(item);
        if (index == -1) {
            throw new RuntimeException("Элемент не найден");
        } else if (index == this.capacity) {
            this.integerList[this.capacity--] = null;
            return item;
        } else {
            System.arraycopy(this.integerList, this.capacity + 1, this.integerList, index, this.capacity - index);
            --this.capacity;
            return item;
        }
    }

    @Override
    public Integer remove(int index) {
        this.validateIndex(index);
        if (index == this.capacity) {
            this.integerList[this.capacity--] = null;
            return this.integerList[index];
        } else {
            System.arraycopy(this.integerList, this.capacity + 1, this.integerList, index, this.capacity - index);
            --this.capacity;
            return this.integerList[index];
        }
    }


    //бинарный поиск
    @Override
    public boolean contains(Integer item) {
        sortInsertion();
        int min = 0;
        int max = integerList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(integerList[mid])) {
                return true;
            }

            if (item < integerList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item){
        for(int i = 0; i < this.capacity; ++i) {
            if (this.integerList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for(int i = this.capacity - 1; i >= 0; --i) {
            if (this.integerList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Integer get(int index) {
        this.validateIndex(index);
        return this.integerList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public boolean isEmpty() {
        return this.capacity == 0;
    }

    @Override
    public void clear() {
        this.capacity = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(this.integerList, this.capacity);
    }

    @Override
    public int size() {
        return this.capacity;
    }


    private void validateData(Integer item) {
        if (item == null) {
            throw new RuntimeException("Данные не были введены, попробуйте снова");
        }
    }

    private void validateSize() {
        if (this.capacity == this.integerList.length) {
            throw new RuntimeException("Массивы заполнен, нельзя добавить новые элементы");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > this.capacity) {
            throw new RuntimeException("введен некорректный индекс, введите, повторно");
        }
    }

    private  void sortInsertion() {
        for (int i = 1; i < capacity; i++) {
            int temp = integerList[i];
            int j = i;
            while (j > 0 && integerList[j - 1] >= temp) {
                integerList[j] = integerList[j - 1];
                j--;
            }
            integerList[j] = temp;
        }
    }



}
