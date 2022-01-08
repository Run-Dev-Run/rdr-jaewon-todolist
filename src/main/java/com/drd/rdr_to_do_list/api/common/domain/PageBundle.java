package com.drd.rdr_to_do_list.api.common.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageBundle {
    private final int pageSize;
    private final int pageNumber;

    public PageBundle(final int pageSize, final int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public PageBundle(final PageSize pageSize, final int pageNumber) {
        this(pageSize.size(), pageNumber);
    }

    public int pageSize() {
        return pageSize;
    }

    public Pageable toPageable(long fetchCount) {
        return PageRequest.of(calculatedPageNumber(fetchCount), pageSize);
    }

    private int calculatedPageNumber(long fetchCount) {
        if (isExceededOffset(fetchCount)) {
            return (int)(fetchCount / pageSize * pageSize);
        }
        return pageNumber;
    }

    private boolean isExceededOffset(long fetchCount) {
        return (long) pageNumber * pageSize > fetchCount;
    }
}
