package com.hyetaekon.hyetaekon.common.publicdata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceDataDto {
    private Response response;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Response {
        private Body body;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Body {
        private Items items;
        private long page;
        private long perPage;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Items {
        private List<Item> items;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Item {
        @JsonProperty("서비스ID")
        private long serviceId;

        @JsonProperty("서비스명")
        private String serviceName;

        @JsonProperty("서비스분야")
        private String serviceCategory;

        @JsonProperty("서비스목적요약")
        private String summaryPurpose;

        @JsonProperty("소관기관명")
        private String governingAgency;

        @JsonProperty("부서명")
        private String department;

        @JsonProperty("사용자구분")
        private String userType;

        @JsonProperty("신청기한")
        private String applicationDeadline;
    }
}
