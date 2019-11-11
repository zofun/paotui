package com.runningman.paotui.service;

import com.runningman.paotui.pojo.AuthInfo;
import com.runningman.paotui.pojo.CommentUser;

import java.util.List;

public interface StartService {

    /**
     * 罗列信誉详情
     * @param username
     * @return
     */
    List<CommentUser> queryReputation(String username, int page, int limit);

    List<AuthInfo> SumUserStart(String username);

    int getUserStartCount(String username);
}
