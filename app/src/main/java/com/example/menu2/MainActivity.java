package com.example.menu2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.Spanned;
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

        can = new canteen(1,"samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "10","0", R.drawable.samosa);
        menuList.add(can);
        can = new canteen(2,"Samosa Pav", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas wrapped in soft breadstuff", "12","0", R.drawable.samosapav);
        menuList.add(can);
        can = new canteen(3,"Vada Pav", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas wrapped in soft breadstuff", "12","0", R.drawable.vadapav);
        menuList.add(can);
        can = new canteen(4,"Poha", "you know what", "18","0", R.drawable.poha);
        menuList.add(can);
        can = new canteen(5,"Sada Uttappa", "uttappa", "21","0", R.drawable.sadauttappa);
        menuList.add(can);
        can = new canteen(6,"Onion Uttappa", "uttappa flavoured with onions", "26","0",R.drawable.onion);
        menuList.add(can);
        can = new canteen(7,"Tomato Uttappa", "uttappa flavoured with tomato", "27","0",R.drawable.tomatouttappa);
        menuList.add(can);
        can = new canteen(8,"Sada Dosa", "dish made from rice served with authentic sides and dips", "21","0",R.drawable.sada);
        menuList.add(can);
        can = new canteen(9,"Masala Dosa", "dish made from rice with fillings served with authentic sides and dips", "26","0", R.drawable.masaladosa);
        menuList.add(can);
        can = new canteen(10,"Butter Sada Dosa", "dish made from rice with fillings served with authentic sides and dips", "20","0", R.drawable.buttersada);
        menuList.add(can);
        can = new canteen(11,"Butter Masala Dosa", "dish made from rice with fillings served with authentic sides and dips", "20","0",R.drawable.butter);
        menuList.add(can);
        can = new canteen(12,"Schezwan Sada Dosa", "dish made from rice with fillings served with authentic sides and dips", "20","0", R.drawable.schezwan);
        menuList.add(can);
        can = new canteen(13,"Schezwan Masala Dosa", "dish made from rice with fillings served with authentic sides and dips", "20","0", R.drawable.masala);
        menuList.add(can);
        can = new canteen(14,"Bread Butter", "bread served with butter", "17","0", R.drawable.breadbutter);
        menuList.add(can);
        can = new canteen(15,"Veg Sandwich", "sandwich", "20","0", R.drawable.sw);
        menuList.add(can);
        can = new canteen(16,"Veg Cheese Sandwich", "sandwich with cheese", "38","0", R.drawable.vegsandwich);
        menuList.add(can);
        can = new canteen(17,"Upma", "", "17","0", R.drawable.upma);
        menuList.add(can);
        can = new canteen(18,"Idli Sambar", "Dish made with rice served with dips", "18","0", R.drawable.idli);
        menuList.add(can);
        can = new canteen(19,"Medu Vada", "fried or baked dish served with dips", "20","0", R.drawable.meduwada);
        menuList.add(can);
        can = new canteen(20,"Misal Pav", "missal served with soft breadstuff", "23","0", R.drawable.missalpav);
        menuList.add(can);
        can = new canteen(21,"Ragada Samosa", "fried or baked dish with a savoury filling, such as spiced potatoes, onions, peas", "28","0", R.drawable.ragdasamosa);
        menuList.add(can);
        can = new canteen(22,"Tea", "", "10","0", R.drawable.tea);
        menuList.add(can);
        can = new canteen(23,"Coffee", "", "12","0", R.drawable.coffee);
        menuList.add(can);
        can = new canteen(24,"Chass", "", "15","0", R.drawable.chhass);
        menuList.add(can);
        can = new canteen(25,"Lassi", "", "20","0", R.drawable.lassi);
        menuList.add(can);
    }

    public static class Inputfilter implements InputFilter{
        private int max = 10, min = 0;

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe){}
            return "";
        }
        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }
}
