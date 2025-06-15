package com.flowu.service;

import com.flowu.model.Flow;
import com.flowu.repository.FlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowService {
    private final FlowRepository flowRepository;

    @Transactional
    public Flow saveFlow(Flow flow){
        //ToDo: Ver com o túlio sobre as regras
        return flowRepository.save(flow);
    }

    @Transactional( readOnly = true )
    public Optional<Flow> findFlowById (String id){
        return flowRepository.findById(id);
    }

    @Transactional (readOnly = true)
    public List<Flow> findAllFlows(){
        return flowRepository.findAll();
    }

    @Transactional
    public void deleteFlowById(String id){
        flowRepository.deleteById(id);
    }

    @Transactional
    public Flow updateFlow(String id, Flow updateFlow){
        return flowRepository.findById(id).map(existingFlow -> {
            existingFlow.setTitle(updateFlow.getTitle());
            existingFlow.setUserId(updateFlow.getUserId());
            existingFlow.setCompanyId(updateFlow.getCompanyId());
            return flowRepository.save(existingFlow);
        }).orElse(null);
    }

    @Transactional
    public void incrementExecutedSuccessCount(String flowId){
        flowRepository.findById(flowId).ifPresent(flow ->{
            flow.setExecutedSuccessCount(flow.getExecutedSuccessCount() + 1);
            flowRepository.save(flow);
        });
    }

    @Transactional
    public void incrementExecuteErrorCount(String flowId){
        flowRepository.findById(flowId).ifPresent(flow -> {
            flow.setExecutedErrorCount(flow.getExecutedErrorCount() + 1);
            flowRepository.save(flow);
        });
    }
}
