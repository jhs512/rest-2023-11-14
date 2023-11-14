package com.ll.rest20231114.domain.article.article.service;

import com.ll.rest20231114.domain.article.article.entity.Article;
import com.ll.rest20231114.domain.article.article.repository.ArticleRepository;
import com.ll.rest20231114.global.rsData.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public RsData<Article> write(String title, String body) {
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("S-1", "성공", article);
    }
}
