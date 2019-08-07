package com.example.menu2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MENU_URL = "http://192.168.137.1/menufetch.php";

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private Button order;
    public ArrayList<canteen> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        myAdapter = new MyAdapter(MainActivity.this, menuList);
        recyclerView.setAdapter(myAdapter);
        order = (Button) findViewById(R.id.button_order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("BUNDLE",menuList);
                startActivity(intent);
                Log.d("start","ok");
            }
        });
        loadMenu();

    }

    private void loadMenu(){
        canteen can;

        can = new canteen(1,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(2,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(3,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(4,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(5,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(6,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(7,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(8,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(9,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
        can = new canteen(10,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "20","0");
        menuList.add(can);
    }
}
