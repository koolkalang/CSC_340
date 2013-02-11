import java.io.FileNotFoundException;

public class MainMethod extends HelperMethods{
	
	public static void main(String[] args){

		Algorithms algoWorker = new Algorithms();
		double[][] coeff;	

	//get resources
		Read mRead = new Read("resources/2013 Test 1 linear.txt");
		coeff = mRead.getMatrix();
		
		double[][] setOne;
		double[][] setTwo;

		Read reader = new Read("resources/2013 Test 1 data.txt");
		setOne = reader.getSetOne();
		setTwo = reader.getSetTwo();
		

		TwoDSet datOne = new TwoDSet(setOne);
		TwoDSet datTwo = new TwoDSet(setTwo);
		
		
		System.out.println("----1 mean vectors of the classes 1----");
			System.out.println("Class 1 Mean Vector: "+datOne.mean[0]+"\t"+datOne.mean[1]);
			System.out.println("Class 2 Mean Vector: "+datTwo.mean[0]+"\t"+datTwo.mean[1]);
		System.out.println("----2 covariance matrices of the classes 2----");
			System.out.println("Class 1 covariance: ");
			printMatrix(datOne.cov);
			System.out.println("Class 2 covariance: ");
			printMatrix(datTwo.cov);
		System.out.println("----3 determinats of the covariances 3----");
			System.out.println("Determinant 1: "+mTwoxTwoDeterminant(datOne.cov));
			System.out.println("Determinant 2: "+mTwoxTwoDeterminant(datTwo.cov));
		System.out.println("----4 inverse of the covariances 4----");
			System.out.println("Inverse 1: ");
				printMatrix(algoWorker.inverse(datOne.cov));
			System.out.println("Inverse 2: ");
				printMatrix(algoWorker.inverse(datTwo.cov));
			
			
			
//		System.out.println("\nSystem\n");
//			printMatrix(coeff);
//		System.out.println("\nGauss-Jordan Solution\n");
//			printMatrix(algoWorker.gaussJordan(coeff));	
//		System.out.println("\nGaussian Solution\n");
//			printMatrix(algoWorker.gaussian(coeff));
//		System.out.println("\nSet One Average\n");
//			printArray(averageSet(setOne));
//		System.out.println("\nCovariance\n");
//			printMatrix(covariance(setOne));
//			
//		System.out.println("discrim");
//		double g1, g2;		
//		for (int i = 0; i < datOne.set.length; i++) {
//			g1 = discrimFunction(datOne.set[i],datOne.mean,datOne.cov);
//			g2 = discrimFunction(datOne.set[i],datTwo.mean,datTwo.cov);
//			if(g1 > g2)
//				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g1");
//			else
//				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g2");
//		}
//		System.out.println("==============setTwo==================");
//		for (int i = 0; i < datTwo.set.length; i++) {
//			g1 = discrimFunction(datTwo.set[i],datOne.mean,datOne.cov);
//			g2 = discrimFunction(datTwo.set[i],datTwo.mean,datTwo.cov);
//			if(g1 > g2)
//				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g1");
//			else
//				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g2");
//		}
//		System.out.println("=========mean vectors=================");
//		g1 = discrimFunction(datOne.mean,datOne.mean,datOne.cov);
//		g2 = discrimFunction(datOne.mean,datTwo.mean,datTwo.cov);
//		System.out.println(g1 +"\t"+ g2);
//		if(g1 > g2)
//			System.out.println("avg of g1 should be in g1");
//		g1 = discrimFunction(datTwo.mean,datOne.mean,datOne.cov);
//		g2 = discrimFunction(datTwo.mean,datTwo.mean,datTwo.cov);
//		System.out.println(g1 +"\t"+ g2);
//		if(g2 > g1)
//			System.out.println("avg of g2 should be in g2");
		
			//consoleTests();
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
		
		Algorithms algoTest = new Algorithms();
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
	
		System.out.println("\nTest covariance, inverse\n");
		double[][] setTest = {{2,6},{3,4},{3,8},{4,6},};
		double[][] setTest2 = {{1,-2},{3,0},{3,-4},{5,-2}};
		
//		TwoDSet dataOne = new TwoDSet(setTest);
//		TwoDSet dataTwo = new TwoDSet(setTest2);
//		
//		double g1;
//		double g2;
//		//System.out.println("average set Test One\t"+avg[0]+"\t"+avg[1]);
//		
//		//double[][] inv = algoTest.inverse(cov);
//		System.out.println("\ncovariance of covTest\n");
//			printMatrix(covariance(setTest));
//		System.out.println("\ninverse of covariance of covTest\n");
//			printMatrix(algoTest.inverse(covariance(setTest)));
//		System.out.println("\ndeterminant covariance of covTest\n");
//			System.out.println(mTwoxTwoDeterminant(covariance(setTest)));
//		System.out.println("\ndiscriminant function test\n"); 
//			System.out.println("setOne using f(x) of set Two");
//			for (int i = 0; i < setTest.length; i++) {
//				g1 = discrimFunction(dataTwo.set[i],dataOne.mean,dataOne.cov);
//				g2 = discrimFunction(dataTwo.set[i],dataTwo.mean,dataTwo.cov);
//				if(g1 > g2)
//					System.out.println(dataOne.set[i][0]+", "+dataOne.set[i][1] + " is in g1");
//				else
//					System.out.println(dataOne.set[i][0]+", "+dataOne.set[i][1] + " is in g2");
//			}
	}

}

