import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class imageEncrpytion {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500, 300);
        f.setTitle("Image Encryption And Decryption");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Font font = new Font("Roberto", Font.BOLD, 19);
        JButton button = new JButton("Open Image");
        button.setFont(font);

        JTextField text = new JTextField(10);
        text.setFont(font);

            JLabel label = new JLabel("Please Enter the Key in the text Field");
            label.setFont(font);
            f.add(label);
            button.addActionListener(e -> {
                try {
//                    System.out.println("Button Clicked");
                    String t = text.getText();
                    JLabel label2 = new JLabel("Key Entered In text Filed is:- " + text.getText());
                    f.add(label2);
                    int key = Integer.parseInt(t);
                    operate(key);
                }catch(Exception ob){
                    System.out.println("Some Error Occurred "+ob.getMessage());
//                    JLabel label1 = new JLabel("Some Error Occurred "+ ob.getMessage())
                }
            });


//        JLabel label = new JLabel("Please Enter the Key in the text Field");

        f.add(button);
        f.add(text);
        JLabel label1 = new JLabel("Please Remember The Key Or Else The Image Can't Be Decrypted");
//        JLabel label2 = new JLabel("Key Entered In text Filed is:- " + text.getText());
        f.add(label1);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }

    public static void operate(int key){
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        File f = file.getSelectedFile();

        try {
            FileInputStream buffer = new FileInputStream(f);
            byte [] image = new byte[buffer.available()];
            buffer.read(image);
            int i = 0;
            for(byte b : image){
//                System.out.println(b);
                image[i] =(byte)(b^key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(f);
            fos.write(image);
            fos.close();
            buffer.close();

            JOptionPane.showMessageDialog(null, "Image Encrypted Successfully");
        }catch ( Exception ob){
            System.out.println("Some Error occurred " + ob.getMessage());
        }
    }
}
