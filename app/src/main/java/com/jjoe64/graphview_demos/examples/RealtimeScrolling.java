package com.jjoe64.graphview_demos.examples;

import android.os.Handler;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class RealtimeScrolling extends BaseExample {
    private final Handler mHandler = new Handler();
    private Runnable mTimer;
    public double graphLastXValue = 5d;
    private LineGraphSeries<DataPoint> mSeries;
    public int type = 1;

    public RealtimeScrolling(){}
    public RealtimeScrolling(int t){
        type = t;
    }

    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);

        graph.getGridLabelRenderer().setLabelVerticalWidth(100);

        // first mSeries is a line
        mSeries = new LineGraphSeries<>();
        mSeries.setDrawDataPoints(true);
        mSeries.setDrawBackground(true);
        graph.addSeries(mSeries);
    }

    public void onResume() {
        mTimer = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                double y;
                switch (type){
                    case 1:
                        y = 0.05 * graphLastXValue;
                        break;
                    case 2:
                        y = -0.05 * graphLastXValue;
                        break;
                    case 3:
                        y = 2;
                        break;
                    default:
                        y = 0;
                        break;
                }
                mSeries.appendData(new DataPoint(graphLastXValue, y), true, 22);
                mHandler.postDelayed(this, 500);
            }
        };
        mHandler.postDelayed(mTimer, 500);
    }

    public void onPause() {
        mHandler.removeCallbacks(mTimer);
    }

    double mLastRandom = 2;
    Random mRand = new Random();
    private double getRandom() {
        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
    }
}
