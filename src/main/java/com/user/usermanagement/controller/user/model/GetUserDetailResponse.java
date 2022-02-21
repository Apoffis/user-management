package com.user.usermanagement.controller.user.model;

import com.user.usermanagement.controller.AbstractResponse;

public class GetUserDetailResponse extends AbstractResponse {

    private UserDetailsDto userDetailsDto;

    public GetUserDetailResponse() {
        super();
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

}
