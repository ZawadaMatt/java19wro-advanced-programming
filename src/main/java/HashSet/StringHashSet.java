package HashSet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringHashSet implements Set<String> {

    private List<List<String>> buckets;
    private int currentSize = 0;

    public StringHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    @Override
    public int size() {
        int counter = 0;
        for (List<String> bucket : buckets) {
            counter = counter + bucket.size();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        } else
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
        int index = Math.abs(hash) % this.buckets.size();
        if (this.buckets.get(index).contains(s)) {
            return false;
        }
        this.buckets.get(index).add(s);
        currentSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = o.hashCode() % this.buckets.size();
        if (this.buckets.get(index).contains(o)) {
            this.buckets.get(index).remove(o);
            currentSize--;
            return true;
        } else
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        for (String s : collection) {
            int index = Math.abs(s.hashCode()) % this.buckets.size();
            buckets.get(index).add(s);
            currentSize++;
        }
        return true;
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
            currentSize = 0;
        }
        System.out.println("Wyczyszczono :");
    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {
        for (List<String> bucket : buckets) {
            {
                if (bucket.removeIf(filter)) {
                    bucket.remove(bucket);
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.buckets.stream()
                .flatMap(bucket -> bucket.stream())
                .collect(Collectors.joining(", "));
    }


}
