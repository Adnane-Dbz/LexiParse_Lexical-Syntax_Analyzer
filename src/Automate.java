import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Automate {
    Eta initialState;

    public Automate() {
        // Initial state for all transitions will start from Eta1
        Eta eta1 = new Eta("Eta1", false, null);


        Eta identfy = new Eta("Eta100", true, "identfy");
        Eta mallidentfy_tmp = new Eta("Eta101", true, "mallidentfy");
        Eta mallidentify_final = new Eta("Eta103", true, "mallidentfy");

        eta1.addTransition(mallidentfy_tmp, Transition.giveme("p","d","f","v","E","C","c","r","j","d","o","m","1","2","3","4","5","6","7","8","9"));
        mallidentfy_tmp.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        mallidentfy_tmp.addTransition(mallidentify_final, Transition.giveme("0","1","2","3","4","5","6","7","8","9"));

        identfy.addTransition(mallidentfy_tmp,Transition.giveme("0","1","2","3","4","5","6","7","8","9"));
        identfy.addTransition(mallidentify_final,'0','1','2','3','4','5','6','7','8','9');

        mallidentify_final.addTransition(mallidentify_final, Transition.giveme());




        Eta eta100 = new Eta("Eta100", true, "identfy");
        Eta eta101 = new Eta("Eta101", true, "identfy");
        Eta eta106 = new Eta("Eta103", true, "mallidentfy");
        eta100.addTransition(eta101, Transition.giveme("0","1","2","3","4","5","6","7","8","9"));
        eta100.addTransition(eta106, '0','1','2','3','4','5','6','7','8','9');


        eta101.addTransition(eta100, '0','1','2','3','4','5','6','7','8','9');
        eta106.addTransition(eta106, Transition.giveme());

        eta106.addTransition(eta106, Transition.giveme());


        eta101.addTransition(eta100,  '0','1','2','3','4','5','6','7','8','9');

        // For the keyword "programme"
        Eta eta2 = new Eta("Eta2", true, "mallidentfy");
        Eta eta3 = new Eta("Eta3", true, "mallidentfy");
        Eta eta4 = new Eta("Eta4", true, "mallidentfy");
        Eta eta5 = new Eta("Eta5", true, "mallidentfy");
        Eta eta6 = new Eta("Eta6", true, "mallidentfy");
        Eta eta7 = new Eta("Eta7", true, "mallidentfy");
        Eta eta8 = new Eta("Eta8", true, "mallidentfy");
        Eta eta199 = new Eta("199", true, "mallidentfy");
        Eta eta9 = new Eta("Eta9", true, "KEYWORD.programme");  // Final state for "programme"
        eta1.addTransition(eta2, 'p');
        eta2.addTransition(eta3, 'r');
        eta3.addTransition(eta4, 'o');
        eta4.addTransition(eta5, 'g');
        eta5.addTransition(eta6, 'r');
        eta6.addTransition(eta7, 'a');
        eta7.addTransition(eta199, 'm');
        eta199.addTransition(eta8, 'm');
        eta8.addTransition(eta9, 'e');


// For the operator ";"
        Eta eta178 = new Eta("Eta178", true, "OPERATOR.;");
        eta1.addTransition(eta178, ';');
// For the operator ","
        Eta eta1777 = new Eta("eta1777", true, "OPERATOR.,");
        eta1.addTransition(eta1777, ',');



        // For the keyword "debut"
        Eta eta10 = new Eta("Eta10", true, "mallidentfy");
        Eta eta11 = new Eta("Eta11", true, "mallidentfy");
        Eta eta12 = new Eta("Eta12", true, "mallidentfy");
        Eta eta13 = new Eta("Eta13", true, "mallidentfy");
        Eta eta14 = new Eta("Eta14", true, "KEYWORD.debut");  // Final state for "debut"
        eta1.addTransition(eta10, 'd');
        eta10.addTransition(eta11, 'e');
        eta11.addTransition(eta12, 'b');
        eta12.addTransition(eta13, 'u');
        eta13.addTransition(eta14, 't');

        // For the keyword "fin"
        Eta eta15 = new Eta("Eta15", true, "mallidentfy");
        Eta eta16 = new Eta("Eta16", true, "mallidentfy");
        Eta eta17 = new Eta("Eta17", true, "KEYWORD.fin");  // Final state for "fin"
        eta1.addTransition(eta15, 'f');
        eta15.addTransition(eta16, 'i');
        eta16.addTransition(eta17, 'n');

        // For the keyword "variable"
        Eta eta18 = new Eta("Eta18", false, null);
        Eta eta19 = new Eta("Eta19", false, null);
        Eta eta20 = new Eta("Eta20", false, null);
        Eta eta270 = new Eta("Eta20", false, null);
        Eta eta179 = new Eta("Eta19", false, null);
        Eta eta1679 = new Eta("Eta19", false, null);
        Eta eta21 = new Eta("Eta21", false, null);
        Eta eta22 = new Eta("Eta22", true, "KEYWORD.variable");  // Final state for "variable"
        eta1.addTransition(eta18, 'v');
        eta18.addTransition(eta19, 'a');
        eta19.addTransition(eta20, 'r');
        eta20.addTransition(eta21, 'i');
        eta21.addTransition(eta270, 'a');
        eta270.addTransition(eta179, 'b');
        eta179.addTransition(eta1679, 'l');
        eta1679.addTransition(eta22, 'e');


        // For the type "Entier"
        Eta eta34 = new Eta("Eta34", true, "mallidentfy");
        Eta eta35 = new Eta("Eta35", true, "mallidentfy");
        Eta eta36 = new Eta("Eta36", true, "mallidentfy");
        Eta eta37 = new Eta("Eta37", true, "mallidentfy");
        Eta eta38 = new Eta("Eta38", true, "mallidentfy");
        Eta eta39 = new Eta("Eta39", true, "KEYWORD.Entier");  // Final state for "Entier"
        eta1.addTransition(eta34, 'E');
        eta34.addTransition(eta35, 'n');
        eta35.addTransition(eta36, 't');
        eta36.addTransition(eta37, 'i');
        eta37.addTransition(eta38, 'e');
        eta38.addTransition(eta39, 'r');

        // For the type "constant"
        Eta eta540 = new Eta("Eta40", false, null);
        Eta eta541 = new Eta("Eta41", false, null);
        Eta eta542 = new Eta("Eta42", false, null);
        Eta eta543 = new Eta("Eta43", false, null);
        Eta eta544 = new Eta("Eta44", false, null);
        Eta eta5342 = new Eta("Eta42", false, null);
        Eta eta5343 = new Eta("Eta43", false, null);
        Eta eta5344 = new Eta("Eta44", false, null);
        Eta eta545 = new Eta("Eta45", true, "KEYWORD.Constante");
        eta1.addTransition(eta540, 'c');
        eta540.addTransition(eta541, 'o');
        eta541.addTransition(eta542, 'n');
        eta542.addTransition(eta543, 's');
        eta543.addTransition(eta544, 't');
        eta544.addTransition(eta5342, 'a');
        eta5342.addTransition(eta5343, 'n');
        eta5343.addTransition(eta5344, 't');
        eta5344.addTransition(eta545, 'e');
        // For the type "Caractere"
        Eta eta40 = new Eta("Eta40", true, "mallidentfy");
        Eta eta41 = new Eta("Eta41", true, "mallidentfy");
        Eta eta42 = new Eta("Eta42", true, "mallidentfy");
        Eta eta43 = new Eta("Eta43", true, "mallidentfy");
        Eta eta44 = new Eta("Eta44", true, "mallidentfy");
        Eta eta143 = new Eta("Eta43", true, "mallidentfy");
        Eta eta144 = new Eta("Eta44", true, "mallidentfy");
        Eta eta145 = new Eta("Eta44", true, "mallidentfy");
        Eta eta45 = new Eta("Eta45", true, "KEYWORD.Caractere");  // Final state for "Caractere"
        eta1.addTransition(eta40, 'C');
        eta40.addTransition(eta41, 'a');
        eta41.addTransition(eta42, 'r');
        eta42.addTransition(eta43, 'a');
        eta43.addTransition(eta44, 'c');
        eta44.addTransition(eta144, 't');
        eta144.addTransition(eta143, 'e');
        eta143.addTransition(eta145, 'r');
        eta145.addTransition(eta45, 'e');

        // For the type "Reel"
        Eta eta46 = new Eta("Eta46", true, "mallidentfy");
        Eta eta47 = new Eta("Eta47", true, "mallidentfy");
        Eta eta48 = new Eta("Eta48", true, "mallidentfy");
        Eta eta49 = new Eta("Eta49", true, "KEYWORD.Reel");
        eta1.addTransition(eta46, 'R');
        eta46.addTransition(eta47, 'e');
        eta47.addTransition(eta48, 'e');
        eta48.addTransition(eta49, 'l');



        // For the keyword "repeter"
        Eta eta52 = new Eta("Eta52", true, "mallidentfy");
        Eta eta53 = new Eta("Eta53", true, "mallidentfy");
        Eta eta54 = new Eta("Eta54", true, "mallidentfy");
        Eta eta55 = new Eta("Eta55", true, "mallidentfy");
        Eta eta56 = new Eta("Eta56", true, "mallidentfy");
        Eta eta57 = new Eta("Eta57", true, "mallidentfy");  // Final state for "repeter"
        Eta eta157 = new Eta("Eta57", true, "KEYWORD.repeter");  // Final state for "repeter"
        eta1.addTransition(eta52, 'r');
        eta52.addTransition(eta53, 'e');
        eta53.addTransition(eta54, 'p');
        eta54.addTransition(eta55, 'e');
        eta55.addTransition(eta56, 't');
        eta56.addTransition(eta57, 'e');
        eta57.addTransition(eta157, 'r');

// For the keyword "jusqu’a"
        Eta eta58 = new Eta("Eta58", true, "mallidentfy");
        Eta eta59 = new Eta("Eta59", true, "mallidentfy");
        Eta eta60 = new Eta("Eta60", true, "mallidentfy");
        Eta eta61 = new Eta("Eta61", true, "mallidentfy");
        Eta eta62 = new Eta("Eta62", true, "mallidentfy");
        Eta eta63 = new Eta("Eta63", true, "mallidentfy");
        Eta eta163 = new Eta("eta163", true, "KEYWORD.jusqu’a");


        eta1.addTransition(eta58, 'j');
        eta58.addTransition(eta59, 'u');
        eta59.addTransition(eta60, 's');
        eta60.addTransition(eta61, 'q');
        eta61.addTransition(eta62, 'u');
        eta62.addTransition(eta63, '’');
        eta63.addTransition(eta163, 'à');


        // For the operator "="
        Eta eta30 = new Eta("Eta30", true, "OPERATOR.=");
        eta1.addTransition(eta30, '=');

        // For the operator "<=","<>"
        Eta eta32 = new Eta("Eta32", true, "OPERATOR.< ");
        Eta eta33 = new Eta("Eta33", true, "OPERATOR.<= ");  // Final state for "<="
        Eta eta67 = new Eta("Eta67", true, "OPERATOR.<>");
        eta1.addTransition(eta32, '<');
        eta32.addTransition(eta33, '=');
        eta32.addTransition(eta67, '>');
// For the operator ">="
        Eta eta64 = new Eta("Eta64", true, "OPERATOR.>");
        Eta eta65 = new Eta("Eta65", true, "OPERATOR.>=");  // Final state for ">="
        eta1.addTransition(eta64, '>');
        eta64.addTransition(eta65, '=');

        // For the operator ":="
        Eta eta7764 = new Eta("Eta64", true, "OPERATOR.:");
        Eta eta7765 = new Eta("Eta65", true, "OPERATOR.:=");  // Final state for ">="
        eta1.addTransition(eta7764, ':');
        eta7764.addTransition(eta7765, '=');
// For the operator "+"
        Eta eta74 = new Eta("Eta74", true, "OPERATOR.+");
        eta1.addTransition(eta74, '+');


// For the operator "-"
        Eta eta76 = new Eta("Eta76", true, "OPERATOR.-");
         eta1.addTransition(eta76, '-');

// For the operator "*"
        Eta eta78 = new Eta("Eta78", true, "OPERATOR.*");
        eta1.addTransition(eta78, '*');
// For the operator "."
        Eta eta1978 = new Eta("Eta78", true, "OPERATOR..");
        eta1.addTransition(eta1978, '.');


// For the operator "div"
        Eta eta82 = new Eta("Eta82", true, "mallidentfy");
        Eta eta83 = new Eta("Eta83", true, "mallidentfy");
        Eta eta84 = new Eta("Eta84", true, "OPERATOR.div");  // Final state for "div"
        eta1.addTransition(eta82, 'd');
        eta82.addTransition(eta83, 'i');
        eta83.addTransition(eta84, 'v');

// For the operator "mod"
        Eta eta86 = new Eta("Eta86", true, "mallidentfy");
        Eta eta87 = new Eta("Eta87", true, "mallidentfy");
        Eta eta88 = new Eta("Eta88", true, "OPERATOR.mod");
         eta1.addTransition(eta86, 'm');
        eta86.addTransition(eta87, 'o');
        eta87.addTransition(eta88, 'd');

// For the operator "et"
        Eta eta90 = new Eta("Eta90", true, "mallidentfy");
        Eta eta91 = new Eta("Eta91", true, "OPERATOR.et");  // Final state for "et"
        eta1.addTransition(eta90, 'e');
        eta90.addTransition(eta91, 't');

// For the operator "ou"
        Eta eta92 = new Eta("Eta92", true, "mallidentfy");
        Eta eta93 = new Eta("Eta93", true, "OPERATOR.ou");  // Final state for "ou"
        eta1.addTransition(eta92, 'o');
        eta92.addTransition(eta93, 'u');

// numbers
        Eta eta94 = new Eta("Eta92", true, "constant");
        Eta eta95 = new Eta("Eta93", true, "mallconstant");  // Final state for "ou"
        eta1.addTransition(eta94, '0','1','2','3','4','5','6','7','8','9');
        eta94.addTransition(eta94, '0','1','2','3','4','5','6','7','8','9');
        eta94.addTransition(eta95, Transition.giveme("0","1","2","3","4","5","6","7","8","9"));
        eta95.addTransition(eta95, Transition.giveme());
//:=

        Eta eta194 = new Eta("Eta92", true, "OPERATOR.:");
        eta1.addTransition(eta194, ':');

      
        Eta eta1194 = new Eta("Eta92", true, "OPERATOR.(");
        Eta eta1195 = new Eta("Eta93", true, "OPERATOR.)");  // Final state for "ou"
        eta1.addTransition(eta1194, '(');
        eta1.addTransition(eta1195, ')');


        Eta eta17194 = new Eta("Eta92", true, "OPERATOR.‘");
        Eta eta11795 = new Eta("Eta93", true, "OPERATOR.’");  // Final state for "ou"
        eta1.addTransition(eta17194, '‘');
        eta1.addTransition(eta11795, '’');


        // lol
        eta540.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta2.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta10.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta15.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta18.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta34.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta41.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta46.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta52.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta58.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta92.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta82.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta86.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');
        eta90.addTransition(identfy, '0','1','2','3','4','5','6','7','8','9');



        eta1.addTransition(mallidentify_final, Transition.giveme("p", "d", "f", "v", "E", "C", "r", "j", "d", "o", "m", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        eta2.addTransition(mallidentify_final, Transition.giveme("r"));
        eta3.addTransition(mallidentify_final, Transition.giveme("o"));
        eta4.addTransition(mallidentify_final, Transition.giveme("g"));
        eta5.addTransition(mallidentify_final, Transition.giveme("r"));
        eta6.addTransition(mallidentify_final, Transition.giveme("a"));
        eta7.addTransition(mallidentify_final, Transition.giveme("m"));
        eta8.addTransition(mallidentify_final, Transition.giveme("e"));
        eta10.addTransition(mallidentify_final, Transition.giveme("e"));
        eta11.addTransition(mallidentify_final, Transition.giveme("b"));
        eta12.addTransition(mallidentify_final, Transition.giveme("u"));
        eta13.addTransition(mallidentify_final, Transition.giveme("t"));
        eta15.addTransition(mallidentify_final, Transition.giveme("i"));
        eta16.addTransition(mallidentify_final, Transition.giveme("n"));
        eta18.addTransition(mallidentify_final, Transition.giveme("a"));
        eta19.addTransition(mallidentify_final, Transition.giveme("r"));
        eta20.addTransition(mallidentify_final, Transition.giveme("i"));
        eta21.addTransition(mallidentify_final, Transition.giveme("a"));
        eta34.addTransition(mallidentify_final, Transition.giveme("n"));
        eta35.addTransition(mallidentify_final, Transition.giveme("t"));
        eta36.addTransition(mallidentify_final, Transition.giveme("i"));
        eta37.addTransition(mallidentify_final, Transition.giveme("e"));
        eta38.addTransition(mallidentify_final, Transition.giveme("r"));
        eta40.addTransition(mallidentify_final, Transition.giveme("a"));
        eta41.addTransition(mallidentify_final, Transition.giveme("r"));
        eta42.addTransition(mallidentify_final, Transition.giveme("a"));
        eta43.addTransition(mallidentify_final, Transition.giveme("c"));
        eta44.addTransition(mallidentify_final, Transition.giveme("e"));
        eta46.addTransition(mallidentify_final, Transition.giveme("e"));
        eta47.addTransition(mallidentify_final, Transition.giveme("e"));
        eta48.addTransition(mallidentify_final, Transition.giveme("l"));
        eta49.addTransition(mallidentify_final, Transition.giveme("e"));
        eta52.addTransition(mallidentify_final, Transition.giveme("e"));
        eta53.addTransition(mallidentify_final, Transition.giveme("p"));
        eta54.addTransition(mallidentify_final, Transition.giveme("e"));
        eta55.addTransition(mallidentify_final, Transition.giveme("t"));
        eta56.addTransition(mallidentify_final, Transition.giveme("e"));
        eta58.addTransition(mallidentify_final, Transition.giveme("u"));
        eta59.addTransition(mallidentify_final, Transition.giveme("s"));
        eta60.addTransition(mallidentify_final, Transition.giveme("q"));
        eta61.addTransition(mallidentify_final, Transition.giveme("u"));
        eta62.addTransition(mallidentify_final, Transition.giveme("a"));
        eta82.addTransition(mallidentify_final, Transition.giveme("i"));
        eta83.addTransition(mallidentify_final, Transition.giveme("v"));
        eta86.addTransition(mallidentify_final, Transition.giveme("o"));
        eta87.addTransition(mallidentify_final, Transition.giveme("d"));
        eta92.addTransition(mallidentify_final, Transition.giveme("u"));



        // Set the initial state

        initialState = eta1;
    }

    // Process the file and generate tokens
    public void analyzeFile(String inputFilePath, String outputFilePath, String tablePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter varTable = new BufferedWriter(new FileWriter(tablePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int lineNumber = 1;
            int identifierOrConstantCount = 0;
            Map<String, Integer> identifierMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                int columnNumber = 1;
                Eta currentState = this.initialState;
                StringBuilder tokenBuilder = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    if (Character.isWhitespace(currentChar)) {
                        if (tokenBuilder.length() > 0) {
                            processToken(writer, varTable, identifierMap, tokenBuilder.toString(), currentState, lineNumber, columnNumber - tokenBuilder.length());
                            tokenBuilder.setLength(0);
                            currentState = this.initialState;
                        }
                        columnNumber++;
                    } else {
                        tokenBuilder.append(currentChar);
                        Eta nextState = currentState.nextState(currentChar);
                        if (nextState == null) {
                            processToken(writer, varTable, identifierMap, tokenBuilder.toString(), currentState, lineNumber, columnNumber - tokenBuilder.length());
                            tokenBuilder.setLength(0);
                            tokenBuilder.append(currentChar);
                            currentState = this.initialState.nextState(currentChar);
                        } else {
                            currentState = nextState;
                        }
                        columnNumber++;
                    }
                }

                if (tokenBuilder.length() > 0) {
                    processToken(writer, varTable, identifierMap, tokenBuilder.toString(), currentState, lineNumber, columnNumber - tokenBuilder.length());
                }
                lineNumber++;
            }

            System.out.println("Tokenization complete. Results written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error while processing files: " + e.getMessage());
        }
    }

    private void processToken(BufferedWriter writer, BufferedWriter varTable, Map<String, Integer> identifierMap,
                              String token, Eta currentState, int lineNumber, int columnNumber) throws IOException {
        if (currentState != null && currentState.isFinalState()) {
            String tokenType = currentState.getTokenType();

            if (tokenType.contains("identfy") || tokenType.contains("constant")) {
                int id;
                if (identifierMap.containsKey(token)) {
                    id = identifierMap.get(token);
                } else {
                    id = identifierMap.size();
                    identifierMap.put(token, id);
                    varTable.write(tokenType + "|" + token + "|" + id);
                    varTable.newLine();
                }
                writer.write("(" + tokenType + "| \"" + id + "\"| line " + lineNumber + "| column " + columnNumber + ")");
                writer.newLine();
            } else {
                writer.write("(" + tokenType + "| \"" + token + "\"| line " + lineNumber + "| column " + columnNumber + ")");
                writer.newLine();
            }
        } else {
            writer.write("(error| \"" + token + "\"| line " + lineNumber + "| column " + columnNumber + ")");
            writer.newLine();
        }
    }
}
