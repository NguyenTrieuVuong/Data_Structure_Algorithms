public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {

    private ArrEntry<K, E> heapPQ[];

    public MinHeapPriorityQueue() {
        super();
        heapPQ = new ArrEntry[super.keys.length];
        for (int i = 0; i < super.keys.length; i++) {
            heapPQ[i] = new ArrEntry<>();
        }
    }

    @Override
    protected void upHeap() {
        int index = super.size - 1;
        while (index > 0 && heapPQ[index].getKey().compareTo(heapPQ[index / 2].getKey()) < 0) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    @Override
    protected void downHeap() {
        int index = 0;
        while (2 * index + 1 < super.size) {
            int child = 2 * index + 1;
            if (child + 1 < super.size && heapPQ[child + 1].getKey().compareTo(heapPQ[child].getKey()) < 0) {
                child++;
            }
            if (heapPQ[index].getKey().compareTo(heapPQ[child].getKey()) > 0) {
                swap(index, child);
                index = child;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }
}
