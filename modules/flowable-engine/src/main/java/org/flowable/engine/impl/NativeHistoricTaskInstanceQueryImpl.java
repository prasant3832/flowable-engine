/* Licensed under the Apache License, Version 2.0 (the "License");
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
 */
package org.flowable.engine.impl;

import java.util.List;
import java.util.Map;

import org.flowable.engine.common.impl.interceptor.CommandContext;
import org.flowable.engine.common.impl.interceptor.CommandExecutor;
import org.flowable.engine.history.HistoricTaskInstance;
import org.flowable.engine.history.NativeHistoricTaskInstanceQuery;
import org.flowable.engine.impl.util.CommandContextUtil;

public class NativeHistoricTaskInstanceQueryImpl extends AbstractNativeQuery<NativeHistoricTaskInstanceQuery, HistoricTaskInstance> implements NativeHistoricTaskInstanceQuery {

    private static final long serialVersionUID = 1L;

    public NativeHistoricTaskInstanceQueryImpl(CommandContext commandContext) {
        super(commandContext);
    }

    public NativeHistoricTaskInstanceQueryImpl(CommandExecutor commandExecutor) {
        super(commandExecutor);
    }

    // results ////////////////////////////////////////////////////////////////

    public List<HistoricTaskInstance> executeList(CommandContext commandContext, Map<String, Object> parameterMap) {
        return CommandContextUtil.getHistoricTaskInstanceEntityManager(commandContext).findHistoricTaskInstancesByNativeQuery(parameterMap);
    }

    public long executeCount(CommandContext commandContext, Map<String, Object> parameterMap) {
        return CommandContextUtil.getHistoricTaskInstanceEntityManager(commandContext).findHistoricTaskInstanceCountByNativeQuery(parameterMap);
    }

}
