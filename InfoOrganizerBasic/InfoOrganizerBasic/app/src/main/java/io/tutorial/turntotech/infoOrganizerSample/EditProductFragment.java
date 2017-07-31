package io.tutorial.turntotech.infoOrganizerSample;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;


public class EditProductFragment extends Fragment {
    EditText Name, LogoURL, ProductURL;
    Button submitButton;
    ImageButton backButton,addButton;
    CheckBox Edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_edit_product, container, false);
        Name = (EditText)view.findViewById(R.id.ProductName);
        LogoURL = (EditText)view.findViewById(R.id.LogoURL);
        ProductURL = (EditText)view.findViewById(R.id.ProductURL);
        submitButton = (Button)view.findViewById(R.id.button3);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.toolbar);
        backButton = (ImageButton)activity.findViewById(R.id.imageButton);
        addButton = (ImageButton)activity.findViewById(R.id.imageButton2);
        Edit = (CheckBox)activity.findViewById(R.id.Edit);
        Edit.setVisibility(View.INVISIBLE);
        addButton.setVisibility(View.INVISIBLE);

        if(DAO.getEdit()){
            Name.setText(DAO.getcompanyList().get(DAO.getCompanyNo()).products.get(DAO.getProductNo()).product_name);
            LogoURL.setText(DAO.getcompanyList().get(DAO.getCompanyNo()).products.get(DAO.getProductNo()).logoURL);
            ProductURL.setText(DAO.getcompanyList().get(DAO.getCompanyNo()).products.get(DAO.getProductNo()).productURL);
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LogoURL.getText().toString().equals("") && ProductURL.getText().toString().equals("")){
                    DAO.getInstance().AddProduct(Name.getText().toString(), "R.mipmap.ic_launcher", "https://www.google.com");
                }
                else if (LogoURL.getText().toString().equals("")){
                    DAO.getInstance().AddProduct(Name.getText().toString(), "R.mipmap.ic_launcher", ProductURL.getText().toString());
                }
                else if (ProductURL.getText().toString().equals("")){
                    DAO.getInstance().AddProduct(Name.getText().toString(), LogoURL.getText().toString(), "https://www.google.com");
                }
                else {
                    DAO.getInstance().AddProduct(Name.getText().toString(), LogoURL.getText().toString(), ProductURL.getText().toString());
                }
                if(DAO.getEdit()){
                    DAO.getcompanyList().get(DAO.getCompanyNo()).products.remove(DAO.getProductNo());
                }
                Fragment productFragment = new ProductFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainLayout, productFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}

