package com.example.kpn.bundled_notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int flag=1;
    String GROUP_KEY="GROUP";
    String SENDER_1="ABCD";
    String SENDER_2="EFGH";
    String TEXT_1="Fill out this google form if you have any issues regarding mess facilities"+
            "The last date for filling this form is XXXXXXXX";
    String TEXT_2="Football selections for the hostel football team will happen in the ground"
            +"Reporting time is by 4 pm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify1(View view)
    {
        if(flag==1) {
            NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
            style.bigText(TEXT_1)
                    .setSummaryText("ee16b054@smail.iitm.ac.in")
                    .setBigContentTitle(SENDER_1);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true)
                    .setGroup(GROUP_KEY)
                    .setContentTitle(SENDER_1)
                    .setContentText("Regarding mess and hostel facilities")
                    .setStyle(style);

            Intent i = new Intent(this, Activity_B.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(Activity_B.class);
            stackBuilder.addNextIntent(i);
            PendingIntent pi = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pi);

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(1, builder.build());
            flag++;
        }
        else
            summary();

    }

    public void notify_2(View view)
    {
        if(flag==1) {
            NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
            style.bigText(TEXT_2)
                    .setSummaryText("ee16b054@smail.iitm.ac.in")
                    .setBigContentTitle(SENDER_2);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true)
                    .setGroup(GROUP_KEY)
                    .setContentTitle(SENDER_2)
                    .setContentText("Football selections")
                    .setStyle(style);

            Intent i = new Intent(this, Activity_B.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(Activity_B.class);
            stackBuilder.addNextIntent(i);
            PendingIntent pi = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pi);

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(2, builder.build());
            flag++;
        }
        else
            summary();

    }

    private void summary()
    {
        NotificationCompat.InboxStyle style=new android.support.v4.app.NotificationCompat.InboxStyle();
        style.addLine(SENDER_1+" - Regarding mess and hostel facilities");
        style.addLine(SENDER_2+" - Football selections");
        style.setBigContentTitle("New Emails");
        style.setSummaryText("ee16b054@smail.iitm.ac.in");

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("ee16b054@smail.iitm.ac.in")
                .setAutoCancel(true)
                .setContentTitle("New Emails")
                .setStyle(style)
                .setGroup(GROUP_KEY)
                .setGroupSummary(true);

        Intent i = new Intent(this,Activity_B.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Activity_B.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(3,builder.build());




    }
}
