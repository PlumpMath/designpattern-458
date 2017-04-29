package strategypattern;

//��Ϊ��ί�и��˸�ӡcopy�ʹ�ӡprint����������Ϸ�ʽ
//�ص������㷨����滻�����ҷ�װ���㷨��
public class Image {

	private String name;
	private int size;
	private Print p;
	private Copy c;
	
	public Image(String name,int size,Print p,Copy c){
		this.name = name;
		this.size = size;
		this.p = p;
		this.c = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Print getP() {
		return p;
	}

	public void setP(Print p) {
		this.p = p;
	}

	public Copy getC() {
		return c;
	}

	public void setC(Copy c) {
		this.c = c;
	}
	
	public static void main(String[] args){
		Copy cp = new MachineCopy();
		Print pn = new ComputerPrint();
		Image i = new Image("wk2016",2016,pn,cp);
		i.getP().print();
		i.getC().copy();
	}
	
}
