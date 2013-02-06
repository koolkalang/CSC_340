
public class HelperMethods extends Matrix {


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

}

