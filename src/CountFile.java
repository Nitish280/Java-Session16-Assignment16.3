/*
 * here we are making a program to count the line,words an character in the file
 */
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
//here we are creating a class
public class CountFile {
//here we are creating the main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//here we are creating the new file
		File file = new File("E:/File/New1/abc.txt");
		//here we are applying the condition for checking the file exists or not

		if (file.exists()) {
			System.out.println("Total Lines=" + getLineCount(file));
			System.out.println("Total Words=" + getWordCount(file));
			System.out.println("Total Characters=" + getCharacterCount(file));
		} else {
			System.out.println("File does not exists!");
		}
	}

	/**
	 * Use a BufferedReader to read the file line-by-line using readLine(). Then
	 * split each line on whitespace using String.split("\\s") and the size of
	 * the resulting array is the total words count.
	 */
	private static int getWordCount(File file) {
		int count = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				String[] parts = line.split(" ");
				for (String w : parts) {
					count++;
				}
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return count;

	}

	private static int getCharacterCount(File file) {
		FileReader fr = null;
		int charCount = 0;

		try {
			fr = new FileReader(file);
			while (fr.read() > -1) {
				charCount++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (null != fr)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return charCount;
	}

	private static int getLineCount(File file) {
		int linenumber = 0;
		FileReader fr = null;
		try {
			fr = new FileReader(file);

			/*
			 * buffered character-input stream that keeps track of line numbers
			 */
			LineNumberReader lnr = new LineNumberReader(fr);
			while (lnr.readLine() != null) {
				linenumber++;
			}
			lnr.close();

			return linenumber;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//here we are applying the finally block

		finally {
			if (null != fr)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return linenumber;
	}
}
