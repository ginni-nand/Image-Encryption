package imageop;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class imageopration {
	public static void operate(int key)
	{
	JFileChooser fc=new JFileChooser();
	fc.showOpenDialog(null);
	File file=fc.getSelectedFile();
	try{
		FileInputStream fis=new FileInputStream(file);
		byte []data=new byte[fis.available()];
		fis.read(data);
		int i=0;
		
		for(byte b:data)
		{
			System.out.println(b);
			data[i]=(byte)(b^key);
			i++;
		}
		FileOutputStream fos=new FileOutputStream(file);
		fos.write(data);
		fos.close();
		fis.close();
		JOptionPane.showMessageDialog(null, "Done");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setTitle("Image Operation");
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//creating button
		Font font=new Font("Roboto",Font.BOLD,25);
		JButton b=new JButton();
		b.setText("Open Image");
		b.setFont(font);
		
		//creating text feild
		JTextField t=new JTextField(10);
		t.setFont(font);
		b.addActionListener(e->{
			System.out.println("button clicked");
			String text=t.getText();
			int temp=Integer.parseInt(text);
			operate(temp);
		});
		f.setLayout(new FlowLayout());
		f.add(b);
		f.add(t);
		f.setVisible(true);
		

	}

	

}

