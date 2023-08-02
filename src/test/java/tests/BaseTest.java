package tests;

import api.requests.ReqresRequests;
import api.utils.ReqresUtils;

public class BaseTest {
    ReqresRequests requests = new ReqresRequests();
    ReqresUtils utils = new ReqresUtils(requests);

}
