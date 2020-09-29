package com.blucyn.secretmessage;

public class CaesarShift {

    //Constructor.
    public CaesarShift(){

    }


    //Converts a letter to a number.
    /*
      - A to Z is 1 to 26 respectively.
     */
    public int letterToNum(String str){
        str = str.substring(0, 1).toUpperCase();

        if(str.equals("A")){
            return 1;
        }else if(str.equals("B")){
            return 2;
        }else if(str.equals("C")){
            return 3;
        }else if(str.equals("D")){
            return 4;
        }else if(str.equals("E")){
            return 5;
        }else if(str.equals("F")){
            return 6;
        }else if(str.equals("G")){
            return 7;
        }else if(str.equals("H")){
            return 8;
        }else if(str.equals("I")){
            return 9;
        }else if(str.equals("J")){
            return 10;
        }else if(str.equals("K")){
            return 11;
        }else if(str.equals("L")){
            return 12;
        }else if(str.equals("M")){
            return 13;
        }else if(str.equals("N")){
            return 14;
        }else if(str.equals("O")){
            return 15;
        }else if(str.equals("P")){
            return 16;
        }else if(str.equals("Q")){
            return 17;
        }else if(str.equals("R")){
            return 18;
        }else if(str.equals("S")){
            return 19;
        }else if(str.equals("T")){
            return 20;
        }else if(str.equals("U")){
            return 21;
        }else if(str.equals("V")){
            return 22;
        }else if(str.equals("W")){
            return 23;
        }else if(str.equals("X")){
            return 24;
        }else if(str.equals("Y")){
            return 25;
        }else if(str.equals("Z")){
            return 26;
        }

        return -1;
    }

    //Reverses letter to num.
    public String numToLetter(int num){

        if(num == 1) {
            return "A";
        }else if(num == 2) {
            return "B";
        }else if(num == 3) {
            return "C";
        }else if(num == 4) {
            return "D";
        }else if(num == 5) {
            return "E";
        }else if(num == 6) {
            return "F";
        }else if(num == 7) {
            return "G";
        }else if(num == 8) {
            return "H";
        }else if(num == 9) {
            return "I";
        }else if(num == 10) {
            return "J";
        }else if(num == 11) {
            return "K";
        }else if(num == 12) {
            return "L";
        }else if(num == 13) {
            return "M";
        }else if(num == 14) {
            return "N";
        }else if(num == 15) {
            return "O";
        }else if(num == 16) {
            return "P";
        }else if(num == 17) {
            return "Q";
        }else if(num == 18) {
            return "R";
        }else if(num == 19) {
            return "S";
        }else if(num == 20) {
            return "T";
        }else if(num == 21) {
            return "U";
        }else if(num == 22) {
            return "V";
        }else if(num == 23) {
            return "W";
        }else if(num == 24) {
            return "X";
        }else if(num == 25) {
            return "Y";
        }else if(num == 26) {
            return "Z";
        }

        return "";
    }

    //Shifts a letter by a given int amount.
    public String shift(String str, int shift){
        //Ignore spaces.
        if(str.substring(0, 1).equals(" ")){
            return " ";
        }
        int num = this.letterToNum(str) + shift;

        //Make sure it wraps around.
        while(num > 26 || num < 1) {
            if (num > 26) {
                num = num - 26;
            } else {
                num = num + 26;
            }
        }

        str = this.numToLetter(num);
        return str;
    }

    //Shifts a sentence by a given int amount.
    public String shiftSentence(String str, int shift){
        char[] arr = str.toCharArray();
        String newStr = "";
        for(int i = 0; i < arr.length; i++){
            newStr = newStr + this.shift(Character.toString(arr[i]), shift);
        }
        return newStr;
    }

}
