package com.example.game.View;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class CharacterIcons {
    private ArrayList<Integer> characterIcons = new ArrayList<Integer>();

    CharacterIcons(AppCompatActivity activity){
        populateCharacterIcons(activity);
    }

    private void populateCharacterIcons(AppCompatActivity activity) {
        ArrayList<String> iconNames = new ArrayList<String>(Arrays.asList("@drawable/person","@drawable/boy1","@drawable/girl1",
                "@drawable/boy2", "@drawable/girl2", "@drawable/boy3", "@drawable/girl3",
                "@drawable/pikachu", "@drawable/cactus", "@drawable/androidstudio", "@drawable/piggy"
        ));

        for (String iconName: iconNames){
            characterIcons.add(activity.getResources().getIdentifier(iconName, null,
                    activity.getPackageName()));
        }

    }

    int getIconByIndex(int index){
        return characterIcons.get(index);
    }

    int getNumberOfPics(){
        return characterIcons.size();
    }
}
