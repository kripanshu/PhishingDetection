package phishtank;



import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.LineStyle;
import org.swtchart.ISeries.SeriesType;

public class SVM {
	private String inputFile;
	 static String status,tablevalue;
static int [][] grap;

public static double[] x1;
public static double[] x2;
static int rowsize,columnsize;
static double weight1=0.1,weight2=-0.2,bias=0.4;
static double f;
//private static final double[] xSeries = SVM.x1;
//private static final double[] ySeries = SVM.x2;

private static final double[] x1Series = { -4,0,50,70 };
private static final double[] y1Series = { 0,2,27,37 };
	  public void setInputFile(String inputFile) {
	    this.inputFile = inputFile;
	  }

	  public void read() throws IOException  {
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first sheet
	      Sheet sheet = w.getSheet(0);
	      // Loop over first 10 column and lines

rowsize=sheet.getRows();
columnsize=sheet.getColumns();
grap=new int[columnsize][rowsize];

	      for (int j = 1; j < sheet.getColumns(); j++) {
	        for (int i = 1; i < sheet.getRows(); i++) {
	        	
	        	
	          Cell cell = sheet.getCell(j, i);
	          CellType type = cell.getType();
	          if (type == CellType.LABEL) {
	           // System.out.println("I got a label "
	            //    + cell.getContents());
	        	  
	          }

	          if (type == CellType.NUMBER) {
	            System.out.println("I got a number "
	                + cell.getContents());
	            grap[j][i]=Integer.parseInt(cell.getContents())+2;
	          }

	        }System.out.println(rowsize+"  "+columnsize);
	      }
	      
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  
	 

	  public  void chartsvm() throws IOException {
	    SVM test = new SVM();
	    test.setInputFile("D:/Data/FYP/dataset.xls");
	    test.read();
	    
	    
	    x1=new double[rowsize];
	    x2=new double[rowsize];
	   
	    //int[][] array = new int[rows][columns];
	    for(int i = 1; i<columnsize; i++)
	    {
	    	
	        for(int j = 1; j<rowsize; j++)
	        {
	            System.out.print(grap[i][j]+" ");
	            
	            if(i%2==0)
	            {
	            	x1[j]=grap[i][j];
	            	
	            }
	            else if(i%2!=0)
	            {
	            	x2[j]=grap[i][j];
	            }
	            
	        }
	        System.out.println();
	    }

	 
	  
	  
	  
	  
	  
	  //This code is for building SVM Classification graph 
	  
	  Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setText("Scatter Chart");
	    shell.setSize(500, 400);
	    shell.setLayout(new FillLayout());

	    createChart(shell);
	    
	   

	    shell.open();
	    while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
	        display.sleep();
	    }
	    }
	    display.dispose();
		
	    
	   
	}

	/**
	* create the chart.
	* 
	* @param parent
	*            The parent composite
	* @return The created chart
	*/

	static public Chart createChart(Composite parent) {

	    // create a chart
	    
		Chart chart = new Chart(parent, SWT.NONE);
	    // set titles
	    chart.getTitle().setText("SVM CLASSIFICATION");
	    chart.getAxisSet().getXAxis(0).getTitle().setText("POSITIVE");
	    chart.getAxisSet().getYAxis(0).getTitle().setText("NEGATIVE");

	    // create scatter series
	    ILineSeries scatterSeries = (ILineSeries) chart.getSeriesSet()
	        .createSeries(SeriesType.LINE, "Training Datasets");
	    scatterSeries.setLineStyle(LineStyle.NONE);
	    scatterSeries.setXSeries(x2);
	    scatterSeries.setYSeries(x1);

	    Color color = new Color(Display.getDefault(), 255, 0, 0);
	    
	    scatterSeries.setSymbolColor(color);
	    
	  //this is for classification line
	    ILineSeries scatterSeriesq = (ILineSeries) chart.getSeriesSet()
	            .createSeries(SeriesType.LINE, "CLASSIFIER");
	    scatterSeriesq.setLineStyle(LineStyle.SOLID);
	    scatterSeriesq.setXSeries(x1Series);
	    scatterSeriesq.setYSeries(y1Series);

	    // adjust the axis range
	    chart.getAxisSet().adjustRange();

	    return chart;
	}
	  

}
