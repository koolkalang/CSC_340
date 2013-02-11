/* Acts as a struct for sets.
 * 
 */
public class TwoDSet extends HelperMethods {
	public double[][] cov;
	public double[][] set;
	public double[] avg;
	
	public TwoDSet(double[][] inSet){
		set = inSet;
		cov = covariance(set);
		avg = averageSet(set);
	}
	
	
}
