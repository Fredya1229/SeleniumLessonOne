import java.io.BufferedWriter;
import java.io.FileWriter;

public class writetoFile {
	public static void main(String[] args) throws Exception
	{
	FileWriter fr=new FileWriter("C:\\ToolsQA\\ExcelData\\data.txt");
	BufferedWriter br=new BufferedWriter(fr);

	br.write("This is sample");
	br.newLine();
	br.write("Testing tools");
	br.newLine();

	br.close();

	}
}
