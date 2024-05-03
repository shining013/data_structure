import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<E> implements List<E> {
    int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        E[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <E> E[] toArray(E[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
            if (index < 0 || index > size) {
                    throw new IndexOutOfBoundsException();
            }
            add(element);
            for (int i=size-1; i>index; i--) {
                array[i] = array[i-1];
            }
            array[index] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(E element) {
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length*2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
            int index = indexOf(obj);
            if (index == -1) {
                return false;
            }
            remove(index);
            return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = false;
        for (Object obj: collection) {
            flag |= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E remove(int index) {

        E deleted = get(index);
        for (int i= index; i<size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deleted;
    }

    @Override
    public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
    }

    @Override
    public E set(int index, E element) {
            E old = get(index);
            array[index] = element;
            return old;
    }

    @Override
    public int indexOf(Object target) {
            for  (int i=0; i<size; i++) {
                if(equals(target, array[i]))
                    return i;
            }
            return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     *
     */
    private boolean equals(Object target, Object element) {
            if (target == null) {
                    return element == null;
            } else {
                    return target.equals(element);
            }
    }




}
