/* Acts as a struct for sets.
 * 
 */
public class TwoDSet extends HelperMethods {
	public double[][] cov;
	public double[][] set;
	public double[] mean;
	
	public TwoDSet(double[][] inSet){
		set = inSet;
		cov = covariance(set);
		mean = averageSet(set);
	}
	
	
}
