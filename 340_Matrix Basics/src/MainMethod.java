import java.io.FileNotFoundException;

public class MainMethod extends HelperMethods{
	
	public static void main(String[] args){

		Algorithms algoWorker = new Algorithms();
		double[][] gauss;	

		Read mRead = new Read("resources/2013 Test 1 linear.txt");
		gauss = mRead.getMatrix();
		
		double[][] setOne;

		Read reader = new Read("resources/2013 Test 1 data.txt");
		setOne = reader.getSetOne();
		
		
		System.out.println("\nSystem\n");
			printMatrix(gauss);
		System.out.println("\nGauss-Jordan Solution\n");
			printMatrix(algoWorker.gaussJordan(gauss));	
		System.out.println("\nGaussian Solution\n");
			printMatrix(algoWorker.gaussian(gauss));
		System.out.println("\nSet One Average\n");
			printArray(averageSet(setOne));
		
		
	}

	public static void consoleTests(){
		
		double[][] setOne;
		double[][] setTwo;
		
		double[][] identSet = mAddIdentity(6);
		double[][] identSet2 = mMultiplyIdentity(6);
		
		double[][] addA = {{1,2},{4,5}}; 
		double[][] addB = {{3,1},{5,3}};
		
		double[][] multiplyC = {{1,2,3},{4,5,6}}; 
		double[][] multiplyD = {{3},{5},{9}};
		
		Read reader = new Read("resources/2013 Test 1 data.txt");
		setOne = reader.getSetOne();
		setTwo = reader.getSetTwo();
		
		//=========================================================
		System.out.println("\nx1\t\ty1");
		printMatrix(setOne);
		
		//=========================================================
		System.out.println("\n");
		printMatrix(identSet);
		System.out.println("\n");
		printMatrix(identSet2);
		
		//=========================================================
		System.out.println("\n");
		printMatrix(mAdd(addA, addB));
		System.out.println("\n");
		printMatrix(mSubtract(addA, addB));
		System.out.println("\n");
		printMatrix(mMultiply(multiplyC, multiplyD));
		System.out.println("\n");
		printMatrix(mScalar(addA,34.5));	
		
		//System.out.println("\nInverse Solution\n");
		//	printMatrix(algoWorker.inverse(gauss));
			
		System.out.println("==============TEST GAUSS===================");
		double[][] testGuass = {{2,1,-1,8},{-3,-1,2,-11},{-2,1,2,-3}};
		System.out.println("Gaussian TEST");
		//printMatrix(algoWorker.gaussian(testGuass));
		System.out.println("Gauss-Jordan TEST");
		//printMatrix(algoWorker.gaussJordan(testGuass));
		
		System.out.println("==============TEST INVERSE===================");
		double[][] testInverse = {{4,7},{2,6}};
		//printMatrix(algoWorker.inverse(testInverse));
		System.out.println("==============TEST DETERMINANT===================");
		double[][] testDeterm = {{1,4,0},{0,2,6},{-1,0,1}};
		//System.out.println(algoWorker.nDeterminant(gauss));
		
		System.out.println("==============TEST AVG===================");
		double[][] testAvg = {{1,9},{2,8},{3,7},{4,6},{5,5},{6,4}};
		printMatrix(testAvg);
		//printMatrix(setOne);
		printArray(averageSet(testAvg));
		
	}
	
	private static double[][] addIdentity(double[][] x){
		double[][] identityX = mMultiplyIdentity(x.length);
		double[][] newX = new double[x.length][x.length*2];
		
		for (int i = 0; i < newX.length; i++) {
			for (int j = 0; j < newX.length; j++) {
				if(j<x.length)
					newX[i][j] = x[i][j];
				else
					newX[i][j] = identityX[i][j-x.length];
			}	
		}
		
		return newX;
	}

}

