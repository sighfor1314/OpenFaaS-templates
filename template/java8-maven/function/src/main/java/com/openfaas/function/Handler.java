package com.openfaas.function;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openfaas.model.IRequest;
import com.openfaas.model.IResponse;
import com.openfaas.model.Response;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Handler extends com.openfaas.model.AbstractHandler {


    public IResponse Handle(IRequest req) {

        Response res = new Response();
        res.setContentType("application/text;charset=utf-8");
        res.setBody("Hello World");

        return res;
    }
}
