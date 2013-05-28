package gov.frb.ma.msu.fUnit;

import gov.frb.ma.msu.fUnit.TimeIQDatabase;
import gov.frb.ma.msu.fUnit.TimeIQSeries;

import org.junit.Assert;

import junit.framework.TestCase;
public class TimeIQSeriesTest extends TestCase {
	TimeIQDatabase tHelp;
	TimeIQSeries tSer;
	double tol =1.0e-8;
	public TimeIQSeriesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		tHelp= new TimeIQDatabase(
				"/msu/res2/Shared_Projects/MPSCode/tryFit/",
				"conpol.db");
		tSer = new TimeIQSeries(tHelp,"u_rff",2011,1,2011,4);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		/**
		 * @todo simplify closing db and use here
		 */
				
	}

	public void testGetAsDoubles() {
		double[]expRes={0.156555555555556,0.093296703297,0.083906247998,-0.911941758804};
		Assert.assertArrayEquals(expRes,tSer.getAsDoubles(),tol);

	}

	public void testYearQuarterToIndex() {
		long expr =1293840000000L;
		assertEquals(expr,TimeIQSeries.yearQuarterToIndex(2011,1));
	}

	public void testGetSeriesName() {
		assertEquals("u_rff",tSer.getSeriesName());
	}

	public void testGetStartQ() {
		assertEquals(1,tSer.getStartQ());
	}

	public void testGetStartYear() {
		assertEquals(2011,tSer.getStartYear());
	}

	public void testGetEndQ() {
		assertEquals(4,tSer.getEndQ());
	}

	public void testGetEndYear() {
		assertEquals(2011,tSer.getEndYear());
	}

}
