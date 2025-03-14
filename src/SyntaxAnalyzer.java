import java.io.*;
import java.util.*;

public class SyntaxAnalyzer {
boolean is_fully_correct=true;
    // Token class
    static class Token {
        String type; // Type of the token (e.g., "KEYWORD", "IDENTIFIER")
        String value; // Actual token value
        int line; // Line number of the token
        int column; // Column number of the token

        public Token(String type, String value, int line, int column) {
            this.type = type;
            this.value = value;
            this.line = line;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(" + type + ", \"" + value + "\", line " + line + ", column " + column + ")";
        }
    }

    // Token list and position tracker
    private final List<Token> tokens;
    private int currentTokenIndex = 0;

    public SyntaxAnalyzer(List<Token> tokens) {
        this.tokens = tokens;
    }

    // Method to load tokens from a text file
    public static List<Token> loadTokensFromFile(String filePath) throws IOException {
        List<Token> tokens = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // Match token entries using regex to handle proper formatting
            String regex = "\\(([^|]+)\\|\\s*\"([^\"]+)\"\\|\\s*line\\s*(\\d+)\\|\\s*column\\s*(\\d+)\\)";

            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String type = matcher.group(1).trim();
                String value = matcher.group(2).trim();
                int lineNumber = Integer.parseInt(matcher.group(3).trim());
                int columnNumber = Integer.parseInt(matcher.group(4).trim());

                tokens.add(new Token(type, value, lineNumber, columnNumber));
            }
        }
        reader.close();
        return tokens;
    }
    // Helper: Advance to the next token
    private void advance() {
        if (currentTokenIndex < tokens.size() - 1) { // Ensure we don't go out of bounds
            System.out.println("Advancing from token: " + currentToken());
            currentTokenIndex++;
        } else {
            System.out.println("End of token stream reached.");
        }
    }

    private Token currentToken() {
        return tokens.get(currentTokenIndex);
    }

    // Helper: Expect a specific token type and advance
    private void expect(String expectedType) {
        if (currentToken().type.equals(expectedType)) {
            System.out.println("Expecting token: " + expectedType + " and advancing...");
            advance();
        } else {
            System.err.println("Syntax error at line " + currentToken().line + ", column " + currentToken().column +
                    ": Expected " + expectedType + ", found " + currentToken().type);
            is_fully_correct=false;
        }
    }

    // Grammar rules

    public void parseProgramme() {
        System.out.println("parseProgramme");
        System.out.println("");
        System.out.println("");

        // <ProgrammeAlgoLang> ::= programme <NomProgramme> ; <Corps> .
        expect("KEYWORD.programme");
        parseNomProgramme();
        expect("OPERATOR.;");
        parseCorps();
        expect("OPERATOR..");
        if(   is_fully_correct)System.out.println("Parsing completed successfully! yay😅");
        else System.out.println("Parsing completed with errors! 🤦‍♂️");
    }

    private void parseNomProgramme() {
        // <NomProgramme> ::= <Nom>
        parseNom();
    }

    private void parseNom() {
        // <Nom> ::= <Lettre><Chiffre>{<Lettre><Chiffre>}
        if (!currentToken().type.equals("identfy")) {
            System.err.println("parseNom,Syntax error: Expected an identifier, found " + currentToken());
            return;
        }
        advance(); // Consume identifier
    }

    private void parseCorps() {
        System.out.println("parseCorps");
        System.out.println("");
        System.out.println("");
        // <Corps> ::= [<PartieDéfinitionConstante>] [<PartieDéfinitionVariable>] <InstrComp>
        if (currentToken().type.equals("KEYWORD.Constante")) {
            parsePartieDefinitionConstante();
        }
        if (currentToken().type.equals("KEYWORD.variable")) {
            parsePartieDefinitionVariable();
        }
        parseInstrComp();
    }

    private void parsePartieDefinitionConstante() {
        System.out.println("parsePartieDefinitionConstante");
        System.out.println("");
        System.out.println("");
        // <PartieDéfinitionConstante> ::= constante <DéfinitionConstante> {<DéfinitionConstante>}
        expect("KEYWORD.Constante");
        do {
            parseDefinitionConstante();
        } while (currentToken().type.equals("identfy"));
    }

    private void parseDefinitionConstante() {
        System.out.println("parseDefinitionConstante");
        System.out.println("");
        System.out.println("");
        // <DéfinitionConstante> ::= <NomConstante> = <Constante> ;
        parseNomConstante();
        expect("OPERATOR.=");
        expect("constant");
        expect("OPERATOR.;");
    }

    private void parseNomConstante() {
        // <NomConstante> ::= <Nom>
        parseNom();
    }



    private void parsePartieDefinitionVariable() {
        System.out.println("parsePartieDefinitionVariable");
        System.out.println("");
        System.out.println("");
        // <PartieDéfinitionVariable> ::= variable <DéfinitionVariable> {<DéfinitionVariable>}
        expect("KEYWORD.variable");
        do {
            parseDefinitionVariable();
        } while (currentToken().type.equals("identfy"));
    }

    private void parseDefinitionVariable() {
        System.out.println("parseDefinitionVariable");
        System.out.println("");
        System.out.println("");
        // <DéfinitionVariable> ::= <GroupeVariable> ;
        parseGroupeVariable();
        expect("OPERATOR.;");
    }

    private void parseGroupeVariable() {
        System.out.println("parseGroupeVariable");
        System.out.println("");
        System.out.println("");
        // <GroupeVariable> ::= <NomVariable> {, <NomVariable>} : <NomType>
        parseNomVariable();
        while (currentToken().type.equals("OPERATOR.,")) {
            advance();
            parseNomVariable();
        }
        expect("OPERATOR.:");
        parseNomType();
    }

    private void parseNomVariable() {

        // <NomVariable> ::= <Nom>
        parseNom();
    }

    private void parseNomType() {
        System.out.println("parseNomType");
        System.out.println("");
        System.out.println("");
        // <NomType> ::= Entier / Caractère / Réel
        if (currentToken().type.equals("KEYWORD.Entier") ||
                currentToken().type.equals("KEYWORD.Caractere") ||
                currentToken().type.equals("KEYWORD.Reel")) {
            advance();
        } else {
            System.err.println("parseNomType.Syntax error: Expected a type, found " + currentToken());
        }
    }

    private void parseInstrComp() {
        System.out.println("parseInstrComp");
        System.out.println("");
        System.out.println("");
        // <InstrComp> ::= debut <Instruction> {; <Instruction>} fin
        expect("KEYWORD.debut");
        parseInstruction();

        while (currentToken().type.equals("OPERATOR.;") ){
            advance();
            parseInstruction();
        }
        expect("KEYWORD.fin");

    }

    private void parseInstruction() {
        System.out.println("parseInstruction");
        System.out.println("");
        System.out.println("");
        // <Instruction> ::= <InstructionAffectation> / <InstructionRépéter> / <InstrComp> / <Vide>
        if (currentToken().type.equals("identfy")) {
            parseInstructionAffectation();
        } else if (currentToken().type.equals("KEYWORD.repeter")) {
            parseInstructionRépéter();
        } else if (currentToken().type.equals("KEYWORD.debut")) {
            parseInstrComp();
        } else if (currentToken().type.equals("OPERATOR.‘")) {
            Vide();
        }
    }
    private void Vide() {
        System.out.println("Vide");
        System.out.println("");
        System.out.println("");
        expect("OPERATOR.‘");
        expect("OPERATOR.’");
    }
    private void parseInstructionRépéter() {
        System.out.println("parseInstructionRépéter");
        System.out.println("");
        System.out.println("");
        // <InstructionRépéter> ::= répéter <Instruction> jusqu’à <Condition>
        expect("KEYWORD.repeter");
        parseInstruction();
        expect("KEYWORD.jusqu’a");
        parseCondition();
    }
    private void parseCondition() {
        System.out.println("parseCondition");
        System.out.println("");
        System.out.println("");
        // <Condition> ::= <Expression> <OperateurRelationnel> <Expression> / (<Condition>)
        if (currentToken().type.equals("OPERATOR.(")) {
            advance(); // Consume '('
            parseCondition(); // Parse the nested condition
            expect("OPERATOR.)"); // Expect closing parenthesis
        } else {
            // Parse a simple relational expression
            parseExpression();

            if (matchOperateurRelationnel()) {
                advance(); // Consume relational operator
                parseExpression();
            } else {
                  }
        }
    }



    private void parseInstructionAffectation() {
        System.out.println("parseInstructionAffectation");
        System.out.println("");
        System.out.println("");

        // <InstructionAffectation> ::= <NomVariable> := <Expression>
        parseNomVariable();
        expect("OPERATOR.:=");
        parseExpression();
    }

    private void parseExpression() {
        System.out.println("parseExpression");
        System.out.println("");
        System.out.println("");
        // Parse <ExpressionSimple>
        parseExpressionSimple();

        // Optionally parse [<OperateurRelationnel><ExpressionSimple>]
        if (matchOperateurRelationnel()) {
            parseOperateurRelationnel();
            parseExpressionSimple();
        }
    }

    private void parseExpressionSimple() {
        System.out.println("parseExpressionSimple");
        System.out.println("");
        System.out.println("");
        // Optionally parse [<OperateurSigne>]
        parseOperateurSigne();

        // Parse <Terme>
        parseTerme();

        // Optionally parse {<OperateurAddition><Terme>}
        while (parseOperateurAddition()) {
            parseTerme();
        }
    }

    private void parseOperateurRelationnel() {
        System.out.println("parseOperateurRelationnel");
        System.out.println("");
        System.out.println("");
        // Expect </, >, =, <=, >=, or <>
        if ( matchOperateurRelationnel()) {
            advance(); // Consume operator
        } else {
            System.err.println("Expected relational operator (</, >, =, <=, >=, <>)");
        }
    }

    private void parseOperateurSigne() {
        System.out.println("parseOperateurSigne");
        System.out.println("");
        System.out.println("");
        // Expect + or -
        if (matchOperateurSigne()) {
            advance(); // Consume operator
        }
    }

    private boolean parseOperateurAddition() {
        System.out.println("parseOperateurAddition");
        System.out.println("");
        System.out.println("");
        // Expect +, -, or "ou"
        if ( matchOperateurAddition()) {
            advance();
            return true;
        } else {
            return false;
        }
    }

    private void parseTerme() {
        System.out.println("parseTerme");
        System.out.println("");
        System.out.println("");
        // Parse <Facteur>
        parseFacteur();

        // Optionally parse {<OperateurMult><Facteur>}
        while (matchOperateurMult()) {
            parseOperateurMult();
            parseFacteur();
        }
    }

    private void parseOperateurMult() {
        System.out.println("parseOperateurMult");
        System.out.println("");
        System.out.println("");
        // Expect *, /, div, mod, or "et"
        if (currentToken().type.equals("OPERATOR.*") ||  currentToken().type.equals("KEYWORD.div") ||
                currentToken().type.equals("KEYWORD.mod") || currentToken().type.equals("KEYWORD.et")) {
            advance(); // Consume operator
        } else {
            System.err.println("Expected multiplication operator (*, div, mod, et)");
        }
    }

    private void parseFacteur() {
        System.out.println("parseFacteur");
        System.out.println("");
        System.out.println("");
        if (currentToken().type.equals("constant")) {
            // Parse <Constante>
            advance(); // Consume constant
        } else if (currentToken().type.equals("identfy")) {
            // Parse <NomVariable>
            advance(); // Consume variable name
        } else if (currentToken().type.equals("OPERATOR.(")) {
            // Parse (<Expression>)
            advance(); // Consume '('
            parseExpression();
            expect("OPERATOR.)");

        } else {
            System.err.println("Expected constant, variable, or expression in parentheses");
        }
    }

    private boolean matchOperateurRelationnel() {
        System.out.println("matchOperateurRelationnel");
        System.out.println("");
        System.out.println("");
        return currentToken().type.equals("OPERATOR.<") || currentToken().type.equals("OPERATOR.>") || currentToken().type.equals("OPERATOR.=") ||
                currentToken().type.equals("OPERATOR.<=") || currentToken().type.equals("OPERATOR.>=") || currentToken().type.equals("OPERATOR.<>");
    }

    private boolean matchOperateurSigne() {
        System.out.println("matchOperateurSigne");
        System.out.println("");
        System.out.println("");
        return currentToken().type.equals("OPERATOR.+") || currentToken().type.equals("OPERATOR.-");
    }

    private boolean matchOperateurAddition() {
        System.out.println("matchOperateurAddition");
        System.out.println("");
        System.out.println("");
        return currentToken().type.equals("OPERATOR.+") || currentToken().type.equals("OPERATOR.-") ;
    }

    private boolean matchOperateurMult() {
        System.out.println("matchOperateurMult");
        System.out.println("");
        System.out.println("");
        return currentToken().type.equals("OPERATOR.*") || currentToken().type.equals("OPERATOR./") || currentToken().type.equals("KEYWORD.div") ||
                currentToken().type.equals("KEYWORD.mod") || currentToken().type.equals("KEYWORD.et");
    }


    // Main method
    public static void main(String[] args) {
        try {
            // File path to load tokens
            String filePath = "src/token.txt"; // Replace with your file path
            List<Token> tokens = loadTokensFromFile(filePath);

            SyntaxAnalyzer parser = new SyntaxAnalyzer(tokens);
            parser.parseProgramme();
        } catch (IOException e) {
            System.err.println("Error reading tokens file: " + e.getMessage());
        }
    }
}
