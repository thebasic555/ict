import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class Main {
	
	private static double[][] data, d;
	private static int _a[] = {1,2,3,4};
	private static String _filename = "test.model";
	private static String _str ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new Array2DRowRealMatrix(final _a));
//		System.out.println(ones(4, 4));
//		System.out.println(createFile(_filename));
		//readfile();
		
		javaSplit("16,Casino (1995),Crime|Drama");
		
	}
	
	private static void javaSplit(String _data) {
		// TODO Auto-generated method stub
		String[] spt = _data.split("\\(");
		spt = spt[1].split("\\)");
		System.out.println(spt[0]);
	}

	private static void readfile() {
		// TODO Auto-generated method stub
		try {
			BufferedReader myObj_1 = new BufferedReader( new FileReader("movies.csv"));
			String line;
			try {
				while ((line = myObj_1.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/// done
	private static void writeFile(String filename,String string) {
		try {
			FileWriter _fw = new FileWriter(filename);
			_fw.write(string.toString());
			_fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/// done
	private static String createFile(String filename) {
		// TODO Auto-generated method stub
		File _cf = new File(filename);
		try {
			_cf.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writeFile(filename, "string");
		
		return _cf.getName();
	}
	
	
	
	private static RealMatrix ones(int n, int m) {
		
//		{1,2,3,4}
//		{0,9,8}
//		
//		01 02 03 04
//		91 92 93 94 
//		81 82 83 84
		
		
		d = new double[n][m];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; r++) {
//				d[][] = "";
//			
			}	
		}
		return new Array2DRowRealMatrix(d, false);
	}
//	Array2DRowRealMatrix
//	{
//		{1.0,2.0,3.0,4.0},
//		{4.0,1.0,2.0,3.0},
//		{3.0,4.0,1.0,2.0},
//		{2.0,3.0,4.0,1.0}
//	}
	
	


}
