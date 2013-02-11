import java.text.DecimalFormat;

/*  most of these method names have an m prefix, meaning matrix.
 * 
 * TODO:
 *  cleaner, better transpose methods. 
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
	
	/*  checkDim
	 * 	-check that the incoming arguments of the 2D array argX and argY, 
	 *   are compatible with int x and int y.
	 *   if x or y is negative or zero, assume those parameters are n.
	 */
	public static void checkDim(int argX, int argY, int x, int y){
		try {
			/* Intended interpretation:
			 * If (arg is supposed to be a set length), AND (the arg is not the set length),
			 * throw exception.
			 */
			if ( ((x > 0) && (argX != x)) || ((y > 0) && (argY != y)) )
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
		}
	}

	public static void checkSquare(double[][] x){
		try {
			if (!(x.length == x[0].length))
				throw new NotCompatibleException();
		} catch (NotCompatibleException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkEqualDim(double[][] x, double[][] y) {
		try {
			if (!(x.length == y.length && x[0].length == y[0].length))
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
	
	public static double[][] mConformableNxOne(double[] x){
		double[][] conformable = new double[x.length][1];
		for(int i = 0; i < x.length;i++)
			conformable[i][0] = x[i];
		return conformable;
	}
	
	public static double[] mTransposeNxOne(double[][] oldX){
		checkDim(oldX.length, oldX[0].length,1,-1);
		
		double[] x = new double[oldX[0].length]; 
		for(int i = 0;i < oldX.length;i++){
			x[i] = oldX[0][i];
		}
		return x;
	}
	
	public static double[][] mTransposeOnexN(double[] oldX){
		double[][] x = new double[1][oldX.length]; 
		for(int i = 0;i < oldX.length;i++){
			x[0][i] = oldX[i];
		}
		return x;
	}

	public static double[][] mTransposeOnexN(double[][] oldX){
		checkDim(oldX.length,oldX[0].length, -1,1);
		
		double[][] x = new double[1][oldX.length]; 
		for(int i = 0;i < oldX.length;i++){
			x[0][i] = oldX[i][0];
		}
		return x;
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
	
	public static double[][] mSubtract(double[] oldX, double[] oldY){
		double[][] x = mConformableNxOne(oldX);
		double[][] y = mConformableNxOne(oldY);
		return mSubtract(x,y);
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
	
	public static double mConditionNum(double[][] x){
		Algorithms algo = new Algorithms();
		return mNorm(x)*mNorm(algo.inverse(x));
	}
	
	public static double mNorm(double[][] x){
		
		checkSquare(x);
		
		double[] sum = new double[x.length];
		double max = Double.MIN_VALUE;
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				sum[i] += x[i][j];
			}
		}
		for (int i = 0; i < sum.length; i++) {
			if(sum[i]>max){
				max = sum[i];
			}
		}
		return max;
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
