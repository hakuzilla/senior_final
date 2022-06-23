package com.example.seniorfinal;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends ArrayAdapter<ResultTable> {

    private List<ResultTable> objects;
    private Context context;

    public ResultAdapter(@NonNull Context context, @NonNull List<ResultTable> objects) {
        super(context, R.layout.adapter_view_layout, objects);
        //function to bind data
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        try {
            context = parent.getContext();

            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = loadView(v, vi, position);

        } catch (Exception e) {
            int h = 0;
        }

        return v;
    }


    private View loadView(View view, LayoutInflater layoutInflater, int position){
        view = layoutInflater.inflate(R.layout.adapter_view_layout, null);

        TextView cardid = view.findViewById(R.id.rCardID);
        TextView cardjp = view.findViewById(R.id.rCardJP);
        ResultTable object = objects.get(position);
        cardid.setText(object.getID());


        TextView cardName = view.findViewById(R.id.rCardENG);
        cardName.setText(object.getName());
        cardjp.setText(object.getJpName());

        //serialize the data
        //Intent mIntent = new Intent(context, DataActivity.class);

       //new activity
       view.setOnClickListener(v -> {
           Intent intent = new Intent(context, DataActivity.class);
           //todo new stuff
           intent.putExtra("ResultKey", object);
           //end new stuff
           context.startActivity(intent);
       });
        return view;

    }
}
