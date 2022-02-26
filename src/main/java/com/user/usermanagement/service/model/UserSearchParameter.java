package com.user.usermanagement.service.model;

import com.user.usermanagement.service.utils.SearchUtils;

public class UserSearchParameter {

    private String term;

    private int page = SearchUtils.DEFAULT_FIRST_RESULT;

    private int size = SearchUtils.DEFAULT_MAX_RESULT;

    public UserSearchParameter() {
        super();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
