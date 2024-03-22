package com.crudapplication.configuration;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crudapplication.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private StudentItemReader studentItemReader;

	@Autowired
	private StudentItemProcessor studentItemProcessor;

	@Autowired
	private StudentItemWriter studentItemWriter;

	@Bean
	public Step studentStep() {
		return stepBuilderFactory.get("studentStep").<Student, ProcessedStudent>chunk(10).reader(studentItemReader)
				.processor(studentItemProcessor).writer(studentItemWriter).build();
	}

//    @Bean
//    public Job studentJob() {
//        return jobBuilderFactory.get("studentJob")
//                .start(studentStep())
//                .build();
//                
//    }
}
