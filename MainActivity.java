package com.example.v_m_v.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operand,primary_number,temp;
    int pn=0;

    double memory;
    boolean clear;

    Button button;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        size();
    }

    public void click(View view)
    {

        button=(Button) view;
        text= findViewById(R.id.textview1);
        if(clear==true)
        {
            text.setText("");
            clear=false;
        }

        text.setText(text.getText()+button.getText().toString());
        size();
    }

    public void operate(View view)
    {
        text= findViewById(R.id.textview1);
        button=(Button)view;

        primary_number=text.getText().toString();
        operand=button.getText().toString();
        clear=true;

    }

    public void equal(View view)
    {
        double a ,b ,c = 0;
        String zero;

        button=(Button) view;
        text= findViewById(R.id.textview1);

        if(operand.equals(""))return;

        a=Double.parseDouble(primary_number);
        b=Double.parseDouble(text.getText().toString());
        text.setText(operand);

        if(operand.equals("+")){c=a+b;}
        if(operand.equals("-")){c=a-b;}
        if(operand.equals("*")){c=a*b;}
        if(operand.equals("/")){c=a/b;}

        text.setText(Double.toString(c));
        operand="";

        temp=text.getText().toString();
        zero=temp;

        temp=temp.length()>1 ? temp.substring(0,temp.length()-2):"";
        zero=zero.length()>1 ? zero.substring(zero.length()-2,zero.length()):"";
        if(zero.equals(".0"))
        {
            text.setText(temp);
            size();
        }

    }

    public void ce(View view)
    {
        text=(TextView)findViewById(R.id.textview1);
        text.setText("");
    }
    public void c(View view)
    {
        text=(TextView)findViewById(R.id.textview1);
        primary_number="";
        text.setText("");
    }
    public void backspace(View view)
    {
        text= findViewById(R.id.textview1);
        temp= text.getText().toString();
        temp=temp.length()>1 ? temp.substring(0, temp.length()-1):"";
        text.setText(temp);
    }
    public void pn(View view)
    {
        text=findViewById(R.id.textview1);
        if(pn==0) {
            text.setText("-" + text.getText());
            pn=1;
            return;
        }else if(pn==1)
        {
            temp=text.getText().toString();
            text.setText(temp.length()>1 ? temp.substring(1,temp.length()):"");
            pn=0;
        }
    }
    public void memory(View view)
    {
        text=(TextView) findViewById(R.id.textview1);
        memory=Double.parseDouble(text.getText().toString());
    }
    public void memory_read(View view)
    {
        text=(TextView) findViewById(R.id.textview1);
        temp=Double.toString(memory);
        temp= temp.length()>1 ? temp.substring(0,temp.length()-2):"";
        text.setText(temp);
    }
    public void m_plus(View view)
    {
        text=(TextView)findViewById(R.id.textview1);
        if(text.getText()!="")
        {
            memory += Double.parseDouble(text.getText().toString());
        }
    }
    public void m_mines(View view)
    {
        text=(TextView)findViewById(R.id.textview1);
        if(text.getText()!="")
        {
            memory -= Double.parseDouble(text.getText().toString());
        }
    }
    public void m_clear(View view)
    {
        memory=0;
    }
    public void tavan(View view)
    {
        double q;
        text=(TextView)findViewById(R.id.textview1);
        if(text.getText()!="")
        {
            q=Double.parseDouble(text.getText().toString());
            q=q*q;
            temp=Double.toString(q);
            temp=temp.length()>1 ? temp.substring(0,temp.length()-2):"";
            text.setText(temp);
            size();
        }
    }
    public void sqr(View view)
    {
        double q;
        text=(TextView)findViewById(R.id.textview1);
        if(text.getText()!="")
        {
            q=Double.parseDouble(text.getText().toString());
            q=Math.sqrt(q);
            temp=Double.toString(q);
            temp=temp.length()>1 ? temp.substring(0,temp.length()-2):"";
            text.setText(temp);
            size();
        }
    }
    public void kasr(View view)
    {
        double q;
        text=(TextView)findViewById(R.id.textview1);
        if(text.getText()!="")
        {
            q=Double.parseDouble(text.getText().toString());
            q=1/q;
            text.setText(Double.toString(q));
        }
    }
    public void size()
    {
        text=(TextView)findViewById(R.id.textview1);
        if(text.length()>=8)
        {
            text.setTextSize(40.0f);
        }
    }



}
