package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : pimri", "Exp : 5yrs", "Mobile No :9898989898", "600"},
                    {"Doctor Name : prasad pawar", "Hospital Address : nigdi", "Exp : 15yrs", "Mobile No :7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : pune", "Exp : 8yrs", "Mobile No :88989898", "300"},
                    {"Doctor Name : Deepak", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No :989800000", "500"},
                    {"Doctor Name : Ashok panda", "Hospital Address : katraj", "Exp : 7yrs", "Mobile No :7798989898", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam paatil", "Hospital Address : pimri", "Exp : 5yrs", "Mobile No :9898989898", "600"},
                    {"Doctor Name : Swati pawar", "Hospital Address : nigdi", "Exp : 15yrs", "Mobile No :7898989898", "900"},
                    {"Doctor Name : Neerala", "Hospital Address : pune", "Exp : 8yrs", "Mobile No :88989898", "300"},
                    {"Doctor Name : Manish", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No :989800000", "500"},
                    {"Doctor Name : Hardik", "Hospital Address : katraj", "Exp : 7yrs", "Mobile No :7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Amal", "Hospital Address : pimri", "Exp : 5yrs", "Mobile No :9898989898", "600"},
                    {"Doctor Name : pawar", "Hospital Address : nigdi", "Exp : 15yrs", "Mobile No :7898989898", "900"},
                    {"Doctor Name : Kale", "Hospital Address : pune", "Exp : 8yrs", "Mobile No :88989898", "300"},
                    {"Doctor Name : Monish,", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No :989800000", "500"},
                    {"Doctor Name : Shrikant", "Hospital Address : katraj", "Exp : 7yrs", "Mobile No :7798989898", "800"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Seema", "Hospital Address : pimri", "Exp : 5yrs", "Mobile No :9898989898", "600"},
                    {"Doctor Name : parab", "Hospital Address : nigdi", "Exp : 15yrs", "Mobile No :7898989898", "900"},
                    {"Doctor Name : Prasad", "Hospital Address : pune", "Exp : 8yrs", "Mobile No :88989898", "300"},
                    {"Doctor Name : Vishal", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No :989800000", "500"},
                    {"Doctor Name : Singh", "Hospital Address : katraj", "Exp : 7yrs", "Mobile No :7798989898", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Boruto", "Hospital Address : pimri", "Exp : 5yrs", "Mobile No :9898989898", "600"},
                    {"Doctor Name : kawaki", "Hospital Address : nigdi", "Exp : 15yrs", "Mobile No :7898989898", "900"},
                    {"Doctor Name : Kane", "Hospital Address : pune", "Exp : 8yrs", "Mobile No :88989898", "300"},
                    {"Doctor Name : Kumar", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No :989800000", "500"},
                    {"Doctor Name : Ankul", "Hospital Address : katraj", "Exp : 7yrs", "Mobile No :7798989898", "800"}
            };
    TextView tv;
    Button btn;

    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Deiticians") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorsDetailsActivity.this, FindDoctorActivity2.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons fees:" + doctor_details[i][4] + "/-");
            list.add(item);


        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorsDetailsActivity.this,BookAppoinmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}