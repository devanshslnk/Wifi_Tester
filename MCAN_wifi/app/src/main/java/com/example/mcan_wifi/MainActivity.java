package com.example.mcan_wifi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;
import android.content.Context;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public void getInfo(View view){
        TextView wifi_info=(TextView)findViewById(R.id.wifi_info);
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        int numberOfLevels = 5;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
        String name=wifiInfo.getSSID();
        String ipAddress= Formatter.formatIpAddress(wifiInfo.getIpAddress());

        int linkSpeed=wifiInfo.getLinkSpeed();
        int frequency=wifiInfo.getFrequency();

        System.out.println(name+":"+level);
        wifi_info.setText(Integer.toString(level));
        String display="Name:"+name+"\n"+"Strength:"+level+"\n"+"IP address:"+ipAddress+"\n"+"Link speed:"+linkSpeed+"Mbps\n"+"frequency:"+frequency+"MHz";
        System.out.print(display);
        wifi_info.setText(display);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
