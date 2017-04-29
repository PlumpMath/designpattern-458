package observablepattern;

import java.util.Observable;
import java.util.Observer;

public class NowConditionsDisplay implements Observer{
	Observable o;
	private float temperature;
	private float pressure;

	public NowConditionsDisplay(Observable o){
		this.o = o;
		o.addObserver(this); //�Զ�ע��
	}
	
	public void update(Observable obs,Object args){ //���ڷ����ߵ��õ��ǵ�һ���汾����argsΪ��
		if(obs instanceof WeatherData){  
			WeatherData wd = (WeatherData)obs; //����Ҫʵ�����۲��ߣ�������ʵ������o
			this.temperature = wd.getTemperature();
			this.pressure = wd.getPressure();
			display();
			if(args != null){
				System.out.println("args-"+(Integer)args);
			}
		}
	}
	
	public void display(){
		System.out.println("current conditions:temperature-"+this.temperature+"----pressure-"+this.pressure);
	}
}
