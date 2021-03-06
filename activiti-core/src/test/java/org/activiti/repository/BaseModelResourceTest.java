
package org.activiti.repository;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-base.xml","classpath:spring-servlet.xml"})
public class BaseModelResourceTest {

    @Autowired
    protected RepositoryService repositoryService;

    @Test
    public void getModelFromRequest() {
        String modelId = "50";
        Model model = repositoryService.createModelQuery().modelId(modelId).singleResult();
        if (model == null) {
            throw new ActivitiObjectNotFoundException("Could not find a model with id '" + modelId + "'.", ProcessDefinition.class);
        }
        System.out.println("=======" + JSON.toJSONString(model));
    }
}
