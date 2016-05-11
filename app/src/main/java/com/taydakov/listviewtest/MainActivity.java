package com.taydakov.listviewtest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyObject> myItems = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            MyObject newObj = new MyObject();
            newObj.id = i;
            newObj.title = "Number is " + i;
            newObj.description = "Description of an item #" + i;
            myItems.add(newObj);
        }

        MyAdapter adapter = new MyAdapter(this.getLayoutInflater(), myItems.toArray(new MyObject[0]));
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}

class MyObject {
    public Number id;
    public String title;
    public String description;
}

class MyAdapter extends BaseAdapter {
    MyObject[] items;
    LayoutInflater inflater;

    public MyAdapter(LayoutInflater inflater, MyObject[] items) {
        this.items = items;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        TextView itemText = (TextView) itemView.findViewById(R.id.list_item_text);
        itemText.setText(items[position].title);
        TextView descText = (TextView) itemView.findViewById(R.id.list_item_description);
        descText.setText(items[position].description);
        return itemView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }
}