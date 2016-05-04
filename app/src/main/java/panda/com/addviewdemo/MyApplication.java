package panda.com.addviewdemo;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by panda on 2016/5/4:14:32.
 *
 * application
 */
public class MyApplication extends Application {

    public static Socket gSocket;
    @Override
    public void onCreate() {
        super.onCreate();
        if (gSocket == null) {
            try {
                gSocket = IO.socket("");
            } catch (URISyntaxException e) {
                new RuntimeException(e).printStackTrace();
            }
        }
    }
}
