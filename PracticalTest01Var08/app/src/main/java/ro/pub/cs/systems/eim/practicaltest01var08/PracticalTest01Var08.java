package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08 extends AppCompatActivity {


    private final static int sec = 1;

    private Button set = null;


    private EditText left_top = null;
    private EditText right_top = null;
    private EditText left_bottom = null;
    private EditText right_bottom = null;



    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button:

                    Intent intent = new Intent(getApplicationContext() , PracticalTest01Var08SecondaryActivity.class);

                    int var1 = Integer.parseInt(left_top.getText().toString());
                    int var2 = Integer.parseInt(right_top.getText().toString());
                    int var3 = Integer.parseInt(left_bottom.getText().toString());
                    int var4 = Integer.parseInt(right_bottom.getText().toString());

                    intent.putExtra("var1" , var1);
                    intent.putExtra("var2" , var2);
                    intent.putExtra("var3" , var3);
                    intent.putExtra("var4" , var4);

                    // sunt deja setate numere din xml
                    startActivityForResult(intent , sec);
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString("leftTop" , left_top.getText().toString());
        savedInstanceState.putString("rightTop" , right_top.getText().toString());
        savedInstanceState.putString("leftBottom" , left_bottom.getText().toString());
        savedInstanceState.putString("rightBottom" , right_bottom.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        if (savedInstanceState.containsKey("leftTop"))
        {
            left_top.setText(savedInstanceState.getString("leftTop"));
        }
        else
        {
            left_top.setText(null);
        }


        if (savedInstanceState.containsKey("rightTop"))
        {
            right_top.setText(savedInstanceState.getString("rightTop"));
        }
        else
        {
            right_top.setText(null);
        }


        if (savedInstanceState.containsKey("leftBottom"))
        {
            left_bottom.setText(savedInstanceState.getString("leftBottom"));
        }
        else
        {
            left_bottom.setText(null);
        }


        if (savedInstanceState.containsKey("rightBottom"))
        {
            right_bottom.setText(savedInstanceState.getString("rightBottom"));
        }
        else
        {
            right_bottom.setText(null);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08);

        left_top = (EditText)findViewById(R.id.left_top);
        right_top = (EditText)findViewById(R.id.right_top);
        left_bottom = (EditText)findViewById(R.id.left_bottom);
        right_bottom = (EditText)findViewById(R.id.right_bottom);

        set=(Button)findViewById(R.id.button);
        set.setOnClickListener(buttonClickListener);


        if(savedInstanceState != null)
        {
            if(savedInstanceState.containsKey("leftTop"))
            {
                left_top.setText(savedInstanceState.getString("leftTop"));
            }
            else
            {
                left_top.setText(null);
            }

            if(savedInstanceState.containsKey("rightTop"))
            {
                right_top.setText(savedInstanceState.getString("rightTop"));
            }
            else
            {
                right_top.setText(null);
            }

            if(savedInstanceState.containsKey("leftBottom"))
            {
                left_bottom.setText(savedInstanceState.getString("leftBottom"));
            }
            else
            {
                left_bottom.setText(null);
            }

            if(savedInstanceState.containsKey("rightBottom"))
            {
                right_bottom.setText(savedInstanceState.getString("rightBottom"));
            }
            else
            {
                right_bottom.setText(null);
            }

            left_top.setText(null);
            right_top.setText(null);
            left_bottom.setText(null);
            right_bottom.setText(null);
        }

    }
}
