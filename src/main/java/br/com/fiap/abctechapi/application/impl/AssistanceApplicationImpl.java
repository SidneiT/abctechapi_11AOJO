package br.com.fiap.abctechapi.application.impl;

import br.com.fiap.abctechapi.application.AssistanceApplication;
import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import br.com.fiap.abctechapi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {

    private final AssistanceService assistanceService;

    @Autowired
    public AssistanceApplicationImpl(AssistanceService assistanceService){
        this.assistanceService = assistanceService;
    }

    @Override
    public List<AssistResponseDto> getAssists() {
        return this.assistanceService
                .getAssist()
                .stream()
                .map(it -> new AssistResponseDto(it.getId(), it.getName(), it.getDescription()))
                .collect(Collectors.toList());
    }
}
