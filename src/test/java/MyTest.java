import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sming.commons.utils.StringUtil;

/**
 * @作者: 时明明
 * @日期: 2019年8月12日
 * @时间: 上午8:51:21
 */
public class MyTest {
	@Test
	public void isNumberTest() {
//		(1)	测试工具包中isNumber()，该方法是判断参数是否为数字，如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法。（4分）
		StringUtil.isNumber("33222");
		assertTrue(StringUtil.isNumber("33222"));
		assertFalse(StringUtil.isNumber("33222p"));

	}
//		(2)	测试工具包中hasText()，该方法是过滤String参数空格后判断是否有值，如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法。（4分）
	@Test
	public void hasLength() {
		assertTrue(StringUtil.hasLength("fdsa"));
		assertFalse(StringUtil.hasLength("    "));
		assertTrue(StringUtil.hasLength(" 009   "));
	}
//		(3)	测试工具包中刚编写的getPlaceholderValue()方法，返回正确的提取值。（4分）
	@Test
	public void getPlaceholderValueTest() {
		String src ="http://news.cnstock.com/news,yw-201908-4413224.htm";
		String reg_src="\\d{7}";
		String placeholderValue = StringUtil.getPlaceholderValue(src, reg_src);
		System.out.println(placeholderValue);
	}
}
