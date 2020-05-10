//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//public class SimpleMovieRecommender implements BaseMovieRecommender {
//
//	@Override
//	public Map<Integer, Movie> loadMovies(String movieFilename) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<Integer, User> loadUsers(String ratingFilename) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void loadData(String movieFilename, String userFilename) {
//		// TODO Auto-generated method stub
//		
//		//small/users.test.csv
//		
//		String csvFile = "small/users.test.csv";
//		String csvFile2 = userFilename;
//        BufferedReader br = null;
//        BufferedReader br2 = null;
//        String line = "";
//        //String cvsSplitBy = ",";
//
//        try {
//
//            br = new BufferedReader(new FileReader(csvFile));
//            br2 = new BufferedReader(new FileReader(csvFile2));
//            
//            
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//                //String[] country = line.split(cvsSplitBy);
//
//                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
//            	System.out.println(line);
//
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//	}
//
//	@Override
//	public Map<Integer, Movie> getAllMovies() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<Integer, User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void trainModel(String modelFilename) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void loadModel(String modelFilename) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public double predict(Movie m, User u) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<MovieItem> recommend(User u, int fromYear, int toYear, int K) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
