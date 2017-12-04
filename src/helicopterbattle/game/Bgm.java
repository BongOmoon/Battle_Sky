package helicopterbattle.game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Bgm extends Thread {
   private Player player;
   private boolean isloop;
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;

   public Bgm(String name, boolean isloop){
    try{
     this.isloop = isloop;
     file = new File(Bgm.class.getResource("/helicopterbattle/resources/musics/"+name).toURI());
           fis = new FileInputStream(file);
     bis = new BufferedInputStream(fis);
     player = new Player(bis);
    
    
    }catch (Exception e){
       System.out.println(e.getMessage());
    }
}
public int getTime(){
   if (player==null)
      return 0;
   return player.getPosition();
}
public void close(){
   isloop = false;
   player.close();
   this.interrupt();
}
@Override
public  void run(){
   try{ 
      do{
         player.play();
         fis = new FileInputStream(file);
           bis = new BufferedInputStream(fis);
           player = new Player(bis);

      }while(isloop);
      
   }catch(Exception e){
      System.out.println(e.getMessage());
   }
}

}

