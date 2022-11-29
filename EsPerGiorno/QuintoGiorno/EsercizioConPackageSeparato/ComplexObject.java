package pacakge2EsGiorno5;



public interface ComplexObject{            //non necessariamente dovrebbe essere pubblica
	
	 public default void dafeaultTest() {    
			
		ComplexObjectImpl complexObjectImpl=new ComplexObjectImpl();	

}
	
	void process1();
	void process2();
	void process3();		
}

class ComplexObjectImpl implements ComplexObject{

	@Override
	public void process1() {
		// TODO Auto-generated method stub
		System.out.println("1 ");
	}

	@Override
	public void process2() {
		// TODO Auto-generated method stub
		System.out.println("2 ");
	}

	@Override
	public void process3() {
		// TODO Auto-generated method stub
		System.out.println("3 ");
	}
	
}







