package com.runningman.paotui.service;

public interface StartService {

    /**
     * 罗列信誉详情
     * @param username
     * @return
     */
    String queryReputation(String username, int page, int limit);

    int SumUserStart(String username);


}
