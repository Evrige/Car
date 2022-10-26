package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    TextView tw;
    ImageView iw;
    Button b[]= new Button[6];
    String[] ans;
    Intent intent;
    int right;
    String result="";

    public void clickButton(View v){
        Button vv = (Button) v;
        String answer = vv.getText().toString();
        tw.setText(answer);

        if (answer.equals(ans[right])) result = "Вірно";
        else result = "Не вірно";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        tw = (TextView) findViewById(R.id.answerTextView);
        iw = (ImageView) findViewById(R.id.imageView);
        b[0] = (Button) findViewById(R.id.button);
        b[2] = (Button) findViewById(R.id.button2);
        b[3] = (Button) findViewById(R.id.button3);
        b[4] = (Button) findViewById(R.id.button4);
        b[5] = (Button) findViewById(R.id.button5);
        b[6] = (Button) findViewById(R.id.button6);

        Resources res = getResources();
        ans = res.getStringArray(R.array.answer);

        for (int i = 0; i < 6; i++) b[i].setText(ans[i]);

        int i = (int)( 6 * Math.random() );

        switch (i){
            case 0: iw.setImageResource(R.drawable.i1);
                right = 1;
                break;
            case 1: iw.setImageResource(R.drawable.i2);
                right = 0;
                break;
            case 2: iw.setImageResource(R.drawable.i3);
                right = 2;
                break;
            case 3: iw.setImageResource(R.drawable.i4);
                right = 3;
                break;
            case 4: iw.setImageResource(R.drawable.i5);
                right = 5;
                break;
            case 5: iw.setImageResource(R.drawable.i6);
                right = 4;
                break;
        }
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("answer", tw.getText());
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
        intent = new Intent(this, Activity2.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
       if (id == R.id.New) this.recreate();
       if (id == R.id.Exit) this.finish();

       return super.onOptionsItemSelected(item);
    }

}