package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {


    EditText leftT = null;
    EditText rightT = null;
    EditText leftB = null;
    EditText rightB = null;

    Button sum = null;
    Button prod = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.sum:
                    int var1 = Integer.parseInt(leftT.getText().toString());
                    int var2 = Integer.parseInt(leftB.getText().toString());
                    int var3 = Integer.parseInt(rightT.getText().toString());
                    int var4 = Integer.parseInt(rightB.getText().toString());
                    int mysum = var1 + var2 + var3 + var4;
                    Toast.makeText(getApplicationContext(), "result" + mysum , Toast.LENGTH_LONG).show();
                    break;

                case R.id.prod:
                    int var5 = Integer.parseInt(leftT.getText().toString());
                    int var6 = Integer.parseInt(leftB.getText().toString());
                    int var7 = Integer.parseInt(rightT.getText().toString());
                    int var8 = Integer.parseInt(rightB.getText().toString());
                    int myprod = var5 + var6 + var7 + var8;
                    Toast.makeText(getApplicationContext(), "result" + myprod , Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);

        leftT = (EditText)findViewById(R.id.left_top);
        rightT = (EditText)findViewById(R.id.right_top);
        leftB = (EditText)findViewById(R.id.left_bottom);
        rightB = (EditText)findViewById(R.id.right_bottom);

        sum = (Button)findViewById(R.id.sum);
        prod = (Button)findViewById(R.id.prod);

        sum.setOnClickListener(buttonClickListener);
        prod.setOnClickListener(buttonClickListener);

        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();

        if (data.containsKey("var1"))
            leftT.setText(data.get("var1").toString());
        if (data.containsKey("var2"))
            rightT.setText(data.get("var2").toString());
        if (data.containsKey("var3"))
            leftB.setText(data.get("var3").toString());
        if (data.containsKey("var4"))
            rightB.setText(data.get("var4").toString());


        //finish();
    }
}
