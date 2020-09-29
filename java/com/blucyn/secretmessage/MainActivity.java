package com.blucyn.secretmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    //Variables to remember for later.
    boolean verticalSwitch;
    int config1;
    int config2;

    //File where all the saved data is stored.
    public static final String PREFS_NAME = "MyPrefsFile";

    //Parts of the screen.
    EditText inputText;
    EditText outputText;

    Switch enterSwitch;

    Button copyButton;
    Button clearButton;

    //Not really a part of the screen, but used in many computations.
    toSecretCode secret;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------------------------------------------------------//

        //Initialize EditText objects.
        inputText = (EditText)findViewById(R.id.inputText);
        outputText = (EditText)findViewById(R.id.outputText);

        //Initialize switch objects.
        enterSwitch = (Switch)findViewById(R.id.enterSwitch);

        //Initialize button objects.
        copyButton = (Button)findViewById(R.id.copyButton);
        clearButton = (Button)findViewById(R.id.clearButton);


        //-------------------------------------------------------------------------------------//

        //Turn on switches to their last save state.
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        verticalSwitch = settings.getBoolean("verticalSwitch", verticalSwitch);
        config1 = settings.getInt("config1", config1);
        config2 = settings.getInt("config2", config2);

        if(config1 == 0 && config2 == 0){
            config1 = 21;
            config2 = 11;
        }

        enterSwitch.setChecked(verticalSwitch);

        //-------------------------------------------------------------------------------------//

        //Initialize translator object.

        try {
            secret = new toSecretCode(config1, config2);
        }catch (Exception e){
            System.out.println("Problem in obj initialization.");
            secret = new toSecretCode(21, 11);
        }

        secret.clear();
        secret.initialize();
        if(enterSwitch.isChecked()){
            //Change translators way of treating spaces if box is checked.
            if(enterSwitch.isChecked()){
                secret.addNew(" ", "\n");
            }
        }

        //-------------------------------------------------------------------------------------//

        //Input text code.
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateOutput();
            }
        });

        //-------------------------------------------------------------------------------------//

        //Update output to match when enter switch is clicked.
        enterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Change translators way of treating spaces if box is checked.
                secret.clear();
                secret.initialize();
                if(enterSwitch.isChecked()){
                    secret.addNew(" ", "\n");
                }

                //Update the output.
                updateOutput();

                //Save last switch state.
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("verticalSwitch", isChecked);
                editor.commit();
            }
        });

        //-------------------------------------------------------------------------------------//

        //Code for the copy button.
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Copy the text.
                //Yell for help if a null-pointer error has been found.
                try {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Copied Output", outputText.getText().toString());
                    clipboard.setPrimaryClip(clip);
                }catch (NullPointerException e){
                    System.out.println("NULL POINTER EXCEPTION CAUSED");
                    return;
                }
            }
        });

        //Code for clear button.
        clearButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();

                //Check if it's a command.
                if(input.contains("SYS.CMD.")){

                    //Check if it's a channel set command.
                    if(input.contains(".SET_CHANNEL:") && input.length() == 24){

                        //Since it is, try to execute the command.
                        try{
                            String configs = input.split(":")[1];

                            String s1str = configs.substring(0, 2);
                            String s2str = configs.substring(2);

                            int s1 = Integer.parseInt(s1str);
                            int s2 = Integer.parseInt(s2str);

                            //Apply changes made.
                            secret.s1 = s1;
                            secret.s2 = s2;

                            if(s1 == 0 && s2 == 0){
                                config1 = 21;
                                config2 = 11;

                                secret.s1 = config1;
                                secret.s2 = config2;

                                outputText.setText("COMMAND SUCCESSFUL: CHANNEL SET TO [2111].");
                            }else{
                                outputText.setText("COMMAND SUCCESSFUL: CHANNEL SET TO [" + s1str + s2str + "].");
                            }

                            //Save changes made.
                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putInt("config1", s1);
                            editor.putInt("config2", s2);
                            editor.commit();

                            return;
                        }catch (Exception e){
                            //Doesn't need anything.
                        }
                    }
                    //Check if it's a channel get command.
                    if(input.contains(".GET_CHANNEL") && input.length() == 19){
                        String s1 = secret.s1 + "";
                        String s2 = secret.s2 + "";

                        //Formatting for if s1 or s2 is single digit.
                        if(secret.s1 < 10){
                            s1 = "0" + s1;
                        }
                        if(secret.s2 < 10){
                            s2 = "0" + s2;
                        }

                        outputText.setText("COMMAND SUCCESSFUL: CURRENT CHANNEL IS [" + s1 + s2 + "].");
                        return;
                    }
                }


                //Clear both text fields.
                inputText.setText("");
                outputText.setText("");

            }
        });
    }

    //-------------------------------------------------------------------------------------//

    //Methods.
    public boolean inComp(toSecretCode secret, String term){

        for(int i = 0; i < secret.compIn.size(); i++){
            if(term.equals(secret.compOut.get(i))){
                return true;
            }
        }

        return false;
    }
    public void updateOutput(){
        try {
            String input = inputText.getText().toString();
            String firstChar = input.substring(0, 1);

            boolean firstIsSpecial = firstChar.equals("ᛍ") || inComp(secret, firstChar);

            if (secret.toLetters(firstChar).equals(firstChar) && !firstIsSpecial) {
                //If the first character is english, convert it to code.
                input = secret.encrypt(input);
            } else {
                //If the first character is code, convert to english.
                input = secret.decrypt(input);
            }
            outputText.setText(input);


        }catch (Exception e){
            System.out.println("Error encountered.");
            outputText.setText("");
        }
    }
}