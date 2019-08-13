import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.shimingming.exercise.domain.NewsLink;
import com.sming.commons.utils.StringUtil;

/**
 * @作者: 时明明
 * @日期: 2019年8月12日
 * @时间: 上午9:07:28
 */
public class ImportData {
	static String news[] = {
			"外汇局：美国认定中国“汇率操纵”根本站不住脚|http://news.cnstock.com/news,yw-201908-4413224.htm|8|2019-08-08 07:37:32",
			"二线城市房贷利率接连上调 房贷利率区间波动或成常态|http://news.cnstock.com/news,yw-201908-4413229.htm|5| ",
			"资产负债管理顶层设计亮相 引导险企向高质量发展转型|http://news.cnstock.com/news,yw-201908-4413222.htm||2019-08-08 07:36:50",
			"泰康在线获泰康集团增资20亿元|http://news.cnstock.com/news,jg-201908-4413369.htm|7|2019-08-08 09:25:53",
			"人民银行：中国7月外汇储备为3.1037万亿美元|http://news.cnstock.com/news,bwkx-201908-4412982.htm|10|2019-08-07 16:43:13",
			"百度战略投资有赞 布局电商小程序|http://news.cnstock.com/news,bwkx-201908-4413414.htm||2019-08-08 10:57:59",
			"MSCI：8只个股将被新增入MSCI中国指数|http://news.cnstock.com/news,bwkx-201908-4413216.htm|9|2019-08-08 07:28:58",
			"全球三大指数巨头进入“中国时间”|http://stock.cnstock.com/stock/smk_gszbs/201908/4413244.htm|10|2019-08-08 07:47:08",
			"8月8日沪深两市最新交易提示|http://news.cnstock.com/news,bwkx-201908-4413227.htm||2019-08-08 07:39:05",
			"华为发布面向2025十大趋势|http://news.cnstock.com/news,bwkx-201908-4413402.htm|8|2019-08-06 10:19:49",
			"网易第二季度净收入188亿元 创新业务毛利率转正|http://news.cnstock.com/news,bwkx-201908-4413415.htm||2019-08-08 10:58:39",
			"中欧班列（郑州）开通俄罗斯新线路|http://news.cnstock.com/news,bwkx-201908-4413425.htm|7|2019-08-08 11:15:24",
			"我国股权投资市场规模突破10万亿元|http://news.cnstock.com/news,yw-201908-4412690.htm|9|2019-08-07 07:59:11",
			"临港新片区聚焦高端制造 A股公司提前布局|http://news.cnstock.com/news,yw-201908-4412640.htm|2|2019-08-07 07:42:29",
			"中国人民银行关于美国财政部将中国列为“汇率操纵国”的声明|http://news.cnstock.com/news,yw-201908-4412630.htm|10| "

	};

	public static List<NewsLink> getList() {
		List<NewsLink> list = new ArrayList<NewsLink>();
		NewsLink nl = null;
		for (int i = 0; i < news.length; i++) {
			String[] split = news[i].split("\\|");
			nl = new NewsLink();

			for (int j = 0; j < split.length; j++) {
				if (StringUtil.hasLength(split[j])) {
					String reg_id = "\\d{7}";
					String placeholderValue = StringUtil.getPlaceholderValue(split[1], reg_id);
					if (StringUtil.isNumber(placeholderValue)) {
						nl.setId(Integer.valueOf(placeholderValue));
					}
					nl.setTitle(split[0]);

					nl.setUrl(split[1]);

					if (StringUtil.hasLength(split[2])) {

						nl.setScore(Integer.valueOf(split[2]));
					} else {
						nl.setScore(Integer.valueOf(0));
					}
					if (StringUtil.hasLength(split[3])) {
						nl.setCreated(split[3]);
					} else {
						Date d = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String format = sdf.format(d);
						nl.setCreated(format);
					}
				}
			}
			list.add(nl);
		}
		return list;
	}

	public static void main(String[] args) {
		List<NewsLink> list = getList();
		list.forEach(s -> System.out.println(s));
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javamaven?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
		String username = "root";
		String password = "sming";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			for (NewsLink n : list) {

				PreparedStatement ps = conn
						.prepareStatement("insert into t_news_link (id,title,score,url,created) values (?,?,?,?,?)");
				ps.setInt(1, n.getId());
				ps.setString(2, n.getTitle());
				ps.setInt(3, n.getScore());
				ps.setString(4, n.getUrl());
				ps.setString(5, n.getCreated());
				ps.executeUpdate();
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
