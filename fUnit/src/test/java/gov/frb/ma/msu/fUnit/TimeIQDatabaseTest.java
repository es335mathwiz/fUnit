package gov.frb.ma.msu.fUnit;
import gov.frb.ma.msu.fUnit.TimeIQDatabase;
import junit.framework.TestCase;

public class TimeIQDatabaseTest extends TestCase {
	TimeIQDatabase tHelp;
	TimeIQDatabase tReg;
	public TimeIQDatabaseTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		tHelp= new TimeIQDatabase(
				"/msu/res2/Shared_Projects/MPSCode/tryFit/",
				"conpol.db");
		tReg= new TimeIQDatabase("","useruth");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
  
	}

	public void testGetDStore() {
		assertEquals("/msu/res2/Shared_Projects/MPSCode/tryFit/conpol.db",tHelp.getDStore().toString());
	}

	public void testGetDirectory() {
		assertEquals("/msu/res2/Shared_Projects/MPSCode/tryFit/",tHelp.getDirectory());
	}

	public void testGetDbName() {
		assertEquals("conpol.db",tHelp.getDbName());
	}
	public void testRegisteredDir() {
		assertEquals("",tReg.getDirectory());
	}
	public void testRegisteredDbN() {
		assertEquals("useruth",tReg.getDbName());
	}
	public void testRegisteredDS() {
		assertEquals("/mcr/gb/databases/useruth.db",tReg.getDStore().toString());
	}
}

