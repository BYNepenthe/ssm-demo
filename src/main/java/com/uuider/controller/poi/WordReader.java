package com.uuider.controller.poi;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 * @author  <a href="mailto:xingsan.zhang@gmail.com">zhangpl</a>
 * @version 2015年7月14日
 */
public class WordReader {
	public static String readDoc(String doc) throws Exception{
		//创建输入流读取Doc文件
		FileInputStream in = new FileInputStream(new File(doc));
		WordExtractor extractor = null;
		String text = null;
		//创建WordExtractor
		extractor = new WordExtractor(in);
		//对Doc文件进行提取
		text = extractor.getText();
		return text;
	}
	
	public static void main(String[] args) {
		try {
			String text = WordReader.readDoc("e:\\testCode\\题库模板.doc");
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
