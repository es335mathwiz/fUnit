package gov.frb.ma.msu;
import java.util.Arrays;

import gov.frb.ma.msu.fUnit.*;
public class Usage {
public static TimeIQDatabase theDB=new 
			TimeIQDatabase("/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/","conpol.db"); 
public static TimeIQSeries unemp=new TimeIQSeries(theDB,"u_rff",2011,1,2011,4);
		double[]expRes=
		{0.156555555555556,0.093296703297,0.083906247998,-0.911941758804};

	public static void main(String[] args){
		System.out.println(Arrays.toString(unemp.getAsDoubles()));
	}

}


