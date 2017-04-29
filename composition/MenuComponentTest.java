package composition;




public class MenuComponentTest {


	public void test() {
		//�����˵���
		MenuComponent coffeeMenuComponent=new Menu("���Ȳ˵�", "���ֿ�ζ�Ŀ���");
		MenuComponent dessert=new Menu("���˵�", "�ȿ��ȵ�ʱ�򣬻������������");
		MenuComponent beverage=new Menu("���ϲ˵�", "Ʒ������ʱ������������");
		beverage.add(new MenuItem("����ѩ��", 22, "�ӱ����ڸи���", true));
		dessert.add(new MenuItem("���̷��۱����", 57, "�ڸ���ӱ���أ��Ӿ�Ч��Ҳ��һ��", true));
		dessert.add(new MenuItem("С�����̻ư�", 37, "��̬�����С�����̻ư�", true));
		dessert.add(beverage);
		coffeeMenuComponent.add(dessert);
		coffeeMenuComponent.add(new MenuItem("��������", 100, "������ţ�̵Ľ���", true));
		coffeeMenuComponent.add(new MenuItem("Խ�Ͽ���", 200, "���ô�����Խ�Ͽ��ȶ�", true));
		coffeeMenuComponent.add(new MenuItem("��ʽ����", 80, "���µķ�ζ�в�ʧ����", true));
		
		MenuComponent chineseMenuComponent=new Menu("�й��˲˵�", "��ζ���й���");
		chineseMenuComponent.add(new MenuItem("������", 45, "���������Ǵ��˵Ĵ���ˣ��ɼ����⡢�������������׳��ƶ��ɣ������ó�", false));
		chineseMenuComponent.add(new MenuItem("�Ǵ��Ｙ", 78, "�Ǵ��Ｙɫ�����������ɿڡ���������", false));
		chineseMenuComponent.add(new MenuItem("��Ѽ", 80, "������Ѽ������Ϊ��������ζ�����������⣬������ɫ���������ϸ�ۣ�ζ�����񣬷ʶ��������ɫ������������", false));
		
		MenuComponent allmenus=new Menu("���˵�", "���в˵������");
		allmenus.add(coffeeMenuComponent);
		allmenus.add(chineseMenuComponent);
		
		Waitress waitress=new Waitress(allmenus);
		waitress.print();
		System.out.println("\n\n\n");
		System.out.println("==========================��ӡ��ʳ====================================");
		waitress.printVegetarianName();
		
	}

}
