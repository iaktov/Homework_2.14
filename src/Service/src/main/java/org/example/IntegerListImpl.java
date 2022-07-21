package org.example;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer[] integerList;
    private int capacity;

    public IntegerListImpl(int capacity) {
        this.integerList = new Integer[capacity];
    }

    public IntegerListImpl(Integer item) {
        this.integerList = new Integer[10];
    }


    //Добавление элемента в массив по значению
    @Override
    public Integer add(Integer item) {
//        this.validateSize();
        grow(this.integerList);
        this.validateData(item);
        this.integerList[this.capacity++] = item;
        return item;
    }

    //Добавление элемента в массив по индексу и значению
    @Override
    public Integer add(int index, Integer item) {
        this.validateData(item);
        grow(this.integerList);
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

    // присваивание нового значению элемента по индексу
    @Override
    public Integer set(int index, Integer item) {
        this.validateData(item);
        this.validateIndex(index);
        this.integerList[index] = item;
        return item;
    }

    //Удаление элемента из массива
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

    //Удаление элемента по индексу
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


    //проверка на наличие значения в массиве
    @Override
    public boolean contains(Integer item) {
        sortInsertion(1,capacity-1);
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
    public int indexOf(Integer item) {
        for (int i = 0; i < this.capacity; ++i) {
            if (this.integerList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = this.capacity - 1; i >= 0; --i) {
            if (this.integerList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    //передать значение по индексу
    @Override
    public Integer get(int index) {
        this.validateIndex(index);
        return this.integerList[index];
    }

    //проверка на идентичность значений в нашем и другом массиве
    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    //проверка на присутствие элементов в массиве
    @Override
    public boolean isEmpty() {
        return this.capacity == 0;
    }

    // Очитска массива
    @Override
    public void clear() {
        this.capacity = 0;
    }


    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(this.integerList, this.capacity);
    }

    // показывает размер списка
    @Override
    public int size() {
        return this.capacity;
    }

    //проверка, что клиент ввел данные
    private void validateData(Integer item) {
        if (item == null) {
            throw new RuntimeException("Данные не были введены, попробуйте снова");
        }
    }


    //проверка, что клиент ввел корректный индекс
    private void validateIndex(int index) {
        if (index < 0 || index > this.capacity) {
            throw new RuntimeException("введен некорректный индекс, введите, повторно");
        }
    }

    //Сортировка вставкой рекусривная
    private void sortInsertion(int i, int n) {

        int temp = integerList[i];
        int j = i;

        while (j > 0 && integerList[j - 1] > temp)
        {
            integerList[j] = integerList[j - 1];
            j--;
        }

        integerList[j] = temp;

        if (i + 1 <= n) {
            sortInsertion( i + 1, n);
        }
    }

    //увеличение массива в 1,5 раза
    private void grow(Integer[] arr) {
        if (this.capacity == this.integerList.length) {
            Integer[] arr2 = new Integer[(int) (arr.length * 1.5)];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            this.integerList = arr2;
            System.out.println("Массив был увеличен");
        }
    }

}
