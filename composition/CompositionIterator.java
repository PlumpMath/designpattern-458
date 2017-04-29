package composition;

import java.util.Iterator;
import java.util.Stack;


public class CompositionIterator implements Iterator {

	//ʹ�ö�ջ �������νṹ
	Stack stack=new Stack<>();
	
	public CompositionIterator(Iterator iterator) {
		// TODO Auto-generated constructor stub
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		//�ж϶�ջ�Ƿ�Ϊ��
		if(stack.empty()){
			return false;
		}else {
			Iterator iterator=(Iterator) stack.peek();
			//�жϵ������Ƿ���������Ԫ��
			if(!iterator.hasNext()){
				stack.pop();
				return hasNext();
			}else {
				return true;
			}
		}
		
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		if(hasNext()){
			Iterator iterator=(Iterator) stack.peek();
			MenuComponent menuComponent=(MenuComponent) iterator.next();
			//����ǲ˵��Ļ� ��ջ ���� �˵��еĲ˵���
			if(menuComponent instanceof Menu)
			{
				stack.push(menuComponent.createIterator());
			}
			return menuComponent;
		}else {
			return null;
		}
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
