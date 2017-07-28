package io.tutorial.turntotech.infoOrganizerSample;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class Web extends Fragment{
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_web, container, false);
        webView = (WebView) view.findViewById(R.id.WebView);
        webView.loadUrl(DAO.getcompanyList().get(DAO.getCompanyNo()).products.get(DAO.getProductNo()).productURL);
        return view;
    }
}
