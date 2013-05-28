package gov.frb.ma.msu.fUnit;
import com.fame.timeiq.*;
import com.fame.timeiq.persistence.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author m1gsa00 -- Gary S. Anderson
 * The <code>TimeIQDatabase</code> class provides a simplified java interface to a fame database.
 *
 */
public class TimeIQDatabase {
private	Server sr = Server.getInstance();
private	Session ss = sr.getSession();
private	String directory =null;
private DataStore dStore;
private Connection con;
private		String dbName=null;
/**
 * This constructor requires a path and a database name.
 * @param directory String -- path to directory containing fame databases
 * @param dbName String -- the database name
 * 
 *
 */
public TimeIQDatabase(String directory,String dbName){
		try {
			String regPath=getRegisteredPath(dbName);
			if(regPath==null){
			setDirectory(directory);
			setDbName(dbName);
			setCon(ss.createConnection(null));
			setDb(con.getDataStore(directory+dbName));} else
			{setDirectory("");
			setDbName(dbName);
			setCon(ss.createConnection(null));
				setDb(con.getDataStore(regPath));			
			}
		} 
		catch(DataStoreOpenChkException ee)
			{	System.out.println(
			   "Error in getDataStore for ("+directory+dbName+")");
			}
		catch(TiqCheckedException ee){
			System.out.println(ee);
		}

	}
/**
 * 
 * The <code>finalize</code> method will ensure that the database connection is closed when the TimeIQDatabase instance is garbage collected.
 */
protected void finalize() throws Throwable {
	try {
        if (getCon() != null)
        {
            getCon().close();
        }
	} finally {
		super.finalize();
	}
}
public void setDirectory(String directory) {
	this.directory = directory;
}
public void setDb(DataStore db) {
	this.dStore = db;
}
public void setCon(Connection con) {
	this.con = con;
}
public void setDbName(String dbName) {
	this.dbName = dbName;
}
public DataStore getDStore(){return (dStore);}
public String getDirectory() {
	return directory;
}
public String getDbName() {
	return dbName;
}
public Connection getCon() {
	return con;
}

public String getRegisteredPath(String regDbName) {
String cmd = "famedbreg -lf "+ regDbName;
Runtime run = Runtime.getRuntime();
Process pr = null;
try {
pr = run.exec(cmd);
} catch (IOException ee) {
ee.printStackTrace();
}
try {
pr.waitFor();
} catch (InterruptedException ee) {
ee.printStackTrace();
}
BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
String line = "";
try {
line=buf.readLine(); 
} catch (IOException e) {
e.printStackTrace();
}
return line;
}

}
