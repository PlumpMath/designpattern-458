package composition;

import java.util.Iterator;


public abstract class MenuComponent {
	/**
	 * �ṩ��Ĭ��ʵ�� ����Ԫ�ؾ����Ƿ���д
	 */
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();

	}

	public abstract Iterator createIterator();
	
}