package proxy.test;



import java.lang.reflect.InvocationHandler;

import proxy.Person;
import proxy.PersonBeanImpl;
import proxy.ProxyFactory;

public class PersonBeanTest {


	public static void main(String[] args) {
		PersonBeanImpl personBean = new PersonBeanImpl("�Ʊ�", "����", "ְҵ������õ��˶�Ա");
		System.out.println(personBean);
		//����ӵ����
		Person personBeanOwner = ProxyFactory.getOwnerPersonBean(personBean);
		System.out.println(personBeanOwner.getName());
		personBeanOwner.setDescription(personBeanOwner.getDescription()
				+ ",�Ͻ��е�ս����");
		System.out.println(personBeanOwner.getDescription());
		System.out.println(personBean);
		try {
			// �Լ����Լ����� �ᷢ���쳣
			personBeanOwner.setScore(100);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(personBean);
		}
		//������ӵ����
		Person personNonOwner=ProxyFactory.getNonOwnerPersonBean(personBean);
		System.out.println(personNonOwner.getDescription());
		personNonOwner.setScore(100);
		System.out.println(personBean);
		try {
			//���ñ��˵���Ϣ �ᷢ���쳣
			personNonOwner.setDescription("�����ߵ÷ǳ���");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(personBean);
		}
	}

}
