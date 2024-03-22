package com.crudapplication.configuration;

import static org.mockito.Mockito.verify;

import javax.batch.api.chunk.ItemReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;

class BatchConfigTest {

    @Mock
    private JobBuilderFactory jobBuilderFactory;

    @Mock
    private StepBuilderFactory stepBuilderFactory;

    @Mock
    private StudentItemReader studentItemReader;

    @Mock
    private StudentItemProcessor studentItemProcessor;

    @Mock
    private StudentItemWriter studentItemWriter;

    
    private BatchConfig batchConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        batchConfig = new BatchConfig(jobBuilderFactory, stepBuilderFactory,
                studentItemReader, studentItemProcessor, studentItemWriter);
    }

    @Test
    void studentStep() {
        Step step = batchConfig.studentStep();
        verify(stepBuilderFactory).get("studentStep");
 
    }

//    @Test
//    void studentJob() {
//        Job job = batchConfig.studentJob();
//        verify(jobBuilderFactory).get("studentJob");
//     
//    }
}