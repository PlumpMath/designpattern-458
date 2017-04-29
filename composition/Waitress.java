package composition;

import java.util.Iterator;

public class Waitress {
	
	MenuComponent menuComponent;

	public Waitress(MenuComponent menuComponent) {
		super();
		this.menuComponent = menuComponent;
	}
	
	public void print(){
		menuComponent.print();
	}
	

	public void printVegetarianName(){
		Iterator iteratorAll=menuComponent.createIterator(); //������ϵ�����
		while (iteratorAll.hasNext()) {
			MenuComponent currMenuComponent = (MenuComponent) iteratorAll.next(); //��ϵ�������next�����ǲ˵������Ϊ�˵����nulliterator
																				  //����hasNext����false������ÿ�ε��˵�����popȻ�������һ��stack��hasNext
			try { 
				//��ʾ�ǲ˵��� �������ز�
				if(currMenuComponent.isVegetarian()){
					System.out.println(currMenuComponent);
				}
			} catch (Exception e) {
				// TODO: handle exception
				//�˵� ���׳��쳣
			}
		}
	}
	
}
