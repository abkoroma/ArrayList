import java.util.Iterator;
import java.util.ListIterator;
import java.util.*;

//import ArrayList.ArrayListIterator;

public class ArrayList<E> implements SimpleList<E> {
	E[] data;
	int size;
	
	public ArrayList() {
		//data = (E[])(new Object[0]);
		clear();
	}
	
	
	private class MyArrayListIterator implements ListIterator<E> {
		int index = 0;
		
		public boolean hasNext() {
			return index < size();
			
		}
		public E next() {
			E element = data[index];
			index++;
			return element;
		}
		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public MyArrayListIterator Iterator() {
		return new MyArrayListIterator();
	}


	@Override
	public boolean add(E element) {
		add(size, element);
		return true;
	}

	@Override
	public void add(int index, E element) {
		//if (size >= data.length) {
			//E[] newData  = (E[]) new Object[data.length + 1];
		//}
		E[] newData  = (E[]) new Object[size];
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		//data = newData;
		for (int i = 0; i < index; i++) {
			newData[i] = data[i];
			//newData[index] = element;
		}
		data = (E[]) new Object[size * 2];
		for (int i = 0; i < index; i++) {
			data[i] = newData[i];
	
		}
		size++;
		
		newData[index] = element;
		
		//for (int i = index; i < data.length; i++) {
			//newData[i + 1] = data[i];
		//}
	}

	@Override
	public boolean addAll(SimpleList<? extends E> c) {
		
		return addAll(size, c);
	}

	@Override
	public boolean addAll(int index, SimpleList<? extends E> c) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		Iterator<? extends E> itr = c.iterator();
		int cSize = c.size();
		
		//modCount++;
		//if (cSize + size > data.length)
		return false;
	}

	@Override
	public void clear() {
		E[] data = (E[])(new Object[0]);
		size = 0;
	}

	@Override
	public boolean contains(Object object) {
		return indexOf(object) != - 1;
	}

	@Override
	public boolean containsAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		return (E) data[index];
	}

	@Override
	public int indexOf(Object object) {
		for (int i = 0; i < size; i++) {
			if (object.equals(data[i]))
				return i;
		}
		return - 1;	
		
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		for (int i = 0; i < size(); i++) {
			System.out.println(data[i]);
		}
		for (E element : data) {
			System.out.println(element);
		}
		return iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		if (object == null) {
			for (int i = size - 1; i >= 0; i--) 
				if (data[i] == null)
					return i;
		}
		else {
			for (int i = size - 1; i >= 0; i--)
				if (object.equals(data[i]))
					return i;			
		}
		return -1;	
	}

	@Override
	public boolean remove(Object object) {
		remove(size);
		return true;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound");
			//System.out.println("Index is out of bound");
		}
		E indexRemove = this.data[index];
		E[] tempArray = (E[])(new Object[size - 1]);
		for (int i = 0, x = 0; i < size; i++) {
			if (i != index) {
				tempArray[x++] = this.data[i];
			}
		}
		size--;
		this.data = tempArray;
		return indexRemove;
	}

	@Override
	public boolean removeAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(SimpleList<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		E setIndex = data[index];
		data[index] = element;
		return setIndex;
	}

	@Override
	public int size() {
		return size;
		
	}

	@Override
	public SimpleList<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		E[] newdata = (E[])(new Object[size]);
		System.arraycopy(data, 0, newdata, 0, size);
		return newdata;
	}
	
	public String toString() {
		String s = "[";
		for(int i = 0; i < size; i++)
			s += data[i].toString() + ", ";
		s = s.substring(0, s.length() - 2) + "]";
		return s;
	}


}
