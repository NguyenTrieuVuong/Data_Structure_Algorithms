package Bai2;

public class SearchAlgorithms {
    public static <T extends Comparable<T>> int linearSearch(ListInterface<T> list, T key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(key) == 0) return i;
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(ListInterface<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(list.get(mid)) < 0) high = mid - 1;
            else if (key.compareTo(list.get(mid)) > 0) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}


