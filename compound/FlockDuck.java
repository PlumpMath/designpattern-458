package compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FlockDuck implements Quackable {

	List<Quackable> flockQuackables=new ArrayList<>();

	public FlockDuck() {
		// TODO Auto-generated constructor stub
		
	}

	public void add(Quackable quackable){
		flockQuackables.add(quackable); //�������������ڵݹ�
	}
	

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		//�ݹ���� �ڲ�������
		for (Iterator iterator = flockQuackables.iterator(); iterator.hasNext();) {
			Quackable quackable = (Quackable) iterator.next();
			quackable.quack();
			
		}
	}

	/**
	 * ��һ����Ⱥ���ע��ʱ ����ÿһ��Ԫ�����ע��
	 * 
	 * 
	 * 
	 * */
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		for (Quackable quackable : flockQuackables) {
			quackable.registerObserver(observer);
		}
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		for (Quackable quackable : flockQuackables) {
			quackable.removeObserver(observer);
		}
	}

	/**
	 * ί�и�ÿһ��Ҷ�ӽڵ㴦��֪ͨ�¼�����quack��ʵ��֪ͨ
	 */
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
