public class HelperMethods extends Matrix {


	public static void checkAugmented(double[][] x){
		try {
			if (!(x[0].length==x.length+1))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void checkNxN(double[][] x){
		try {
			if (!(x.length==x[0].length))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	
	public static double[] averageSet(double[][] x){
		double[] avg = {0,0};
		
		for (int i = 0; i < x.length; i++) {
			avg[0] += x[i][0];
			avg[1] += x[i][1];
		}
		
		avg[0] /= x.length;
		avg[1] /= x.length;
		return avg;
	}
	
	public static double[][] covariance(double[][] set){
		double[][] covariance = new double[2][2];
		double[] averageV = averageSet(set);
		double[] current = new double[2];
		double[][] middle;
		double[][] middlet = new double[1][2];
		
		for (int i = 0; i < set.length; i++) {
			current[0] = set[i][0];
			current[1] = set[i][1];
			
			middle = mSubtract(current,averageV);
			
//			System.out.println("=== Sanity Check ===");
//			System.out.println("current length "+current.length);
//			System.out.println("average length "+averageV.length);
//			System.out.println("middle length "+middle.length);
//			System.out.println("=== Sanity Check ===");
			
	//quick and dirty transpose
			middlet[0][0] = middle[0][0];
			middlet[0][1] = middle[1][0];
			
			covariance = mAdd(covariance,mMultiply(middle,middlet));	
		}
		
		
		return mScalar(covariance,(double)1/set.length);
	}

}

