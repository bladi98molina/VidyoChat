package com.example.vidyochat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;

public class MainActivity extends AppCompatActivity implements Connector.IConnect{

    private Connector vc;
    private FrameLayout videoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();
        videoFrame=(FrameLayout)findViewById(R.id.videoFrame);
    }

    public void Start(View v){
        vc=new Connector(videoFrame,Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default,16,"","",0);
    }

    public void Conect(View v){
        String token="cHJvdmlzaW9uAHVzZXIxQDM3OWU5Ni52aWR5by5pbwA2Mzc4MTU3NTcxNAAAYzUxMjZjZjExYTQzZTYzOWU0OTM2NDlmZmU5NzRhYzBjODNkNGI2NDQ3N2UyM2U0YjQyNzU1NTU1MjdjYTQwYzcyZWNhZjdhM2U1YzNlM2RlNzAwYjYyNzZjMDg0ZmQx";
        vc.connect("prod.vidyo.io",token,"DemoUser","DemoRoom",this);
    }
    public void Disconect(View v){
        vc.disconnect();
    }

    public void onSuccess() {

    }

    public void onFailure(Connector.ConnectorFailReason connectorFailReason) {

    }

    public void onDisconnected(Connector.ConnectorDisconnectReason connectorDisconnectReason) {

    }
}