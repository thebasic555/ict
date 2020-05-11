import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class SimpleMovieRecommender implements BaseMovieRecommender {

	Movie _movie;
	User _user;
	
	Map<Integer, Movie> _mMovies = new HashMap<Integer, Movie>();
	Map<Integer, User> _mUser = new HashMap<Integer, User>();
	
	//int[] _movieID;
	double[][] d;
	List<String> _lUserProp,_uid;
	List<String> _lMovieID = new ArrayList<String>();
	List<List<String>> _lUser = new ArrayList<List<String>>();
	
	public String _movieFilename,_userFilename,_str;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		File file = new File(movieFilename);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
//			int _im = 0;
			int _no = 0,_im = -1;
			
			while((line = reader.readLine())!=null) {
				line = line.trim();
				Integer mid = null;
				String title = null;
				Integer years = null;
				if(line.isEmpty()) {
					continue;
				}else if(_no > 0) {
					String[] limits = line.split(",");
					String _limits;
					if (limits.length > 3)
						_limits = limits[2];
					else
						_limits = limits[1];
					String[] spt = _limits.split("\\(");
					String _spt;
					if (spt.length > 2)
						_spt = spt[2];
					else
						_spt = spt[1];
					spt = _spt.split("\\)");
					
					if(limits.length>=3) {
						Set<String> tagSet = new HashSet<String>();
						mid = Integer.parseInt(limits[0]);
						years = Integer.parseInt(spt[0]);
						String _blimits;
						if (limits.length > 3)
							_blimits = limits[1] + limits[2];
						else
							_blimits = limits[1];
						title = _blimits.substring(0, _blimits.length() - 7);
//						System.out.println(title);
						String[] tags = limits[2].split("\\|");
						for(String tag: tags) {
							tagSet.add(tag);
						}
						if(!title.trim().isEmpty()) {
							_movie = new Movie(mid, title, years);
							_movie.tags = tagSet;
							_mMovies.put(_no, _movie);
							_lMovieID.add(mid.toString());
							
//							_lMovieProp.clear();
//							_lMovie.add(_im,null);
//							_lMovieProp.add(mid.toString());
//							_lMovieProp.add(title.toString());
//							_lMovieProp.add(years.toString());
//							
////							_lMovie.add(_im,null);
//							_lMovie.set(_im,_lMovieProp);
						}
					}
					
				}
				_no++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return _mMovies;
	}

	@Override
	public Map<Integer, User> loadUsers(String ratingFilename) {
		// TODO Auto-generated method stub
		File file = new File(ratingFilename);
		BufferedReader reader = null;
		int _no = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!=null) {
				line = line.trim();
				if(line.isEmpty()) {
					continue;
				}else if(_no > 0) {
					_lUserProp = new ArrayList<String>();
					String[] limits = line.split(",");
//					System.out.println(limits[0]);
					_user = new User(Integer.parseInt(limits[0]));
//					_movie = new Movie(_mid, _title, _year);
//					System.out.println(_user);
					_mUser.put(_no, _user);
					_lUserProp.add(limits[0]);
					_lUserProp.add(limits[1]);
					_lUserProp.add(limits[2]);
					_lUserProp.add(limits[3]);
					_lUser.add(_lUserProp);
//					_user.addRating(_movie, Double.parseDouble(limits[2]),Long.parseLong(limits[3]));
				}
				_no++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return _mUser;
	}

	@Override
	public void loadData(String movieFilename, String userFilename) {
		/// input file data
		loadMovies(movieFilename);
		loadUsers(userFilename);
		getAllMovies();
		getAllUsers();
		
		/// map matrix
		int uz = 0 , _uidIndex = 0;
		_uid = new ArrayList<String>();
		while (uz < _lUser.size()) {
			String _tc = _lUser.get(uz).get(0);
				
			if((_uid.size() == 0) || (_tc.equals(_uid.get(_uid.size()-1)) == false)) {
				_uid.add(_tc);
				_uidIndex++;
			}
//			System.out.println(_tc);
//			System.out.println(_uid.size());
			uz++;
		}
		
		ones(_uid.size(), _lMovieID.size());
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {
		return _mMovies;
	}

	@Override
	public Map<Integer, User> getAllUsers() {
//		System.out.println(_mUser.values());
		return _mUser;
	}

	@Override
	public void trainModel(String modelFilename) {
		// TODO Auto-generated method stub
		
		

	}

	@Override
	public void loadModel(String modelFilename) {
		// TODO Auto-generated method stub
		File myObj_1 = new File("small/movies.csv");
		modelFilename = myObj_1.toString();
	}

	@Override
	public double predict(Movie m, User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MovieItem> recommend(User u, int fromYear, int toYear, int K) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private RealMatrix ones(int _r, int _c) {
//		(u, m)
//		{1,2,3,4} m
//		{0,9,8} u
//		
//		01 02 03 04
//		91 92 93 94 
//		81 82 83 84
		
		
		d = new double[_r][_c];
		for (int r = 0; r < _r; r++) {
			for (int c = 0; c < _c; c++) {
				
//				int _ss = Movie.mid[1]; concept code
				
//				[1, 16, 4.0, 1217897793], 
//				[1, 32, 4.0, 1217896246], 
//				[1, 24, 1.5, 1217895807]
				
				System.out.println(_lUser.get(r));
				
				if (_lMovieID.get(c).equals(_lUser.get(r).get(1))) { 
						d[r][c] = Double.parseDouble(_lUser.get(r).get(2)); 
					}else {
						d[r][c] = 0;
					}
				System.out.println();
//				_mMovies.get(c);
				
//				if( _mUser.get(c).equals(_mMovies.get(c)))
//					if(true)
//						d[r][c] = 0;
//						System.out.print(d[r][c]+" ");
			}	
			
		}
		System.out.println(new Array2DRowRealMatrix(d, false));
		return new Array2DRowRealMatrix(d, false);
	}

}
