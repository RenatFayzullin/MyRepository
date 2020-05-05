package Sem2;
class Introsort {


    private static int sizeThreshold = 16;

    public static void sort(int[] a) {
        introsortLoop(a, 0, a.length, 2*floorLg(a.length));
    }
    private static int floorLg(int a) {
        return (int)(Math.floor(Math.log(a)/Math.log(2)));
    }


    private static void introsortLoop (int[] a, int from, int to, int depth_limit)
    {
        while (to-from > sizeThreshold)
        {
            if (depth_limit == 0)
            {
                heapsort(a, from, to);
                return;
            }
            depth_limit--;
            int p=partition(a, from, to, medianof3(a, from, from+((to-from)/2)+1, to-1));
            introsortLoop(a, p, to, depth_limit);
            to=p;
        }
        insertionsort(a, from, to);
    }
    /*
     * QuickSort algorithm
     */
    private static int partition(int[] a, int from, int to, int pivot) {
        int left=from;
        int right=to-1;
        while (left<=right) {
            while (a[left] < pivot) {
                left++;
            }
            while (a[right]>pivot)
                right--;
            if(left<=right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static int medianof3(int[] a, int from, int mid, int to) {
        if (a[mid] < a[from])
        {
            if (a[to] < a[mid])
                return a[mid];
            else
            {
                if (a[to] < a[from])
                    return a[to];
                else
                    return a[from];
            }
        }
        else
        {
            if (a[to] < a[mid])
            {
                if (a[to] < a[from])
                    return a[from];
                else
                    return a[to];
            }
            else
                return a[mid];
        }
    }

    /*
     * Heapsort algorithm
     */
    private static void heapsort(int[] a, int from, int to) {
        int n = to-from;

        for (int i = n / 2 - 1; i >= 0; i--) {
            downheap(a, n, i,from);
        }
        for (int i=n-1; i>=0; i--)
        {
            swap(a,from,i+from);
            downheap(a, i, 0,from);
        }
    }

    private static void downheap(int[] a, int i, int n, int from) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l + from] > a[largest + from])
            largest = l;

        if (r < n && a[r + from] > a[largest + from])
            largest = r;

        if (largest != i) {
            swap(a,i+from,largest+from);
            downheap(a, n, largest,from);
        }
    }
    /*
     * InsertionSort algorithm
     */
    private static void insertionsort(int[] a, int from, int to) {
        for (int i = from+1; i < to; i++) {
            int current = a[i];
            int j = i - 1;
            while(j >= 0 && current < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = current;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}