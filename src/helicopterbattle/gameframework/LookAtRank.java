package helicopterbattle.gameframework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LookAtRank extends JFrame {
	
   BufferedReader br = null;
   InputStreamReader isr = null;

   FileInputStream fis = null;

   File file = new File("out.txt");

   String temp = "";
   String content = "";

   JButton b1 = new JButton("end");
   
   JTextArea l1 = new JTextArea();

   public LookAtRank() {

      Container c = getContentPane();
      // c.setBackground(Color.WHITE);

      c.add(b1, BorderLayout.SOUTH);
      c.add(l1, BorderLayout.CENTER);

      try {

         // ������ �о�鿩 File Input ��Ʈ�� ��ü ����
         fis = new FileInputStream(file);

         // File Input ��Ʈ�� ��ü�� �̿��� Input ��Ʈ�� ��ü�� �����ϴµ� ���ڵ��� UTF-8�� ����
         isr = new InputStreamReader(fis, "euc-kr");

         // Input ��Ʈ�� ��ü�� �̿��Ͽ� ���۸� ����
         br = new BufferedReader(isr);

         // ���۸� �������� �о�鿩 ���� ����
         while ((temp = br.readLine()) != null) {
            content += temp + "\n";
         }

      } catch (FileNotFoundException e) {
         e.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();

      } finally {

         try {
            fis.close();
         } catch (IOException e) {
            e.printStackTrace();
         }

         try {
            isr.close();
         } catch (IOException e) {
            e.printStackTrace();
         }

         try {
            br.close();
         } catch (IOException e) {
            e.printStackTrace();
         }

      }

      l1.setText(content);
      l1.setFocusable(false);
      b1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
         }
      });

      setSize(500, 500);
      setVisible(true);
      setLocationRelativeTo(null);
      setResizable(false);

   }

}