import java.text.DecimalFormat;

/*  most of these method names have an m prefix, meaning matrix.
 * 
 */

public class Matrix{
	
	
	
	public static void checkCompatibility(double[][] x, double[][] y) {
			try {
				if (!(x[0].length == y.length))
					throw new NotCompatibleException();
			} catch (NotCompatibleException e) {
				e.printStackTrace();
			}
	}

	public static void checkEqualDim(double[][] x, double[][] y) {
		try {
			if (!(x[0].length == y.length))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
		}
	}
	
	public static double mTwoxTwoDeterminant(double[][] d){
		
		
		return d[0][0]*d[1][1]-d[0][1]*d[1][0];
	}

	public static double[][] mCopy(double[][] x){
		
		double[][] y = new double[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				y[i][j] = x[i][j];
			}
		}
		
		return y;
	}
	
	public static double[][] mMultiplyIdentity(int n){
		
		double[][] x = new double[n][n];
		for(int i = 0;i<n;i++)
			x[i][i] = 1;
		return x; 
	}
	
	public static double[][] mAddIdentity(int n){
		double[][] x = new double[n][n];
		for(int i = 0;i < x.length;i++)
			for(int j = 0;j < x[i].length;j++)
				x[i][j] = 0;
		return x;
	}
	
	public static double[][] mAdd(double[][] x, double[][] y){
		
		checkEqualDim(x,y);
		
		double[][] z = new double[x.length][x[0].length];
		for(int i = 0;i < x.length;i++)
			for(int j = 0;j < x[i].length;j++)
			z[i][j] = x[i][j]+y[i][j];
		return z; 
	}
	
	public static double[][] mSubtract(double[][] x, double[][] y){
		
		checkEqualDim(x,y);
		
		double[][] z = new double[x.length][x[0].length];
		for(int i = 0;i < x.length;i++)
			for(int j = 0;j < x[i].length;j++)
			z[i][j] = x[i][j]-y[i][j];
		return z; 
	}
	
	public static double[][] mMultiply(double[][] x, double[][] y){
		
		checkCompatibility(x,y);
		
		double[][] z = new double[x.length][y[0].length];
		
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[0].length; j++) {
				for (int k = 0; k < x[0].length; k++) {
					z[i][j] += x[i][k] * y[k][j];
				}
			}
		}
		return z; 
	}
	
	public static double[][] mScalar(double[][]x, double y){
		
		double[][] z = mCopy(x);
		
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; j++) {
				z[i][j] = x[i][j]*y;
			}
		}
		return z;
		
	}
	
	private static 
	double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
	}
	
	public static void printMatrix(double[][] m){
		for(int i = 0;i<m.length;i++){
			for(int j = 0;j<m[i].length;j++)
				System.out.print(roundTwoDecimals(m[i][j])+"\t");
			System.out.println();
		}
	}
	
	public static void printArray(double[] m){
		for(int i = 0;i<m.length;i++){
				System.out.print(roundTwoDecimals(m[i])+"\t");
		}
		System.out.println();
	}
	
}
