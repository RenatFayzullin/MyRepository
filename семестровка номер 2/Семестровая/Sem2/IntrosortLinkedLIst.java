package Sem2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class IntrosortLinkedLIst {
    private int count = 0;

    public int getCount() {
        return count;
    }

    // фактические данные, которые должны быть отсортированы
    private List<Integer> list = new LinkedList<>();
    // количество элементов в данных
    private int n;
    // Конструктор для инициализации размера данных
    IntrosortLinkedLIst(int n) {
        this.n = n;
    }
    // Утилита для вставки данных
    void dataAppend(int temp) {
        list.add(temp);
    }
    // Утилита для замены двух элементов
    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    // Чтобы maxHeap поддерево укоренилось с узла i, который
    // индекс в []. heapN - размер кучи
    private void maxHeap(int i, int heapN, int begin) {
        int temp = list.get(begin + i - 1); //a[begin + i - 1];
        int child;
        while (i <= heapN / 2) {
            child = 2 * i;
            if (child < heapN
                    && list.get(begin + child - 1) < list.get(begin + child)) //a[begin + child - 1] < a[begin + child])
                child++;
            if (temp >= list.get(begin + child - 1)) //a[begin + child - 1])
                break;
            list.set(begin + i - 1, list.get(begin + child - 1)); //a[begin + i - 1] = a[begin + child - 1];
            i = child;
        }
        list.set(begin + i - 1, temp);  //a[begin + i - 1] = temp;
    }
    // Функция для построения кучи (перестановка массива)
    private void heapify(int begin, int end, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }
    // основная функция для работы с heapsort
    private void heapSort(int begin, int end) {
        int heapN = end - begin;
        // Строим кучу (переставляем массив)
        this.heapify(begin, end, heapN);
        // один за другим извлекаем элемент из кучи
        for (int i = heapN; i >= 1; i--) {
            // Переместить текущий корень в конец
            swap(begin, begin + i);
            // вызываем maxHeap () для уменьшенной кучи
            maxHeap(1, i, begin);
        }
    }
    // функция, которая реализует сортировку вставкой
    private void insertionSort(int left, int right) {
        for (int i = left; i <= right; i++) {
            int key = list.get(i); //a[i];
            int j = i;
            // Перемещаем элементы arr [0..i-1], которые
            // больше, чем ключ, на одну позицию впереди
            // их текущей позиции
            while (j > left && list.get(j - 1) > key) {  //a[j - 1] > key) {
                list.set(j,list.get(j - 1));  //a[j] = a[j - 1];
                j--;
            }
            list.set(j,key);  //a[j] = key;
        }
    }
    // Функция для нахождения медианы трех элементов
    private int findPivot(int a1, int b1, int c1) {
        int max = Math.max(Math.max(list.get(a1),list.get(b1)),list.get(c1));   //(a[a1], a[b1]), a[c1]);
        int min = Math.min(Math.min(list.get(a1),list.get(b1)),list.get(c1));   //(a[a1], a[b1]), a[c1]);
        int median = max ^ min ^ list.get(a1) ^ list.get(b1) ^ list.get(c1);   //a[a1] ^ a[b1] ^ a[c1];
        if (median == list.get(a1)) //a[a1])
            return a1;
        if (median == list.get(b1)) //a[b1])
            return b1;
        return c1;
    }
    // Эта функция принимает последний элемент в качестве точки, мест
    // элемент поворота в правильном положении в отсортированном
    // массив, и все места меньше (меньше, чем шарнир)
    // слева от оси
    // и большие элементы справа от оси
    private int partition(int low, int high) {
        // пивот
        int pivot = list.get(high); //a[high];
        // Индекс меньшего элемента
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // Если текущий элемент меньше
            // чем или равен оси
            if (list.get(j) <= pivot) {  //a[j] <= pivot) {
                // увеличиваем индекс меньшего элемента
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }

    // Основная функция, которая реализует Introsort
    // низкий -> начальный индекс,
    // высокий -> конечный индекс,
    // deepLimit -> уровень рекурсии

    private void sortDataUtil(int begin, int end, int depthLimit) {
        count++;
        if (end - begin > 16) {
            if (depthLimit == 0) {
                // если предел рекурсии
                // произошла сортировка кучи вызовов
                this.heapSort(begin, end);
                return;
            }
            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin, begin + ((end - begin) / 2) + 1, end);
            swap(pivot, end);
            // p - индекс разбиения,
            // arr [p] теперь в нужном месте
            int p = partition(begin, end);
            // Отдельно сортируем элементы перед
            // раздел и после раздела
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);
        }
        else {
            // если набор данных небольшой,
            // вызов сортировки вставкой
            insertionSort(begin, end);
        }
    }
    // Полезная функция для начала
    // Introsort module
    void sortData() {
        // Инициализируем глубину
        // as 2 * log (длина (данные))
        int depthLimit = (int)(2 * Math.floor(Math.log(n) / Math.log(2)));
        this.sortDataUtil(0, n - 1, depthLimit);
    }
    // Утилита для печати данных массива
    void printData() {
        for (int i = 0; i < n; i++)
            System.out.print(list.get(i) + " ");  //a[i] + " ");
    }
}
