package com.hyetaekon.hyetaekon.bookmark.service;

import com.hyetaekon.hyetaekon.bookmark.entity.Bookmark;
import com.hyetaekon.hyetaekon.bookmark.repository.BookmarkRepository;
import com.hyetaekon.hyetaekon.common.exception.GlobalException;
import com.hyetaekon.hyetaekon.publicservice.entity.PublicService;
import com.hyetaekon.hyetaekon.publicservice.repository.PublicServiceRepository;
import com.hyetaekon.hyetaekon.user.entity.User;
import com.hyetaekon.hyetaekon.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.hyetaekon.hyetaekon.common.exception.ErrorCode.*;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final PublicServiceRepository publicServiceRepository;

    public void addBookmark(Long serviceId, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new GlobalException(BOOKMARK_USER_NOT_FOUND));

        PublicService publicService = publicServiceRepository.findById(serviceId)
            .orElseThrow(() -> new GlobalException(SERVICE_NOT_FOUND_BY_ID));

        // 이미 북마크가 있는지 확인
        if (bookmarkRepository.existsByUserIdAndPublicServiceId(userId, serviceId)) {
            throw new GlobalException(BOOKMARK_ALREADY_EXISTS);
        }

        Bookmark bookmark = Bookmark.builder()
            .user(user)
            .publicService(publicService)
            .build();

        bookmarkRepository.save(bookmark);

        // 북마크 수 증가
        publicService.increaseBookmarkCount();
    }

    @Transactional
    public void removeBookmark(Long serviceId, Long userId) {
        Bookmark bookmark = bookmarkRepository.findByUserIdAndPublicServiceId(userId, serviceId)
            .orElseThrow(() -> new GlobalException(BOOKMARK_NOT_FOUND));

        bookmarkRepository.delete(bookmark);

        // 북마크 수 감소
        PublicService publicService = bookmark.getPublicService();
        publicService.decreaseBookmarkCount();
    }
}
