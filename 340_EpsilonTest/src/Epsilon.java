//prelim answer float: 1.1920929E-7
//prelim answer double: 2.220446049250313E-16


public class Epsilon {
	public static void main(String[] args){
		
		float em	= 1;
		float x		= 0;
		//int count	= 0;
		
		do{
		em = em/2;
		x = 1 + em;
		//System.out.println(++count);
		}
		while(x>1);
		
		System.out.println(em*2);
		
	}
}
