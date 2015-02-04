package com.jimmy.cc;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	getData();
//    	saveData();
    }
    
    private void saveData(){
    	AVObject testObject = new AVObject("TestObject");
    	testObject.put("foo", "bar");
    	testObject.saveInBackground();
    }
    
    private void getData(){
    	AVQuery<AVObject> query = new AVQuery<AVObject>("cloth");
    	query.findInBackground(new FindCallback<AVObject>() {
			
			@Override
			public void done(List<AVObject> arg0, AVException arg1) {
				if(arg0 == null){
					return;
				}
				for(AVObject o : arg0){
					Log.i("kshj", o.toJSONObject().toString());
					AVFile file = o.getAVFile("imageUrl");
					Log.i("kshj", "getData() -> file url : " + file.getUrl());
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
