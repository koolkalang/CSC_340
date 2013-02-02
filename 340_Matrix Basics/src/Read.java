import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Read {
	
	Scanner txtscanner;
	File data;
	String fileName;

/* Read Constructor
 * input string txt
 */
	Read(String txt){
		fileName = txt;
		try { 
			setScanner(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

/* setScanner
 * 
 */
	private void setScanner(String txt) throws FileNotFoundException{
		data = new File(txt);
		txtscanner = new Scanner(data);
	}
	
/* getSetOne
 *  
 */
	public double[][] getSetOne(){
		return getSets(0);
	}
/* getSetTwo
 * 
 */
	public double[][] getSetTwo(){	
		return getSets(1);
	}
	
/* getClassesTestOne
 * returns matrix of data from test one. int takes either 0 or 1, 
 * for either the first class or second class.
 */
	private double[][] getSets(int set){
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		
	//removes first two lines.
		txtscanner.nextLine();
		txtscanner.nextLine();
		
		while(txtscanner.hasNext()){
			if(set == 0){
				x.add(txtscanner.nextDouble());
				y.add(txtscanner.nextDouble());
				txtscanner.next();
				txtscanner.next();
			}else if(set == 1){
				txtscanner.next();
				txtscanner.next();
				x.add(txtscanner.nextDouble());
				y.add(txtscanner.nextDouble());
			}else
				return null;
		}
		
		double[][] matrixSet = new double[x.size()][2];
		for(int i = 0; i < matrixSet.length; i++){
			matrixSet[i][0] = x.get(i);
			matrixSet[i][1] = y.get(i);
		}
		
		//reset Scanner
		try {
			setScanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matrixSet;
	}

	public double[][] getMatrix(){
		ArrayList<ArrayList<Double>> x = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> temp = new ArrayList<Double>();
		int row = 0;
		
		while(txtscanner.hasNextLine()){
			Scanner tempScanner = new Scanner(txtscanner.nextLine());
			while(tempScanner.hasNext()){
				temp.add(tempScanner.nextDouble());
			}
			x.add(row, temp);
			row++;
			temp = new ArrayList<Double>();
		}
		
		double[][] matrixSet = new double[x.size()][x.get(0).size()];
		for(int i = 0; i < matrixSet.length; i++){
			for (int j = 0; j < matrixSet[i].length; j++) {
				matrixSet[i][j] = x.get(i).get(j);
			}
		}
		
		//reset Scanner
		try {
			setScanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matrixSet;
	}
}