package observablepattern;

import java.util.Observable;

public class WeatherData extends Observable{
	private float temperature;
	private float pressure;
	
	public WeatherData(){
		
	} //������������Ҫ��ʼ���۲����б���
	
	public void measurementsChanged(){
		setChanged(); //��֮ǰҪ���ô˷���
		notifyObservers(); //����û�д������ݸ�update��˵���������ķ�ʽ
	}
	public void measurementsChanged2(int args){
		setChanged(); //��֮ǰҪ���ô˷���
		notifyObservers(new Integer(args)); //����û�д������ݸ�update��˵���������ķ�ʽ
	}
	public void setMeasurements(float temperature,float pressure){
		this.temperature = temperature;
		this.pressure = pressure;
		measurementsChanged();
	}

	public void setMeasurements2(float temperature,float pressure,int args){
		this.temperature = temperature;
		this.pressure = pressure;
		measurementsChanged2(args);
	}
	
	public float getTemperature() {
		return temperature;
	}


	public float getPressure() {
		return pressure;
	}

	
	

}
