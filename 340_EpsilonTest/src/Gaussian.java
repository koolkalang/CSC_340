//ctrl+shift+/ - comment block 

public class Gaussian {
	
	static double max = Double.MIN_VALUE;
	static double min = Double.MAX_VALUE;
	
	public static void main(String[] args){
		
		double rand1;
		double rand2;
		double x1;
		double x2;
		double range;
		int[] test = new int[100];
		
		for(int i = 0;i<30000;i++)
		{
			rand1 = Math.random();
			rand2 = Math.random();
			
			x1 = Math.cos(2*Math.PI*rand2)*Math.sqrt(-2*Math.log(rand1));
			x2 = Math.sin(2*Math.PI*rand2)*Math.sqrt(-2*Math.log(rand1));
			
			//System.out.println(x1+"\t"+rand1);
			//System.out.println(x2+"\t"+rand2);++++
		
			System.out.println((x1));
			System.out.println((x2));
/*			
			max(x1);
			max(x2);
			min(x1);
			min(x2);
			*/
			//test[(int)(x1*.5)+49] += 1;
			//test[(int)(x2*.5)+49] += 1;
			
		}
/*		
		System.out.println("=============================");
		System.out.println(min);
		System.out.println(max);
		System.out.println("range: "+(Math.abs(min)+Math.abs(max)));
		System.out.println("=============================");
		*/
/*		for(int x:test)
		{
			System.out.println(x);
		}
*/	
	}
	
	public static void max(double next){
		if(next > max)
			max = next;
	}
	
	public static void min(double next){
		if(next < min)
			min = next;
	}
}


