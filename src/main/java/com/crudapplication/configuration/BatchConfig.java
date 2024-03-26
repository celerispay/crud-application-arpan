package com.crudapplication.configuration;

import java.util.Set;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crudapplication.entity.Student;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Configuration
@EnableBatchProcessing
@Log4j2
public class BatchConfig {

	@Bean
	public Step studentStep(StepBuilderFactory stepBuilderFactory,StudentItemReader studentItemReader, StudentItemProcessor studentItemProcessor, StudentItemWriter studentItemWriter) {
		return stepBuilderFactory.get("studentStep").<Student, ProcessedStudent>chunk(10).reader(studentItemReader)
				.processor(studentItemProcessor).writer(studentItemWriter).build();
	}

    @Bean
    public Job studentJob(JobBuilderFactory jobBuilderFactory) {
    	return jobBuilderFactory.get("studentJob")
                .start(studentStep(null,null,null,null))
                .build();
                
    }
    
    @Bean
    public JobExecutionListenerSupport jobExecutionListener(JobOperator jobOperator) {
        return new JobExecutionListenerSupport() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                String jobName = jobExecution.getJobInstance().getJobName();

                try {
                    Set<Long> runningExecutionIds = jobOperator.getRunningExecutions(jobName);
                    if (!runningExecutionIds.isEmpty()) {
                        long runningExecutionId = runningExecutionIds.iterator().next();
                        log.info("Stopping running job execution with ID: {}", runningExecutionId);
                        jobOperator.stop(runningExecutionId);
                    } else {
                        log.info("No running job executions found for job: {}", jobName);
                    }
                } catch (NoSuchJobException | NoSuchJobExecutionException | JobExecutionNotRunningException e) {
                    log.error("Error occurred while stopping the running job execution: {}", e.getMessage());
                }
            }
        };
    }
    
}
