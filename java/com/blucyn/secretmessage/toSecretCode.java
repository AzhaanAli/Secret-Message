package com.blucyn.secretmessage;

import java.util.ArrayList;

public class toSecretCode {
    ArrayList<String> input;
    ArrayList<String> output;

    ArrayList<String> compIn;
    ArrayList<String> compOut;

    int s1;
    int s2;


    //-------------------------------------------------------------------------------------//

    //Constructor.
    public toSecretCode(){
        this.input = new ArrayList<>();
        this.output = new ArrayList<>();

        this.compIn = new ArrayList<>();
        this.compOut = new ArrayList<>();

        this.s1 = 21;
        this.s2 = 2;

        this.initialize();
        this.initializeCompression();
    }
    public toSecretCode(int s1, int s2){
        this.input = new ArrayList<>();
        this.output = new ArrayList<>();

        this.compIn = new ArrayList<>();
        this.compOut = new ArrayList<>();

        this.s1 = s1;
        this.s2 = s2;

        this.initialize();
        this.initializeCompression();
    }

    //Setup methods.
    public void addNew(String input, String output) {
        this.input.add(input);
        this.output.add(output);
    }
    public void addNewComp(String input, String output) {
        this.compIn.add(input);
        this.compOut.add(output);
    }
    public void clear() {
        this.input.clear();
        this.output.clear();
    }

    //Streamline setup for symbols.
    public void initialize(){
        this.initializeLetters();
        this.initializeNumbers();
        this.initializePunctuation();
    }
    public void initializeLetters(){
        this.addNew("A", "ⵠ");
        this.addNew("B", "ᐁ");
        this.addNew("C", "ⵋ");
        this.addNew("D", "ⵁ");
        this.addNew("E", "ⵀ");
        this.addNew("F", "ⵚ");
        this.addNew("G", "ⵄ");
        this.addNew("H", "ⴿ");
        this.addNew("I", "ⴽ");
        this.addNew("J", "ⴼ");
        this.addNew("K", "ⴷ");
        this.addNew("L", "ⴸ");
        this.addNew("M", "ᐅ");
        this.addNew("N", "ᐊ");
        this.addNew("O", "ᗆ");
        this.addNew("P", "ᗉ");
        this.addNew("Q", "ⴳ");
        this.addNew("R", "ⴴ");
        this.addNew("S", "ⴵ");
        this.addNew("T", "ᗋ");
        this.addNew("U", "ᗊ");
        this.addNew("V", "ⵟ");
        this.addNew("W", "ⴱ");
        this.addNew("X", "ⴲ");
        this.addNew("Y", "ⴾ");
        this.addNew("Z", "ⵗ");
    }
    public void initializeNumbers(){
        this.addNew("0", "ᘜ");
        this.addNew("1", "ᘞ");
        this.addNew("2", "ᘢ");
        this.addNew("3", "ᘤ");
        this.addNew("4", "ᘨ");
        this.addNew("5", "ᘩ");
        this.addNew("6", "ᘧ");
        this.addNew("7", "ᘣ");
        this.addNew("8", "ᘡ");
        this.addNew("9", "ᘝ");
    }
    public void initializePunctuation(){
        this.addNew("~", "ᐋ");
        this.addNew("@", "ᐌ");
        this.addNew("#", "ᐍ");
        this.addNew("$", "ᐎ");
        this.addNew("%", "ᐏ");
        this.addNew("^", "ᐐ");
        this.addNew("&", "ᐑ");
        this.addNew("*", "ᐒ");
        this.addNew(":", "ᐓ");
        this.addNew(";", "ᐔ");
        this.addNew("'", "ᐕ");
        this.addNew("\"", "ᐖ");
        this.addNew(",", "ᐗ");
        this.addNew("/", "ᐘ");
        this.addNew("`", "ᐙ");
        this.addNew("+", "ᐚ");
        this.addNew("=", "ᐛ");
        this.addNew("-", "ᐟ");
        this.addNew("_", "ᐠ");
    }

    //Streamline setup for compression.
    public void initializeCompression(){
        this.initializeCompWords();
        this.initializeCompPairs();
    }
    private void initializeCompWords(){
        this.addNewComp("alright", "ᒥ");
        this.addNewComp("reyhan", "✞");
        this.addNewComp("Reyhan", "✞");
        this.addNewComp("chloe", "〠");
        this.addNewComp("Chloe", "〠");
        this.addNewComp("babey", "ᕓ");
        this.addNewComp("thing", "ᕔ");
        this.addNewComp("would", "ᒧ");
        this.addNewComp("their", "ᒨ");
        this.addNewComp("with", "ᒩ");
        this.addNewComp("good", "ᒪ");
        this.addNewComp("that", "ᒫ");
        this.addNewComp("they", "ᕖ");
        this.addNewComp("okay", "ᒱ");
        this.addNewComp("not", "ᒭ");
        this.addNewComp("you", "ᒮ");
        this.addNewComp("she", "ᒯ");
        this.addNewComp("and", "ᒰ");
        this.addNewComp("the", "ᒳ");
        this.addNewComp("how", "ᕕ");
        this.addNewComp("are", "ᕜ");
    }
    private void initializeCompPairs(){
        this.addNewComp("th", "ᖸ");
        this.addNewComp("he", "ᖵ");
        this.addNewComp("an", "ᖶ");
        this.addNewComp("in", "ᖷ");
        this.addNewComp("er", "ᖺ");
        this.addNewComp("on", "ᖹ");
        this.addNewComp("re", "ᖻ");
        this.addNewComp("ed", "ᖼ");
        this.addNewComp("nd", "ᖽ");
        this.addNewComp("ha", "ᖾ");
        this.addNewComp("at", "ᖿ");
        this.addNewComp("en", "ᗀ");
        this.addNewComp("es", "ᗁ");
        this.addNewComp("of", "ᗂ");
        this.addNewComp("nt", "ᗃ");
    }

