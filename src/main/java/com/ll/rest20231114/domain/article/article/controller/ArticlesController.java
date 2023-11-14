package com.ll.rest20231114.domain.article.article.controller;

import com.ll.rest20231114.domain.article.article.dto.ArticleDto;
import com.ll.rest20231114.domain.article.article.entity.Article;
import com.ll.rest20231114.domain.article.article.service.ArticleService;
import com.ll.rest20231114.global.rsData.RsData.RsData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/articles")
@RequiredArgsConstructor
public class ArticlesController {
    private final ArticleService articleService;

    @Getter
    public static class GetArticlesResponseBody {
        public GetArticlesResponseBody(List<Article> articles) {
            this.articles = articles.stream().map(
                    article -> ArticleDto.of(article)
            ).toList();
        }

        private List<ArticleDto> articles;
    }

    @GetMapping("")
    public ResponseEntity<RsData<GetArticlesResponseBody>> getArticles() {
        return ResponseEntity.ok(
                RsData.of("S-1", "성공", new GetArticlesResponseBody(articleService.findAll()))
        );
    }
}