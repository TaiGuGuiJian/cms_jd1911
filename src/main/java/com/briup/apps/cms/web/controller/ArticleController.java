package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 文章控制器类
 * @author: charles
 * @create: 2019-11-12 10:22
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Article> list =articleService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
        List<ArticleExtend> list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id){
        ArticleExtend articleExtend = articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Article article){
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }

}
