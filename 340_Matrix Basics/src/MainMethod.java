import java.io.FileNotFoundException;

public class MainMethod extends HelperMethods{
	
	public static void main(String[] args){

		Algorithms algoWorker = new Algorithms();
		double[][] gauss;	

		Read mRead = new Read("resources/2013 Test 1 linear.txt");
		gauss = mRead.getMatrix();
		
		double[][] setOne;
		double[][] setTwo;

		Read reader = new Read("resources/2013 Test 1 data.txt");
		setOne = reader.getSetOne();
		setTwo = reader.getSetTwo();
		
		System.out.println("\nSystem\n");
			printMatrix(gauss);
		System.out.println("\nGauss-Jordan Solution\n");
			printMatrix(algoWorker.gaussJordan(gauss));	
		System.out.println("\nGaussian Solution\n");
			printMatrix(algoWorker.gaussian(gauss));
		System.out.println("\nSet One Average\n");
			printArray(averageSet(setOne));
		System.out.println("\nCovariance\n");
			printMatrix(covariance(setOne));
			
		System.out.println("discrim");
		double g1, g2;
		TwoDSet datOne = new TwoDSet(setOne);
		TwoDSet datTwo= new TwoDSet(setTwo);
		
		for (int i = 0; i < datOne.set.length; i++) {
			g1 = discrimFunction(datOne.set[i],datOne.avg,datOne.cov);
			g2 = discrimFunction(datOne.set[i],datTwo.avg,datTwo.cov);
			if(g1 > g2)
				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g1");
			else
				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g2");
		}
		System.out.println("==============setTwo==================");
		for (int i = 0; i < datTwo.set.length; i++) {
			g1 = discrimFunction(datTwo.set[i],datOne.avg,datOne.cov);
			g2 = discrimFunction(datTwo.set[i],datTwo.avg,datTwo.cov);
			if(g1 > g2)
				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g1");
			else
				System.out.println(datOne.set[i][0]+", "+datOne.set[i][1] + " is in g2");
		}
		System.out.println("=========mean vectors=================");
		g1 = discrimFunction(datOne.avg,datOne.avg,datOne.cov);
		g2 = discrimFunction(datOne.avg,datTwo.avg,datTwo.cov);
		System.out.println(g1 +"\t"+ g2);
		if(g1 > g2)
			System.out.println("avg of g1 should be in g1");
		g1 = discrimFunction(datTwo.avg,datOne.avg,datOne.cov);
		g2 = discrimFunction(datTwo.avg,datTwo.avg,datTwo.cov);
		System.out.println(g1 +"\t"+ g2);
		if(g2 > g1)
			System.out.println("avg of g2 should be in g2");
		
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
		
		TwoDSet dataOne = new TwoDSet(setTest);
		TwoDSet dataTwo = new TwoDSet(setTest2);
		
		double g1;
		double g2;
		//System.out.println("average set Test One\t"+avg[0]+"\t"+avg[1]);
		
		//double[][] inv = algoTest.inverse(cov);
		System.out.println("\ncovariance of covTest\n");
			printMatrix(covariance(setTest));
		System.out.println("\ninverse of covariance of covTest\n");
			printMatrix(algoTest.inverse(covariance(setTest)));
		System.out.println("\ndeterminant covariance of covTest\n");
			System.out.println(mTwoxTwoDeterminant(covariance(setTest)));
		System.out.println("\ndiscriminant function test\n"); 
			System.out.println("setOne using f(x) of set Two");
			for (int i = 0; i < setTest.length; i++) {
				g1 = discrimFunction(dataTwo.set[i],dataOne.avg,dataOne.cov);
				g2 = discrimFunction(dataTwo.set[i],dataTwo.avg,dataTwo.cov);
				if(g1 > g2)
					System.out.println(dataOne.set[i][0]+", "+dataOne.set[i][1] + " is in g1");
				else
					System.out.println(dataOne.set[i][0]+", "+dataOne.set[i][1] + " is in g2");
			}
	}

}

