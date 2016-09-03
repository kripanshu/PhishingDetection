package phishtank;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Evaluation {

	private String inputFile;
	 static String status,tablevalue="";
static int [][] grap;
static String[] urlval;
static String[] result;
public static double[] x1;
public static double[] x2;
static int rowsize,columnsize;
static double weight1=0.1,weight2=-0.2,bias=0.4;
static double f;
//private static final double[] xSeries = SVM.x1;
//private static final double[] ySeries = SVM.x2;


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
	            grap[j][i]=Integer.parseInt(cell.getContents());
	          }

	        }System.out.println(rowsize+"  "+columnsize);
	      }
	      
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  
	  public void read1() throws IOException  {
		    File inputWorkbook = new File(inputFile);
		    Workbook w;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      // Get the first sheet
		      Sheet sheet = w.getSheet(0);
		      // Loop over first 10 column and lines

	
urlval=new String[rowsize];
		      
		        for (int i = 1; i < sheet.getRows(); i++) {
		        	
		        	
		          Cell cell = sheet.getCell(0, i);
		          CellType type = cell.getType();
		          if (type == CellType.LABEL) {
		           // System.out.println("I got a label "
		            //    + cell.getContents());
		        	  
		          }
urlval[i]=cell.getContents();
		          

		        }
		      
		      
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }
		  }
	  

	  public  String chartsvm() throws IOException {
	    Evaluation test = new Evaluation();
	    test.setInputFile("D:/Data/FYP/dataset.xls");
	    test.read();
	    test.read1();
	    result=new String[rowsize];
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
	    System.out.println("the value of x1 : ");
	    
	    for(int i=1;i<x1.length;i++)
	    {
	    	System.out.print(" "+x1[i]);
	    }
	    System.out.println();
	    System.out.println("the value of x2 : ");
	    for(int i=1;i<x2.length;i++)
	    {
	    	System.out.print(" "+x2[i]);
	    }
	    System.out.println();
	    System.out.println("the urls bitches : ");
	    for(int i=2;i<urlval.length;i++)
	    {
	    	System.out.print(" "+urlval[i]);
	    }
	 for(int i=0; i<x1.length;i++){ 
	  f=(weight1*x1[i])+weight2*x2[i]+bias;
	  
	  if(f<0)
	  {
		  result[i]="+1";
	  }
	  else if(f>0)
	  {
		  result[i]="-1";
		  
	  }
	  
	 }
	 for(int i=1;i<result.length;i++)
	 {
    	
    	tablevalue=tablevalue+urlval[i]+" : "+result[i]+"\n";
    	
	 } 
		 System.out.println(tablevalue);
    
    return tablevalue;
	
	 
	  }
}
