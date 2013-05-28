package gov.frb.ma.msu.MPSCodeTests;


import gov.frb.ma.msu.fUnit.TimeIQDatabase;
import gov.frb.ma.msu.fUnit.TimeIQSeries;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ConstrainedPolTests extends TestCase {
	TimeIQDatabase mqcon;
	TimeIQDatabase mquncon;
	TimeIQDatabase conpol;


	TimeIQSeries mqconSer;
	TimeIQSeries mqunconSer;
	TimeIQSeries conpolSer;
	double tol =1.0e-8;
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		mqcon= new TimeIQDatabase(
				"/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/",
				"mqcon.db");
		mquncon= new TimeIQDatabase(
				"/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/",
				"mquncon.db");
		conpol= new TimeIQDatabase(
				"/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/",
				"conpol.db");

	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testc_rff_2() {
		mqconSer = new TimeIQSeries(mqcon,"rff_2",2011,1,2011,4);
		conpolSer = new TimeIQSeries(conpol,"c_rff",2011,1,2011,4);
		Assert.assertArrayEquals(mqconSer.getAsDoubles(),conpolSer.getAsDoubles(),tol);
	}
	@Test
	public void testu_rff_2() {
		mqconSer = new TimeIQSeries(mquncon,"rff_2",2011,1,2011,4);
		conpolSer = new TimeIQSeries(conpol,"u_rff",2011,1,2011,4);
		Assert.assertArrayEquals(mqconSer.getAsDoubles(),conpolSer.getAsDoubles(),tol);
	}


}
