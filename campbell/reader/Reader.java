package org.campbell.reader;

import javafx.scene.control.Label;
import java.util.ArrayList;

import org.campbell.connect.Connect;

public class Reader {
    public Reader() {}

    public void getBook(String... args) {

        ArrayList<String> params = new ArrayList<>();

        for(String arg : args) {
            params.add(arg);
        }


    }
}
