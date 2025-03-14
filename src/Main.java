import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Specify the paths for the input and output files
        String inputFilePath = "src/test.txt";
        String outputFilePath = "src/token.txt";
        String table_analisis = "src/table_analisis.txt";
        String SyntaxAnalyzer_result = "src/table_analisis.txt";

        // Create an instance of the Automate class
        Automate automate = new Automate();

        try {
            // Call the analyzeFile method on the Automate instance
            automate.analyzeFile(inputFilePath, outputFilePath,table_analisis);

            // Print a confirmation message
            System.out.println("File analysis complete. Results written to " + outputFilePath);
        } catch (Exception e) {
            // Handle any exceptions that may occur during file analysis
            System.out.println("An error occurred during file analysis: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            // File path to load tokens
            String filePath = "src/token.txt"; // Replace with your file path
            List<SyntaxAnalyzer.Token> tokens = SyntaxAnalyzer.loadTokensFromFile(filePath);

            SyntaxAnalyzer parser = new SyntaxAnalyzer(tokens);
            parser.parseProgramme();
        } catch (IOException e) {
            System.err.println("Error reading tokens file: " + e.getMessage());
        }


    }
}
