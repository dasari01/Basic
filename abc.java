
abc1/*
import java.io.FileWriter; import java.io.IOException; import java.io.PrintWriter; import java.util.ArrayList; import java.util.HashMap; import java.util.List; import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class FlatFileSenderCsv { //Delimiter used in CSV file private static final String COMMA_DELIMITER = ","; private static final String NEW_LINE_SEPARATOR = "\n"; private static final Map<Long, String> map=new HashMap<>(); //CSV file header

		private static String columnFormat(int width) {
		if(width>=1){
			return "%-" + width + "s";
		}
		return "";
	}
	private List<String> validValue(FlatFile column){
		List<String> validValues= new ArrayList();
		System.out.println(column.getAcctype().length());
if(column.getAcctype().length()<=1){
	validValues.add(column.getAcctype());
}
else{
	validValues.add("");
}
if(column.getBokeraccnumber().length()<=15){
	validValues.add(column.getBokeraccnumber());
}
else{
	validValues.add("");
}
if(column.getConfirmationnumber().length()<=15){
	validValues.add(column.getConfirmationnumber());
}
else{
	validValues.add("");
}
return validValues;	
} private void test1() throws IOException { FileWriter fw = new FileWriter("C:\Users\Public\testing1.csv"); PrintWriter out = new PrintWriter(fw);

	  List<FlatFile>   file = new ArrayList<>();
	  FlatFile flatfile = new FlatFileVVI();
	  flatfile.setAcctype("2");
	  flatfile.setConfirmationnumber("5556487");
	  flatfile.setBokeraccnumber("658");
	  file.add(flatfile);
	  FlatFile flatfile1 = new FlatFileVVI();
	  flatfile1.setAcctype("123");
	  flatfile1.setConfirmationnumber("000000000000000000000000000000005556487");
	  flatfile1.setBokeraccnumber("658123");
	  file.add(flatfile1);
	  file.stream().forEach(e->{
		  List<String> validValue = validValue(e);
		 validValue.stream().forEach(item->{
			 
			 out.format(columnFormat(item.length()), StringUtils.leftPad(item,item.length())); 
			 out.print(COMMA_DELIMITER);
				 
		 });
		 out.print(NEW_LINE_SEPARATOR);
	  });
	  

	
		       out.flush();      
		       out.close();
		       fw.close();     
	}

		public static void main(String[] args) throws IOException {
		FlatFileSenderCsv app= new FlatFileSenderCsv();
	    app.test1();
	    app.test2();
	 
		}
	}
