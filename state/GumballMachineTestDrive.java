package state;

import java.util.Random;

interface State {
   public void insertQuarter();   // Ͷ��25��Ǯ
   public void ejectQuarter();    // �ܾ�25��Ǯ
   public void turnCrank();       // ת������
   public void dispense();        // �����ǹ�
}

class NoQuarterState implements State{
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine){
		this.gumballMachine=gumballMachine;
	}
	// Ͷ��25��Ǯ
	public void insertQuarter() {
		System.out.println("You insert a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
    // �ܾ�25��Ǯ
	public void ejectQuarter() {
		System.out.println("You haven't insert a quarter");
	}
    // ת������
	public void turnCrank() {
		System.out.println("You turned crank,but you there's no quarter");
	}
	// �����ǹ�
	public void dispense() {
		System.out.println("You need to pay first");
	}
}


class HasQuarterState implements State {
	Random randomWinner = new Random(System.currentTimeMillis()); 

	GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	// Ͷ��25��Ǯ
	public void insertQuarter() {
		System.out.println("You can not insert anther quarter");
	}
	// �ܾ�25��Ǯ
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
    // ת������
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		System.out.println("winner =" + winner);
		if((winner ==0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}
	// �����ǹ�
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
}

class SoldState implements State{
	
	GumballMachine gumballMachine;
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	// Ͷ��25��Ǯ
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
	// �ܾ�25��Ǯ
	public void ejectQuarter() {
		System.out.println("Sorry,you have already turn crank");
	}
	// ת������
	public void turnCrank() {
		System.out.println("trun twice ,doesn't give you anthor gamball!");
	}
	// �����ǹ�
	public void dispense() {
		gumballMachine.releaseBall();
			if(gumballMachine.getCount()>0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
			System.out.println("Opps,out of gamball!");	
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}


class SoldOutState implements State{
	
	GumballMachine gumballMachine;
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine=gumballMachine;
	}
    // Ͷ��25��Ǯ
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
	// �ܾ�25��Ǯ
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
    // ת������
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("You turned, but there are no gumballs");
	}
	// �����ǹ�
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("No gumball dispensed");
	}
}


class WinnerState implements State{
    GumballMachine gumballMachine;
    
    public WinnerState(GumballMachine gumballMachine){
    	this.gumballMachine = gumballMachine;
    }
    // Ͷ��25��Ǯ
    @Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
    	System.out.println("Please wait, we're already giving you a gumball");
	}
    // �ܾ�25��Ǯ
    @Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
    	System.out.println("Sorry,you have already turn crank");
	}
    // ת������
	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("trun twice ,doesn't give you anthor gamball!");
	}
	// �����ǹ�
	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("You're a Winner! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
	    if(gumballMachine.getCount() == 0) {
	    	gumballMachine.setState(gumballMachine.getSoldOutState());
	    } else {
	    	gumballMachine.releaseBall();//��������
	    	if(gumballMachine.getCount()>0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
			    System.out.println("Opps,out of gamball!");	
			   gumballMachine.setState(gumballMachine.getSoldOutState());
		   }
	    }
	}
}


class GumballMachine {
	//״̬ʵ��
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	// ʵ������state����ʼ��Ϊ�ǹ�����״̬
	State state = soldOutState; 
	// ��¼������װ���ǹ�����Ŀ����ʼ������û��װ�ǹ���
	int count=0;
	// ������ȡ���ǹ��ĳ�ʼ��Ŀ����������һ��ʵ������count��
	public GumballMachine(int numberGumballs) {
		// ÿ��״̬������һ��״̬ʵ��
		soldOutState=new SoldOutState(this);
		noQuarterState=new NoQuarterState(this);
		hasQuarterState=new HasQuarterState(this);
		soldState=new SoldState(this);
		winnerState = new WinnerState(this);
		
		this.count = numberGumballs;
		// ������0���ǹ����ͽ�״̬����ΪNoQuarterState
		if(numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	// ȡ�û����ڵ��ǹ���Ŀ
	public int getCount() {
		return count;
	}
    // ȡ���ǹ�����״̬
	public State getSoldOutState() {
		return soldOutState;
	}
    // ȡ��û��25��Ǯ״̬
	public State getNoQuarterState() {
		return noQuarterState;
	}
    // ȡ��ӵ��25��Ǯ
	public State getHasQuarterState() {
		return hasQuarterState;
	}
    // ȡ���۳��ǹ�״̬
	public State getSoldState() {
		return soldState;
	}
	// ȡ��Ӯ��״̬
	public State getWinnerState() {
		return winnerState;
	}
    // Ͷ��25��Ǯ
	public void insertQuarter(){
		state.insertQuarter();
	}
	// �ܾ�25��Ǯ
	public void ejectQuarter(){
		state.ejectQuarter();
	}
	// ת������
	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}
	// ����״̬
	public void setState(State state){
		this.state=state;
	}
	// �ǹ�������һ��
	public void releaseBall(){
		System.out.println("A gumball comes rolling out of the solt...");
		if(count!=0){
			count--;
		}
	}
}



public class GumballMachineTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        
        System.out.println(gumballMachine);
        System.out.println("The current gumball number is:" + gumballMachine.getCount());
        System.out.println("****************************************");
        
        
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        
        System.out.println(gumballMachine);
        System.out.println("The current gumball number is:" + gumballMachine.getCount());
        System.out.println("****************************************");
        
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine); 
        System.out.println("The current gumball number is:" + gumballMachine.getCount());
        System.out.println("****************************************");
        
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine); 
        System.out.println("The current gumball number is:" + gumballMachine.getCount());
        System.out.println("****************************************");
	}

}

