package io.tutorial.turntotech.infoOrganizerSample;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static io.tutorial.turntotech.infoOrganizerSample.DAO.getCompanyNo;

public class ProductFragment extends Fragment {

    private RecyclerView product_recycler_view;
    private ProductFragment.VerticalProductAdapter recyclerProductAdapter;
    ImageButton addButton;
    ImageButton backButton;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main2, container, false);

        product_recycler_view= (RecyclerView) view.findViewById(R.id.vertical_recycler_view);

        // Get the Company to display correct Products
        int companyNo = getCompanyNo();



        recyclerProductAdapter = new VerticalProductAdapter(DAO.getcompanyList().get(companyNo).products);


        LinearLayoutManager layoutmanager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        product_recycler_view.setLayoutManager(layoutmanager);


        product_recycler_view.setAdapter(recyclerProductAdapter);
        product_recycler_view.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), product_recycler_view ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getContext(), DAO.getcompanyList().get(getCompanyNo()).products.get(position).product_name, Toast.LENGTH_SHORT).show();


                        DAO.setProductNo(position);

                        // Go to Child not Found Screen
                        Fragment webFragment = new Web();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainLayout, webFragment);
                        fragmentTransaction.addToBackStack(null);

                        // Commit the transaction
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));

        // ActionBar SetUp
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.toolbar);
        backButton = (ImageButton)activity.findViewById(R.id.imageButton);
        addButton = (ImageButton)activity.findViewById(R.id.imageButton2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Back",Toast.LENGTH_LONG).show();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Add",Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }

    public class VerticalProductAdapter extends RecyclerView.Adapter<ProductFragment.VerticalProductAdapter.MyViewHolder> {

        private List<Product> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView textProductName;
            public ImageView imView;

            public MyViewHolder(View view) {
                super(view);
                textProductName = (TextView) view.findViewById(R.id.textProductName);
                imView = (ImageView) view.findViewById(R.id.imageView);
            }
        }


        public VerticalProductAdapter(List<Product> verticalList) {
            this.verticalList = verticalList;
        }

        @Override
        public ProductFragment.VerticalProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_product_item, parent, false);

            return new ProductFragment.VerticalProductAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.textProductName.setText(verticalList.get(position).product_name);
            Picasso.with(getContext()).load(verticalList.get(position).logoURL).into(holder.imView);
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }
    }
}