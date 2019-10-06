package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField plain;

    @FXML
    private TextField cipher;

    @FXML
    private TextField key;


    public void decode(ActionEvent actionEvent) {
        plain.setText(decode(cipher.getText(),Integer.parseInt(key.getText())));
        cipher.clear();
        key.clear();
    }

    public void encode(ActionEvent actionEvent) {
        cipher.setText(encode(plain.getText(),Integer.parseInt(key.getText())));
        plain.clear();
        key.clear();
    }


    private static String decode(String enc, int offset) {
        return encode(enc, 26-offset);
    }

    private static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

        //System.out.println( Cipher.encode( str, 12 ));
        //System.out.println( Cipher.decode( Cipher.encode( str, 12), 12 ));

}
