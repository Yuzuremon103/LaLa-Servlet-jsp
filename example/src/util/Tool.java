package util;

public class Tool {
	
	public static double myRound(double value) {
		double v = value * 10.0 + .5;
		v = Math.floor(v);
		v /= 10.0;
		return v;
	}
}
