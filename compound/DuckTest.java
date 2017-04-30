package compound;


public class DuckTest {

	public void test() {
		System.out.println("=====================���Գ��󹤳�====================");
		AbstractDuckFactory duckFactory = new DuckFactory();
		// ��ͷѼ
		Quackable quackable = duckFactory.createMallardDuck();
		quack(quackable);
		// ��ͷѼ
		quackable = duckFactory.createRedheadDuck();
		quack(quackable);
		// ����Ѽ
		quackable = duckFactory.createBeiJingDuck();
		quack(quackable);
		System.out.println("=====================���Գ��󹤳�====================");
		System.out.println("=====================����������====================");
		// ����ת��ΪѼ��
		Creak creak = new Goose();
		quack(new GooseAdapter(creak));
		System.out.println("=====================����������====================");
		System.out.println("=====================����װ����====================");
		// ΪѼ����ӽ����ļ�����Ϊ
		duckFactory = new CountingDuckFactory();
		// ����Ѽ
		quackable = duckFactory.createBeiJingDuck();
		quack(quackable);
		// ��ͷѼ
		quackable = duckFactory.createMallardDuck();
		quack(quackable);
		// ��ͷѼ
		quackable = duckFactory.createRedheadDuck();
		quack(quackable);
		System.out.println("=====================����װ����====================");
		System.out.println("=====================�������ģʽ====================");
		duckFactory = new DuckFactory();
		//����Ѽ�����
		FlockDuck flockQuackable=(FlockDuck) duckFactory.createFlockDuck();
 		// ��ͷѼ
		quackable = duckFactory.createMallardDuck();
		flockQuackable.add(quackable);
		// ��ͷѼ
		quackable = duckFactory.createRedheadDuck();
		flockQuackable.add(quackable);
		// ����Ѽ
		quackable = duckFactory.createBeiJingDuck();
		flockQuackable.add(quackable);
		flockQuackable.quack();
		System.out.println("=====================�������ģʽ====================");
		System.out.println("=====================���Թ۲���ģʽ====================");
		//�ɹ۲���
		quackable=duckFactory.createMallardDuck();
		//�۲��� 
		Observer observer=new DuckDoctor();
		quackable.registerObserver(observer);
		quackable.quack();
		//Ⱥ��۲�
		flockQuackable.registerObserver(observer);
		flockQuackable.quack();
		System.out.println("=====================���Թ۲���ģʽ====================");

	}

	private void quack(Quackable quackable) {
		// TODO Auto-generated method stub
		quackable.quack();
	}

}
