package com.example.jackson.avatarrules;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class info_screen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Intent intent = getIntent();

        TextView genericTextView = (TextView) findViewById(R.id.textViewGeneric);
        TextView characterTextView = (TextView) findViewById(R.id.textViewCharacter);
        TextView characterTitleTextView = (TextView) findViewById(R.id.textView4);
        TextView title = (TextView) findViewById(R.id.title);

        String character = intent.getStringExtra("char");
        String spaceNumString = intent.getStringExtra("spaceNum");

        Resources res = getResources();

        String[] genericRules = res.getStringArray(R.array.genericRules);

        int spaceNum = Integer.parseInt(spaceNumString);

        String genericRule = genericRules[spaceNum - 1];

        String characterRule = getCharRule(character, res, spaceNum);

        genericTextView.setText(genericRule);
        characterTextView.setText(characterRule);
        characterTitleTextView.setText(character + " Rule:");

        String[] epNames = res.getStringArray(R.array.spaceNames);
        title.setText(epNames[spaceNum-1]);
    }//onCreate


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_info_screen, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private String getCharRule(String characterString, Resources res, int spaceNum){
        String ruleString;
        String[] rules;
        switch (characterString){
            case "Aang":
                rules = res.getStringArray(R.array.aangRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Katara":
                rules = res.getStringArray(R.array.kataraRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Sokka":
                rules = res.getStringArray(R.array.sokkaRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Zuko":
                rules = res.getStringArray(R.array.zukoRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Toph/Appa/Momo":
                rules = res.getStringArray(R.array.tophRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Zhao/Azula":
                rules = res.getStringArray(R.array.azulaRules);
                ruleString = rules[spaceNum - 1];
                break;
            case "Uncle Iroh":
                rules = res.getStringArray(R.array.irohRules);
                ruleString = rules[spaceNum - 1];
                break;
            default:
                rules = res.getStringArray(R.array.aangRules);
                ruleString = rules[spaceNum - 1];
                break;
        }//switch
        return ruleString;
    }//getCharNameForRule(String)
}
