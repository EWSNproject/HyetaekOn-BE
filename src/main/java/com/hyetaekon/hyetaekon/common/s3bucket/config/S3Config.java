package com.hyetaekon.hyetaekon.common.s3bucket.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
  @Value("${aws.s3.bucket.credentials.accessKey}")
  private String accessKey;

  @Value("${aws.s3.bucket.credentials.secretAccessKey}")
  private String secretAccessKey;

  @Value("${aws.s3.bucket.region}")
  private String region;

  @Bean
  public AmazonS3 amazonS3Client() {
    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);
    return AmazonS3ClientBuilder.standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .build();
  }
}
