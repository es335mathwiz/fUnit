package gov.frb.ma.msu;
//import gov.frb.ma.msu.fUnit.TimeIQDatabase;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fame.timeiq.tools.charts.beans.FameChart;
import com.fame.timeiq.tools.charts.beans.FameObjectData;
import com.fame.timeiq.persistence.ConnectionFailedChkException;
import com.fame.timeiq.persistence.DataStoreOpenChkException;
import com.fame.timeiq.persistence.ObjectAccessChkException;
import com.fame.timeiq.persistence.Server;
import com.fame.timeiq.persistence.Connection;
import com.fame.timeiq.persistence.DataStore;;
public class TryChart extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Add a panel in the center to hold the chart and add the chart to it.
	   FameChart aChart= new FameChart();
	private void layoutFrame(){
		
	
    JPanel chartPanel = new JPanel();
 

   chartPanel.setLayout(new BorderLayout(0, 0));
   getContentPane().add(BorderLayout.CENTER, chartPanel);
   chartPanel.add(BorderLayout.CENTER, aChart);
   setTitle("First Try");
   FameObjectData FOD = new FameObjectData();
   FOD.setServerName(null);
  Connection myCon = null; 
   try {
	myCon = Server.getInstance().getSession().createConnection(null);
} catch (ObjectAccessChkException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ConnectionFailedChkException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
//	myCon.close();
}String[] sNames={"/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/conpol.db"};
String [] oNames={"u_rff"};
   FOD.setStoreNames(sNames);
   FOD.setObjectNames(oNames);
   aChart.setData(FOD);
   /*
    * conpol= new TimeIQDatabase(
				"/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/",
				"conpol.db");
				
    */
   try {
	DataStore ds =myCon.getDataStore("/msu/res2/m1gsa00/legacyCode/garyUsingProdBare/ConstrainedPol/conpol.db");
} catch (DataStoreOpenChkException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ObjectAccessChkException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ConnectionFailedChkException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
	public TryChart(){
		layoutFrame();
		setVisible(true);
		aChart.updateDisplay();
	}
public static void main(String[] args) {
	   {
	        try
	        {
System.out.println("working Directory = " + 
	        System.getProperty("user.dir"));
//	            TryChart frame = new TryChart();
	        }
	        catch (Throwable t)
	        {
	            t.printStackTrace();
	            System.exit(1);
	        }
	    }

}
}
