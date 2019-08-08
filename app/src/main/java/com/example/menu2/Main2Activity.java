package com.example.menu2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Button pbutton;
    private TextView tv;
    private TextView tvtotal;
    private TextView info;
    private TextView tvtotalamount;
    private RecyclerView r1;
    private O_Adapter oAdapter;
    public MyAdapter ma;
    MainActivity m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<canteen> orderList = new ArrayList<canteen>();
        orderList = (ArrayList<canteen>) getIntent().getSerializableExtra("BUNDLE");
        final int n = 24;
        int amount = 0;

        pbutton = (Button) findViewById(R.id.button3);
        tv = (TextView) findViewById(R.id.textView2);
        info = (TextView) findViewById(R.id.textView4);
        tvtotal = (TextView) findViewById(R.id.total);
        tvtotalamount = (TextView) findViewById(R.id.totaltextview);
        r1 = (RecyclerView) findViewById(R.id.order_rv);
        r1.setHasFixedSize(true);
        r1.setLayoutManager( new LinearLayoutManager(this));
        oAdapter = new O_Adapter(Main2Activity.this, orderList);
        r1.setAdapter(oAdapter);


        for(int i = 0; i<=n; i++){
            amount = amount + (Integer.parseInt(orderList.get(i).getPrice())*Integer.parseInt(orderList.get(i).getQuantity()));
        }

        tvtotalamount.setText(String.valueOf(amount));

        final ArrayList<canteen> finalOrderList = orderList;
        final int finalAmount = amount;
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsNumber = String.format("smsto: 9987117186;9322896284;8655664156;9699112242");
                String message = "order is placed";
                for (int j = 0; j<=n; j++) {
                    if (Integer.parseInt(finalOrderList.get(j).getQuantity()) != 0) {
                        message = message + "\n" + finalOrderList.get(j).getItems() + " " + finalOrderList.get(j).getQuantity();
                    }
                }
                message = message + "\n" + "TOTAL AMOUNT : " + String.valueOf(finalAmount);
                Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse(smsNumber));
                sms.putExtra("sms_body", message);
                startActivity(sms);
            }
        });

    }
}
