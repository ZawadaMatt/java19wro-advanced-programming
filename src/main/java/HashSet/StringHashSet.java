package HashSet;

import java.util.*;
import java.util.stream.Collectors;

public class StringHashSet implements Set<String> {

    private List<List<String>> buckets;

    public StringHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % this.buckets.size();
        if (this.buckets.get(index).contains(o)) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        int hash = s.hashCode();
        int index = hash % this.buckets.size();
        if (this.buckets.get(index).contains(s)) {
            return false;
        }
        this.buckets.get(index).add(s);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (List<String> bucket : buckets) {
            bucket.clear();
        }
        System.out.println("Wyczyszczono :");
    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public String toString() {
        return this.buckets.stream()
                .flatMap(bucket -> bucket.stream())
                .collect(Collectors.joining(", "));
    }
}
