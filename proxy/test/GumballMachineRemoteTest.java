package proxy.test;


import java.rmi.RemoteException;

import javax.imageio.spi.RegisterableService;

import proxy.GumballMachine;
import proxy.GumballMachineRemote;
import proxy.RegisterRmiServer;


public class GumballMachineRemoteTest {


	public void test() {
		try {
			//����Զ�̷���
			GumballMachineRemote remoteServer=new GumballMachine("�пƴ�", "��ѧ���", 100);
			//��
			int port=4567;
			RegisterRmiServer.registerRmi(port,"rmi://192.168.1.101:"+port+"/remoteServer", remoteServer);
			//�ȴ��ͻ��˵Ĳ���RMI����
			while(true){
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testClient(){
		int port=4567;
		GumballMachineRemote remoteServer=RegisterRmiServer.getRmiServer("rmi://192.168.1.101:"+port+"/remoteServer");
		try {
			System.out.println(remoteServer.getCount());
			System.out.println(remoteServer.getLocation());
			System.out.println(remoteServer.getDescription());
			System.out.println(remoteServer.getCurrState());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
