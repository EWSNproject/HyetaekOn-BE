package com.hyetaekon.hyetaekon.bookmark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyetaekon.hyetaekon.common.util.BaseEntity;
import com.hyetaekon.hyetaekon.publicservice.entity.PublicService;
import com.hyetaekon.hyetaekon.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(name = "public_service_id", nullable = false)
  private PublicService publicService;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

}