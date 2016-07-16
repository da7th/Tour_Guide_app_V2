package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by da7th on 7/13/2016.
 */
public class MainSitesFragment extends Fragment {

    public MainSitesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_card_list, container, false);

        final ArrayList<TourCard> tourCards = new ArrayList<TourCard>();
        tourCards.add(new TourCard("Amman Citadel", "http://culture.gov.jo/new/%D8%A7%D9%84%D9%85%D8%AA%D8%A7%D8%AD%D9%81/6952-%D9%85%D8%AA%D8%AD%D9%81-%D8%A7%D9%84%D8%A2%D8%AB%D8%A7%D8%B1-%D8%A7%D9%84%D8%A3%D8%B1%D8%AF%D9%86%D9%8A", R.drawable.amman_citadel));
        tourCards.add(new TourCard("King Abdullah I Mosque", "https://www.google.jo/url?sa=t&rct=j&q=&esrc=s&source=web&cd=19&cad=rja&uact=8&ved=0ahUKEwjOpqq2p_jNAhVNnRQKHZACDjMQmhMIqAEwEg&url=http%3A%2F%2Fen.wikipedia.org%2Fwiki%2FKing_Abdullah_I_Mosque&usg=AFQjCNHJNuXRfcsM9aNbmRzmPBCYcptMuw&sig2=dmCc6QFjgcxoA0MIMyoabg&bvm=bv.127178174,d.d2s", R.drawable.king_abdullah_i_mosque));
        tourCards.add(new TourCard("Roman Theatre", "https://en.wikipedia.org/wiki/Roman_theater_(Amman)", R.drawable.roman_theatre));
        tourCards.add(new TourCard("Royal Automobile Museum", "http://www.royalautomuseum.jo/", R.drawable.royal_automobile_museum));
        tourCards.add(new TourCard("Jordan Archaeological Museum", "http://culture.gov.jo/new/%D8%A7%D9%84%D9%85%D8%AA%D8%A7%D8%AD%D9%81/6952-%D9%85%D8%AA%D8%AD%D9%81-%D8%A7%D9%84%D8%A2%D8%AB%D8%A7%D8%B1-%D8%A7%D9%84%D8%A3%D8%B1%D8%AF%D9%86%D9%8A", R.drawable.jordan_archaeological_museum));
        tourCards.add(new TourCard("Mango House", "https://en.wikipedia.org/wiki/Mango_House", R.drawable.mango_house));


        TourCardAdapter tourCardAdapter = new TourCardAdapter(getActivity(), tourCards, R.color.colorPrimary);

        ListView cardListView = (ListView) rootView.findViewById(R.id.TourCardList);


        cardListView.setAdapter(tourCardAdapter);

        cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourCard tourCard = tourCards.get(position);

                //here goes the intent for a browser
                String url = tourCard.getCardInfoLink();

                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
