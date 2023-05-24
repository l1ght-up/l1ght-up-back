package com.example.web_ai_back.caption.dto;

import com.example.web_ai_back.caption.domain.Caption;
import com.example.web_ai_back.image.domain.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CaptionDto {

    private Long idx;
    private Long imageIdx;  // 전체 객체 요청을 하므로 전체 img객체가 아닌 id값만 가져와 매핑하도록
    private String originalCaption;
    private Set<String> dangerFactor;

    @Builder
    public CaptionDto(Long idx, Long imageIdx, String originalCaption, Set<String> dangerFactor) {
        this.idx = idx;
        this.imageIdx = imageIdx;
        this.originalCaption = originalCaption;
        this.dangerFactor = dangerFactor;
    }

    // update시 수정할 요소가 뭐가 있을지에 대한 고민 필요
    @Builder
    public CaptionDto(String originalCaption, Set<String> dangerFactor) {
        this.originalCaption = originalCaption;
        this.dangerFactor = dangerFactor;
    }

    public Caption toEntity(Image image) {

        return Caption.builder()
                .image(image)
                .originalCaption(originalCaption)
                .dangerFactor(dangerFactor)
                .build();
    }


}