package com.artemzin.android.wail.api.lastfm;

import com.artemzin.android.bytes.common.StringUtil;
import com.artemzin.android.wail.api.network.NetworkException;
import com.artemzin.android.wail.api.network.NetworkRequest;

public class LFUserApi {

    private LFUserApi() {}

    /**
     *
     * @param user optional user name
     * @return
     * @see <a href="http://www.lastfm.ru/api/show/user.getInfo">user.getInfo()</a>
     */
    public static String getInfo(String sessionKey, String apiKey, String secret, String user)
            throws LFApiException, NetworkException {

        final LFRequestParamContainer requestParams = new LFRequestParamContainer("user.getInfo", secret);

        if (!StringUtil.isNullOrEmpty(user)) {
            requestParams.addParam("user", user);
        }

        requestParams.addParam(LFApiCommon.PARAM_API_KEY, apiKey);
        requestParams.addParam(LFApiCommon.PARAM_SK, sessionKey);

        return NetworkRequest.newPostRequestInstance(
                LFApiCommon.API_ROOT_URL,
                requestParams.generateRequestParamsAsStringWithSign()
        ).getResponse();
    }
}
