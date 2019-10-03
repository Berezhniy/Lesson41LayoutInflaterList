package ru.startandroid.lesson41layoutinflaterlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //массивы с данными
    String[] name = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь" };
    String[] position = { "Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник" };
    int salary[] = { 13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000 };
    //создаём переменную цвет
    int[] colors = new int[2];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //добавляем возможные цвета для переменной
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");
        //находим linLayout по id
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        //добавляем в неё Inflater
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++) {
            Log.d("myLogs", "i = " + i);
            //создаём view елемент item из activity_item
            View item = ltInflater.inflate(R.layout.activity_item, linLayout, false);
            //находим view по id
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            //добавляем в неё данные из массива имён
            tvName.setText(name[i]);
            //находим view по id
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            //добавляем в неё данные из массива должностей
            tvPosition.setText("Должность: " + position[i]);
            //находим view по id
            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            //добавляем в неё данные из массива оклада
            tvSalary.setText("Оклад: " + String.valueOf(salary[i]));
            //присваиваем ширину по паренту
            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            //поочередно накладываем на фон view каждый из ветов
            item.setBackgroundColor(colors[i % 2]);
            //добавляем данные из item в linLayout
            linLayout.addView(item);
        }
    }
}