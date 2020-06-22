
// Julien Phan, ID:40133814
// COMP249
// Assignment 3
// March 30th, 2020

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 
 * @author julienphan
 *
 */
public class BibliographyFactory {

	// Static variables
	private static Scanner sc;
	private static Path path = Paths.get("resources");
	private static String absolutePath = path.toFile().getAbsolutePath();

	/**
	 * 
	 * @param openFile
	 * @return
	 * @throws Exception
	 */
	// ProcessFilesValidation method
	public static boolean processFilesForValidation(File openFile) throws Exception {

		// Variables
		sc = new Scanner(openFile);
		String fileName = openFile.getName();
		boolean valid = true;
		String line = null;
		PrintWriter pw = null, pw1 = null, pw2 = null;
		File fileIEEE, fileACM, fileNJ;
		BufferedReader br = null, br1 = null, br2 = null;

		// Verifiyng file index
		String numOnly = fileName.replaceAll("[^0-9]", "");
		int index = Integer.parseInt(numOnly);

		// Verification of empty field
		try {
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.contains("{}")) {
					valid = false;
					break;
				}
			}

			// if valid
			if (valid) {

				br = new BufferedReader(new FileReader(absolutePath + "/Latex" + index + ".bib"));
				br1 = new BufferedReader(new FileReader(absolutePath + "/Latex" + index + ".bib"));
				br2 = new BufferedReader(new FileReader(absolutePath + "/Latex" + index + ".bib"));
				pw = new PrintWriter(new FileOutputStream(absolutePath + "/IEEE" + index + ".json"));
				pw1 = new PrintWriter(new FileOutputStream(absolutePath + "/ACM" + index + ".json"));
				pw2 = new PrintWriter(new FileOutputStream(absolutePath + "/NJ" + index + ".json"));

				try {
					fileCopyIEEE(br, pw);
					fileCopyACM(br1, pw1);
					fileCopyNJ(br2, pw2);
				} catch (IOException e) {

				}

				return true;

				// if false
			} else
				throw new FileInvalidException("\nError: Detected Empty Field!" + "\n============================"
						+ "\n\nProblem detected with input file: " + fileName + "\nFile is Invalid: Field \""
						+ line.replace("={},", "") + "\" is Empty. Processing stoped at this point. Other empty fields"
						+ " may be present as well!");

		} catch (FileInvalidException e) {
			System.out.println(e.getMessage());
			fileIEEE = new File(absolutePath + "/IEEE" + index + ".json");
			fileACM = new File(absolutePath + "/ACM" + index + ".json");
			fileNJ = new File(absolutePath + "/NJ" + index + ".json");
			fileIEEE.delete();
			fileACM.delete();
			fileNJ.delete();
			return false;
		}
	}

	/**
	 * 
	 * @param br
	 * @param p
	 * @throws IOException
	 */
	// Copy IEEE file method
	public static void fileCopyIEEE(BufferedReader br, PrintWriter p) throws IOException {
		String s;
		String remove[] = { "@ARTICLE{", "[^0-9]", "author={", "},", "journal={", "title={", "year={", "volume={",
				"number={", "pages={", "keywords={", "doi={", "ISSN={", "month={", "}"};
		boolean article = true;
		String author = null, title = null, journal = null, volume = null, number = null, pages = null, month = null,
				year = null;

		// Reading file
		s = br.readLine();
		while (s != null) {

			// Writing article to output file
			if (s.contains("@ARTICLE")) {
				article = true;

				while (article) {
					if (s.contains("author")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						s = s.replace(" and", ",");
						author = s + ". ";
						s = br.readLine();
					}

					if (s.contains("title")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						title = "\"" + s + "\" ";
						s = br.readLine();
					}

					if (s.contains("journal")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						journal = s + ", ";
						s = br.readLine();
					}

					if (s.contains("volume")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						volume = "vol. " + s + ", ";
						s = br.readLine();
						continue;
					}

					if (s.contains("number")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						number = "no. " + s + ", ";
						s = br.readLine();
					}

					if (s.contains("pages")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						pages = "p. " + s + ", ";
						s = br.readLine();
					}

					if (s.contains("month")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						month = s + " ";
						article = false;
						s = br.readLine();
						p.print(author + title + journal + volume + number + pages + month + year);
					}

					if (s.contains("year")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						year = s + ".\n\n";
						s = br.readLine();
					} else {
						s = br.readLine();
					}
				}
			} else {
				s = br.readLine();
			}
			if (s == null)
				break;
		}
		p.close();
		br.close();
	}

	/**
	 * 
	 * @param br
	 * @param p
	 * @throws IOException
	 */
	// Copy ACM file method
	public static void fileCopyACM(BufferedReader br, PrintWriter p) throws IOException {
		String s;
		String remove[] = { "@ARTICLE{", "[^0-9]", "author={", "},", "journal={", "title={", "year={", "volume={",
				"number={", "pages={", "keywords={", "doi={", "ISSN={", "month={", "}", "doi={" };
		boolean article = true;
		String author = null, title = null, journal = null, volume = null, number = null, pages = null, year = null,
				doi = null;
		int count = 0;

		// Reading file
		s = br.readLine();
		while (s != null) {

			// Writing article to output file
			if (s.contains("@ARTICLE")) {
				article = true;
				count++;

				while (article) {
					if (s.contains("author")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						for (int i = 0; i < s.length(); i++) {
							if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'n' && s.charAt(i + 2) == 'd')
								s = s.substring(0, i);
						}
						author = s + "et al. ";
						s = br.readLine();
					}

					if (s.contains("title")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						title = s + ". ";
						s = br.readLine();
					}

					if (s.contains("journal")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						journal = s + ". ";
						s = br.readLine();
					}

					if (s.contains("volume")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						volume = s + ", ";
						s = br.readLine();
						continue;
					}

					if (s.contains("number")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						number = s + " ";
						s = br.readLine();
					}

					if (s.contains("pages")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						pages = s + ". ";
						s = br.readLine();
					}

					if (s.contains("month")) {
						article = false;
						s = br.readLine();
						p.println("[" + count + "]\t" + author + year + ". " + title + journal + volume + number + "("
								+ year + ")," + pages + "DOI:https://doi.org/" + doi + "\n");
					}

					if (s.contains("year")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						year = s;
						s = br.readLine();
					}
					if (s.contains("doi")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						doi = s;
						s = br.readLine();
					} else {
						s = br.readLine();
					}
				}
			} else {
				s = br.readLine();
			}
			if (s == null)
				break;
		}
		p.close();
		br.close();
	}

	/**
	 * 
	 * @param br
	 * @param p
	 * @throws IOException
	 */
	// Copy NJ file method
	public static void fileCopyNJ(BufferedReader br, PrintWriter p) throws IOException {
		String s;
		String remove[] = { "@ARTICLE{", "[^0-9]", "author={", "},", "journal={", "title={", "year={", "volume={",
				"number={", "pages={", "keywords={", "doi={", "ISSN={", "month={", "}" };
		boolean article = true;
		String author = null, title = null, journal = null, volume = null, pages = null, year = null;

		// Reading file
		s = br.readLine();
		while (s != null) {

			// Writing to output file
			if (s.contains("@ARTICLE")) {
				article = true;

				while (article) {
					if (s.contains("author")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						s = s.replace(" and", " &");
						author = s + ". ";
						s = br.readLine();
					}

					if (s.contains("title")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						title = s + ". ";
						s = br.readLine();
					}

					if (s.contains("journal")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						journal = s + ". ";
						s = br.readLine();
					}

					if (s.contains("volume")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						volume = s + ", ";
						s = br.readLine();
						continue;
					}

					if (s.contains("pages")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						pages = s;
						s = br.readLine();
					}

					if (s.contains("month")) {
						article = false;
						s = br.readLine();
						p.println(author + title + journal + volume + pages + "(" + year + ")\n");
					}

					if (s.contains("year")) {
						for (int i = 0; i < remove.length; i++) {
							if (s.contains(remove[i])) {
								s = s.replace(remove[i], "");
							}
						}
						year = s;
						s = br.readLine();
					} else {
						s = br.readLine();
					}
				}
			} else {
				s = br.readLine();
			}
			if (s == null)
				break;
		}
		p.close();
		br.close();
	}

	/**
	 * 
	 * @param b
	 * @throws IOException
	 */
	// Reading output file method
	public static void displayFileContents(BufferedReader b) throws IOException {
		String str;
		str = b.readLine();

		while (str != null) {
			System.out.println(str);
			str = b.readLine();
		}
		b.close();
	}

	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();

		// Variables
		Scanner reader = null;
		int index = 0;
		PrintWriter FileIEEE = null;
		PrintWriter FileACM = null;
		PrintWriter FileNJ = null;
		File newFileIEEE = null;
		File newFileACM = null;
		File newFileNJ = null;
		int invalidFiles = 0;
		int validFiles = 0;
		Scanner fileOutputName = new Scanner(System.in);
		BufferedReader br = null;
		String attempt1;
		String attempt2;
		boolean invalidPass = true;
		File fileInput = null;

		// Opening statement
		System.out.println("Welcome to BibliographyFactory!\n");

		// Attempt to open every file
		try {
			for (index = 1; index <= 10; index++) {
				fileInput = new File(classloader.getResource("Latex" + index + ".bib").getFile());
				reader = new Scanner(new FileInputStream(fileInput));
			}
			// Open/Create output files
			try {
				for (index = 1; index <= 10; index++) {
					newFileIEEE = new File(absolutePath + "/IEEE" + index + ".json");
					newFileACM = new File(absolutePath + "/ACM" + index + ".json");
					newFileNJ = new File(absolutePath + "/NJ" + index + ".json");

					if (!newFileIEEE.exists() && !newFileACM.exists() && !newFileNJ.exists()) {
						newFileIEEE.createNewFile();
						newFileACM.createNewFile();
						newFileNJ.createNewFile();
					} else {
						for (index = 1; index <= 10; index++) {
							FileIEEE = new PrintWriter(new FileOutputStream(newFileIEEE));
							FileACM = new PrintWriter(new FileOutputStream(newFileACM));
							FileNJ = new PrintWriter(new FileOutputStream(newFileNJ));
						}
					}
				}
			} catch (IOException e) {
				if (FileIEEE.checkError()) {
					System.out.println("Could not open/create output file IEEE" + index + ".json."
							+ "\n\nPlease check if file exists! Program will terminate after closing any opened files.");
					newFileIEEE.delete();
					newFileACM.delete();
					newFileNJ.delete();
					FileIEEE.close();
					FileACM.close();
					FileNJ.close();
					reader.close();
					System.exit(0);
				}

				else if (FileACM.checkError()) {
					System.out.println("Could not open/create output file ACM" + index + ".json."
							+ "\n\nPlease check if file exists! Program will terminate after closing any opened files.");
					newFileIEEE.delete();
					newFileACM.delete();
					newFileNJ.delete();
					FileIEEE.close();
					FileACM.close();
					FileNJ.close();
					reader.close();
					System.exit(0);
				}

				else if (FileNJ.checkError()) {
					System.out.println("Could not open/create output file NJ" + index + ".json."
							+ "\n\nPlease check if file exists! Program will terminate after closing any opened files.");
					newFileIEEE.delete();
					newFileACM.delete();
					newFileNJ.delete();
					FileIEEE.close();
					FileACM.close();
					FileNJ.close();
					reader.close();
					System.exit(0);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file Latex" + index + ".bib for reading."
					+ "\n\nPlease check if file exists! Program will terminate after closing any opened files.");
			if (reader != null)
				reader.close();
			System.exit(0);
		}

		// Validating Files
		for (index = 1; index <= 10; index++) {
			File inputFile = new File("/Users/julienphan/Desktop/Comp249_W20_Assg3_Files/Latex" + index + ".bib");
			if (processFilesForValidation(inputFile) == false) {
				invalidFiles++;
			}
		}

		// Display number of valid and invalid files
		validFiles = 10 - invalidFiles;
		System.out.println("\nA total of " + invalidFiles + " files were invalid, and could not be processed."
				+ " All other " + validFiles + " \"Valid\" files have been created.");

		System.out.print("\nPlease enter the name of one of the files that you need to review:");

		// Reading output files
		try {
			attempt1 = fileOutputName.next();

			for (index = 1; index <= 10; index++) {
				newFileIEEE = new File(absolutePath + "/IEEE" + index + ".json");
				newFileACM = new File(absolutePath + "/ACM" + index + ".json");
				newFileNJ = new File(absolutePath + "/NJ" + index + ".json");

				if ((attempt1.equals(newFileIEEE.getName()) && newFileIEEE.exists())
						|| (attempt1.equals(newFileACM.getName()) && newFileACM.exists())
						|| (attempt1.equals(newFileNJ.getName()) && newFileNJ.exists())) {
					System.out.println("Here are the contents of the successfully created Jason File: " + attempt1);
					br = new BufferedReader(new FileReader(absolutePath + "/" + attempt1));
					displayFileContents(br);
					invalidPass = false;
					break;
				}
			}

			if (invalidPass) {
				throw new FileNotFoundException(
						"Could not open input file. File does not exist; possible it could not be created!"
								+ "\n\nHowever, you will be allowed another chance to enter another file name."
								+ "\nPlease enter the name of one of the files that you need to review:");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

			try {
				attempt2 = fileOutputName.next();

				for (index = 1; index <= 10; index++) {
					newFileIEEE = new File(absolutePath + "/IEEE" + index + ".json");
					newFileACM = new File(absolutePath + "/ACM" + index + ".json");
					newFileNJ = new File(absolutePath + "/NJ" + index + ".json");

					if ((attempt2.equals(newFileIEEE.getName()) && newFileIEEE.exists())
							|| (attempt2.equals(newFileACM.getName()) && newFileACM.exists())
							|| (attempt2.equals(newFileNJ.getName()) && newFileNJ.exists())) {
						System.out.println("Here are the contents of the successfully created Jason File: " + attempt2);
						br = new BufferedReader(new FileReader(absolutePath + "/" + attempt2));
						displayFileContents(br);
						invalidPass = false;
						break;
					}
				}

				if (invalidPass) {
					throw new FileNotFoundException(
							"Could not open input file. File does not exist; possible it could not be created."
									+ "\nSorry! I am unable to display your desired files! Program will exit!");

				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
				System.exit(0);
			}

		}

	}

}
