/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Authors:
 *   wuhua <wq163@163.com> , boyan <killme2008@gmail.com>
 */
package com.taobao.metamorphosis.server.network;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.gecko.core.command.ResponseCommand;
import com.taobao.gecko.service.Connection;
import com.taobao.gecko.service.RequestProcessor;
import com.taobao.metamorphosis.network.GetCommand;
import com.taobao.metamorphosis.network.RemotingUtils;
import com.taobao.metamorphosis.server.CommandProcessor;


/**
 * get请求处理器
 * 
 * @author boyan
 * @Date 2011-4-21
 * 
 */
public class GetProcessor implements RequestProcessor<GetCommand> {

    public static final Log log = LogFactory.getLog(GetProcessor.class);

    private final ThreadPoolExecutor executor;

    private final CommandProcessor processor;


    public GetProcessor(final CommandProcessor processor, final ThreadPoolExecutor executor) {
        super();
        this.processor = processor;
        this.executor = executor;
    }


    @Override
    public ThreadPoolExecutor getExecutor() {
        return this.executor;
    }


    @Override
    public void handleRequest(final GetCommand request, final Connection conn) {
        final ResponseCommand response =
                this.processor.processGetCommand(request, SessionContextHolder.getOrCreateSessionContext(conn, null));
        if (response != null) {
            RemotingUtils.response(conn, response);
        }
    }
}
