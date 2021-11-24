package WorkingWithAbstractionExercise.greedyTimes;



public class Sorter implements Comparable<Sorter> {
    int key;
    int value;

    public Sorter(int key, int value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Sorter o) {
        return key==o.key?value-o.value:key-o.key;
    }
}
