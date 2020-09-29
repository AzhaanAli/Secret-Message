package com.blucyn.secretmessage;

public class Scramble {
    //Caesar shift object for Scrambles encryption.
    CaesarShift c;

    //Changes the encryption method.
    int s1;
    int s2;

    //Constructor.
    public Scramble(){
        c = new CaesarShift();
        this.s1 = 0;
        this.s2 = 0;
    }
    public Scramble(int s1){
        c = new CaesarShift();
        this.s1 = s1;
        this.s2 = 0;
    }
    public Scramble(int s1, int s2){
        c = new CaesarShift();
        this.s1 = s1;
        this.s2 = s2;
    }

    //Returns the amount the shift should change by.
    public int getChange(String str){
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

        return 0;
    }

    //Returns the amount the shift should change by.
    public boolean isLetter(String str){
        str = str.substring(0, 1).toUpperCase();

        if(str.equals("A")){
            return true;
        }else if(str.equals("B")){
            return true;
        }else if(str.equals("C")){
            return true;
        }else if(str.equals("D")){
            return true;
        }else if(str.equals("E")){
            return true;
        }else if(str.equals("F")){
            return true;
        }else if(str.equals("G")){
            return true;
        }else if(str.equals("H")){
            return true;
        }else if(str.equals("I")){
            return true;
        }else if(str.equals("J")){
            return true;
        }else if(str.equals("K")){
            return true;
        }else if(str.equals("L")){
            return true;
        }else if(str.equals("M")){
            return true;
        }else if(str.equals("N")){
            return true;
        }else if(str.equals("O")){
            return true;
        }else if(str.equals("P")){
            return true;
        }else if(str.equals("Q")){
            return true;
        }else if(str.equals("R")){
            return true;
        }else if(str.equals("S")){
            return true;
        }else if(str.equals("T")){
            return true;
        }else if(str.equals("U")){
            return true;
        }else if(str.equals("V")){
            return true;
        }else if(str.equals("W")){
            return true;
        }else if(str.equals("X")){
            return true;
        }else if(str.equals("Y")){
            return true;
        }else if(str.equals("Z")){
            return true;
        }

        return false;
    }

    //Encrypts a message.
    public String encrypt(String msg){

        int shift = 0;
        char[] arr = msg.toCharArray();
        char[] newArr = new char[arr.length];
        String newStr = "";

        //Change for s1 value.
        for(int i = 0; i < arr.length; i++){
            if(this.isLetter(Character.toString(arr[i]))){
                arr[i] = c.shift(Character.toString(arr[i]), this.s1 + shift).charAt(0);
                shift += this.s2;
            }
        }

        //Base encoding.
        shift = 0;
        for(int i = 0; i < arr.length; i++){
            if(this.isLetter(Character.toString(arr[i]))){
                //System.out.println("index " + i + " shifted by " + shift);
                newArr[i] = c.shift(Character.toString(arr[i]), shift).charAt(0);
                shift += this.getChange(Character.toString(arr[i]));
            }else{
                newArr[i] = arr[i];
            }

        }

        //Turn newArr into a string.
        for(int i = 0; i < newArr.length; i++){
            newStr += newArr[i];
        }
        return newStr;
    }

    //Decrypts a message.
    public String decrypt(String msg){
        int shift = 0;
        char[] arr = msg.toCharArray();
        char[] newArr = new char[arr.length];
        String newStr = "";

        //Base decoding.
        for(int i = 0; i < arr.length; i++){
            if(this.isLetter(Character.toString(arr[i]))){
                //System.out.println("index " + i + " shifted by " + shift);
                newArr[i] = c.shift(Character.toString(arr[i]), shift * -1).charAt(0);
                shift = this.getChange(Character.toString(arr[i]));
            }else{
                newArr[i] = arr[i];
            }
        }

        //Change for s1 value.
        shift = 0;
        for(int i = 0; i < arr.length; i++){
            if(this.isLetter(Character.toString(arr[i]))){
                newArr[i] = c.shift(Character.toString(newArr[i]), s1 * -1 - shift).charAt(0);
                shift += this.s2;
            }
        }

        //Turn newArr into a string.
        for(int i = 0; i < newArr.length; i++){
            newStr += newArr[i];
        }

        return newStr;
    }
}
