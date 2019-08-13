package com.shimingming.exercise.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shimingming.exercise.domain.NewsLink;
import com.shimingming.exercise.service.NewsLinkService;

/**
 * @作者: 时明明
 * @日期: 2019年8月12日
 * @时间: 上午10:07:45
 */
@Controller
public class NewsController {
	@Resource
	private NewsLinkService nls;

	@RequestMapping("/")
	public String getList(Model m,
			@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(required = false, value = "mh1") String mh1,
			@RequestParam(required = false, value = "mh2") String mh2,
			@RequestParam(required = false, value = "mh3") String mh3) {
		Page<NewsLink> page = new Page<>(currentPage, 5);
		QueryWrapper<NewsLink> qw = new QueryWrapper<>();
		if (mh1 != null && !"".equals(mh1)) {
			qw.like("title", mh1);
		}
		if (mh3 != null && !"".equals(mh3) && mh2 != null && !"".equals(mh2) && "asc".equals(mh3)) {
			qw.orderByAsc(mh2);
		}
		if (mh3 != null && !"".equals(mh3) && mh2 != null && !"".equals(mh2) && "desc".equals(mh3)) {
			qw.orderByDesc(mh2);
		}

		IPage<NewsLink> page2 = nls.page(page, qw);
		m.addAttribute("page", page2);
		m.addAttribute("mh1", mh1);
		m.addAttribute("mh2", mh2);
		m.addAttribute("mh3", mh3);
		return "list";

	}

	@GetMapping("home")
	public String update(Model m, Integer id) {
		NewsLink byId = nls.getById(id);
		m.addAttribute("nl", byId);
		return "update";
	}

	@GetMapping("update")
	public String update(NewsLink nl) {
		nls.updateById(nl);
		return "redirect:/";

	}
}
