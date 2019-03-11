package alexgochi.ruangguru.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import alexgochi.ruangguru.R;
import alexgochi.ruangguru.SessionHandler;
import alexgochi.ruangguru.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView welcomeText;
    ImageView openAccount;
    Button openCamera;
    private SessionHandler session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final Context context = inflater.getContext();
        session = new SessionHandler(context);
        User user = session.getUserDetails();

        welcomeText = view.findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome "+user.getFullName()+"\n Mau Belajar apa hari ini?");


        openCamera = view.findViewById(R.id.foto);
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Open Camera", Toast.LENGTH_SHORT).show();
            }
        });

        openAccount = view.findViewById(R.id.ruang_baca);
        openAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Open Account Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
