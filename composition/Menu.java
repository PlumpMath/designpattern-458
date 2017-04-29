package composition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

	List<MenuComponent> menus = new ArrayList<>();
	String name;
	String description;

	public Menu(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		menus.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		menus.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		// TODO Auto-generated method stub
		return menus.get(i);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(getName()+","+getDescription());
		System.out.println("===============================");
		Iterator iteratorMenu=menus.iterator();
		//�����ݹ��ӡ��ʽ
		while (iteratorMenu.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iteratorMenu.next();
			menuComponent.print();
		}
		System.out.println("==============================================================");
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	/**
	 * �ⲿ������ ʹ�ö�ջ��¼��ǰ����λ��
	 */
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new CompositionIterator(menus.iterator());
	}

}
