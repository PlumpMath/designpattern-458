package javacallback;


//remember :�ص��ǿ����ƵĻ����ֶ�
//���վ���ϲ�ģ��ĽǶȣ����Σ����ö�̬����ʵ�֣�����me���ϲ�ģ�飬��˵�ĺ����뷨���ǶԵģ�����ӳ�˷ֲ�ṹ�����������ԡ�
//���վ���²�ģ��ĽǶȣ��ֲ㣩����me���²�ģ�飬��˵�ĺ����뷨���ǶԵģ����ǿ����ƵĻ���ԭ����������У��ص���GUI���
//�¼�������̡��۲���ģʽ������ע�롢�ֲ�ʽ��̣�RMI��Ҳ����ʹ�ûص����ƣ�����ʽ���á������Ʒ�ת������Java�������࣬C++��
//����ָ�롢C#�Ħ˱��ʽ����
public class Wk extends Person{
	public Wk(String name,int a,int b){
		this.setName(name);
		this.setBegin(a);
		this.setEnd(b);
	}

	@Override
	public void say() {
		System.out.println(this.getName() + "say:"+ "a long time~" );
		
	}
	
	public void call(){
		CallBackSuper.callback(this.getBegin(), this.getEnd(), this);
	}
	
	public static void main(String[] args){
		Wk wk = new Wk("wk2016",20,40);
		wk.call();
		WkStudent ws = new WkStudent("wk2008",20,40);
		ws.call();
	}
	

}
