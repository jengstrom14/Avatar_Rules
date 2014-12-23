package com.example.jackson.avatarrules;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {
    private String[] array_spinner = new String[67];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 1; i <= 67; i++){
            array_spinner[i-1] = Integer.toString(i);
        }//for
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
    }//onCreate(Bundle)

    public void sendMessage(View view){
        Intent intent = new Intent(this, info_screen.class);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rGroup);

        String spaceNum = spinner.getSelectedItem().toString();

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonId);
        int radioId = radioGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
        String character = (String) btn.getText();

        intent.putExtra("char",character);
        intent.putExtra("spaceNum",spaceNum);

        startActivity(intent);

//        Log.d("tag", "spinner number = " + spaceNum);
//        Log.d("tag","character = " + character);
    }//sendMessage


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
