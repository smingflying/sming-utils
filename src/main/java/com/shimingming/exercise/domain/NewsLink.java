package com.shimingming.exercise.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @作者: 时明明
 * @日期: 2019年8月12日
 * @时间: 上午9:09:17
 */
@TableName("t_news_link")
public class NewsLink {
	@TableId(type = IdType.AUTO,value="id")
	private Integer id;
	@TableField("title")
	private String title;
	@TableField("url")
	private String url;
	@TableField("score")
	private Integer score;
	@TableField("created")
	private String created;
	public NewsLink(Integer id, String title, String url, Integer score, String created) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.score = score;
		this.created = created;
	}
	public NewsLink() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NewsLink [id=" + id + ", title=" + title + ", url=" + url + ", score=" + score + ", created=" + created
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	
}
