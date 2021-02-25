package com.example.createrapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.createrapp.databinding.ActivityMainBinding;
import com.example.createrapp.databinding.FragmentInicioBinding;
import com.google.firebase.auth.FirebaseAuth;


public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentInicioBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        Glide.with(this).load(auth.getCurrentUser().getPhotoUrl()).circleCrop().into(binding.profilePictureInicio);
        Glide.with(this).load(R.drawable.community_logo_example).circleCrop().into(binding.comunidadPictureInicio);

        navController = Navigation.findNavController(view);

        binding.constraint1Inicio.setOnClickListener(v -> {
            navController.navigate(R.id.action_inicioFragment_to_profileFragment);
        });

        binding.constraint2Inicio.setOnClickListener(v -> {
            navController.navigate(R.id.action_inicioFragment_to_homeFragment);
        });

        binding.constraint3Inicio.setOnClickListener(v -> {
            navController.navigate(R.id.action_inicioFragment_to_actividadFragment);
        });

        binding.constraint4Inicio.setOnClickListener(v -> {
            navController.navigate(R.id.action_inicioFragment_to_comunidadesFragment);
        });

        binding.continuar.setOnClickListener(v -> {
            navController.navigate(R.id.action_inicioFragment_to_homeFragment);
        });


    }
}