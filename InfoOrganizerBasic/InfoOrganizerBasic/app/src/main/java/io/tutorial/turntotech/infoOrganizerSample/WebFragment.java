package io.tutorial.turntotech.infoOrganizerSample;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageButton;


public class WebFragment extends Fragment{
    WebView webView;
    ImageButton addButton;
    ImageButton backButton;
    CheckBox Edit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_web, container, false);
        webView = (WebView) view.findViewById(R.id.WebView);
        webView.loadUrl(DAO.getcompanyList().get(DAO.getCompanyNo()).products.get(DAO.getProductNo()).productURL);


        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.toolbar);
        backButton = (ImageButton)activity.findViewById(R.id.imageButton);
        addButton = (ImageButton)activity.findViewById(R.id.imageButton2);
        Edit = (CheckBox)activity.findViewById(R.id.Edit);
        Edit.setVisibility(View.INVISIBLE);
        addButton.setVisibility(View.INVISIBLE);

        return view;

    }
}
