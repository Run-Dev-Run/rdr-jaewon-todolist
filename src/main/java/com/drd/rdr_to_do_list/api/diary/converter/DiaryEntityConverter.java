package com.drd.rdr_to_do_list.api.diary.converter;

import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import org.springframework.stereotype.Component;

@Component
public class DiaryEntityConverter {
    public Diary toDiary(DiaryBundle.AddEdit bundle) {
        return Diary.builder()
                .name(bundle.getDiaryName())
                .build();
    }
}