    //-------------------------------------------------------------------------------------//

    //To symbols.
    public String toSymbol(String letter){
        letter = letter.toUpperCase();
        for(int i = 0; i < this.input.size(); i++){
            if (letter.equals(input.get(i))) {
                return output.get(i);
            }
        }
        return letter;
    }
    public String toSymbols(String word){
        String temp = "";
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++){
            temp += toSymbol(Character.toString(arr[i]));
        }

        return temp;
    }

    //To english.
    public String toLetter(String alien){
        for(int i = 0; i < this.input.size(); i++){
            if (alien.equals(output.get(i))){
                return input.get(i);
            }
        }
        return alien;
    }
    public String toLetters(String alien){
        String temp = "";
        char[] arr = alien.toCharArray();
        for(int i = 0; i < arr.length; i++){
            temp += toLetter(Character.toString(arr[i]));
        }

        return temp;
    }

    //-------------------------------------------------------------------------------------//

    //Decode/encode.
    public String encrypt(String input){
        Scramble s = new Scramble(this.s1, this.s2);

        input = this.compress(input);
        input = this.accountUpper(input);
        input = s.encrypt(input);
        input = this.toSymbols(input);

        return input;
    }
    public String decrypt(String input){
        Scramble s = new Scramble(this.s1, this.s2);

        input = this.toLetters(input);
        input = s.decrypt(input);
        input = this.removeUpper(input);
        input = this.decompress(input);

        return input;
    }

    //Compress/uncompress.
    public String compress(String input){
        //Loop through every term.
        for(int i = 0; i < this.compIn.size(); i++){

            String searchFor = this.compIn.get(i);
            String assignAs = this.compOut.get(i);

            //Replace every occurrence of each.
            while(input.contains(this.compIn.get(i))){
                input = input.replace(searchFor, assignAs);
            }
        }

        return input;
    }
    public String decompress(String input){
        //Loop through every term.
        for(int i = 0; i < this.compIn.size(); i++){

            String searchFor = this.compOut.get(i);
            String assignAs = this.compIn.get(i);

            //Replace every occurrence of each.
            while(input.contains(this.compOut.get(i))){
                input = input.replace(searchFor, assignAs);
            }
        }

        return input;
    }

    //-------------------------------------------------------------------------------------//

    //Helper methods.
    private boolean isUpper(String letter){
        if(letter.equals(" ")){
            return false;
        }else{
            for(int i = 0; i < this.compIn.size(); i++){
                if(letter.equals(compOut.get(i))) {
                    return false;
                }
            }
        }
        return letter.toUpperCase().equals(letter);
    }

    //Adds distinctions so you can tell if something is uppercase.
    private String accountUpper(String input){
        String newMsg = "";

        char[] arr = input.toCharArray();
        boolean onUpper = false;

        for(int i = 0; i < arr.length; i++){
            String letter = Character.toString(arr[i]);

            if(this.isUpper(letter)){
                if(!onUpper){
                    onUpper = true;
                    letter = "ᛍ" + letter;
                }
            }else if(onUpper){
                onUpper = false;
                letter = "ᛜ" + letter;
            }
            newMsg += letter;
        }

        return newMsg;
    }
    private String removeUpper(String input){
        input = input.toLowerCase();
        String newMsg = "";

        char[] arr = input.toCharArray();
        boolean makeUpper = false;

        for(int i = 0; i < arr.length; i++){
            String letter = Character.toString(arr[i]);

            if(makeUpper){
                letter = Character.toString(arr[i]).toUpperCase();
            }

            if(letter.equals("ᛍ")){
                makeUpper= true;

            }else if(letter.equals("ᛜ")){
                makeUpper = false;

            }else{
                newMsg += letter;
            }
        }

        return newMsg;
    }

    //Prints repeats that must be corrected.
    public void printRepeat(){
        boolean found = false;

        //Check for repeats in input.
        for(int i = 0; i < this.input.size(); i++){
            for(int j = 0; j < this.input.size(); j++){
                if(i != j && this.input.get(i).equals(this.input.get(j))){
                    System.out.println("Repeat found in input: " + this.input.get(i));
                    found = true;
                }
            }
        }

        //Check for repeats in output.
        for(int i = 0; i < this.output.size(); i++){
            for(int j = 0; j < this.output.size(); j++){
                if(i != j && this.output.get(i).equals(this.output.get(j))){
                    System.out.println("Repeat found in output: " + this.output.get(i));
                    found = true;
                }
            }
        }

        //Check both for mismatches.
        for(int i = 0; i < this.input.size(); i++){
            for(int j = 0; j < this.output.size(); j++){
                if(this.input.get(i).equals(this.output.get(j))){
                    System.out.println("Mismatch found: " + this.input.get(i) + " and " + this.output.get(j));
                    found = true;
                }
            }
        }

        if(!found){
            System.out.println("No repeats found.");
        }
    }
}
