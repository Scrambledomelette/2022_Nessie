package frc.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Pneumatics {
     public static Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
     public static void compress() {
         compressor.enableDigital();
     }
     public static void compressDisable() {
         compressor.enableDigital();
     }
    
     public boolean enabled() {
         return true;
     }
}
