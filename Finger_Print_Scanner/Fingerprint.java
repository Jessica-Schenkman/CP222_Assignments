import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Fingerprint{

  BufferedImage original_image;
  BufferedImage marked_image;

  int image_width = 0;
  int image_height = 0;
  int rgb_value = 0;
  boolean is_black = false;
  int black_count = 0;

  public void findFeatures(){

         try{
             BufferedImage original_image = ImageIO.read(new File("fingerprint2.png"));
              image_width = original_image.getWidth();
              image_height = original_image.getHeight();

              BufferedImage marked_image = new BufferedImage(original_image.getWidth(), original_image.getHeight(), BufferedImage.TYPE_INT_RGB);

              for(int i = 0; i < image_height; i++){

                  for(int j = 0; j < image_width; j++){
                      rgb_value = original_image.getRGB(j, i);
                    if(original_image.getRGB(j, i) != -1){
                      blackCount(original_image, j, i);

                      if(black_count == 1){
                          marked_image.setRGB(j, i, 0xff0000);
                      }

                      else{
                        marked_image.setRGB(j, i, rgb_value);
                      }
                  }
                  else{
                    marked_image.setRGB(j, i, rgb_value);
                  }

                }
              }
              ImageIO.write(marked_image, "png", new File("marked_features.png"));

          }

          catch(IOException e){
              System.out.println("Error" + e);
          }
      }

    public int blackCount(BufferedImage original_image, int j, int i){

          black_count = 0;
            //System.out.println(original_image.getRGB(j, i));
        if(j - 1 >= 0 && i - 1 >= 0 && j+1 <= 127 && i+1 <= 181){

         if(original_image.getRGB(j-1, i-1) != -1){
            black_count++;
            }
          if(original_image.getRGB(j-1, i) != -1){
              black_count++;
           }
          if(original_image.getRGB(j-1, i+1) != -1){
              black_count++;
            }


        if(original_image.getRGB(j, i-1) != -1){
           black_count++;
           }

            if(original_image.getRGB(j, i+1) != -1){
            black_count++;
          }


          if(original_image.getRGB(j+1, i-1) != -1){
            black_count++;
            }
          if(original_image.getRGB(j+1, i) != -1){
           black_count++;
            }
          if(original_image.getRGB(j+1, i+1) != -1){
            black_count++;
            }

        }

          return black_count;
        }

    public static void main(String[] args) {

        Fingerprint scan_fingerprint = new Fingerprint();
        scan_fingerprint.findFeatures();

    }
}
