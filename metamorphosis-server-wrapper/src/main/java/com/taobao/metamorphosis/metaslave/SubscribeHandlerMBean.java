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
 *   wuhua <wq163@163.com>
 */
package com.taobao.metamorphosis.metaslave;

/**
 * 
 * @author 无花
 * @since 2011-11-10 下午5:55:28
 */

public interface SubscribeHandlerMBean {

    /**
     * 重启slave数据同步
     */
    public void restart();


    /**
     * Returns a string described current status.
     * 
     * @since 1.4.4
     * @return
     */
    public String getStatus();

}
