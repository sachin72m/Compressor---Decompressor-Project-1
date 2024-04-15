package Compressor_Decompressor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


public class Decompressor { 
    public static void method(File file) throws IOException { // Method to decompress a GZIP file
        
        String fileDirectory = file.getParent();  // Get the parent directory of the input file

        FileInputStream fis = new FileInputStream(file); // Initialize FileInputStream to read the input GZIP file

        GZIPInputStream gzip = new GZIPInputStream(fis); // Initialize GZIPInputStream to decompress the input stream

        FileOutputStream fos = new FileOutputStream(fileDirectory + "/decompressedFile"); // Initialize FileOutputStream to write the decompressed output to a new file

        byte[] buffer = new byte[1024]; // Initialize a buffer for reading/writing data

        int len;
        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // Close the streams in the reverse order: first GZIPInputStream, then FileOutputStream, and finally FileInputStream
        gzip.close();
        fos.close();
        fis.close();
    }
}
