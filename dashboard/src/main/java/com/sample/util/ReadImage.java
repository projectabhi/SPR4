package com.sample.util;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        CLibrary.INSTANCE.setlocale(CLibrary.LC_ALL, "C");
        CLibrary.INSTANCE.setlocale(CLibrary.LC_NUMERIC, "C");
        CLibrary.INSTANCE.setlocale(CLibrary.LC_CTYPE, "C");

        //assertEquals(defaultLocale, Locale.getDefault());
		
		Tesseract tesseract=new Tesseract();
		tesseract.setDatapath("/home/borokali/software/tesseract_ocr/tessdata_best");
		try {
			String text = tesseract.doOCR(new File("/home/borokali/Downloads/Admission Form.pdf"));
			System.out.println(text);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
