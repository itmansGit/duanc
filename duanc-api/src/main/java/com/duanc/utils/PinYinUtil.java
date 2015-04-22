package com.duanc.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {
	/**
     * 汉字转换位汉语拼音首字母，英文字符不变
     * @param chines  汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
          String pinyinName = "";
           char[] nameChar = chines.toCharArray();
          HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
         defaultFormat.setCaseType(HanyuPinyinCaseType. LOWERCASE);
         defaultFormat.setToneType(HanyuPinyinToneType. WITHOUT_TONE);
           for ( int i = 0; i < nameChar. length; i++) {
                if (nameChar[i] > 128) {
                     try {
                          pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                                    nameChar[i], defaultFormat)[0].charAt(0);
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                          e.printStackTrace();
                    }
               } else {
                    pinyinName += nameChar[i];
               }
          }
           return pinyinName;
    }

    /**
     * 汉字转换位汉语拼音，英文字符不变
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToSpell(String chines) {
          String pinyinName = "";
           char[] nameChar = chines.toCharArray();
          HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
         defaultFormat.setCaseType(HanyuPinyinCaseType. LOWERCASE);
         defaultFormat.setToneType(HanyuPinyinToneType. WITHOUT_TONE);
           for ( int i = 0; i < nameChar. length; i++) {
                if (nameChar[i] > 128) {
                     try {
                          pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                                    nameChar[i], defaultFormat)[0];
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                          e.printStackTrace();
                    }
               } else {
                    pinyinName += nameChar[i];
               }
          }
           return pinyinName;
    }
    
    /**
     *
     * @Title: converterToNameSpell
     * @Description: 中文名转英文名  例如：阿斯顿 --siduna
     * @param chines
     * @return String 
     * @author chao.duan
     * @date 2015年2月26日 上午10:08:50
     */
    public static String converterToNameSpell(String chines){
          String[] strs = chines.split("");
          String lastName = converterToSpell(strs [1]);
          String firstName = "";
           for ( int i = 2; i < strs.length; i++) {
               firstName += converterToSpell(strs [i]);
          }
           return firstName+lastName;
    }
}
