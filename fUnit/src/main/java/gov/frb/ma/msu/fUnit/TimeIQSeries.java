package gov.frb.ma.msu.fUnit;

import com.fame.timeiq.*;
import com.fame.timeiq.dates.*;
import com.fame.timeiq.data.*;
/**
 * 
 * @author m1gsa00 -- Gary S. Anderson
 * 
 * The <code>TimeIQSeries</code> class provides a simplified java interface to a 
 * fame database series.
 *
 */
public class TimeIQSeries {
private	String seriesName=null;
private	TiqObject theVals=null; 
private	ObservationList obsList= null;
private double [] asDoubles	=null;
private	int startQ;
private int startYear;
private long startIndx;
private long endIndx;
private int endQ;
private int endYear;
/**
 * 
 * This constructor requires a <code>TimeIQDatabase</code> instance as well as a series name and beginning 
 * and ending dates.
 * @param tiqDb an instance of of a TimeIQDatabase
 * @param sName String the name of a series in the database
 * @param startY int the starting year
 * @param startQtr int the starting quarter
 * @param endY int the ending year
 * @param endQtr int the ending quarter
 */

	public TimeIQSeries(TimeIQDatabase tiqDb,
        String sName, int startY,int startQtr,int endY,int endQtr) {
		try {
			startYear=startY;endYear=endY;startQ=startQtr;endQ=endQtr;
			seriesName=sName;
			startIndx=yearQuarterToIndex(startY,startQtr);
			endIndx=yearQuarterToIndex(endY,endQtr);
			theVals =tiqDb.getDStore().getTiqObjectCopy(
			  seriesName,startIndx,endIndx);
			obsList=theVals.getObservations();
			asDoubles=obsList.getValues().getDoubleArray();
		} 
		catch(TiqCheckedException ee){
			System.out.println(ee);
		}
	}
	
	/**
	 * 
	 * This method retrieves the time series values.
	 * @return double[] the values for the series
	 */
	public double[] getAsDoubles() {
		return asDoubles;
	}
	
	/**
	 * 
	 * This method computes the fame/TimeIQ internal index associated with the specified year and quarter
	 * @param year int
	 * @param quarter int
	 * @return long
	 */
	protected static long yearQuarterToIndex(int year,int quarter){
		return(DateHelper.ymdToIndex(year,(quarter-1)*3+1,1));
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public int getStartQ() {
		return startQ;
	}

	public int getStartYear() {
		return startYear;
	}
	
	public int getEndQ() {
		return endQ;
	}
	
	public int getEndYear() {
		return endYear;
	}
	


}
