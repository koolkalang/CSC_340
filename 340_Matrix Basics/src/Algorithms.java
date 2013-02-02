
public class Algorithms extends Matrix{
	
	private enum Algo{
		GAUSSIAN, GAUSSJORDAN, INVERSE, NONE
	}
	private Algo algoSet;
	
	public Algorithms(){
		algoSet = Algo.NONE;
	}
	
	public void checkAugmented(double[][] x){
		try {
			if (!(x[0].length==x.length+1))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
		}
		
	}
	
	public void checkNxN(double[][] x){
		try {
			if (!(x.length==x[0].length))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	private void checkValid(){
		try{
			if(algoSet == Algo.NONE)
				throw new IllegalArgumentException();
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
	}
	
	public double[][] gaussJordan(double[][] c){
		algoSet = Algo.GAUSSJORDAN;
		checkAugmented(c);
		return  gaussBase(c);
	}
	
	public double[][] gaussian(double[][] c){
		algoSet = Algo.GAUSSIAN;
		checkAugmented(c);
		return  gaussBase(c);
	}
	
	public double[][] inverse(double[][] c){
		double[][] iCopy = mCopy(c);
		iCopy = addIdentity(iCopy);
		algoSet = Algo.INVERSE;
		return  gaussBase(iCopy);
	}
	
	
	/*  Assumes matrix argument is already augmented.
	 * 
	 */
	public double[][] gaussBase(double[][] cCopy){
		//===================================
		/*
		if((j-1)==1){
			System.out.println("/////");
			printMatrix(c);
			System.out.println("/////");	
		}
		*/
		//===================================
		
		checkValid();
		double[][] c = mCopy(cCopy);
		
		
		int E = 1;
		double max = Double.MIN_VALUE;
		int p = 0;
		//make sure all js are j-1
		for (int j = 1; j <= c.length; j++) {
			
			//computePivot
			for(int i = 0;i<c.length;i++){
				if(Math.abs(c[i][j-1])>max){
					p = i;
					max = Math.abs(c[i][j-1]);
				}
			}
			
			//check for 0
			if(c[p][j-1] == 0){
				E = 0;
				return c;
			}
			
			//interchange
			if(p>j-1){
				double[] temp = c[j-1];
				c[j-1] = c[p];
				c[p] = temp;
			}
			
			//divide row j by Cjj
			double jj = c[j-1][j-1];
			for(int i = 0;i<c[j-1].length;i++){
				c[j-1][i] = c[j-1][i]/jj;
			}
			
			//for each i != j-1, row i - c[i][j-1]*row j
			switch(algoSet){
			case INVERSE:
			case GAUSSJORDAN:
				for (int i = 0; i < c.length; i++) {
					double ij = c[i][j-1];
					if(i != j-1){
						for(int k = j-1; k<c[i].length;k++)
							c[i][k] = c[i][k] - ij*c[j-1][k];
					}
				}
				break;
			case GAUSSIAN:
				for (int i = 0; i < c.length; i++) {
					if(i > j-1){
						double ij = c[i][j-1];
						for(int k = j-1; k<c[i].length;k++){
								c[i][k] = c[i][k] - ij*c[j-1][k];
						}
					}
				}
				break;
			default:
				break;
			
			}
			
			//reset max
			p = 0;
			max = Double.MIN_VALUE;
		
		}
		
		return c;
	}
	
	private double[][] addIdentity(double[][] x){
		
		checkNxN(x);
		double[][] identityX = mMultiplyIdentity(x.length);
		double[][] newX = new double[x.length][x.length*2];
		
		for (int i = 0; i < newX.length; i++) {
			for (int j = 0; j < newX[i].length; j++) {
				if(j<x.length)
					newX[i][j] = x[i][j];
				else{
					newX[i][j] = identityX[i][j-x.length];
				}
			}	
		}
		
		return newX;
	}
	
}
