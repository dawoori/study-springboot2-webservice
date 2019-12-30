package com.dawool.springboot.service.posts;

import com.dawool.springboot.domain.posts.Posts;
import com.dawool.springboot.domain.posts.PostsRepository;
import com.dawool.springboot.web.dto.PostsResponseDto;
import com.dawool.springboot.web.dto.PostsSaveRequestDto;
import com.dawool.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEnity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestsDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        posts.update(requestsDto.getTitle(), requestsDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id ="+ id));

        return new PostsResponseDto(entity);
    }
}
