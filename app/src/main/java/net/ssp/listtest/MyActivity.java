package net.ssp.listtest;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MyActivity extends Activity {

    ListView lvDetail;
    Context context = MyActivity.this;
    ArrayList<DataList> myList = new ArrayList<DataList>();

    String[] title = new String[] {
            "Title 1", "Title 2", "Title 3", "Dr.Haitham salim ",
            "Title 5", "Title 6", "Title 7", "Title 8"
    };
    String[] StuffName  = new String[] {
            "Desc 1", "Desc 2", "Desc 3", "Dr.Haitham salim",
            "Desc 5", "Desc 6", "Desc 7", "Desc 8"
    };
    int[]    img   = new int[]          {
            R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
    };

    int[]    StuffId   = new int[]          {
            11228, 87363, 827253, 172552,
            176252, 82863, 82736, 1111
    };

    String[] StuffStatus  = new String[] {
            "I am free", "Away", "Busy", "I will come back after 20m",
            " I have a meeting", "lunch break", "Holyday", "i have a lucture"
    };

    boolean[] Stuffconnection  = new boolean[] {
           true, false, true, true,
            false, false, false, false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        lvDetail = (ListView) findViewById(R.id.listView);
        // insert data into the list before setting the adapter
        // otherwise it will generate NullPointerException  - Obviously
        getDataInList();
        lvDetail.setAdapter(new MyBaseAdapter(context, myList));
      lvDetail.setClickable(true);
       lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                String id;
                id= myList.get(i).toString();

                Toast.makeText(MyActivity.this, "Stuff Id is: "+id, Toast.LENGTH_LONG).show();
            }
        });
    }



    private void getDataInList() {
        for(int i=0;i<8;i++) {
            // Create a new object for each list item
            DataList ld = new DataList();

            ld.setStuffId(StuffId[i]);
            ld.setStuffName(StuffName[i]);
            ld.setTitle(title[i]);
            ld.setImgResId(img[i]);
            ld.setStuffStatus(StuffStatus[i]);
            ld.setConnection(Stuffconnection[i]);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }

}
