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
package org.flowable.engine.impl.event.logger.handler;

import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.common.impl.interceptor.CommandContext;
import org.flowable.engine.delegate.event.FlowableSignalEvent;
import org.flowable.engine.impl.persistence.entity.EventLogEntryEntity;

/**
 * @author Joram Barrez
 */
public class ActivitySignaledEventHandler extends AbstractDatabaseEventLoggerEventHandler {

    @Override
    public EventLogEntryEntity generateEventLogEntry(CommandContext commandContext) {
        FlowableSignalEvent signalEvent = (FlowableSignalEvent) event;

        Map<String, Object> data = new HashMap<String, Object>();
        putInMapIfNotNull(data, Fields.ACTIVITY_ID, signalEvent.getActivityId());
        putInMapIfNotNull(data, Fields.ACTIVITY_NAME, signalEvent.getActivityName());
        putInMapIfNotNull(data, Fields.PROCESS_DEFINITION_ID, signalEvent.getProcessDefinitionId());
        putInMapIfNotNull(data, Fields.PROCESS_INSTANCE_ID, signalEvent.getProcessInstanceId());
        putInMapIfNotNull(data, Fields.EXECUTION_ID, signalEvent.getExecutionId());
        putInMapIfNotNull(data, Fields.ACTIVITY_TYPE, signalEvent.getActivityType());

        putInMapIfNotNull(data, Fields.SIGNAL_NAME, signalEvent.getSignalName());
        putInMapIfNotNull(data, Fields.SIGNAL_DATA, signalEvent.getSignalData());

        return createEventLogEntry(signalEvent.getProcessDefinitionId(), signalEvent.getProcessInstanceId(), signalEvent.getExecutionId(), null, data);
    }

}
