package com.sdey.api.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinTool {
	/**
	 * 将汉字转换为全拼
	 * 
	 * @param src
	 * @return String
	 */
	public static String getPinYin(String str) {
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		// 默认小写
		outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 不显示拼音的声调
		outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		// outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

		StringBuilder sb = new StringBuilder();
		try {
			for (char c : str.toCharArray()) {
				// 如果包含有中文标点除号，需要使用正则表达式
				if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
					// if (c > 128) {
					sb.append(PinyinHelper.toHanyuPinyinStringArray(c,
							outputFormat)[0]);
				} else {
					sb.append(Character.toString(c));
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 提取每个汉字的首字母
	 * 
	 * @param str
	 * @return String
	 */
	public static String getPinYinFirstChar(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
			if (pinyinArray != null) {
				sb.append(pinyinArray[0].charAt(0));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}


	/**
	 * 将汉字转 Unicode 码
	 * 
	 * @param cnStr
	 * @return String
	 */
	public static String toUnicode(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			// 将每个字符转换成ASCII码
			sb.append(Integer.toHexString(str.charAt(i) & 0xffff) + "\\u");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "JAVA Chinese characters to Pinyin 俄媒：美国无法说服中国跟随制裁俄罗斯";
		System.out.println(getPinYin(str));
		System.out.println(getPinYinFirstChar(str));
		System.out.println(toUnicode("中JAVA大"));
	}

}
