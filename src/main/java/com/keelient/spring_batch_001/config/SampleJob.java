package com.keelient.spring_batch_001.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleJob {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstJob() {
        return jobBuilderFactory
                .get("First job")  // This is the job name
                .start(firstStep())
                .build();// Starts a step
    }

    private Step firstStep() {
        return stepBuilderFactory
                .get("First step")  // This is the step name
                .tasklet(firstTask())
                .build();// Invokes a tasklet
    }

    private Tasklet firstTask() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                // The tasklet logic
                System.out.println("<<< -- This is first tasklet step --- >>>");
                return RepeatStatus.FINISHED;
            }
        };
    }
}
