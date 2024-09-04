package org.flowable.engine.impl.bpmn.http;

import org.apache.commons.lang3.StringUtils;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.impl.bpmn.behavior.AbstractBpmnActivityBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultG4CustomActivityBehaviour extends AbstractBpmnActivityBehavior {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DefaultG4CustomActivityBehaviour.class);

    private Expression g4CustomTaskJobId;
    private Expression g4CustomTaskJobIdVariable;

    public static final String G4_CUSTOM_JOB_ID_REQUIRED = "G4 Custom Job Id required";

    private String getStringFromField(final Expression expression, final DelegateExecution execution) {
        if (expression != null) {
            Object value = expression.getValue(execution);
            if (value != null) {
                return value.toString();
            }
        }
        return null;
    }

    @Override
    public void execute(DelegateExecution execution) {
        try {
            String customJobId = getStringFromField(g4CustomTaskJobId, execution);
            String customJobIdVariable = getStringFromField(g4CustomTaskJobIdVariable, execution);
            execution.setVariable(customJobIdVariable, customJobId);
            log.info("Processing the job : {}. And, creating a variable for {}", customJobId, customJobIdVariable);
            if(StringUtils.isEmpty(customJobId)) {
                throw new FlowableException(G4_CUSTOM_JOB_ID_REQUIRED);
            }
            // Save request fields
        } catch (Exception e) {
            if (e instanceof FlowableException) {
                throw (FlowableException) e;
            } else {
                throw new FlowableException(G4_CUSTOM_JOB_ID_REQUIRED + " in execution " + execution.getId(), e);
            }
        }
        leave(execution);
    }

}
