import java.io.File;
import java.nio.file.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class App {
    public static void main(String[] args) throws Exception {
        ConverterFacade easyConverter = new ConverterFacade();
        easyConverter.getFilesAndConvert();
        
    }
}

class ConverterFacade{
    public void getFilesAndConvert(){
        /* piece of code that gets file from window, not important to the task */
        String pathStr, pathStrWrite, formatIn, formatOut;
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            pathStr = chooser.getSelectedFile().getAbsolutePath();
            File in = new File(pathStr);
            String[] splitArr =  pathStr.split("\\.");
            if ( splitArr.length > 1){
            formatIn = splitArr[1];
            returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                pathStrWrite = chooser.getSelectedFile().getAbsolutePath();
                splitArr = pathStrWrite.split("\\.");
                if ( splitArr.length > 1){
                    /* !!!!!!!!!!!!!!!!! actual call to facade !!!!!!!!!!!!!!!!! */
                    formatOut = splitArr[1];
                    convert(in, formatOut, pathStrWrite.substring(0, pathStrWrite.lastIndexOf("\\")));
                }
                else{
                    System.out.println("error");
                    return;
                }
            }
        }
        else{
            System.out.println("error");
            return;
        }
        }
    }
    public void convert(File in, String formatOut, String outPath){
        switch ( in.getName().split("\\.")[1]){
            case "txt":
                switch ( formatOut ){
                    case "txt":
                        new txtTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new txtTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
            case "docx":
                switch ( formatOut ){
                    case "txt":
                        new txtTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new txtTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new txtImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
            case "png":
                switch ( formatOut ){
                    case "txt":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
                case "bmp":
                switch ( formatOut ){
                    case "txt":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
                case "jpg":
                switch ( formatOut ){
                    case "txt":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
                case "jpeg":
                switch ( formatOut ){
                    case "txt":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "docx":
                        new imgTxt().convert(in, formatOut, outPath);
                        break;
                    case "png":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "jpeg":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    case "bmp":
                        new imgImg().convert(in, formatOut, outPath);
                        break;
                    default: break;
                }
                break;
        }
    }
}

abstract class Converter {
    abstract void convert(File in, String formatOut, String outPath);
}

class txtImg extends Converter{
    @Override
    void convert(File in, String formatOut, String outPath) {
        String fileName = in.getName().substring(0, in.getName().lastIndexOf("\\."));
        // some serious conersions happen here, which makes this method and class unique and extend-worthy
        System.out.println("txt to img converted");
    }
}

class imgTxt extends Converter{
    @Override
    void convert(File in, String formatOut, String outPath) {
        String fileName = in.getName().substring(0, in.getName().lastIndexOf("\\."));
        // some serious conersions happen here, which makes this method and class unique and extend-worthy
        System.out.println("img to txt converted");
        
    }
}

class imgImg extends Converter{
   @Override
   void convert(File in, String formatOut, String outPath) {
       String fileName = in.getName().substring(0, in.getName().lastIndexOf("\\."));
       // some serious conersions happen here, which makes this method and class unique and extend-worthy
       System.out.println("img to img converted");
       
       
   }
}

class txtTxt extends Converter{
    @Override
    void convert(File in, String formatOut, String outPath) {
        String fileName = in.getName().substring(0, in.getName().lastIndexOf("."));
        // some serious conersions happen here, which makes this method and class unique and extend-worthy
        System.out.println("txt to txt converted");        
    }
}