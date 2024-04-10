package com.yuda.houserent.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.entity.News;
import com.yuda.houserent.service.NewsService;
import com.yuda.houserent.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
新闻资讯控制器
 */
@Controller("frontNewsController")
@RequestMapping("/news")
public class NewsController extends BaseController {
   @Autowired
   private NewsService newsService;
    //进入新闻资讯列表页面
    @RequestMapping("")
    public String newsList(@RequestParam(value = "page",defaultValue = "1")Long pageNumber, @RequestParam(value = "size",defaultValue = "6")Long pageSize, Model model) {
        Page page = PageUtil.initMapPage(pageNumber, pageSize);
        News condition = new News();
        Page<News> newsPage = newsService.findAll(page, condition);
        model.addAttribute("pageInfo", newsPage);
        model.addAttribute("pagePrefix", "/news?");
        return "front/news-list";
    }
    //新闻详情
    @RequestMapping("/detail/{id}")
    public String publish(@PathVariable(value = "id",required = false)Long id, Model model){
        News news=newsService.get(id);
        if (news==null){
            return renderNotFound();
        }

        model.addAttribute("news",news);
        return "front/news-detail";
    }

}
