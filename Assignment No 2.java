import java.util.HashSet;
import java.util.Set;

interface CustomSet<T> {
    void add(T element);

    void remove(T element);

    Set<T> getElements();

    boolean contains(T element);

    int size();

    Set<T> intersection(CustomSet<T> otherSet);

    Set<T> union(CustomSet<T> otherSet);

    Set<T> difference(CustomSet<T> otherSet);

    boolean isSubset(CustomSet<T> otherSet);
}

class CustomSetImpl<T> implements CustomSet<T> {
    private Set<T> elements;

    public CustomSetImpl() {
        this.elements = new HashSet<>();
    }

    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public void remove(T element) {
        elements.remove(element);
    }

    @Override
    public Set<T> getElements() {
        return new HashSet<>(elements);
    }

    @Override
    public boolean contains(T element) {
        return elements.contains(element);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public Set<T> intersection(CustomSet<T> otherSet) {
        Set<T> result = new HashSet<>(elements);
        result.retainAll(otherSet.getElements());
        return result;
    }

    @Override
    public Set<T> union(CustomSet<T> otherSet) {
        Set<T> result = new HashSet<>(elements);
        result.addAll(otherSet.getElements());
        return result;
    }

    @Override
    public Set<T> difference(CustomSet<T> otherSet) {
        Set<T> result = new HashSet<>(elements);
        result.removeAll(otherSet.getElements());
        return result;
    }

    @Override
    public boolean isSubset(CustomSet<T> otherSet) {
        return elements.containsAll(otherSet.getElements());
    }
}

public class Main {
    public static void main(String[] args) {
        CustomSet<Integer> set1 = new CustomSetImpl<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        CustomSet<Integer> set2 = new CustomSetImpl<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set 1: " + set1.getElements());
        System.out.println("Set 2: " + set2.getElements());

        System.out.println("Intersection: " + set1.intersection(set2));
        System.out.println("Union: " + set1.union(set2));
        System.out.println("Difference (Set1 - Set2): " + set1.difference(set2));
        System.out.println("Is Set2 a subset of Set1? " + set1.isSubset(set2));
    }
}
