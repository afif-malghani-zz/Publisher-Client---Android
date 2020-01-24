package com.project.network_proj;

import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class send_data extends AsyncTask< String , Void, Void>{
    Socket s;
    PrintWriter whatever;
    String conn = new String();

//    public void onPreExecute(String everytime, String data_in) {
//        String field1 = everytime;
//        String field2 = data_in;
//    }

    @Override
    public Void doInBackground(String... data) {
        try
        {
            Socket s;
            s = new Socket("192.168.43.3",5500);
            whatever = new PrintWriter(s.getOutputStream());
            whatever.write(data[0]);
            whatever.flush();
//            s.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
