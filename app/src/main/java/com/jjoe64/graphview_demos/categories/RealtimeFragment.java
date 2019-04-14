package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.AddSeriesAtRuntime;
import com.jjoe64.graphview_demos.examples.BaseExample;
import com.jjoe64.graphview_demos.examples.FixedFrame;
import com.jjoe64.graphview_demos.examples.RealtimeScrolling;

/**
 * Created by jonas on 07.09.16.
 */
public class RealtimeFragment extends ItemDetailFragment {
    private BaseExample RealtimeScrolling1;
    private BaseExample RealtimeScrolling2;
    private BaseExample RealtimeScrolling3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RealtimeScrolling1 = new RealtimeScrolling(1);
        RealtimeScrolling2 = new RealtimeScrolling(2);
        RealtimeScrolling2 = new RealtimeScrolling(3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.realtime_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        RealtimeScrolling1.initGraph(graph);
        rootView.findViewById(R.id.cardScrolling).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.REALTIME_SCROLLING);
            }
        });

        /*graph = (GraphView) rootView.findViewById(R.id.graph2);
        RealtimeScrolling2.initGraph(graph);
        rootView.findViewById(R.id.cardScrolling).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgFullscreen2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgSource2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.REALTIME_SCROLLING);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph3);
        RealtimeScrolling3.initGraph(graph);
        rootView.findViewById(R.id.cardScrolling).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgFullscreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgSource3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.REALTIME_SCROLLING);
            }
        });



*/
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        RealtimeScrolling1.onResume();
        RealtimeScrolling2.onResume();
        RealtimeScrolling3.onResume();

    }

    @Override
    public void onPause() {
        RealtimeScrolling1.onPause();
        RealtimeScrolling2.onPause();
        RealtimeScrolling3.onPause();
        super.onPause();
    }
}
