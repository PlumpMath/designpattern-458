package compound;

/**
 * �۲�Ѽ�ӵĽ���Ϊ
 *
 */
public class DuckDoctor implements Observer {

	/**
	 * 
	 */
	public DuckDoctor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(QuackObservable quackObservable) {
		// TODO Auto-generated method stub
		System.out.println(DuckDoctor.class.getName()+"\t�۲쵽��Ѽ�ӵĶ���Ϊ��"+quackObservable);
	}

}
