package pacakge2EsGiorno5;

import pacakge2EsGiorno5.*;



//devo essere nello stesso pacchetto perché altrimenti ComplexObjectImpl non sarebbe visibile









public class ComplexObjectProxy implements ComplexObject{

	
	private ComplexObjectImpl objPr;    //uso private per fare in modo che il costruttore possa costruire solamente qui dentro
	
	


	public ComplexObjectProxy() {
		this.objPr = new ComplexObjectImpl();
			
	}		
	

	@Override
	public void dafeaultTest() {
		// TODO Auto-generated method stub
		ComplexObject.super.dafeaultTest();
	}

	@Override
	public void process1() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("Lmao");
	}


	
	@Override
	public void process2() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("AYYYYY");
	}

	@Override
	public void process3() {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis());
		System.out.println("AEEE");
	}

	
	
	
	
}















