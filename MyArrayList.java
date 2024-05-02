import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
}
