package org.flowable.editor.language.json.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.ServiceTask;

import java.util.Map;

public class G4CustomTaskJsonConverter extends BaseBpmnJsonConverter {

    public static void fillTypes(Map<String,
            Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap,
                                 Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {

        fillJsonTypes(convertersToBpmnMap);
        fillBpmnTypes(convertersToJsonMap);
    }

    public static void fillJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
        convertersToBpmnMap.put(STENCIL_TASK_G4_CUSTOM, G4CustomTaskJsonConverter.class);
    }

    public static void fillBpmnTypes(Map<Class<? extends BaseElement>,
            Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
    }

    @Override
    protected void convertElementToJson(ObjectNode propertiesNode,
                                        BaseElement baseElement,
                                        BpmnJsonConverterContext converterContext) {

    }

    @Override
    protected BaseElement convertJsonToElement(JsonNode elementNode,
                                               JsonNode modelNode,
                                               Map<String, JsonNode> shapeMap,
                                               BpmnJsonConverterContext converterContext) {
        ServiceTask task = new ServiceTask();
        task.setType("g4-custom");
        addField("jobId", PROPERTY_G4CUSTOM_TASK_JOB_ID, elementNode, task);
        return task;
    }

    @Override
    protected String getStencilId(BaseElement baseElement) {
        return STENCIL_TASK_G4_CUSTOM;
    }
}
